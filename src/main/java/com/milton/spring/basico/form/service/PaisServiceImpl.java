package com.milton.spring.basico.form.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.milton.spring.basico.form.models.domain.Pais;

@Service
public class PaisServiceImpl implements PaisService {

	private List<Pais> paises;

	public PaisServiceImpl() {
		this.paises = Arrays.asList(
				new Pais(1, "PE", "PERU"),
				new Pais(2, "EC", "ECUADOR"),
				new Pais(3, "CO", "COLOMBIA"),
				new Pais(4, "AR", "ARGENTINA"),
				new Pais(5, "CL", "CHILE")
		);
	}

	@Override
	public List<Pais> list() {
		return paises;
	}

	@Override
	public Pais findById(Integer id) {

		Pais resultado = null;

		for (Pais pais : this.paises) {
			if (id == pais.getId()) {
				resultado = pais;
				break;
			}
		}
		return resultado;
	}

}
