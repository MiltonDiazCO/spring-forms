package com.milton.spring.basico.form.interceptors;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component("horarioInterceptor")
public class HorarioInterceptor implements HandlerInterceptor {

	@Value("${config.horario.apertura}")
	private Integer apertura;

	@Value("${config.horario.cierre}")
	private Integer cierre;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		Calendar calendar = Calendar.getInstance();
		int hora = calendar.get(Calendar.HOUR_OF_DAY);

		if (hora >= apertura && hora < cierre) {

			StringBuilder mensaje = new StringBuilder("Bienvenido. ");
			mensaje.append("Estamos en horario de atencion");

			request.setAttribute("horarioMensaje", mensaje);
			return true;
		}

		response.sendRedirect(request.getContextPath().concat("/cerrado"));
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		if (modelAndView != null) {

			StringBuilder mensaje = (StringBuilder) request.getAttribute("horarioMensaje");
			modelAndView.addObject("mensaje", mensaje);
		}
	}

}
