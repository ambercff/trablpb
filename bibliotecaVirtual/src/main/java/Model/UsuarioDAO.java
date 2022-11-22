package Model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class UsuarioDAO {
	private EntityManagerFactory emf;
	
	public UsuarioDAO(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}
	
	public void inserirUsuario(String login, String senha) {	
		EntityManager em = emf.createEntityManager();
		
		try {
			Usuario usuario = new Usuario(login, senha);
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	}
	
	
	
	public Usuario procurarUsuario(String login) {
		EntityManager em = emf.createEntityManager();
		Usuario usuario = null;
		
		try {
			usuario = em.find(Usuario.class, login);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		return usuario;
	}
} 
