package Controller;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Model.Livro;
import Model.LivroDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/MetodosController")
public class MetodosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LivroDAO livrosDAO;

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("livro-jpa");

	@Override
	public void init() throws ServletException {
		livrosDAO = new LivroDAO(emf);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String operacao = request.getParameter("operacao");
		operacao = operacao.toLowerCase();		
		switch(operacao) {
		case "calcular promocao":
			buscarLivroPromocao(request, response); 
			break; 
			
		case "calcular idade":
			buscarLivroIdade(request, response);
			break; 
			
		case "calcular tempo":
			buscarLivroTempo(request, response);
			break; 
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	
	private void buscarLivroPromocao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Livro livro = livrosDAO.procurarLivro(id);
		
		request.setAttribute("livro", livro);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/calcularPromocao.jsp");
		dispatcher.forward(request, response);
	}
	
	private void buscarLivroIdade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Livro livro = livrosDAO.procurarLivro(id);
		
		request.setAttribute("livro", livro);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/calcularIdade.jsp");
		dispatcher.forward(request, response);
	}
	
	private void buscarLivroTempo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Livro livro = livrosDAO.procurarLivro(id);
		
		request.setAttribute("livro", livro);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/calcularTempo.jsp");
		dispatcher.forward(request, response);
	}
}