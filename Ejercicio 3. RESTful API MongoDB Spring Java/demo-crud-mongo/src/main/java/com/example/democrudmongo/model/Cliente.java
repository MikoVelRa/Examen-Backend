package com.example.democrudmongo.model;
import java.time.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientes")
public class Cliente {
	
	@Id
	private int Cliente_ID;	
	
	
	private String Nombre_Usuario;
	private String Contraseña;
	private String Nombre;
	private String Apellidos;
	private String Correo_Electronico;
	private int Edad;
	private float Estatura;
	private float Peso;
	private float IMC;
	private float GEB;
	private float ETA;
	private String Fecha_Creacion;
	private String Fecha_Actualizacion;
	
	public Cliente(int cliente_ID, String nombre_Usuario, String contraseña, String nombre, String apellidos,
			String correo_Electronico, int edad, float estatura, float peso, float iMC, float gEB, float eTA,
			LocalDate fecha_Creacion, LocalDate fecha_Actualizacion) {
		super();
		this.Cliente_ID = cliente_ID;
		this.Nombre_Usuario = nombre_Usuario;
		this.Contraseña = contraseña;
		this.Nombre = nombre;
		this.Apellidos = apellidos;
		this.Correo_Electronico = correo_Electronico;
		this.Edad = edad;
		this.Estatura = estatura;
		this.Peso = peso;
		this.IMC = iMC;
		this.GEB = gEB;
		this.ETA = eTA;
		this.Fecha_Creacion = LocalDate.now().toString();
		this.Fecha_Actualizacion = null;
	}
	
	public Cliente() {}

	public int getCliente_ID() {
		return this.Cliente_ID;
	}

	public void setCliente_ID(int cliente_ID) {
		this.Cliente_ID = cliente_ID;
	}

	public String getNombre_Usuario() {
		return this.Nombre_Usuario;
	}

	public void setNombre_Usuario(String nombre_Usuario) {
		this.Nombre_Usuario = nombre_Usuario;
	}

	public String getContraseña() {
		return this.Contraseña;
	}

	public void setContraseña(String contraseña) {
		this.Contraseña = contraseña;
	}

	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	public String getApellidos() {
		return this.Apellidos;
	}

	public void setApellidos(String apellidos) {
		this.Apellidos = apellidos;
	}

	public String getCorreo_Electronico() {
		return this.Correo_Electronico;
	}

	public void setCorreo_Electronico(String correo_Electronico) {
		this.Correo_Electronico = correo_Electronico;
	}

	public int getEdad() {
		return this.Edad;
	}

	public void setEdad(int edad) {
		this.Edad = edad;
	}

	public float getEstatura() {
		return this.Estatura;
	}

	public void setEstatura(float estatura) {
		this.Estatura = estatura;
	}

	public float getPeso() {
		return this.Peso;
	}

	public void setPeso(float peso) {
		this.Peso = peso;
	}

	public float getIMC() {
		return this.IMC;
	}

	public void setIMC(float iMC) {
		this.IMC = iMC;
	}

	public float getGEB() {
		return this.GEB;
	}

	public void setGEB(float gEB) {
		this.GEB = gEB;
	}

	public float getETA() {
		return this.ETA;
	}

	public void setETA(float eTA) {
		this.ETA = eTA;
	}

	public String getFecha_Creacion() {
		return this.Fecha_Creacion;
	}

	public void setFecha_Creacion(String fecha_Creacion) {
		this.Fecha_Creacion = fecha_Creacion;
	}

	public String getFecha_Actualizacion() {
		return this.Fecha_Actualizacion;
	}

	public void setFecha_Actualizacion(String fecha_Actualizacion) {
		this.Fecha_Actualizacion = fecha_Actualizacion;
	}
}
