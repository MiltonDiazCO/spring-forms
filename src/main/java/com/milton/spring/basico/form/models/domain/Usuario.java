package com.milton.spring.basico.form.models.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Usuario {

	private int identificador;

	private String identificadorRegular;

	@Size(min = 3, max = 8)
	private String username;

	@NotEmpty
	@Email(message = "El formato del correo es incorrecto")
	private String email;

	@NotEmpty
	private String edad;

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getIdentificadorRegular() {
		return identificadorRegular;
	}

	public void setIdentificadorRegular(String identificadorRegular) {
		this.identificadorRegular = identificadorRegular;
	}

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
