package br.com.deveficiente.apicdc.controller;

import java.math.BigDecimal;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.deveficiente.apicdc.model.Livro;

@Embeddable
public class ItemCompra {

	@ManyToOne
	@NotNull
	@Valid
	private Livro livro;
	@Positive
	private int quantidade;
	@Positive
	@NotNull
	private BigDecimal preco;
	@Positive
	@NotNull
	private BigDecimal total;
	@NotBlank
	private String titulo;

	@Deprecated
	public ItemCompra() {
		
	}
	
	public ItemCompra(@NotNull Livro livro, @Positive int quantidade, @Positive @NotNull BigDecimal preco, @Positive @NotNull BigDecimal total, @NotBlank String titulo) {
		this.livro = livro;
		this.quantidade = quantidade;
		this.preco = preco;
		this.total = total;
		this.titulo = titulo;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		ItemCompra other = (ItemCompra) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemCompra [livro=" + livro + ", quantidade=" + quantidade + ", preco=" + preco + ", total=" + total
				+ ", titulo=" + titulo + "]";
	}

}
