package br.com.deveficiente.apicdc.model.dto;

import br.com.deveficiente.apicdc.model.Autor;

public class AutorDetalheDTO {

	private String nome;
	private String descricao;

	public AutorDetalheDTO(Autor autor) {
		nome = autor.getNome();
		descricao = "Aqui precisa vir a descrição do Autor";
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
