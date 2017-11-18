
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Horizontal Nav & Subnav for Bootstrap</title>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js" type="text/javascript"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.5.1/moment.min.js" type="text/javascript"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.0.0/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>  
    <script src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.4.0/lang/en-gb.js" type="text/javascript"></script>

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://getbootstrap.com/assets/css/ie10-viewport-bug-workaround.css"
	rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">BRAND X</a>
			</div>
			<div class="navbar-collapse collapse navbar-right main-nav"
				id="navbar">
				<ul class="nav navbar-nav ">
					<li id="sub-1"><a href="#products">Products &amp; Services</a></li>
					<li id="sub-2"><a href="#features">Features</a></li>
					<li id="sub-3"><a href="#about">About</a></li>
					<li id="sub-4"><a href="#faqs">FAQS</a></li>
				</ul>
				<form class="navbar-form navbar-right">
					<button type="submit" class="btn btn-warning">CALL 2
						ACTION</button>
				</form>
				<div class="bottom-arrow"></div>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</nav>

	<!-- Sub navbar -->
	<nav class="subnavbar navbar navbar-fixed-top">
		<div class="container">
			<div class="navbar-collapse collapse navbar-right" id="subnavbar">

				<ul class="nav navbar-nav sub-1" style="display: none;">
					<li class="active"><a href="#sprockets">Sprockets</a></li>
					<li><a href="#housewares">Housewares</a></li>
					<li><a href="#widgets">Widgets &amp; Whatnots</a></li>
					<li><a href="#tools">Tools</a></li>
					<li><a href="#utilities">Utilities</a></li>
				</ul>

				<ul class="nav navbar-nav sub-2" style="display: none;">http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js
					<li class="active"><a href="#marketing">Marketing</a></li>
					<li><a href="#sales">Sales</a></li>
					<li><a href="#service">Customer Service</a></li>
					<li><a href="#security">Security</a></li>
					<li><a href="#legal">Rights &amp; Privacy</a></li>
				</ul>

				<ul class="nav navbar-nav sub-3" style="display: none;">
					<li class="active"><a href="#w1">Who</a></li>
					<li><a href="#w2">What</a></li>
					<li><a href="#w3">When</a></li>
					<li><a href="#w4">Where</a></li>
					<li><a href="#w5">Why</a></li>
				</ul>

				<ul class="nav navbar-nav sub-4" style="display: none;">
					<li class="active"><a href="#g1">General</a></li>
					<li><a href="#g2">Social Networking</a></li>
					<li><a href="#g3">Servicing</a></li>
					<li><a href="#g4">Plans</a></li>
				</ul>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</nav>
	<div class="container" style="margin-top: 65px;">
		<div class="row">
			<div class="col-sm-12">
				<form action="adicionaContato" method="post">
					<div class="form-group">
						<label for="nome">nome:</label> <input type="text"
							class="form-control" id="nome" name="nome">
					</div>

					<div class="form-group">
						<label for="email">Email address:</label> <input type="email"
							class="form-control" id="email" name="email">
					</div>

					<div class="form-group">
						<label for="endereco">EndereÃ§o:</label> <input type="text"
							class="form-control" id="endereco" name="endereco">
					</div>

					<div class="form-group">
						<label for="data-de-nascimento">Data de Nascimento:</label> 
						<!-- input type="text" class="form-control" id="dataDeNascimento" name="dataDeNascimento"> -->
						<caelum:campoData id="dataNascimento" />
					</div>
					<button type="submit" class="btn btn-primary">Submit</button>
				</form>
			</div>
		</div>
	</div>
 
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"
		type="text/javascript"></script>
</body>
</html>
