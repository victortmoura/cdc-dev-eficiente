package br.com.deveficiente.apicdc.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContinuaPagamentoController {

	@PostMapping(value = "/api/carrinho/finaliza")
	public String processa(@Valid DadosCompradorForm form) {
		return "validou os dados";
	}

}
