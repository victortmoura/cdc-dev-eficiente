package br.com.deveficiente.apicdc.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import org.hibernate.validator.constraints.URL;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@NotBlank @URL
	private String linkGitHub;
	@PastOrPresent
	private LocalDateTime createdAt = LocalDateTime.now();
	
	@Deprecated
	public Autor() {
	}

	public Autor(@NotBlank String nome, @NotBlank @URL String linkGitHub) {
		this.nome = nome;
		this.linkGitHub = linkGitHub;
	}

	@Override
	public String toString() {
		return "Autor [nome=" + nome + ", linkGitHub=" + linkGitHub + ", createdAt=" + createdAt + "]";
	}
	
	public String getNome() {
		return nome;
	}

}
