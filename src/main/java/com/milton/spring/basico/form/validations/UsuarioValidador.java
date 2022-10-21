package com.milton.spring.basico.form.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.milton.spring.basico.form.models.domain.Usuario;

@Component
public class UsuarioValidador implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Usuario usuario = (Usuario) target;
		
		ValidationUtils.rejectIfEmpty(errors, "username", "NotEmpty.usuario.username");
		
		if(!usuario.getIdentificadorRegular().matches("[0-9]{2}[.][0-9]{3}[-][A-Z]{1}")) {
			errors.rejectValue("identificadorRegular", "pattern.usuario.identificadorRegular");
		}
		
		if(usuario.getIdentificadorRegular().contains("@")) {
			errors.rejectValue("identificadorRegular", "notChar@.usuario.identificadorRegular");
		}
		
	}

}
