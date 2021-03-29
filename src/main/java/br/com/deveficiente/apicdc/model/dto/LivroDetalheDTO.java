package br.com.deveficiente.apicdc.model.dto;

import java.math.BigDecimal;

import br.com.deveficiente.apicdc.detalhelivro.Markdown;
import br.com.deveficiente.apicdc.model.Livro;

public class LivroDetalheDTO {

	private Long id;
	private String titulo;
	private String subTitulo;
	private BigDecimal preco;
	private String conteudo;
	private String sumarioOriginal;
	private String sumarioHtml;
	private int numeroPaginas;
	private String isbn;
	private AutorDetalheDTO autor;

	public LivroDetalheDTO(Livro livro) {
		titulo = livro.getTitulo();
		subTitulo = livro.getSubTitulo();
		preco = livro.getPreco();
		conteudo = livro.getConteudo();
		sumarioOriginal = livro.getSumario();
		sumarioHtml = Markdown.renderHtml(livro.getSumario());
		numeroPaginas = livro.getNumeroPaginas();
		isbn = livro.getIsbn();
		id = livro.getId();
		autor = new AutorDetalheDTO(livro.getAutor());
	}
	
	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getSubTitulo() {
		return subTitulo;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getConteudo() {
		return conteudo;
	}

	public String getSumario() {
		return sumarioOriginal;
	}
	
	public String getSumarioHtml() {
		return sumarioHtml;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public AutorDetalheDTO getAutor() {
		return autor;
	}
	
}
