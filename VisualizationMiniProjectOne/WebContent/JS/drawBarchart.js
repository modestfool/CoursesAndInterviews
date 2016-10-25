function refreshBars(){
//				d3.csv("data/Clothing.csv"){}
				var dataset = getDataset();
				bins = w/dataset.length;
				
				console.log('RefreshBars');
	       		
	       		d3.select("svg").remove();
	       		

				// Axis Labels
	       		var xScale = d3.scale.ordinal()
	       		.domain([0,10])
	       	    .rangeRoundBands([0, w]);

	       		var yScale = d3.scale.linear()
	       	    .range([h, 0]);
	       	
	       		var xAxis = d3.svg.axis()
	       	    .scale(xScale)
	       	    .orient("bottom");

	       		var yAxis = d3.svg.axis()
	       	    .scale(yScale)
	       	    .orient("left")
	       	    .ticks(10);
	       		
	       		
	       		svg = d3.select("body")
   					.append("svg")
   					.attr("width",w + margin.left + margin.right)
   					.attr("height",h + margin.top + margin.bottom)
	       		.append("g")
	            .attr("transform", "translate(" + margin.left + "," + margin.top + ")");
	            
	        
	       		var bar = svg.selectAll(".bar")
				   .data(dataset)
				   .enter()
				   .append("g")
				   .attr("class",".bar");
				
				bar.append("rect")
				   .attr("x",function(d, i) {
					   return (i * (w / dataset.length));
				   })
				   .attr("y", function(d) {
					    return (h - d*4);  //Height minus data value
				   })
				   .attr("width", w / dataset.length - barPadding)
				   .attr("height", function(d){
					   return d*4; 
				   })
				   .attr("fill", function(d) {
					    return "rgb(0, " + (d * 10)%255 + ", 0)";
				   });
	       		
				bar.on("mouseover",function(d){
					   var bar  = d3.select(this);
					   console.log(bar);
					   highlightBar(svg,bar,d);
				   })
				   .on("mouseout",function(d){
					   var rect = d3.select(this);
					   setTimeout(restoreBar(rect,d),200);
					   });
				
				   
	       		svg.append("g")
	            .attr("class", "x axis")
	            .attr("transform", "translate(0," + h + ")")
	            .call(xAxis);
//	            .selectAll("text")
//	            .style("text-anchor", "end")
//	            .attr("dx", "-.8em")
//	            .attr("dy", "-.55em");
	            

	       		svg.append("g")
	            .attr("class", "y axis")
	            .call(yAxis)
	            .append("text")
	            .attr("transform", "rotate(-90)")
	            .attr("y", 6)
	            .attr("dy", ".71em")
	            .style("text-anchor", "end")
	            .text("Frequency");
	       		
				svg.on("click", function(){
					  console.log('SVG Click');
					  refreshBars();
				  });
}

function highlightBar(svg,bar,value){
					console.log("Highlight Bar", value);
//					var rect = bar.select("rect");
//					console.log("Rect:" , rect);
					
					
					var rect = bar.select("rect").style("fill","green");
//						.attr("width", w / bins - barPadding + 3)
//						.attr("height",function(value){
//							 return value*4 + 3;
//						})
//						.attr("y", function(value){
//							return h - value*4 - 3;
//						});
					
					var x = Math.floor((Number(rect.attr("x")) + (w / bins - barPadding)) / 2);
					var y = Number(rect.attr("y")) + 14;

//					console.log(svg)
					
					bar.append("text")
					   .text(function(){
						   console.log("text" ,value, x,y);
						   return value;
					   })
					   .attr("x", x + 1.5)
		  		 	   .attr("y", y)
		   			   .attr("font-family", "sans-serif")
		   			   .attr("font-size", "11px")
		   			   .attr("fill", "black")
		   			   .attr("text-anchor", "middle");	
					
				}
				
function restoreBar(bar,d){
					console.log("Restore Bar", d);
					
					bar.selectAll("text").remove();
					var rect = bar.select("rect");
					
					rect.style("fill", function(d) {
					    return "rgb(0, " + (d * 10)%255 + ",  0 )";
					    })
						.attr("width", w / bins - barPadding + 3)
						.attr("height",function(d){
							 return d*4;
						})
						.attr("y", function(d){
							return h - d*4;
						});
				}
