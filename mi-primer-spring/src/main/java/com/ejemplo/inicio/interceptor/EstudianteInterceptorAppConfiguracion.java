package com.ejemplo.inicio.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class EstudianteInterceptorAppConfiguracion implements WebMvcConfigurer{
	@Autowired
	private EstudianteInterceptor estInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registro) {
		registro.addInterceptor(estInterceptor);
	}
}
