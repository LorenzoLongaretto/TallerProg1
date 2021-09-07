package agregado;

import interfaces.I_Contratable;
import servicios.Domicilio;

/**
 * @author Taller1
 * <br>
 * Clase para Agregados tipo Telefono
 */
public class Telefono extends DecoratorAgregado {

	/**
	 * Constructor para un Agregado tipo Telefono<br>
	 * @param cantLineas: parametro de tipo int que representa la cantidad de lineas contratadas de este Agregado
	 * @param contratable: parametro de tipo I_Contrtable que representa el servicio o Agregado adjunto
	 */
	public Telefono(int cantLineas, I_Contratable contratable) {
		super(cantLineas, contratable);
	}

	/**
	 * @return Devuelve el precio total del Servicio mas sus Agregados
	 */
	public double getPrecio() {
		return this.getContratable().getPrecio() + this.getCantLineas() * 200;
	}
	
	/**
	 * @return Devuelve la ID unica del Servicio
	 */
	public int getID() {
		return this.getContratable().getID();
	}

	/**
	 * @return Devuelve el domicilio adjunto al Servicio
	 */
	public Domicilio getDomicilio() {
		return this.getContratable().getDomicilio();
	}
	
	/**
	 *@return Devuelve un String con los detalles del Servicio
	 */
	@Override
	public String toString() {
		return this.getContratable().toString() + " + TELEFONO: $200 x " +this.getCantLineas();
	}

     /**
     *
     * @return false
     */
	public boolean isInternet100() {
		return false;
	}
    /**
     *
     * @return false
     */
	public boolean isInternet500() {
		return false;
	}
    /**
     *
     * @return false
     */
	public boolean isCelular() {
		return false;
	}
    /**
     *
     * @return true
     */
	public boolean isTelefono() {
		return true;
	}
    /**
     *
     * @return false
     */
	public boolean isTV_Cable() {
		return false;
	}
        
        /**
	 * @return Devuelve un clon, siempre son clonables
	 */
	@Override
	public Object clone() {
		Telefono telefonoClonado;
		telefonoClonado=(Telefono) super.clone();
		return telefonoClonado;
	}
}
