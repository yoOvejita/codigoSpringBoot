package com.ejemplo.inicio.controlador;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ejemplo.inicio.servicios.AlgoService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class Primero {
	@Value("${valor.secreto}")
	private String val;
	@Autowired
	AlgoService algoservice;
	
	@Autowired
	private ApplicationContext contexto;
	
	@RequestMapping("/") //localhost:8080/
	@ResponseBody
	public String saludo() {
		return "Hola a todos! " + val;
	}
	@RequestMapping("/cerrar")
	public void cerrar() {
		System.out.println(algoservice.saludar());
		SpringApplication.exit(contexto);
	}
	@RequestMapping(value="/algo", method = RequestMethod.POST)
	@ResponseBody
	public String prueba(@RequestBody Persona p) {
		return "Nombre: "+p.getNombre()+", edad: "+ p.getEdad();
	}
	@RequestMapping(value="/algo2/{valorcito}")
	@ResponseBody
	public String prueba2(@PathVariable("valorcito") String val) {
		return "El valorcito enviado es: "+ val;
	}
	@GetMapping("/prueba")
	public void formaRustica(HttpServletResponse response) throws IOException{
		response.setStatus(200);
		response.setHeader("user", "Pepe");
		response.getWriter().println("Un texto cualquiera.");
	}
	
	@PostMapping(value="/prueba2", produces= MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public Persona devolverPersona() {
		return new Persona("XX",33);
	}
}

class Persona{
	private String nombre;
	private int edad;
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Persona(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
}
