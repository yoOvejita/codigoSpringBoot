package com.ejemplo.inicio.frijoles;

import org.springframework.stereotype.Component;

@Component("cosa")
public class Saludador {
	public String unMetodo() {
		return "Hola muchachos";
	}
}
