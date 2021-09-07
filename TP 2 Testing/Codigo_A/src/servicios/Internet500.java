package servicios;
/**
 * @author Taller1
 * <br>
 * Clase para el tipo de Servicio Internet500
 */
public class Internet500 extends Servicio {

	/**
	 * Constuctor para un Servicio de tipo Internet500 <br>
	 * <b>Pre: </b>El parametro Domicilio debe ser distinto de null.<br>
	 * <b>Post: </b>Crea un nuevo objeto Servicio.<br>
	 * @param domicilio: Objeto tipo Domicilio al que estara asociado este Servicio.
	 */
	public Internet500(Domicilio domicilio) {
		super(domicilio);
	}
	
	public Internet500(Domicilio domicilio,int id) {
		super(domicilio,id);
	}

	/**
	 * @return Devuelve el precio del Servicio Internet500
	 */
	public double getPrecio() {
		return 1000;
	}
	
	/**
	 *@return Devuelve un String con los detalles del Servicio
	 */
	@Override
	public String toString() {
		return this.getDomicilio().toString() + " SERVICIO== INTERNET500: $1000 ";
	}
        /**
	 * @return false
	 */
	public boolean isInternet100() {
		return false;
	}
        /**
	 * @return true
	 */
	public boolean isInternet500() {
		return true;
	}
        /**
	 * @return false
	 */
	public boolean isCelular() {
		return false;
	}
         /**
	 * @return false
	 */
	public boolean isTelefono() {
		return false;
	}
        /**
	 * @return false
	 */
	public boolean isTV_Cable() {
		return false;
	}
}
