package br.com.deveficiente.apicdc.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.deveficiente.apicdc.model.Carrinho;
import br.com.deveficiente.apicdc.model.Cookies;
import br.com.deveficiente.apicdc.model.Livro;
import br.com.deveficiente.apicdc.repository.LivroRepository;

@RestController
public class CarrinhoController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private Cookies cookies;

	@PostMapping(value = "/api/carrinho/{id}/atualiza")
	public void atualiza(@PathVariable Long id, @RequestParam int novaQuantidade, @CookieValue("carrinho") String jsonCarrinho,
			HttpServletResponse response) {
		Carrinho carrinho = Carrinho.cria(Optional.of(jsonCarrinho));
		Livro livro = livroRepository.findById(id).get();
		
		carrinho.atualiza(livro, novaQuantidade);
		cookies.writeAsJson("carrinho", carrinho, response);
	}
	
	@DeleteMapping(value = "/api/carrinho/{id}")
	public void deleteMethodName(@PathVariable Long id, @CookieValue("carrinho") String jsonCarrinho, HttpServletResponse response) {
		Carrinho carrinho = Carrinho.cria(Optional.of(jsonCarrinho));
		Livro livro = livroRepository.findById(id).get();
		
		carrinho.deletar(livro);
		cookies.writeAsJson("carrinho", carrinho, response);
	}


	
}
