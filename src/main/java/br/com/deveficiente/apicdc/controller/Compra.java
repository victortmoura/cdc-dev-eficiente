package br.com.deveficiente.apicdc.controller;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import br.com.deveficiente.apicdc.model.Cupom;

@Entity
public class Compra {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private @NotBlank @Email String email;
	private @CpfCnpj @NotBlank String documento;
	private @NotBlank String endereco;
	private String complemento;
	private @ElementCollection Set<ItemCompra> itens = new HashSet<>();
	private @PastOrPresent LocalDateTime createdAt = LocalDateTime.now();
	@ManyToOne
	private Cupom cupom;

	public Compra(@NotBlank @Email String email, @NotBlank String documento, @NotBlank String endereco,
			@Size(min = 1) Set<ItemCompra> itens) {
				this.email = email;
				this.documento = documento;
				this.endereco = endereco;
				this.itens.addAll(itens);
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setCupom(Cupom cupom) {
		Assert.isTrue(cupom.taValido(), "Você passou um cupom inválido");
		this.cupom = cupom;
		
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", email=" + email + ", documento=" + documento + ", endereco=" + endereco
				+ ", complemento=" + complemento + ", itens=" + itens + ", createdAt=" + createdAt;
	}
	
}
