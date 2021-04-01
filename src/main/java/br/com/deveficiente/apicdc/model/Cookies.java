package br.com.deveficiente.apicdc.model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Cookies {

	/**
	 * @param name nome da chave que vai ser gerada para o cookie
	 * @param carrinho carrinho de compras que vai ser serializado
	 * @param response 
	 * */
	public void writeAsJson(String name, Carrinho carrinho, HttpServletResponse response) {
		try {
			Cookie cookie = new Cookie(name, new ObjectMapper().writeValueAsString(carrinho));
			cookie.setHttpOnly(true);
			response.addCookie(cookie);
		} catch (JsonProcessingException e) {
			new RuntimeException();
		}
	}
}
