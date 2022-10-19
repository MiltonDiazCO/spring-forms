package com.milton.spring.basico.form.controllers;

import java.util.HashMap;
import java.util.Map;

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

			Map<String, String> errores = new HashMap<>();

			result.getFieldErrors().forEach(err -> {
				String mensajeError = "El campo ".concat(err.getField()).concat(", no debe quedar vacio");
				errores.put(err.getField(), mensajeError);
			});
			model.addAttribute("titulo", "Formulario de registro");
			model.addAttribute("errores", errores);
			return "form";
		}

		model.addAttribute("titulo", "Usuarios");
		return "result";
	}

}
