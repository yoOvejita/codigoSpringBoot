package com.ejemplo.inicio.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class EstudianteInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if(request.getMethod().equals("PUT"))
		{
			System.out.println("Host remoto: " + request.getRemoteHost());
			System.out.println("Dirección remota: " + request.getRemoteAddr());
		}
		System.out.println("Se llamará al controlador");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("Ya estoy volviendo al cliente");
		
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {
		System.out.println("Se acabó todo, señores");
		
	}
}
