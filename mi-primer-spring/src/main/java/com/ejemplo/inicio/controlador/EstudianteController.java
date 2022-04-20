package com.ejemplo.inicio.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ejemplo.inicio.entidad.Estudiante;
import com.ejemplo.inicio.excepciones.EstudianteNoEncontradoException;
import com.ejemplo.inicio.servicios.EstudianteService;

@Controller
public class EstudianteController {
	@Autowired
	private EstudianteService estServ;
	private static Map<String, Estudiante> estudiantes = new HashMap<>();
	static {
		Estudiante e1 = new Estudiante(1, "Pepe","Perales");
		Estudiante e2 = new Estudiante(2, "Ana","Rocha");
		Estudiante e3 = new Estudiante(3, "Sofia","Loza");
		estudiantes.put("1", e1);
		estudiantes.put("2", e2);
		estudiantes.put("3", e3);
	}
	@RequestMapping(value="/estudiantes")
	public ResponseEntity<Object> getEstudiantes(){
		List<Estudiante> ests = estServ.listar();
		return new ResponseEntity<>(ests, HttpStatus.OK);
	}
	@RequestMapping(value="/estudiantes", method=RequestMethod.POST)
	public ResponseEntity<Object> setEstudiante(@RequestBody Estudiante est){
		estudiantes.put(est.getId()+"", est);
		return new ResponseEntity<>("e creó al estudiante " + est.getNombre(), HttpStatus.CREATED);
	}
	@RequestMapping(value="/estudiantes/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> editarEstudiante(@PathVariable("id") int id, @RequestBody Estudiante est){
		if(!estudiantes.containsKey(id+""))
			throw new EstudianteNoEncontradoException();
		estudiantes.remove(id+"");
		est.setId(id);
		estudiantes.put(id+"", est);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("un_valor", "123");
		headers.add("otro", "algo!!");
		
		return new ResponseEntity<>("Se actualizó al estudiante " + est.getNombre(), headers, HttpStatus.OK);
	}
	@RequestMapping(value="/estudiantes/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> eliminarEstudiante(@PathVariable("id") int id){
		estudiantes.remove(id+"");
		//return ResponseEntity.ok("Se eliminó al estudiante " + id);
		return ResponseEntity.ok().header("un_valor", "123").body(new Estudiante(10, "Pepe","Pepales"));
				
	}
}
