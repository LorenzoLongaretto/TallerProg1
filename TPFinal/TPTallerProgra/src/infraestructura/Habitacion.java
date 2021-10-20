package infraestructura;

import java.io.Serializable;

/**
 * Clase que representa una habitacion de la clinica.
 *
 */
public abstract class Habitacion implements Serializable{

	//Atributos
	/**
	 * nroHabitacion: Corresponde al nro de la habitacion.
	 * cantDias: Corresponde la cantidad de dias que la habitacion es utilizada.
	 * costoAsignacion: Corresponde al costo base de la habitacion.
	 * cantPersonas: Corresponde a la cantidad de personas que entran actualmente en la habitacion.
	 */
	private int nroHabitacion, cantDias;//VERIFICAR nroHabitacion
    /**
     * @aggregation shared
     */
	private double costoAsignacion;//El de cada habitacion particular
    protected int  cantPersonas=1; // cantidad de personas que entran en la habitacion
   
	
	//Constructores
	public Habitacion(int nroHabitacion,double costoAsignacion) {
		
		this.nroHabitacion = nroHabitacion;
		
		this.costoAsignacion=costoAsignacion;
	}

	//Metodos
	public abstract double costoDeHabitacion(int cantDias);
	public int getNroHabitacion() {
		return nroHabitacion;
	}
	public int getCantDias() {
		return cantDias;
	}

	public double getCostoAsignacion() {
		return costoAsignacion;
	}

	@Override
	public String toString() {
		return "Habitacion nro " + nroHabitacion;
	}

	public int getCantPersonas() {
		return cantPersonas;
	}


	public void setCantPersonas(int cantPersonas) {
		this.cantPersonas = cantPersonas;
	}

	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}

	
	
	
}
