package br.com.deveficiente.apicdc.controller;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.deveficiente.apicdc.model.Livro;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LivroCarrinhoDTO {

	private String livro;
	private BigDecimal preco;
	private String linkCapaLivro;
	private int quantidade = 1;

	@Deprecated
	public LivroCarrinhoDTO() {
	}
	
	public LivroCarrinhoDTO(Livro livro) {
		this.livro = livro.getTitulo();
		this.preco = livro.getPreco();
		this.linkCapaLivro = livro.getLinkCapaLivro();
	}
	
	public void incrementar() {
		this.quantidade++;
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
	
	public int getQuantidade() {
		return quantidade;
	}

	public BigDecimal getTotal() {
		return preco.multiply(new BigDecimal(quantidade));
	}
	
	@Override
	public String toString() {
		return "LivroCarrinhoDTO [livro=" + livro + ", preco=" + preco + ", linkCapaLivro=" + linkCapaLivro + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((linkCapaLivro == null) ? 0 : linkCapaLivro.hashCode());
		result = prime * result + ((livro == null) ? 0 : livro.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LivroCarrinhoDTO other = (LivroCarrinhoDTO) obj;
		if (linkCapaLivro == null) {
			if (other.linkCapaLivro != null)
				return false;
		} else if (!linkCapaLivro.equals(other.linkCapaLivro))
			return false;
		if (livro == null) {
			if (other.livro != null)
				return false;
		} else if (!livro.equals(other.livro))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		return true;
	}

}
