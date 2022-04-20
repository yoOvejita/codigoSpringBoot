package com.ejemplo.inicio.entidad;

public class Mascota {
	private String id;
	private String nombre;
	private String foto;
	public Mascota() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Mascota(String id, String nombre, String foto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.foto = foto;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
}
