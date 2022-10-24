package com.milton.spring.basico.form.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.milton.spring.basico.form.service.RolService;

@Component
public class RolesPropertyEditor extends PropertyEditorSupport {

	@Autowired
	private RolService service;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		try {
			Integer id = Integer.parseInt(text);
			this.setValue(service.findRoleById(id));
		} catch (NumberFormatException e) {
			setValue(null);
		}
		
		
	}

}
