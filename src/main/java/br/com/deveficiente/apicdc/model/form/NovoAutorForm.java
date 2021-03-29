package br.com.deveficiente.apicdc.model.form;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import br.com.deveficiente.apicdc.model.Autor;

public class NovoAutorForm {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@URL
	private String linkGitHub;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLinkGitHub() {
		return linkGitHub;
	}

	public void setLinkGitHub(String linkGitHub) {
		this.linkGitHub = linkGitHub;
	}

	public Autor novoAutor() {
		return new Autor(nome, linkGitHub);
	}

}
