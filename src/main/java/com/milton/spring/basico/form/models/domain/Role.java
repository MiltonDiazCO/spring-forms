package com.milton.spring.basico.form.models.domain;

public class Role {

	private Integer id;
	private String nombre;
	private String rol;

	public Role() {
	}

	public Role(Integer id, String nombre, String rol) {
		this.id = id;
		this.nombre = nombre;
		this.rol = rol;
	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getRol() {
		return rol;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}
