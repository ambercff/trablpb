<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.Random"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Projeto Livros Status</title>

	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" href="css/metodo.css">
</head>

<body>
	<div class="box">
		<%
			/*
			String nomeLivro = (String) request.getAttribute("nomeLivro");
			String autor = (String) request.getAttribute("autor");
			String editora = (String) request.getAttribute("editora");
			String dataLanc = (String) request.getAttribute("dataLanc");
			double preco = (double) request.getAttribute("preco");
			String genero = (String) request.getAttribute("genero");
			int paginas = (int) request.getAttribute("paginas");
			
			String metodo = request.getParameter("metodo");
			metodo = metodo.toLowerCase();
			
			
			String titulo = "";
			
			String res = "";
			*/
			
			
			
			//CORES ALEATÓRIAS DO LIVRO
			Random r = new Random();
			int red = r.nextInt(256);
			int green = r.nextInt(256);
			int blue = r.nextInt(256);
			
			
			/*
			switch (metodo) {
				case "calcularpromocao":
					double novoPreco = (double) request.getAttribute("novoPreco");
					String novoPrecoFormatado = new DecimalFormat("#,##0.00").format(novoPreco);
					
					if (novoPreco == 0)
						titulo = "Cálculo de promoção: falhou";
					
					titulo = "Cálculo de promoção";
					res = "Preço do livro com promoção: <b>R$" + novoPrecoFormatado + "</b>";
					
					break;
					
					
					
				case "calcularidade":
					int idade = (int) request.getAttribute("idade");
					
					titulo = "Cálculo de idade";
					
					if (idade == 1)
						res = "Idade do livro: <b>" + idade + " ano</b>";
					
					res = "Idade do livro: <b>" + idade + " anos</b>";
					break;
					
					
					
				case "calculartempo":
					int tempoMedio = (int) request.getAttribute("tempoMedio");
					
					titulo = "Tempo médio de leitura";
					
					res = "Tempo médio de leitura do livro: <b>" + tempoMedio + " minutos</b>";
							
					break;
					
					
					
				default:
					titulo = "Erro";
					res = "inválido";
			}
			*/
			
		%>
		
		<c:set var="titulo"/>
		<c:set var="novoPreco" value="${livro.calcularPromocao(requestScope.desconto)}"/>
		<c:set var="res"/>
		
		<c:choose>
			<c:when test="${!requestScope.metodo.equals('sexo')}">
				<c:if test="${novoPreco <= 0}">
					${titulo = "Cálculo de promoção: falhou"}
				</c:if>
				
				<%-- 
				//String novoPrecoFormatado = new DecimalFormat("#,##0.00").format(novoPreco);
				--%>
				
				${titulo = "Cálculo de promoção"}
				
				
				<%-- 
				res = "Preço do livro com promoção: <b>R$" + novoPrecoFormatado + "</b>";
				--%>
			</c:when>
		</c:choose>
		
		<c:if test="${requestScope.metodo}"></c:if>
		
		<h3>Livros - ${titulo}</h3>
		
		<div class="box-body">
			<div class="livro">
				<div class="capa" style="background-color: rgb(<%=red%>, <%=green%>, <%=blue%>)">
					<h1>
						${livro.nomeLivro.charAt(0)}
					</h1>
				</div>
			
				<ul>
					<li>Nome do livro: <b>${livro.nomeLivro}</b></li>
					<li>Autor: <b>${livro.autor}</b></li>
					<li>Editora: <b>${livro.editora}</b></li>
					<li>Data de lançamento: <b>${livro.dataLanc}</b></li>
					<li>Preço: <b>${livro.preco}</b></li>
					<li>Gênero: <b>${livro.genero}</b></li>
					<li>Páginas: <b>${livro.paginas}</b>
					
					<li class="operacao">${res}.</li>
				</ul>
			</div>

			<div class="link-container">
				<a class="link" href="index.html">Voltar pro menu</a>
			</div>
		</div>
	</div>
</body>
</html>
