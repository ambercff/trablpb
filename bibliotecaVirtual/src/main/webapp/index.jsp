<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
	</head>
	<body>
		<c:if test="${usuarioexiste = false}">
			<p>Usuário informado não existe.</p>
		</c:if>
		
		<h3>Aplicação Tarefas</h3>
		 
		<form action="UsuarioController" method="post">
			<label for="loginId">Login: </label>
			<input type="text" id="loginId" name="login"><br><br>
		
			<label for="senhaId">Senha: </label>
			<input type="password" id="senhaId" name="senha"><br><br>
			
			<input type="submit" value="Entrar" name="operacao">
		</form>
		
		<br><a href="infoUsuario.html">Cadastre-se</a>
	</body>
</html>