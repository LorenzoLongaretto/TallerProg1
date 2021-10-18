package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import infraestructura.Habitacion;
import infraestructura.Prestacion;
import personas.Paciente;

/**
 * <br>
 * Clase que representa una historia clinica.
 *
 */
public class HistoriaClinica implements Serializable{
      private Paciente paciente;
      private ArrayList <Prestacion> prestaciones = new ArrayList <Prestacion>();
	public HistoriaClinica(Paciente paciente, ArrayList<Prestacion> prestaciones) {
		
		this.paciente = paciente;
		this.prestaciones = prestaciones;
	}
	
	/** Metodo que agrega una practica medica a la historia Clinica de un paciente.
	 * * <b>Pre: El parametro IMedico debe ser distinto de null</b>
	 * <b>Post: Se agrega una practica medica a una historia medica.</b>
	 * @param medico: Parametro de tipo IMedico.
	 */
	public void agregarPractica(IMedico medico) {
		Prestacion nueva = new Prestacion(medico.getNombre()+" "+medico.getMatricula(),medico.getHonorario()*1.2,1);  // Ponemos nombre y matricula por si hay dos medicos con el mismo nombre
		nueva.setSubtotal(nueva.getCantidad()*nueva.getValor());
		nueva.setFecha(new GregorianCalendar());
		this.prestaciones.add(nueva);
	}
	/** Metodo que agrega una instalacion a la historia Clinica de un paciente.
	 * * <b>Pre: El parametro habitacion debe ser distinto de null</b>
	 * <b>Post: Se agrega una instalacion a una historia medica.</b>
	 * @param habitacion: Parametro de tipo Habitacion.
	 */
	public void agregarInstalacion(Habitacion habitacion) {
		 Prestacion nueva = new Prestacion(habitacion.toString(),habitacion.getCostoAsignacion(),habitacion.getCantDias());
		 nueva.setSubtotal(habitacion.costoDeHabitacion(habitacion.getCantDias()));	
		 nueva.setFecha(new GregorianCalendar());
		 this.prestaciones.add(nueva);
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public ArrayList<Prestacion> getPrestaciones() {
		return prestaciones;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public void setPrestaciones(ArrayList<Prestacion> prestaciones) {
		this.prestaciones = prestaciones;
	}
	
	public void agregarPrestacion(Prestacion p) {
		this.prestaciones.add(p);
	}

	@Override
	public String toString() {
		return "HistoriaClinica [paciente=" + paciente + ", prestaciones=" + prestaciones + "]";
	}
      
}
