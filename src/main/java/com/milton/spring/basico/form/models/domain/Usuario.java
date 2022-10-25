package com.milton.spring.basico.form.models.domain;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.milton.spring.basico.form.validations.EdadMenorCero;

public class Usuario {

	private int identificador;

	private String identificadorRegular;

	@Size(min = 3, max = 8)
	private String username;

	@NotEmpty
	@Email(message = "El formato del correo es incorrecto")
	private String email;

	@NotEmpty
	@EdadMenorCero
	private String edad;

	@NotNull
	@Min(100)
	@Max(500)
	private Integer numeroCuenta;

	@NotNull
	@Past
	private Date fechaNacimiento;

	@NotNull
	private Pais paisOrigen;

	@NotEmpty
	private List<Role> roles;

	@NotEmpty
	private String genero;

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

	public Integer getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(Integer numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Pais getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(Pais paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
