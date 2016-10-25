<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

<link rel="stylesheet"
	href="resourcefiles/js/httpmaxcdn.bootstrapcdn.combootstrap3.3.4cssbootstrap.min.css">
<script
	src="resourcefiles/js/httpsajax.googleapis.comajaxlibsjquery1.11.1jquery.min.js"></script>
<script
	src="resourcefiles/js/httpmaxcdn.bootstrapcdn.combootstrap3.3.4jsbootstrap.min.js"></script>
<link rel="stylesheet"
	href="resourcefiles/js/httpcdnjs.cloudflare.comajaxlibsbootstrap-datepicker1.3.0cssdatepicker.min.css" />
<link rel="stylesheet"
	href="resourcefiles/js/httpcdnjs.cloudflare.comajaxlibsbootstrap-datepicker1.3.0cssdatepicker3.min.css" />
<script
	src="resourcefiles/js/httpajax.googleapis.comajaxlibsjquery1.11.2jquery.min.js"></script>
<script
	src="resourcefiles/js/httpcdnjs.cloudflare.comajaxlibsbootstrap-datepicker1.3.0jsbootstrap-datepicker.min.js"></script>

<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.3.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="https://cdn.plot.ly/plotly-latest.min.js"></script>

<script src="resourcefiles/js/jquery-1.11.1.min.js"></script>
<script src="resourcefiles/js/jquery.dataTables.min.js"></script>
<script src="resourcefiles/js/dataTables.bootstrap.js"></script>

<link rel="stylesheet" type="text/css"
	href="resourcefiles/css/jquery.dataTables.min.css">

<link rel="stylesheet" type="text/css"
	href="resourcefiles/js/httpcdn.datatables.net1.10.2cssjquery.dataTables.css">

<link rel="stylesheet" type="text/css"
	href="resourcefiles/js/httpcdn.datatables.nettabletools2.2.2cssdataTables.tableTools.css">


<script type="text/javascript" charset="utf8"
	src="resourcefiles/js/httpcdn.datatables.nettabletools2.2.2jsdataTables.tableTools.js"></script>

<link rel="stylesheet" href="resourcefiles/css/mystyle.css">
<script src="resourcefiles/js/myscript.js"></script>

