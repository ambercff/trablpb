<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="utf-8">
	<title>Projeto Livros - Calcular promoção</title>

	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="css/idLivro.css">
</head>

<body>
	<div class="box">
		<h3>Livros - Calcular promoção</h3>
	
		<div class="box-body">
			<p class="instrucao">Insira o seu <b>desconto (em %)</b>, por favor.</p>

			<div class="form-container">
				<form action="metodo.jsp" method="POST">
					<input type="hidden" id="idId" name="idCampo" value="${livro.id}">
					
					<div class="linha field">
						<label for="descontoId">Desconto: </label>
						<input type="number" id="descontoId" name="descontoCampo" placeholder="(somente números)" required>
					</div>
					
					<input type="hidden" name="metodo" value="calcularpromocao">
					
					<div class="linha enviar">
						<input class="botao-main" type="submit" value="Calcular promocao" name="operacao">
					</div>
				</form>
			</div>

			<div class="link-container">
				<a class="link" href="index.html">Voltar para o menu</a>
			</div>
		</div>
	</div>
</body>
</html>