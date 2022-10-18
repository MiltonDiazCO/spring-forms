package com.milton.spring.basico.form.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.milton.spring.basico.form.models.domain.Usuario;

@Controller
public class FormController {

	@GetMapping({ "/form" })
	public String form(Model model) {
		model.addAttribute("titulo", "Formulario de registro");
		return "form";
	}

	@PostMapping({ "/form" })
	public String process(Model model, Usuario usuario) {
		model.addAttribute("titulo", "Usuarios");
		model.addAttribute("usuario", usuario);
		return "result";
	}

}
