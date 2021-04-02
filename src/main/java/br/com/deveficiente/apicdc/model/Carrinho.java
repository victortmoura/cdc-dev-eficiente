package br.com.deveficiente.apicdc.model;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.deveficiente.apicdc.controller.LivroCarrinhoDTO;

@JsonIgnoreProperties(ignoreUnknown = true)
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
	
	public void atualiza(@NotNull Livro livro, @Positive int novaQuantidade) {
		Assert.isTrue(novaQuantidade > 0, "A quantidade tem que ser maior que zero");
		
		LivroCarrinhoDTO possivelItemAdicionado = new LivroCarrinhoDTO(livro);
		Optional<LivroCarrinhoDTO> possivelItem = livros.stream().filter(possivelItemAdicionado::equals).findFirst();
		
		Assert.isTrue(possivelItem.isPresent(), "Você não deveria atualizar um livro que não foi colocado no carrinho");
		
		LivroCarrinhoDTO livroExistente = possivelItem.get();
		livroExistente.atualizaQuantidade(novaQuantidade);
	}
	
	public void deletar(Livro livro) {
		LivroCarrinhoDTO livroQueSeraDeletado = new LivroCarrinhoDTO(livro);
		Optional<LivroCarrinhoDTO> possivelItem = livros.stream().filter(livroQueSeraDeletado::equals).findFirst();
		if(possivelItem.isPresent()) {
			LivroCarrinhoDTO livroCarrinhoDTO = possivelItem.get();
			livros.remove(livroCarrinhoDTO);
		}
	}

	public BigDecimal getTotal() {
		return livros.stream().map(item -> item.getTotal()).reduce(BigDecimal.ZERO, (atual, proximo) -> atual.add(proximo));
	}
	
	public Set<LivroCarrinhoDTO> getLivros() {
		return livros;
	}
	
	@Override
	public String toString() {
		return "Carrinho [livros=" + livros + "]";
	}

}
