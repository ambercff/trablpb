package Controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Model.Livro;
import Model.LivroDAO;
import Model.Usuario;
import Model.UsuarioDAO;

@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UsuarioDAO usuarioDAO;
	private LivroDAO livrosDAO;
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("livro-jpa");
	
	@Override
	public void init() throws ServletException {
		usuarioDAO = new UsuarioDAO(emf);
		livrosDAO = new LivroDAO(emf);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operacao = request.getParameter("operacao");
		operacao = operacao.toLowerCase();
		
		switch(operacao) {
			case "sair":
				fazerLogoff(request, response);
				break;
			
			default:
				System.out.println("Erro! Operação não encontrada.");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operacao = request.getParameter("operacao");
		operacao = operacao.toLowerCase();
		
		switch(operacao) {
			case "cadastrar":
				cadastrarUsuario(request, response);
				break;
				
			case "entrar":
				fazerLogin(request, response);
				break;
				
			default:
				System.out.println("Erro! Operação não encontrada.");
		}
	}
	
	private void cadastrarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		usuarioDAO.inserirUsuario(login, senha);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
	
	private void fazerLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		RequestDispatcher dispatcher;
		
		Usuario usuario = usuarioDAO.procurarUsuario(login);
		
		if (usuario == null) {
			request.setAttribute("usuarioexiste", false);
			
			dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
			
			return;
		}
		
		
		
		if (!senha.equals(usuario.getSenha())) {
			request.setAttribute("logou", false);
			
			dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
			
			return;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("usuario", usuario);
		
		session.setMaxInactiveInterval(600);
		
		request.setAttribute("logou", true);
		
		List<Livro> listaTarefas = livrosDAO.consultarLivros(usuario);
		
		dispatcher = request.getRequestDispatcher("/indexLivros.jsp");
		dispatcher.forward(request, response);
	}
	
	
	
	private void fazerLogoff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
	
}