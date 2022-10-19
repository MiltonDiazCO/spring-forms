package com.milton.spring.basico.form.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.milton.spring.basico.form.models.domain.Usuario;

@Controller
public class FormController {

	@GetMapping({ "/form" })
	public String form(Model model) {
		Usuario usuario = new Usuario();

		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Formulario de registro");
		return "form";
	}

	@PostMapping({ "/form" })
	public String process(@Valid Usuario usuario, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de registro");
			return "form";
		}

		model.addAttribute("titulo", "Usuarios");
		return "result";
	}

}
