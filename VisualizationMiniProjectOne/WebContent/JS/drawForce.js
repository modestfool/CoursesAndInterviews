var dataset = { nodes:[],links :[]};

function drawForce() {

	d3.select("svg").remove();
	
	var nodes = [];
	var matrix ={};
	
	var v = d3.csv("data/1987_Flights.csv",filter,
			function(csvdata) {
		csvdata.map(function(d){
//			console.log(d);
			var index = nodes.indexOf(d.Origin)
			if (index < 0)
				{
//					var src = {}
					var dest = {};
					dest[d.Dest] = 1;
//					dest['count'] = 1;
//					src[d.Origin] = dest;
					
					nodes.push(d.Origin);
					matrix[d.Origin] = dest;
//					console.log(nodes);
				}
			else
				{
					for (var dest in matrix[d.Origin])
						{
							if (matrix[d.Origin].hasOwnProperty(dest)){
								matrix[d.Origin][dest]++;
								break;
							}
						}
				}
		});
		console.log("Matrix:" ,matrix, Object.keys(matrix).length);
		console.log("Nodes:", nodes,nodes.length);
//		console.log(nodes);
//		dataset = 
		srcdst(matrix,nodes,dataset);
	});
	return dataset;
}
	
	function filter(d){
		return {
			Origin : d.Origin,
			Dest : d.Dest
		};
	}

//	process();
	
	function srcdst(matrix,nodes,dataset){
		for (var i = 0; i < nodes.length; i++){
			var obj = {};
			var link = {};
			var node = matrix[nodes[i]];
			obj['name'] = nodes[i];
			dataset.nodes.push(obj);
			
			
			for (var dest in matrix[nodes[i]])
				{
					if(matrix[nodes[i]].hasOwnProperty(dest))
						{
							var index = nodes.indexOf(dest);
							if ( index > 0)
							{
								link['target'] = index;
								link['source'] = i;
								link['value'] = node[dest];
								dataset.links.push(link);
							}
						}
				}
		}
		console.log(dataset);
		return dataset;
	}
	
	function process(values,nodes,dataset){
		console.log(values);
		console.log(nodes);
		for (var i = 0; i < nodes.length; i++) 			
		{           
			var obj = {};
			obj['name'] = nodes[i];
			dataset.nodes.push(obj);
			for (var j = i + 1; j < nodes.length; j++)
				{
//					dataset.edges.source.push("{ source:" + i + ", target: " + j + ", value: " + Math.abs(values[i]-values[j]) +"}");
					var link = {};
					link['source'] = i;
					link['target'] = j;
					link['value'] = Math.abs((values[i] - values[j])/100);
					dataset.links.push(link);
				}
		}
		console.log(dataset);
		return dataset;
	}