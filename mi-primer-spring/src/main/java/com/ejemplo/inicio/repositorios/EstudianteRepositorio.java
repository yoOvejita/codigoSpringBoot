package com.ejemplo.inicio.repositorios;

import org.springframework.stereotype.Repository;

import com.ejemplo.inicio.entidad.Estudiante;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EstudianteRepositorio extends JpaRepository<Estudiante,Long>{
	// SELECT * FROM estudiante WHERE nombre = XX AND apellido = YY;
	List<Estudiante> findByNombreAndApellido(String nombre, String apellido);

	List<Estudiante> findByApellido(String apellido);
	
	List<Estudiante> findByIdIs(int id); // Equals
	List<Estudiante> findByIdIsNot(int id); // Not
	
	//List<Estudiante> findByProfesional(boolean profesional);
	
	//Composiciones con LIKE
	List<Estudiante> findByApellidoLike(String cadena);
	List<Estudiante> findByApellidoStartingWith(String cadena);
	List<Estudiante> findByApellidoEndingWith(String cadena);
	List<Estudiante> findByApellidoContaining(String cadena);
	List<Estudiante> findByApellidoContainingAndNombreContaining(String apellido, String nombre);
	
	
}
