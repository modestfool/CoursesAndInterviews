
function drawPie(csvdata){
	
	if (typeof drawPie.counter === 'undefined')
		drawPie.counter = 0;
	else
		drawPie.counter += 1;
	
	d3.select("svg").remove();
	
	var zero = d3.format("03d");
	var num_bins = 8;
	/*
	 * Generate the frequencies of the variable
	 */
	histdata = preprocess(csvdata,num_bins, drawPie.counter);

	    var binsize = (maxbin - minbin)/num_bins;
	    total = csvdata.length;
	    // whitespace on either side of the bars in units of MPG
	    var binmargin = parseFloat(binsize/num_bins); 
	    // Set the limits of the x axis
	    var xmin = minbin - 1
	    var xmax = maxbin + 1
	    
	    histdata.forEach(function(d)
	    		{
	    			console.log(d.numfill);
	    		});
	
	var color = d3.scale.ordinal()
	.range(['#058DC7', '#50B432', '#ED561B', '#DDDF00', '#24CBE5', '#64E572', '#FF9655', '#FFF263', '#6AF9C4']);

	var arc = d3.svg.arc()
	.outerRadius(radius - 10)
	.innerRadius(10);

	var labelArc = d3.svg.arc()
	.outerRadius(radius*0.7)
	.innerRadius(radius*0.7);

	var pie = d3.layout.pie()
	.sort(null)
	.value(function(d) { 
		d.numfill = +d.numfill;
		return d.numfill; 
		});
/*
 * 
 */
	
   var chart = d3.select("#svg")
	.append("svg")
	.attr("width",w + margin.left + margin.right)
	.attr("height",h + margin.top + margin.bottom);
   
   chart.append("text")
   .attr("x", (w / 2))             
   .attr("y", 2*margin.top)
   .attr("text-anchor", "middle")  
   .style("font-size", "16px") 
   .style("text-decoration", "underline")  
   .text(function(){
	   return variables[drawPie.counter%4];
   });
	
/*
 * 
 */

   var svg = chart
	.append("g")
	.attr("transform", "translate(" + (w - margin.right)/ 2 + "," + (h + margin.top + margin.bottom)/2 + ")");

	svg.on("click", function(){
		console.log('SVG Click');
		drawPie(csvdata);
	});
	

	/**
	 * 
	 * Scaling view added
	 */
	 // Add the rotation label; the value is set on transition.
    var label = chart.append("text")
        .attr("class", "bin label")
        .attr("text-anchor", "end")
        .attr("y", h - margin.bottom - 24)
        .attr("x", w + radius/2 - 2*margin.right)
        .text(0 + '\xB0');
    
    // Add an overlay for the rotation label.
    var box = label.node().getBBox();
    
    var overlay = chart.append("rect")
    .attr("class", "overlay")
    .attr("x", box.x)
    .attr("y", box.y)
    .attr("width", box.width*2)
    .attr("height", box.height);
    
    overlay.on("mouseover", enableInteraction());

    console.log(typeof(overlay));

    
function enableInteraction() {
  var rotationScale = d3.scale.linear()
      .domain([0, 360])
      .range([box.x + 10, box.x + box.width - 10])
      .clamp(true);

  // Cancel the current transition, if any.
  chart.transition().duration(0);

  overlay
      .on("mouseover", mouseover)
      .on("mouseout", mouseout)
      .on("mousemove", mousemove)
      .on("touchmove", mousemove);

  function mouseover() {
    label.classed("active", true);
  }

  function mouseout() {
    label.classed("active", false);
  }

  function mousemove() {
//	setTimeout(displayrotation(rotationScale.invert(d3.mouse(this)[0]),500));
	  displayRotation(rotationScale.invert(d3.mouse(this)[0]));
	  
  }


  // Updates the display to show the specified rotation.
  function displayRotation(rotation) {
	  label.text((Math.round(rotation) + '\xB0'));
	  svg.attr("transform", "translate(" + (w -margin.right)/ 2 + "," + (h + 2*margin.bottom + 2*margin.top)/ 2 + ")" +" rotate(" + Math.round(rotation) + ")");
	}

}	
	
	
	
	var curAngle = 0;
	var interval = null;

	var key = function(d){ return d.data.label; };
	
	var g = svg.selectAll(".arc")
	.data(pie(histdata))
	.enter().append("g")
	.attr("class", "arc");

	g.append("path")
	.attr("d", arc)
	.style("fill", function(d) { 
		d.value = +d.value;
		return color(d.value);
	});

	g.on("mouseover",function(d){
		var pie = d3.select(this);
		highlightPie(pie, labelArc, d);
	});

	g.on("mouseout", function(d){
		var pie = d3.select(this);
		setTimeout(restorePie(pie, arc, color, d),2000);
	});

}

function highlightPie(pie,labelArc, d){
	console.log("Highlight Pie", d);

	var path = pie.select("path");
	var arc = d3.svg.arc()
	.outerRadius(radius - 5)
	.innerRadius(5);

	path.attr("d", arc)
	.style("stroke", "white")
	.attr("stroke-width",6);

	
	pie.append("svg:text")
	.attr("transform", function(d) {
		return "translate(" + labelArc.centroid(d) + ")" +
				"rotate("+ getAngle(d) + ")"; 
		})
	.attr("dy", ".35em")
	.attr("font-family", "sans-serif")
	.attr("font-size", "15px")
	.attr("text-anchor", "middle")
	.style("fill", "black")
	.style("text-anchor", "middle")
	.text(function(d) {
		console.log(d.value, (d.value/total));
		return d.data.startValue + " to " + d.data.endValue + ": " + Math.round(d.value/total*1000)/10 + "%"; 
	});
}

function restorePie(pie, arc, color, d){
	console.log("Restore Pie", d);
	pie.select("path").remove();

	pie.selectAll("text").remove();

	pie.append("path")
	.attr("d", arc)
	.style("fill", function(d) { 
		d.value =+d.value;
		return color(d.value); 
	});
}

function goRotate(svg,curAngle) {
    curAngle += 1;
    svg.attr("transform", "translate(" + w / 2 + "," + h / 2 + ") rotate(" + curAngle + "," + 0 + "," + 0 + ")");
  }

// Get the angle on the arc and then rotate by -90 degrees
function getAngle(d) {
		var angle = (d.startAngle + d.endAngle)*90/Math.PI - 90;
		return (angle >90 ) ? angle -180 : angle;  
};
