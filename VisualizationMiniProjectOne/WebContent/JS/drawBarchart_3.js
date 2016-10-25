
function hist(csvdata){
	
	if (typeof (hist.counter) === 'undefined' || hist.counter < 0 )
		hist.counter = 0;
	else
		hist.counter += 1;
	
	var zero = d3.format("02d");
	
	d3.select("svg").remove();
	
//	console.log("Num bins: L13", numbins);
	adjustBinsize();
    
//    var minbin = d3.min(csvdata, function(d){
//    	return d.margin;
////    	return d;
//    });
//    var maxbin = d3.max(csvdata, function(d){
//    	return d.margin;
////    	return d;
//    });
    var binsize = (maxbin - minbin) / numbins;
    console.log("bin size",binsize);
    // whitespace on either side of the bars
    binmargin = parseFloat(binsize/numbins); 
    // Set the limits of the x axis
    var xmin = minbin - 1;
    var xmax = maxbin + 1;
    
    
//    histdata.forEach(function(d)
//    		{
//    			console.log(d.numfill);
//    		});
    console.log(binsize,binmargin);
//    console.log(histdata);

    // This scale is for determining the widths of the histogram bars
    // Must start at 0 or else x(binsize a.k.a dx) will be negative
    var x = d3.scale.linear()
	  .domain([0, (xmax - xmin)])
	  .range([0, w]);

    // Scale for the placement of the bars
    var x2 = d3.scale.linear()
	  .domain([xmin, xmax])
	  .range([0, w]);
	
    var y = d3.scale.linear()
	  .domain([0, d3.max(histdata, function(d) { 
						return d.numfill; 
						})])
//      .domain([0, csvdata.length])
	  .range([h - margin.bottom, 0]);

    var xAxis = d3.svg.axis()
	  .scale(x2)
	  .ticks(Math.floor(numbins*1.5))
	  .orient("bottom");
    var yAxis = d3.svg.axis()
	  .scale(y)
	  .ticks(10)
	  .orient("left");
    
    
    svg = d3.select("#svg")
		.append("svg")
		.attr("width",w + margin.left + margin.right)
		.attr("height",h + margin.top + margin.bottom)
	.append("g")
	.attr("transform", "translate(" + margin.left + "," + margin.top*3 + ")");

    svg.append("text")
    .attr("x", (w / 2))             
    .attr("y", 0 - margin.top)
    .attr("text-anchor", "middle")  
    .style("font-size", "16px") 
    .style("text-decoration", "underline")  
    .text(function(){
 	   return variables[hist.counter%4];
    });
    
    plotBars();
	   
    function plotBars(){

    	var bar = svg.append("g")
    	.attr("class","bars")
    	.selectAll(".bar")
       .data(histdata)
       .enter()
       .append("g")
       .attr("class","bar");
    	
    	bar.append("rect")
    	.attr("x", function(d,i){
    		return x(i*binsize + binmargin);
    	})
    	.attr("y",function(d){
    		return  y(d.numfill);
    	} )
    	.attr("width", x(binsize - 2 * binmargin))
    	.attr("height", function(d){
    		return h - margin.bottom - y(d.numfill);
    	});
    		
    	bar.on("mouseover",function(d){
    		   var bar  = d3.select(this);
    		   console.log(bar);
    		   highlightBar(svg,bar,d);
    	   })
    	   .on("mouseout",function(d){
    		   var rect = d3.select(this);
    		   setTimeout(restoreBar(rect,d,y(d.numfill),x(binsize - 2 * binmargin)),200);
    		   });
    	
    }
    
    function adjustBinsize(){
    	histdata = preprocess(csvdata, numbins, hist.counter);
    }
    
    console.log("Num bins:",numbins)
    
	var xlabels = svg.append("g")
    .attr("class", "x axis")
    .attr("transform", "translate(0," + (h - margin.bottom) + ")")
    .call(xAxis);
	
    xlabels.selectAll("text")
        .style("text-anchor", "end")
        .attr("dx", "-.8em")
        .attr("dy", ".15em")
        .attr("transform", function (d) {
        return "rotate(-30)";});
    
    svg.append("text")
    .attr("class", "x label")
    .attr("x", w - 0*margin.right)
    .attr("y",h -margin.bottom - 6)
    .style("text-anchor", "end")
    .text(function(d){
    	return variables[hist.counter % 4];
    });

	svg.append("g")
    .attr("class", "y axis")
    .call(yAxis);
	
	svg	.append("text")
	.attr("class","y label")
    .attr("transform", "rotate(-90)")
    .attr("y", 6)
    .attr("dy", ".71em")
    .style("text-anchor", "end")
    .text("Frequency");
		
	svg.on("click", function(){
		  console.log('SVG Click');
//		  readCSV();
		  hist(csvdata);
	});
	
	/**
	 * 
	 * Scaling view added
	 */
	 // Add the year label; the value is set on transition.
    var label = svg.append("text")
        .attr("class", "year label")
        .attr("text-anchor", "end")
        .attr("y", h - margin.bottom - 72)
        .attr("x", w)
        .text(zero(numbins));
    
    // Add an overlay for the year label.
    var box = label.node().getBBox();
    
    var overlay = svg.append("rect")
    .attr("class", "overlay")
    .attr("x", box.x)
    .attr("y", box.y)
    .attr("width", box.width*2)
    .attr("height", box.height);
    
    overlay.on("mouseover", enableInteraction());

    console.log(typeof(overlay));

    
function enableInteraction() {
  var yearScale = d3.scale.linear()
      .domain([minBins, maxBins])
      .range([box.x + 10, box.x + box.width - 10])
      .clamp(true);

  // Cancel the current transition, if any.
  svg.transition().duration(0);

  overlay
      .on("mouseover", mouseover)
      .on("mouseout", mouseout)
      .on("mousemove", mousemove)
      .on("touchmove", mousemove);
//      .on("click",click);

  function mouseover() {
    label.classed("active", true);
  }

  function mouseout() {
    label.classed("active", false);
//    console.log("Mouse out");
//    hist.counter--;
//    updateBars(yearScale.invert(d3.mouse(this)[0]));
  }

  function mousemove() {
//	setTimeout(displayYear(yearScale.invert(d3.mouse(this)[0]),500));
	  displayYear(yearScale.invert(d3.mouse(this)[0]));
  }

//Tweens the entire chart by first tweening the year, and then the data.
// For the interpolated data, the dots and label are redrawn.
//function tweenYear() {
//  var year = d3.interpolateNumber(minBins, maxBins);
//  return function(t) { displayYear(year(t)); };
//}

//function click(){
//	  hist.counter--;
//	  hist(csvdata);
//}

// Updates the display to show the specified year.
function displayYear(year) {
//  dot.data(interpolateData(year), key).call(position).sort(order);
  label.text(zero(Math.round(year)));
  numbins = Math.round(year);
  hist.counter--;
  hist(csvdata);
		}

}


function highlightBar(svg,bar,d){
	console.log("Highlight Bar", d.numfill);
	var rect = bar.select("rect");
//	console.log("Rect:" , rect);
	
	var x = Math.floor(Number(rect.attr("x"))); //+ Number(binsize/2));
	var y = Math.floor(Number(rect.attr("y")) + 14);
	var height = Math.round(Number(rect.attr("height")));
	var width = Math.round(Number(rect.attr("width")));
	
//	rect.style("fill","#AFEAAA")
//		.attr("width", (width + 0.1))
//		.attr("height",height + 0.1);
//		.attr("y", function(value){
//			return h - value*4 - 3;
//		});
	rect.style("fill","#AFEAAA")
	.style("stroke","orange")
	.style("stroke-width",2)
	.attr("width", (width + 2))
	.attr("height",function(d){
		return height + 6; 
	})
	.attr("y", function(value){
		return y - 20;
	});


	console.log("x,y",x,y);
	bar.append("text")
		   .attr("font-family", "sans-serif")
		   .attr("transform","translate(" + (x + width/2) + "," + y + ") rotate(-30)")
		   .style('text-anchor', 'middle')
		   .style('font-size', '14px')
		   .style('fill','black')
		   .text(function(d){
		   console.log("text" ,d.startValue, d.endValue);
		   console.log(d.numfill);
		   return d.numfill;
	   });	
	
}



function restoreBar(bar,d, height, width){
					console.log("Restore Bar", d.numfill);
					
					bar.selectAll("text").remove();
					var rect = bar.select("rect");
					
					rect.style("fill", "teal")
						.style("stroke-width",0)
						.attr("width",width)
						.attr("height",function(d){
							 return h - margin.bottom - height;
						})
						.attr("y", function(d){
							return height;
						});
}
}





