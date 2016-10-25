<!DOCTYPE html>
<html lang="en">
<head>
<title>Stock Monitor Tool Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="resourcefiles/js/httpmaxcdn.bootstrapcdn.combootstrap3.3.4cssbootstrap.min.css">
<link rel="stylesheet" href="resourcefiles/css/mystyle.css">
<script
	src="resourcefiles/js/httpsajax.googleapis.comajaxlibsjquery1.11.1jquery.min.js"></script>
<script
	src="resourcefiles/js/httpmaxcdn.bootstrapcdn.combootstrap3.3.4jsbootstrap.min.js"></script>
</head>

<body id="loginbody">

<div class="container">
	<!-- <img src="1.jpg" class="img-thumbnail" alt="Cinque Terre" width="1240" height="236">  -->

	<div class="header-shadow">
		<form action="login" method="POST">

			<div class="col-md-4" id="three">
				<div class="col-md-4" id="four">
					<img src="resourcefiles/images/avatar.jpg" class="img-thumbnail"
						alt="Avatar" id="avatar" width="1240" height="236">
				</div>
				<input type="text" class="form-control" id="usr" value=""
					name="user"> <input type="password" class="form-control"
					id="pwd" value="" name="pass">
				<div class="col-md-12" id="fl">
					<!-- <div class="col-md-6">
				<span id="fp"><u>Forgot Password</u>?</span>
				</div> -->
					<div class="col-md-6">
						<button id="log" class="btn btn-lg btn-primary btn-block"
							type="submit">Login</button>
					</div>
				</div>
			</div>
		</form>

		<%
			String message = "";
			try {
				message = (String) request.getAttribute("message");
				if (!message.isEmpty())
		%>
		<script>
			alert("Username or Password are invalid.Please try again !!");
		</script>
		<%
			} catch (Exception e) {
				if (message != null)
					out.println(message);
			}
		%>
	</div>
</div>
</body>
</html>
