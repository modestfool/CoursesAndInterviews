function getDataset()
{
	var dataset = [];                        //Initialize empty array
	for (var i = 0; i < 10; i++) 			//Loop 25 times
	{           
		var newNumber = Math.floor(Math.random() * 20) + 5;  //New random number (0-30)
		dataset.push(newNumber);             //Add new number to array
	}
	return dataset;
}


function readCSV()
{
//	d3.select("#chartButton").text("asdsa");
	
	if (typeof readCSV.counter === 'undefined')
		readCSV.counter = 0;
	else
		readCSV.counter += 1;
	var button = d3.select("#chartButton");
	
	
	var info = d3.select("#info");
	if (readCSV.counter % 2 == 0)
	{
		button.text("Pie chart");
		info.text(" To update the Bin size, hover on the text in the right corner. " +
				"As you move along it, the number of bins are adjusted from 5 to 25.");
	}
	else
	{
		button.text("Bar chart");
		info.text(" To rotate the Pie Chart, hover on the text in the right corner. " +
		"As you move along it, the chart is rotated from 0 through 360 degrees.");
	}
	
	var dataset = [];
	d3.csv("data/Clothing.csv",filterColumns,
			function(error, csvdata) {
		if (readCSV.counter % 2 == 0)	
			hist(csvdata);
		else
			drawPie(csvdata);
	}); 
}

function filterColumns(d){
	return {
		id : d.id,
		tsales : +d.tsales,
		sales : +d.sales,
		margin : +d.margin,
		nown : +d.nown
	};
}


function preprocess(csvdata, numbins, index)
{
	console.log("Preprocess");
	var margin = [],
	tsales = [],
	sales = []
	nown = [],
	currCol =[];

	csvdata.map(function(d){
		margin.push(d.margin);
		tsales.push(d.tsales);
		sales.push(d.sales);
		nown.push(d.nown);
	});
	
	console.log("index",index);
	
	switch(index % 4)
	{
	case 0: 
		currCol = margin;
		break;
	case 1:
		currCol = tsales;
		break;
	case 2:
		currCol = sales;
		break;
	case 3:
		currCol = nown;
		break;
	default:
		currCol = margin;
	}
	
	minbin = d3.min(currCol, function(d){
		return d;//d.margin;
	});
	maxbin = d3.max(currCol, function(d){
		return d;//d.margin;
	});
	

	var binsize = (maxbin - minbin) / numbins;
	
	console.log(minbin,maxbin);
	histdata = new Array(numbins);
	for (var i = 0; i < numbins; i++) {
		histdata[i] = {
						numfill: 0,
						startValue: Math.round((binsize*i + minbin)),
						endValue: Math.ceil(((binsize*(i+1)) + minbin)),
						total: 0
						};
	}

	// Fill histdata with y-axis values
	currCol.forEach(function(d) {
		var bin = Math.floor((d - minbin) / binsize);
		if ((bin.toString() != "NaN") && (bin < histdata.length)) {
			histdata[bin].numfill += 1;
//			histdata[bin].startValue = bin*binsize + minbin;
//			histdata[bin].endValue = (bin+1)*binsize - 1 + minbin;
		}
	});

	return histdata;
}