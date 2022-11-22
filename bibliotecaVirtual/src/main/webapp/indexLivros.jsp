<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Projeto Livros</title>
	</head>
	<body>
		<h3>Livros</h3>

		<a href="infoLivro.html"><input type="button" value="Cadastrar"></a><br><br>	
		
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome do Livro</th>
					<th>Autor</th>
					<th>Editora</th>
					<th>Data Lançamento</th>
					<th>Preço</th>
					<th>Gênero</th>
					<th>Páginas</th>
					<th> </th>
					<th> </th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="livro" items="${livrosBanco}">
					<tr>
						<td>${livro.id}</td>
						<td>${livro.nomeLivro}</td>
						<td>${livro.autor}</td>
						<td>${livro.editora}</td>
						<td>${livro.dataLanc}</td>
						<td>${livro.preco}</td>
						<td>${livro.genero}</td>
						<td>${livro.paginas}</td>
						<td><a href="LivroController?operacao=Buscar&id=${livro.id}">Buscar</a></td>
						<td><a href="LivroController?operacao=Remover&id=${livro.id}">Remover</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<a href="UsuarioController?operacao=Sair">Sair</a>
	</body>
</html>