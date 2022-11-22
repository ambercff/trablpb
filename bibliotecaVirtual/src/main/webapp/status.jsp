<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Status</title>
	</head>
	<body>
		<h3>Status da operação</h3>
		
		<p>
			<c:choose>
				<c:when test="${status}">
					O livro foi ${operacao} com sucesso!!
				</c:when>
				<c:otherwise>
					Erro! O livro não foi ${operacao}.
				</c:otherwise>
			</c:choose>
		</p>
		
		<a href="LivroController?operacao=Listar">Voltar</a>
	</body>
</html>