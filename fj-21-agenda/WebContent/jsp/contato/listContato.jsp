<%@page import="br.com.caelum.vo.ContatoVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- <jsp:useBean id="dao" class="br.com.caelum.dao.ContatoDAO"></jsp:useBean>-->
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Horizontal Nav & Subnav for Bootstrap</title>
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
				<table class="table">
					<c:forEach items="${contatoVOs}" var="contatoVO">
						<tr>
							<td>${contatoVO.nome}</td>
							<td><c:if test="${empty contatoVO.email}">
    								${contatoVO.email}
								</c:if> <c:if test="${not  empty contatoVO.email}">
									<a href="mailto:${contatoVO.email}"> ${contatoVO.email} </a>
								</c:if></td>
							<td>${contatoVO.endereco}</td>
							<td>
								<fmt:formatDate value="${contatoVO.dataNascimento.time}" var="formattedDate"  type="date" pattern="dd/MM/yyyy" />${formattedDate}							
							</td>
							<td>
								<a href="mvc?logica=RemoveContatoLogic&id=${contatoVO.contatoID}" >Remover</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"
		type="text/javascript"></script>
</body>
</html>