package br.com.deveficiente.apicdc.model;

import java.util.ArrayList;
import java.util.List;

import br.com.deveficiente.apicdc.controller.LivroCarrinhoDTO;

public class Carrinho {

	private List<LivroCarrinhoDTO> livros = new ArrayList<>();

	public void adiciona(Livro livro) {
		livros.add(new LivroCarrinhoDTO(livro));
	}

	public List<LivroCarrinhoDTO> getLivros() {
		return livros;
	}
	
	@Override
	public String toString() {
		return "Carrinho [livros=" + livros + "]";
	}

}
