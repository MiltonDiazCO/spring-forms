package com.milton.spring.basico.form.models.domain;

import javax.validation.constraints.NotEmpty;

public class Usuario {

	@NotEmpty
	private String username;
	
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String edad;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

}
