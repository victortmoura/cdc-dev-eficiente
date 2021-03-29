package br.com.deveficiente.apicdc.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.deveficiente.apicdc.model.Categoria;
import br.com.deveficiente.apicdc.model.form.NovaCategoriaForm;
import br.com.deveficiente.apicdc.repository.CategoriaRepository;
import br.com.deveficiente.apicdc.validator.SemCategoriaComNomeDuplicadoValidator;

@RestController
public class CrudCategoriasController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@InitBinder("novaCategoriaForm")
	public void init(WebDataBinder dataBinder) {
		dataBinder.addValidators(new SemCategoriaComNomeDuplicadoValidator(categoriaRepository));
	}
	
	@PostMapping("/api/categoria")
	@Transactional
	public void nova(@RequestBody @Valid NovaCategoriaForm form) {
		Categoria categoria = new Categoria(form.getNome());
		categoriaRepository.save(categoria);
	}
}
