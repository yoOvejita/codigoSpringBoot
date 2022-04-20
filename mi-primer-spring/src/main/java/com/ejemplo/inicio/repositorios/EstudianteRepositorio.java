package com.ejemplo.inicio.repositorios;

import org.springframework.stereotype.Repository;

import com.ejemplo.inicio.entidad.Estudiante;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EstudianteRepositorio extends JpaRepository<Estudiante,Long>{

}
