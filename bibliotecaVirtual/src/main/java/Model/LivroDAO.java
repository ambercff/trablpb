package Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class LivroDAO {
	private EntityManagerFactory emf;

	public LivroDAO(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}

	public List<Livro> consultarLivros(Usuario usuario) {
		List<Livro> listaLivros = new ArrayList<>();
		EntityManager em = emf.createEntityManager();

		try {
			Query query = em.createQuery("from " + Livro.class.getName() + " where usuario = :u");
			query.setParameter("u", usuario);

			listaLivros = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return listaLivros;
	}

	public boolean inserirLivro(String nomeLivro, String autor, String editora, String dataLanc, double preco,
			String genero, int paginas, Usuario usuario) {
		EntityManager em = emf.createEntityManager();

		try {
			Livro livro = new Livro(nomeLivro, autor, editora, dataLanc, preco, genero, paginas, usuario);
			em.getTransaction().begin();
			em.persist(livro);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}
	}

	public boolean excluirLivro(int id) {
		EntityManager em = emf.createEntityManager();

		try {
			Livro livro = em.find(Livro.class, id);
			em.getTransaction().begin();
			em.remove(livro);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}
	}

	public Livro procurarLivro(int id) {
		EntityManager em = emf.createEntityManager();
		Livro livro = null;

		try {
			livro = em.find(Livro.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return livro;
	}

	public boolean modificarLivro(int id, String nomeLivro, String autor, String editora, String dataLanc, double preco,
			String genero, int paginas, Usuario usuario) {
		EntityManager em = emf.createEntityManager();

		try {
			Livro livro = new Livro(id, nomeLivro, autor, editora, dataLanc, preco, genero, paginas, usuario);
			em.getTransaction().begin();
			em.merge(livro);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}
	}
	
}
