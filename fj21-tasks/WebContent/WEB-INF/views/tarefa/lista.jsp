<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Tarefas!!!</h2>
	<table class="table">
		<c:forEach items="${tarefas}" var="tarefa">
			<tr>
				<td>${tarefa.id}</td>
				<td>${tarefa.descricao} </td>
				<td>
				<td> 
				<input type="text" name="lname" value="${(tarefa.finalizado)? 'Finalizado' : 'nao finalizado'}"/>
				<c:set var="value" scope="request" value="${tarefa.finalizado}"/>
				<c:out default="false" escapeXml="true" value="${empty value?'None':value}"/>
				 
				</td>
				<fmt:formatDate value="${tarefa.dataFinalizacao.time}"
						var="formattedDate" type="date" pattern="dd/MM/yyyy" />${formattedDate}
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>