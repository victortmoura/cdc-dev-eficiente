package br.com.deveficiente.apicdc.controller;

import java.math.BigDecimal;

import javax.validation.constraints.Positive;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.deveficiente.apicdc.model.Livro;
import br.com.deveficiente.apicdc.repository.LivroRepository;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LivroCarrinhoDTO {

	private String titulo;
	private BigDecimal preco;
	private String linkCapaLivro;
	private int quantidade = 1;
	private Long id;

	@Deprecated
	public LivroCarrinhoDTO() {
	}
	
	public LivroCarrinhoDTO(Livro livro) {
		this.titulo = livro.getTitulo();
		this.preco = livro.getPreco();
		this.linkCapaLivro = livro.getLinkCapaLivro();
		this.id = livro.getId();
	}
	
	public void atualizaQuantidade(@Positive int novaQuantidade) {
		Assert.isTrue(novaQuantidade > 0, "A quantidade tem que ser maior que zero");
		this.quantidade = novaQuantidade;
	}
	
	public void incrementar() {
		this.quantidade++;
	}

	public String getTitulo() {
		return titulo;
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
	
	public Long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "LivroCarrinhoDTO [livro=" + titulo + ", preco=" + preco + ", linkCapaLivro=" + linkCapaLivro + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((linkCapaLivro == null) ? 0 : linkCapaLivro.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		return true;
	}

	public ItemCompra novoItemCompra(LivroRepository livroRepository) {
		return new ItemCompra(livroRepository.findById(this.id).get(), this.quantidade, this.preco, this.getTotal(), this.titulo);
	}

}
