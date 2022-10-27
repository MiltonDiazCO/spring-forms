package com.milton.spring.basico.form.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component("delayInterceptor")
public class DelayInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(DelayInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		logger.info("preHandle() entrando...");

		Thread.sleep(5000);
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		if(modelAndView != null) {
			modelAndView.addObject("delayMessage", "Hay un retraso de 5 segundos");
			logger.info("postHandle() saliendo...");
		}
	}

}
