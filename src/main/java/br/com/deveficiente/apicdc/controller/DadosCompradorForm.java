package br.com.deveficiente.apicdc.controller;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class DadosCompradorForm {

	@NotBlank
	@Email
	private String email;
	private String nome;
	@NotBlank
	@CpfCnpj
	private String documento;
	@NotBlank
	private String endereco;
	private String complemento;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}