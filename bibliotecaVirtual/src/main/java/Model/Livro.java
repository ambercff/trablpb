package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Livro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nomeLivro;
	private String autor;
	private String editora;
	private String dataLanc;
	private double preco;
	private String genero;
	private int paginas;
	@ManyToOne(optional = false)
	private Usuario usuario;

	public Livro() {
		super();
	}

	public Livro(int id) {
		super();
		this.id = id;
	}

	public Livro(String nomeLivro, String autor, String editora, String dataLanc, double preco, String genero,
			int paginas, Usuario usuario) {
		super();
		this.nomeLivro = nomeLivro;
		this.autor = autor;
		this.editora = editora;
		this.dataLanc = dataLanc;
		this.preco = preco;
		this.genero = genero;
		this.paginas = paginas;
		this.usuario = usuario;
	}

	public Livro(int id, String nomeLivro, String autor, String editora, String dataLanc, double preco, String genero,
			int paginas, Usuario usuario) {
		super();
		this.nomeLivro = nomeLivro;
		this.autor = autor;
		this.editora = editora;
		this.dataLanc = dataLanc;
		this.preco = preco;
		this.genero = genero;
		this.id = id;
		this.paginas = paginas;
		this.usuario = usuario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getDataLanc() {
		return dataLanc;
	}

	public void setDataLanc(String dataLanc) {
		this.dataLanc = dataLanc;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public double calcularPromocao(double desconto) {
		return getPreco() - (getPreco() * (desconto / 100));
	}

	public int calcularIdade() {
		return 2022 - Integer.parseInt(getDataLanc());
	}

	public int calcularTempo(int tempo) {
		return getPaginas() * tempo;
	}
}
