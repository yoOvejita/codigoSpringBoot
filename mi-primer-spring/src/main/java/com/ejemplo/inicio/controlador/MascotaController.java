package com.ejemplo.inicio.controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ejemplo.inicio.entidad.Mascota;

@Controller
public class MascotaController {
	private static Map<String, Mascota> mascotas = new HashMap<>();
	static {
		Mascota e1 = new Mascota("1", "Pepe","dos");
		mascotas.put("1", e1);
	}
	@RequestMapping(value="/mascota/upload", 
			method=RequestMethod.POST, 
			consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> archivoSubir(@RequestParam("archivito") MultipartFile arch) throws IOException{
		File elArchivo = new File("/Users/rusokverse/Desktop/" + arch.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(elArchivo);
		fos.write(arch.getBytes());
		Mascota mm = new Mascota("5", "Mapache", arch.getOriginalFilename());
		mascotas.put("123", mm);
		return new ResponseEntity<>("El archivo fue subido con éxito", HttpStatus.OK);
	}
	@RequestMapping(value="/mascota")
	public ResponseEntity<Object> getMascotas(){
		return new ResponseEntity<>(mascotas.values(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/mascota/download/{id}", 
			method=RequestMethod.GET)
	public ResponseEntity<Object> archivoDescargar(@PathVariable("id") String id) throws IOException{
		Mascota m = mascotas.get(id);
		String nombreArch = "/Users/rusokverse/Desktop/" + m.getFoto();
		File archivo = new File(nombreArch);
		InputStreamResource recurso = new InputStreamResource(new FileInputStream(archivo));
		HttpHeaders headers = new HttpHeaders();
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");
		ResponseEntity<Object> re = ResponseEntity.ok().headers(headers)
				.contentLength(archivo.length()).contentType(MediaType
				.parseMediaType("application/txt")).body(recurso);
		return re;
	}
}
