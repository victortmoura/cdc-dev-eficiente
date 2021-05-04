package br.com.deveficiente.apicdc.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.deveficiente.apicdc.model.Cupom;
import br.com.deveficiente.apicdc.model.form.NovoCupomForm;

public class CupomComCodigoDuplicadoValidator implements Validator {

	private EntityManager manager;

	public CupomComCodigoDuplicadoValidator(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return NovoCupomForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NovoCupomForm form = (NovoCupomForm) target;
		
		Query query = manager.createNamedQuery("findCupomByCodigo");
		query.setParameter("codigo", form.getCodigo());
		@SuppressWarnings("unchecked")
		List<Cupom> cupom = query.getResultList();
		
		if(!cupom.isEmpty()) {
			errors.rejectValue("codigo", null, "Já existe um cupom com esse código");
		}
	}

}
