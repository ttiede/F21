<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.2.1.js"
  integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
  crossorigin="anonymous"></script>
</head>
<body>
	<h2>Tarefas!!!</h2>
	<table class="table">
		<c:forEach items="${tarefas}" var="tarefa">
			<tr>
				<td>${tarefa.id}</td>
				<td>${tarefa.descricao} </td>
				<td> 
				<p id="tarefa_${tarefa.id}"> ${tarefa.finalizado}<p/>	
					<c:if test="${tarefa.finalizado eq false}">
					<a href="#" onclick="finaliza(${tarefa.id})">Finalizar</a>
				</c:if>
				</td>
				<td>
				<fmt:formatDate value="${tarefa.dataFinalizacao.time}"
						var="formattedDate" type="date" pattern="dd/MM/yyyy" />${formattedDate}
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
<script type="text/javascript">

var finaliza = function(id){
	$.post("finalizaTarefa", {'id': id}, function(){
		$("#tarefa_"+id).html("Finalizado");
	});
}

</script>
</html>