package br.com.deveficiente.apicdc.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.deveficiente.apicdc.model.Carrinho;
import br.com.deveficiente.apicdc.model.Cookies;
import br.com.deveficiente.apicdc.model.Livro;
import br.com.deveficiente.apicdc.model.dto.LivroDetalheDTO;
import br.com.deveficiente.apicdc.repository.LivroRepository;

@RestController
public class DetalheLivroController {

	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private Cookies cookies;

	@GetMapping(value = "/api/detalhe/{id}")
	public LivroDetalheDTO exibirDetalhes(@PathVariable Long id) {
		Livro livro = livroRepository.findById(id).get();
		return new LivroDetalheDTO(livro);
	}

	@PostMapping(value = "/api/carrinho/{id}")
	public String adicionarLivroCarrinho(@PathVariable Long id, @CookieValue("carrinho") Optional<String> jsonCarrinho,
			HttpServletResponse response) throws JsonProcessingException {
		Carrinho carrinho = Carrinho.cria(jsonCarrinho);
		carrinho.adiciona(livroRepository.findById(id).get());
		
		cookies.writeAsJson("carrinho", carrinho, response);

		return carrinho.toString();
	}


}
