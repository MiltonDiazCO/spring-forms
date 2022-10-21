package com.milton.spring.basico.form.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EdadMenorCeroValidador implements ConstraintValidator<EdadMenorCero, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if (value.contains("-"))
			return false;

		return true;
	}

}
