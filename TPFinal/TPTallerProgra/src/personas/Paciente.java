package personas;
import infraestructura.Factura;
import infraestructura.Habitacion;
import modelo.IMedico;

/**
 * 
 *Clase que corresponde a los pacientes atendidos dentro de una Clinica.
 */
public abstract class Paciente extends Persona implements Comparable<Object>{
private String rangoEtario;
private int numeroHistoria,nroOrden;

	//Constructores
	public Paciente(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio,String rangoEtario) {
		super(dNI, nombre, apellido, ciudad, telefono, domicilio);
		// TODO Auto-generated constructor stub
		this.rangoEtario=rangoEtario;
	}
	/*
	coleccion

	factura ord fecha

	paciente nro hist o dni
	medico matricula

	 */
	
	//Metodos
	public boolean ocuparSala() {
		return false;
	}
	public String getRangoEtario() {
		return rangoEtario;
	}
	/**Devuelve la prioridad que tiene este paciente con respecto al que puede haber dentro de la sala de espera.
	 * <b> Pre: El paciente debe ser distinto de null.</b>
	 * <b> Post: Se devuelve la prioridad del paciente con respecto al ingreso a la sala de espera.</b>
	 * @param paciente: Parametro de tipo paciente.
	 * @return Devuelve true o false dependiendo la prioridad de los pacientes que se estan comparando para entrar a la sala de espera.
	 */
	public abstract boolean prioridad(Paciente paciente);
	public abstract boolean prioridadNino();	
	public abstract boolean prioridadJoven();	
	public abstract boolean prioridadMayor();


	public int getNroOrden() {
		return nroOrden;
	}

	public void setNroOrden(int nroOrden) {
		this.nroOrden = nroOrden;
	}

	public int getNumeroHistoria() {
		return numeroHistoria;
	}

	public void setNumeroHistoria(int numeroHistoria) {
		this.numeroHistoria = numeroHistoria;
	}

	@Override
	public int compareTo(Object o) {     // Para que la lista de pacientes este ordenada por Nro Historia
		Paciente paciente=(Paciente)o;
		if(this.numeroHistoria>paciente.numeroHistoria)
			
			return 1;
		else
			if(this.numeroHistoria<paciente.numeroHistoria)
				return -1;
			else
				return 0;
	}


	@Override
	public String toString() {
		return nombre + " " + apellido + " " +DNI ;
		
}
	
}


