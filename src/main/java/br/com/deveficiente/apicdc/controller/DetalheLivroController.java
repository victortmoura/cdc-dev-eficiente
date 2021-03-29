package br.com.deveficiente.apicdc.controller;

import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.deveficiente.apicdc.model.Carrinho;
import br.com.deveficiente.apicdc.model.Livro;
import br.com.deveficiente.apicdc.model.dto.LivroDetalheDTO;
import br.com.deveficiente.apicdc.repository.LivroRepository;

@RestController
public class DetalheLivroController {

	@Autowired
	private LivroRepository livroRepository;

	@GetMapping(value = "/api/detalhe/{id}")
	public LivroDetalheDTO exibirDetalhes(@PathVariable Long id) {
		Livro livro = livroRepository.findById(id).get();
		return new LivroDetalheDTO(livro);
	}

	@PostMapping(value = "/api/carrinho/{id}")
	public String adicionarLivroCarrinho(@PathVariable Long id, @CookieValue("carrinho") Optional<String> jsonCarrinho,
			HttpServletResponse response) throws JsonProcessingException {
		Carrinho carrinho = jsonCarrinho.map(json -> {
			try {
				return new ObjectMapper().readValue(json, Carrinho.class);
			} catch (JsonProcessingException e) {
				throw new RuntimeException();
			}
		}).orElse(new Carrinho());
		
		carrinho.adiciona(livroRepository.findById(id).get());
		Cookie cookie = new Cookie("carrinho", new ObjectMapper().writeValueAsString(carrinho));
		cookie.setHttpOnly(true);
		
		response.addCookie(cookie);
		return carrinho.toString();
	}


}
