function forceLayout(){
	
	dataset = drawForce();
	console.log(dataset);
	var w = 900;
	var h = 500;
	var colors = d3.scale.category20(); 
	
//	d3.select("svg").remove();
//	var info = d3.select("#info");
//	info.text(JSON.stringify(dataset));
	svg = d3.select("#svg")
	.append("svg")
	.attr("width",w + margin.left + margin.right)
	.attr("height",h + margin.top + margin.bottom);
//.append("g")
//.attr("transform", "translate(" + margin.left + "," + margin.top*3 + ")");


	var force = d3.layout.force()
	.nodes(dataset.nodes)
	.links(dataset.links)
	.size([w, h])
	.linkDistance([250])        // <-- New!
	.charge([-200])            // <-- New!
	.start();
	
	var links = svg.selectAll("line")
	.data(dataset.links)
	.enter()
	.append("line")
	.style("stroke", "#ccc")
	.style("stroke-width", function(d) { return Math.sqrt(d.value); });
	
	var nodes = svg.selectAll("circle")
	.data(dataset.nodes)
	.enter()
	.append("circle")
	.attr("r", 10)
	.style("fill", function(d, i) {
		return colors(i);
	})
	.call(force.drag);
	force.on("tick", function() {

//		links.attr("x1", function(d) { return d.source.x; })
//		.attr("y1", function(d) { return d.source.y; })
//		.attr("x2", function(d) { return d.target.x; })
//		.attr("y2", function(d) { return d.target.y; });
//
//		nodes.attr("cx", function(d) { return d.x; })
//		.attr("cy", function(d) { return d.y; });

	});
}
