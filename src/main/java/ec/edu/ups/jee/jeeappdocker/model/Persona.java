package ec.edu.ups.jee.jeeappdocker.model;

//import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TBL_PERSONA")
public class Persona{
//	private 
	
	@Id
	@Column(name="per_cedula")
	private String cedula;
	@Column(name="per_nombre")
	private String nombre;
	@Column(name="per_direccion")
	private String direccion;
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		return "Persona [cedula=" + cedula + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}
	
	
}
