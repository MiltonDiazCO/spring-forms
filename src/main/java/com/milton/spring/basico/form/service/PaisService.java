package com.milton.spring.basico.form.service;

import java.util.List;

import com.milton.spring.basico.form.models.domain.Pais;

public interface PaisService {

	public List<Pais> list();

	public Pais findById(Integer id);

}
