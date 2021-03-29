package br.com.deveficiente.apicdc.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.deveficiente.apicdc.model.Autor;
import br.com.deveficiente.apicdc.model.form.NovoAutorForm;
import br.com.deveficiente.apicdc.repository.AutorRepository;

@RestController
public class CrudAutoresController {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@PostMapping(value = "/api/autor")
	@Transactional
	public void novo(@Valid @RequestBody NovoAutorForm form) {
		Autor novoAutor = form.novoAutor();
		autorRepository.save(novoAutor);
	}
}
