
function flight(){

	d3.select("svg").remove();
	d3.select("#info").selectAll("text").remove();

	var info = d3.select("#info")
	.append("text")
	.attr("class","info")
	.text("Each plane icon represents an American Airport. " +
			"And the size of the icon is proportional to the number of flights destined to it. " +
			"Each link represents connectivity between those airports");

	
	  svg = d3.select("#svg")
		.append("svg")
		.attr("width",w + margin.left + margin.right)
		.attr("height",h + margin.top + margin.bottom);

	var force = d3.layout.force()
	.gravity(0.05)
	.distance(60)
	.charge(-300)
	.size([w -margin.right -margin.left, h - margin.top - margin.bottom]);

	d3.json("data/flights.json", function(error, json) {
		if (error) throw error;
		
		var maxCount = +0;
		for (var j = 0; j < json.nodes.length; j++)
			{
				json.nodes[j]["count"] = +0;
			}
		
		for (var i = 0; i < json.links.length; i++)
			{
				var index = +json.links[i]['target'];
				
				if (json.nodes[index].hasOwnProperty('count'))
					{
						json.nodes[index]['count'] += json.links[i]['value'];
						if (maxCount < json.nodes[index]['count'])
							maxCount = json.nodes[index]['count'];
					}
				else
						n['count'] = +json.links['value'];
			}
		
		console.log("Max count",maxCount);
		
		force
		.nodes(json.nodes)
		.links(json.links)
		.start();

		var link = svg.append("svg:g")
		.selectAll(".link")
		.data(json.links)
		.enter().append("line")
		.attr("class", "link");
//		.style("stroke-width", function(d) { return Math.log(d.value); });

		var node = svg.append("svg:g")
		.selectAll(".node")
		.data(json.nodes)
		.enter().append("g")
		.attr("class", "node")
		.call(force.drag);

		var minWidth = 16;
		var scale = d3.scale.linear()
						.range([minWidth, minWidth*4])
						.domain([0, maxCount]);
		
		node.append("image")
		.attr("xlink:href", "data/images.png")
		.attr("x", -8)
		.attr("y", -8)
		.attr("width", function(d) { 
	       return getDim(d);
	    })
		.attr("height", function(d) { 
	       return getDim(d);
	    });
		
		 function getDim (d) {
			 console.log(d.count);
		       if (!isNaN(d.count))
		    	   return scale(d.count);
		       else
		    	   return minWidth;
		    }

		node.append("text")
		.attr("dx", 12)
		.attr("dy", ".35em")
		.text(function(d) { 
			return d.name; 
			});

		force.on("tick", function() {
			link.attr("x1", function(d) { return d.source.x; })
			.attr("y1", function(d) { return d.source.y; })
			.attr("x2", function(d) { return d.target.x; })
			.attr("y2", function(d) { return d.target.y; });

			node.attr("transform", function(d) { return "translate(" + d.x + "," + d.y + ")"; });
		});
	});
}