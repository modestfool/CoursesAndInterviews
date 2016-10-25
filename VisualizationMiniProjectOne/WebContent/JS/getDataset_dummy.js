
function readCSV()
{
//	Checks which graph to Plot
	if (typeof readCSV.counter === 'undefined')
		readCSV.counter = 0;
	else
		readCSV.counter += 1;
	// To update the button's label
	var button = d3.select("#chartButton");
	
	d3.select("#info").selectAll("text").remove();
	
	var info = d3.select("#info")
					.append("text")
					.attr("class","info");
	
	// Update the button label and text for the appropriate graph type.
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
	
	// Read the CSV, filter and pass it along to the Bar Chart or Pie Chart functions
	var dataset = [];
	d3.csv("data/1987_Flights.csv",filterColumns,
			function(error, csvdata) {
		console.log(csvdata[0]);
		if (readCSV.counter % 2 == 0)	
			hist(csvdata);
		else
			drawPie(csvdata);
	}); 
}

// Filter only the interesting columns 
function filterColumns(d){
	return {
		FlightNum : d.FlightNum,
		DayofMonth : +d.DayofMonth,
		DepTime : Math.round(+d.DepTime*0.01),
		ActualElapsedTime : +d.ActualElapsedTime,
		DepDelay : +d.ArrDelay
	};
}

// Called by both the Bar and Pie chart plots to get only the current variable's data
function preprocess(csvdata, numbins, index)
{
	console.log("Preprocess");
	var ActualElapsedTime = [],
	DayofMonth = [],
	DepTime = []
	DepDelay = [],
	currCol =[];

	csvdata.map(function(d){
		ActualElapsedTime.push(d.ActualElapsedTime);
		DayofMonth.push(d.DayofMonth);
		DepTime.push(d.DepTime);
		DepDelay.push(d.DepDelay);
	});
	
	
//	console.log("index",index);
//	Using the constructor's static 'index' to target the current variable
	switch(index % 4)
	{
	case 0: 
		currCol = ActualElapsedTime;
		break;
	case 1:
		currCol = DayofMonth;
		break;
	case 2:
		currCol = DepTime;
		break;
	case 3:
		currCol = DepDelay;
		break;
	default:
		currCol = ActualElapsedTime;
	}
	
	minbin = d3.min(currCol, function(d){
		return d;
	});
	maxbin = d3.max(currCol, function(d){
		return d;
	});
	
	
	// Bin them appropriately based on the number of bins chosen
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

	// Finally fill the hist with respective frequency counts
	currCol.forEach(function(d) {
		var bin = Math.floor((d - minbin) / binsize);
		if ((bin.toString() != "NaN") && (bin < histdata.length)) {
			histdata[bin].numfill += 1;
		}
	});

	return histdata;
}