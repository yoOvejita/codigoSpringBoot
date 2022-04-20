package com.ejemplo.inicio.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.inicio.entidad.Estudiante;
import com.ejemplo.inicio.repositorios.EstudianteRepositorio;

@Service
public class EstudianteService {
	@Autowired
	private EstudianteRepositorio estudianteRepo;
	
	public List<Estudiante> listar(){
		return estudianteRepo.findAll();
	}
}
