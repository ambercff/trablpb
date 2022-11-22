<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Atualiza��o do Livro</title>
	</head>
	<body>
		<h3>Atualiza��o do Livro</h3>
		
		<form action="LivroController" method="post">
			<label for="id">ID: </label>
			<input type="number" id="id" name="id" value="${livro.id}" readonly><br><br>
			
			<label for="nomeLivroId">Nome do livro: </label>
			<input type="text" id="nomeLivroId" name="nomeLivroCampo" value="${livro.nomeLivro}"><br><br>
		
			<label for="autorId">Autor: </label>
			<input type="text" id="autorId" name="autorCampo" value="${livro.autor}"><br><br>
			
			<label for="editoraId">Editora: </label>
			<input type="text" id="editoraId" name="editoraCampo" value="${livro.editora}"><br><br>
			
			<label for="dataLancId">Data de Lan�amento: </label>
			<input type="text" id="dataLancId" name="dataLancCampo" value="${livro.dataLanc}"><br><br>
			
			<label for="precoId">Pre�o: </label>
			<input type="number" id="precoId" name="precoCampo" step="0.1" value="${livro.preco}"><br><br>
			
			<label for="generoId">Genero: </label>
			<input type="text" id="generoId" name="generoCampo" value="${livro.genero}"><br><br>
			
			<label for="pagId">P�ginas: </label>
			<input type="number" id="pagId" name="pagCampo" value="${livro.paginas}"><br><br>
		
			<input type="submit" value="Atualizar" name="operacao">
		</form>
	</body>
</html>