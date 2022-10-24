package com.milton.spring.basico.form.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.milton.spring.basico.form.models.domain.Role;

@Service
public class RolServiceImpl implements RolService {

	private List<Role> roles;

	public RolServiceImpl() {
		roles = new ArrayList<>();
		this.roles.add(new Role(1, "Administrador", "ROLE_ADMIN"));
		this.roles.add(new Role(3, "Moderador", "ROLE_MODERATOR"));
		this.roles.add(new Role(2, "Usuario", "ROLE_USER"));
	}

	@Override
	public List<Role> list() {
		return roles;
	}

	@Override
	public Role findRoleById(Integer id) {
		Role resultado = null;

		for (Role rol : roles) {
			if (id == rol.getId()) {
				resultado = rol;
				break;
			}
		}

		return resultado;
	}

}
