package br.com.deveficiente.apicdc.controller;

import java.math.BigDecimal;

import br.com.deveficiente.apicdc.model.Livro;

public class LivroCarrinhoDTO {

	private String livro;
	private BigDecimal preco;
	private String linkCapaLivro;

	public LivroCarrinhoDTO(Livro livro) {
		this.livro = livro.getTitulo();
		this.preco = livro.getPreco();
		this.linkCapaLivro = livro.getLinkCapaLivro();
	}

	public String getLivro() {
		return livro;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getLinkCapaLivro() {
		return linkCapaLivro;
	}

	@Override
	public String toString() {
		return "LivroCarrinhoDTO [livro=" + livro + ", preco=" + preco + ", linkCapaLivro=" + linkCapaLivro + "]";
	}

}
