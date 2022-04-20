package com.ejemplo.inicio.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ejemplo.inicio.excepciones.EstudianteNoEncontradoException;

@ControllerAdvice
public class EstudianteExceptinController {
	@ExceptionHandler(value=EstudianteNoEncontradoException.class)
	public ResponseEntity<Object> unaExcepcion(EstudianteNoEncontradoException ex){
		return new ResponseEntity<>("[EXCEPCION] ESTUDIANTE NO ENCONTRADO",HttpStatus.NOT_FOUND);
	}
}
