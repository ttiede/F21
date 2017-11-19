
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
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/moment.js/2.5.1/moment.min.js" type="text/javascript"></script>
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
	<c:import url="/jsp/common/menu.jsp"></c:import>
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
