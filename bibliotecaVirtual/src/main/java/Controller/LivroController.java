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

@WebServlet("/LivroController")
public class LivroController extends HttpServlet {
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

		switch (operacao) {
		case "listar":
			listarLivros(request, response);
			break;
		case "buscar":
			buscarLivro(request, response);
			break;
		case "remover":
			removerLivro(request, response);
			break;
		default:
			System.out.println("Erro! Operação não encontrada.");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String operacao = request.getParameter("operacao");
		operacao = operacao.toLowerCase();

		switch (operacao) {
		case "cadastrar":
			cadastrarLivro(request, response);
			break;
		case "atualizar":
			atualizarLivro(request, response);
			break;
		default:
			System.out.println("Erro! Operação não encontrada.");
		}
	}

	private void listarLivros(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");

		List<Livro> listaLivros = livrosDAO.consultarLivros(usuario);

		request.setAttribute("livrosBanco", listaLivros);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/indexLivros.jsp");
		dispatcher.forward(request, response);
	}

	private void cadastrarLivro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");

		String nomeLivro = request.getParameter("nomeLivroCampo");
		String autor = request.getParameter("autorCampo");
		String editora = request.getParameter("editoraCampo");
		String dataLanc = request.getParameter("dataLancCampo");
		double preco = Double.parseDouble(request.getParameter("precoCampo"));
		String genero = request.getParameter("generoCampo");
		int paginas = Integer.parseInt(request.getParameter("pagCampo"));

		boolean inseriu = livrosDAO.inserirLivro(nomeLivro, autor, editora, dataLanc, preco, genero, paginas, usuario);

		request.setAttribute("status", inseriu);
		request.setAttribute("operacao", "cadastrada");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/status.jsp");
		dispatcher.forward(request, response);
	}

	private void removerLivro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		boolean excluiu = livrosDAO.excluirLivro(id);

		request.setAttribute("status", excluiu);
		request.setAttribute("operacao", "removida");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/status.jsp");
		dispatcher.forward(request, response);
	}

	private void buscarLivro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		Livro livroBanco = livrosDAO.procurarLivro(id);

		request.setAttribute("livro", livroBanco);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/atualizaLivro.jsp");
		dispatcher.forward(request, response);
	}

	private void atualizarLivro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");

		int id = Integer.parseInt(request.getParameter("id"));
		String nomeLivro = request.getParameter("nomeLivroCampo");
		String autor = request.getParameter("autorCampo");
		String editora = request.getParameter("editoraCampo");
		String dataLanc = request.getParameter("dataLancCampo");
		double preco = Double.parseDouble(request.getParameter("precoCampo"));
		String genero = request.getParameter("generoCampo");
		int paginas = Integer.parseInt(request.getParameter("pagCampo"));

		boolean atualizou = livrosDAO.modificarLivro(id, nomeLivro, autor, editora, dataLanc, preco, genero, paginas,
				usuario);

		request.setAttribute("status", atualizou);
		request.setAttribute("operacao", "atualizada");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/status.jsp");
		dispatcher.forward(request, response);
	}
	
}