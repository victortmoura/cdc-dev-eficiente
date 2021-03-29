package br.com.deveficiente.apicdc.validator;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.deveficiente.apicdc.model.Livro;
import br.com.deveficiente.apicdc.model.form.NovoLivroForm;

public abstract class CampoUnicoLivroValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return NovoLivroForm.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		NovoLivroForm form = (NovoLivroForm) target;

		Optional<Livro> possivelLivro = buscaLivroPorCampo(form);
		
		if(possivelLivro.isPresent()) {
			String nomeCampoInvalido = getNomeCampoInvalido();
			errors.rejectValue(nomeCampoInvalido, null, nomeCampoInvalido + " Já existe um livro igual cadastrado");
		}
	}

	public abstract String getNomeCampoInvalido();
	
	public abstract Optional<Livro> buscaLivroPorCampo(NovoLivroForm form);

}
