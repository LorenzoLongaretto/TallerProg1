package personas;

import java.io.Serializable;

public abstract class Persona implements Serializable{
protected String DNI,nombre,apellido,ciudad,telefono,domicilio;

	//Constructores
	public Persona(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio) {
		this.DNI = dNI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.ciudad = ciudad;
		this.telefono = telefono;
		this.domicilio = domicilio;
	}
/**
 * preguntar por el sueldo base
 * 
 * 
 */

	public String getDNI() {
		return DNI;
	}

	public String getNombre() {
	return nombre;
}
public String getApellido() {
	return apellido;
}
	public void setDNI(String dNI) {
		DNI = dNI;
	}

}
