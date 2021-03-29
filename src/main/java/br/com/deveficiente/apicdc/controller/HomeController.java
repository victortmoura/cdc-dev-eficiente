package br.com.deveficiente.apicdc.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.deveficiente.apicdc.detalhelivro.LivroParaHome;
import br.com.deveficiente.apicdc.repository.LivroRepository;

@RestController
public class HomeController {

	@Autowired
	private LivroRepository livroRepository;

	@GetMapping(value = "/api/home")
	public Collection<LivroParaHome> lista() {
		return livroRepository.findAll().stream()
				.map(LivroParaHome :: new)
				.collect(Collectors.toList());
	}

}
