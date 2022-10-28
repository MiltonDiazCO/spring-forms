package com.milton.spring.basico.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.milton.spring.basico.form.interceptors.DelayInterceptor;
import com.milton.spring.basico.form.interceptors.HorarioInterceptor;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Autowired
	@Qualifier("delayInterceptor")
	private DelayInterceptor delayInterceptor;
	
	@Autowired
	@Qualifier("horarioInterceptor")
	private HorarioInterceptor horarioInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(delayInterceptor);
		registry.addInterceptor(horarioInterceptor).excludePathPatterns("/cerrado");
	}

}
