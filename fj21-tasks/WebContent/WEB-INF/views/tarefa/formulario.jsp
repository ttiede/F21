<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3> Adicionar tarefas</h3>
	
	<form action="adicionaTarefa" method="POST">
		Descrição: </br>
		<textarea rows="5" cols="100" name="descricao"></textarea>
		<input type="submit" value="adicionar">
	</form>
</body>
</html>