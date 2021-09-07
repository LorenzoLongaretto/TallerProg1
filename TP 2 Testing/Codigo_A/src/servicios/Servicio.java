package servicios;

import interfaces.I_Contratable;

/**
 * @author Taller1
 * <br>
 * Clase abstracta para los servicios de Internet
 */
public abstract class Servicio implements I_Contratable{
	
	private static int sigNro= 0;
	private int servicioID;
    private Domicilio domicilio;

    
	/**
	 * Constructor de un servicio<br>
	 * <b>Pre: </b>El parametro Domicilio debe ser distinto de null.<br>
	 * <b>Post: </b>Crea un nuevo objeto Servicio.<br>
	 * @param domicilio: Objeto tipo Domicilio al que estara asociado este Servicio.
	 */
	public Servicio(Domicilio domicilio) {
		this.domicilio = domicilio;
		sigNro++;
		this.servicioID= sigNro;
	}
	
	public Servicio(Domicilio domicilio,int servicioID) { //PARA MODIFICAR SERVICIO
		this.domicilio=domicilio;
		this.servicioID= servicioID;
	}

	/**
	 * @return Devuelve el domicilio asociado a este Servicio
	 */
	public Domicilio getDomicilio() {
		return domicilio;
	}
    
	/**
	 * @return Devuelve el numero de identificacion unico de este servicio
	 */
	public int getID() {
		return this.servicioID;
	}
	@Override
	public Object clone() {
		Servicio servicioClonado= null;
		try {
			servicioClonado= (Servicio) super.clone();
		} catch (CloneNotSupportedException e) {
			// Nunca se ejecuta porque Servicio siempre es clonable
			e.printStackTrace();
		}
		return servicioClonado; 
	}
    
}
