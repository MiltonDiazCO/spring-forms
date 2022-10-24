package com.milton.spring.basico.form.controllers;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.milton.spring.basico.form.editors.MayusculaEditor;
import com.milton.spring.basico.form.editors.PaisPropertyEditor;
import com.milton.spring.basico.form.editors.RolesPropertyEditor;
import com.milton.spring.basico.form.models.domain.Pais;
import com.milton.spring.basico.form.models.domain.Role;
import com.milton.spring.basico.form.models.domain.Usuario;
import com.milton.spring.basico.form.service.PaisService;
import com.milton.spring.basico.form.service.RolService;
import com.milton.spring.basico.form.validations.UsuarioValidador;

@Controller
@SessionAttributes("usuario")
public class FormController {
	
	@Autowired
	private UsuarioValidador validador;
	
	@Autowired
	private PaisService paisesService;
	
	@Autowired
	private PaisPropertyEditor paisEditor;
	
	@Autowired
	private RolService rolesService;
	
	@Autowired
	private RolesPropertyEditor rolEditor;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validador);
		
		// Formateando fecha
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		
		// Convirtiendo texto a mayuscula
		binder.registerCustomEditor(String.class, "username", new MayusculaEditor());
		
		// Creando objeto de tipo Pais
		binder.registerCustomEditor(Pais.class, "paisOrigen", paisEditor);
		
		// Creando lista con los roles de usuarios
		binder.registerCustomEditor(Role.class, "roles", rolEditor);
	}
	
	@ModelAttribute("paises")
	public List<String> paises() {
		return Arrays.asList("Colombia", "Peru", "Ecuador", "Brasil");
	}
	
	@ModelAttribute("paisService")
	public List<Pais> paisService() {
		return paisesService.list();
	}
	
	@ModelAttribute("rolService")
	public List<Role> rolService() {
		return rolesService.list();
	}

	@GetMapping({ "/form" })
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setIdentificador(2838652);

		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Formulario de registro");
		return "form";
	}

	@PostMapping({ "/form" })
	public String process(@Valid Usuario usuario, BindingResult result, SessionStatus sesion, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de registro");
			return "form";
		}

		model.addAttribute("titulo", "Usuarios");
		sesion.setComplete();
		return "result";
	}

}