<title>Stocks Monitor</title>
</head>
<body>

	<div id="show" align="center"></div>

	<div align="center"></div>
	<script>
		function refreshTable() {
			$('#cos tbody').remove();
			$.ajax({
				type : "GET",
				url : "ListCompanies",
				contentType : "application/json; charset=utf-8",
				success : function(res) {
					
					var companies = res["companies"];
					var parsedCos = JSON.parse(companies);

					var count = 1;
					var trHTML = '<tbody>';
					$.each(parsedCos, function(i, item) {

						trHTML += '<tr><td>' + count + '</td><td>' + item.name
								+ '</td><td>' + item.code + '</td><td>'
								+ item.lastUpdated + '</td><td>'
								+ item.stockPrice
								+ '</td></tr>';

						count++;

					});

					trHTML += '</tbody>';
					$('#cos').append(trHTML);
				}
			});

		    $(document)
					.ajaxComplete(
							function() {
								$('#cos')
										.dataTable(
												{
													"dom" : 'T<"clear">lfrtip',
													destroy : true,
													"pagingType" : "full_numbers",

													"tableTools" : {
														"aButtons" : [ "copy",
																"xls", "csv",
																"pdf", "print" ],
														"sSwfPath" : "resourcefiles/swf/copy_csv_xls_pdf.swf"
													},

												});

								$('#cos').show();
								var table = $('#cos').DataTable();
								var coname = "";
								var cocode = "";

								$('#cos tbody')
										.on(
												'click',
												'tr',
												function() {
													
													if ($(this).hasClass(
															'selected')) {
														$(this).removeClass(
																'selected');
													} else {
														table
																.$('tr.selected')
																.removeClass('selected');
														$(this).addClass(
																'selected');
													}  

													var rowData = table.row(
															'.selected').data();
													if(rowData){
														coname = rowData[1];
														cocode = rowData[2];
														console.log(coname);
													}
												}); 
								$("#delete")
										.click(
												function() {

													if (!coname) {
														alert("Please select a company to delete.");
														exit();
													}

													table.row('.selected').remove().draw(false);
													$.ajax({
																type : "GET",
																url : "DeleteCompany",
																data : {
																	name : coname
																},
																contentType : "application/json; charset=utf-8",
																success : function(res) {
																	location.reload();
																}
															});
												});

								$("#view")
										.click(
												function() {

													if (!cocode) {
														alert("Please select a company to view its historic stocks data.");
														exit();
													}

													$
															.ajax({
																type : "GET",
																url : "CompanyHistory",
																data : {
																	code : cocode
																},
																contentType : "application/json; charset=utf-8",
																success : function(res) {
																	location.reload();
																	var stocks = res["stocks"];
																	var parsedStocks = JSON.parse(stocks);
																	var trace = {
																		x : parsedStocks["map"]["x"],
																		y : parsedStocks["map"]["y"],
																		type : 'scatter'
																	};
																	var layout = {
																		title : "Historic Stocks of "+ coname,
																		xaxis : {
																			title : "Datetime",
																			titlefont : {
																				family : 'Courier New, monospace',
																				size : 18,
																				color : '#7f7f7f'
																			}
																		},
																		yaxis : {
																			title : 'Stock Price',
																			titlefont : {
																				family : 'Courier New, monospace',
																				size : 18,
																				color : '#7f7f7f'
																			}
																		}
																	};
																	
																	var chartData = [ trace ];
																	Plotly.newPlot(
																					'chart',
																					chartData,
																					layout);
																}
															});
													table.rows('.selected').deselect();
												});
							});

		}
		function refresh_handler() {
			setInterval(refreshTable(), 0, 300 * 1000); //every 5 minutes
		}

		$(document).ready(function() {
			refresh_handler();
			
			$('#cos tbody').on('click', 'tr', function() {
				if ($(this).hasClass('selected')) {
					$(this).removeClass('selected');
				} else {
					table.$('tr.selected').removeClass('selected');
					$(this).addClass('selected');
				}
			});

			$("#addCompany").hide();

		});
	</script>

	<TABLE id="cos" class="display" style="width: 100%">
		<thead>
			<TR>
				<TH>S.No.</TH>
				<TH>COMPANY</TH>
				<TH>CODE</TH>
				<TH>LAST UPDATED</TH>
				<TH>STOCK PRICE</TH>
			</TR>
		</thead>
	</TABLE>

	<button type="button" class="btn btn-primary" id="add">Add
		Company</button>
	<button type="button" class="btn btn-primary" id="delete">Delete
		Company</button>
	<button type="button" class="btn btn-primary" id="view">View
		Company Stocks</button>
	<button type="button" class="btn btn-primary" id="refresh">Reload</button>
	<br />
	<br />

	<div id="addCompany" class="input-group">
		<input type="text" class="form-control" placeholder="Company Name"
			id="coname"> <input type="text" class="form-control"
			placeholder="Company Code" id="cocode">
		<button type="button" class="btn btn-primary" id="saveCompany">Save</button>
	</div>
	<br />


	<div id="chart" style="width: 800px; height: 480px;"></div>

	<script>
		$('#refresh').click(function() {
			//refreshTable();
		    location.reload();
		});
		
		$('#add').click(function() {
			$("#addCompany").show();

			$("#saveCompany").click(function() {
				var coname = $('#coname').val();
				var cocode = $('#cocode').val();
				$.ajax({
					type : "GET",
					url : "AddCompany",
					data : {
						name : coname,
						code : cocode
					},
					contentType : "application/json; charset=utf-8",
					success : function(res) {
						location.reload();
					}
				});
				$("#addCompany").hide();
				$("#coname").val("");
				$("#cocode").val("")
			});
		});
	</script>
	<br />
	<br />
</body>
</html>