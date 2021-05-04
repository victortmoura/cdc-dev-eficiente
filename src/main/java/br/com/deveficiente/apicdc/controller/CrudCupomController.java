package br.com.deveficiente.apicdc.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.deveficiente.apicdc.model.Cupom;
import br.com.deveficiente.apicdc.model.form.NovoCupomForm;

@RestController
public class CrudCupomController {

	@PersistenceContext
	private EntityManager manager;
	
	@InitBinder("novoCupomForm")
	public void init(WebDataBinder dataBinder) {
		dataBinder.addValidators(new CupomComCodigoDuplicadoValidator(manager));
	} 
	
	@PostMapping(value = "/api/cupom")
	@Transactional
	public String criar(@RequestBody @Valid NovoCupomForm form) {
		Cupom cupom = form.novoCupom();
		manager.persist(cupom);
		
		return "criado";
	}

}
