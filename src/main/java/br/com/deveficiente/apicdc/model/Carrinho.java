package br.com.deveficiente.apicdc.model;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.deveficiente.apicdc.controller.LivroCarrinhoDTO;

public class Carrinho {

	private Set<LivroCarrinhoDTO> livros = new LinkedHashSet<>();

	@Deprecated
	public Carrinho() {
	}
	
	public void adiciona(Livro livro) {
		LivroCarrinhoDTO novoLivro = new LivroCarrinhoDTO(livro);
		boolean result = livros.add(novoLivro);
		if(!result) {
			LivroCarrinhoDTO livroCarrinhoDTO = livros.stream().filter(novoLivro::equals).findFirst().get();
			livroCarrinhoDTO.incrementar();
		}
	}

	public Set<LivroCarrinhoDTO> getLivros() {
		return livros;
	}
	
	/**
	 * @param jsonCarrinho possível json de um carrinho já criado
	 * @return Carrinho
	 * */
	public static Carrinho cria(Optional<String> jsonCarrinho) {
		return jsonCarrinho.map(json -> {
			try {
				return new ObjectMapper().readValue(json, Carrinho.class);
			} catch (JsonProcessingException e) {
				throw new RuntimeException(e);
			}
		}).orElse(new Carrinho());
	}
	
	@Override
	public String toString() {
		return "Carrinho [livros=" + livros + "]";
	}

}
