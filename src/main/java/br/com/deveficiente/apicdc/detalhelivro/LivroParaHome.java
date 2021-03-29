package br.com.deveficiente.apicdc.detalhelivro;

import br.com.deveficiente.apicdc.model.Livro;

public class LivroParaHome {

	private String titulo;
	private Long id;
	private String nomeAutor;

	public LivroParaHome(Livro livro) {
		this.titulo = livro.getTitulo();
		this.id = livro.getId();
		this.nomeAutor = livro.getAutor().getNome();
	}

}
