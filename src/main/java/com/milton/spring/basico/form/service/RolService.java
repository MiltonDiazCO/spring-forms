package com.milton.spring.basico.form.service;

import java.util.List;

import com.milton.spring.basico.form.models.domain.Role;

public interface RolService {

	public List<Role> list();

	public Role findRoleById(Integer id);

}
