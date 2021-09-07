package interfaces;

import servicios.Domicilio;

/**
 * @author Taller1
 * <br>
 * Interfaz para servicios contratables y sus agregados.
 */
public interface I_Contratable extends Cloneable {
	
	/**
	 * Metodo para obtener el precio de un servicio.<br>	 
	 * @return Devuelve el precio del servicio. En caso de haberse contratado agregados, devuelve el precio total del servicio mas sus agregados<br>
	 */
	double getPrecio();
	
	
	/**
	 * Metodo para obtener el numero de identificacion de un servicio
	 * @return Devuelve un entero, que es el numero de identificacion del servicio. Este numero es unico.
	 */
	int getID();
	
	/**
	 * @return Devuelve el domicilio asociado al Servicio
	 */
	Domicilio getDomicilio();
	
	/**
	 * @return Devuelve un valor booleano de si es Internet100
	 */
	boolean isInternet100();
	
	/**
	 * @return Devuelve un valor booleano de si es Internet500
	 */
	boolean isInternet500();
	
	/**
	 * @return Devuelve un valor booleano de si es Celular
	 */
	boolean isCelular();
	
	/**
	 * @return Devuelve un valor booleano de si es Telefono
	 */
	boolean isTelefono();
	
	/**
	 * @return Devuelve un valor booleano de si es TV Cable
	 */
	boolean isTV_Cable();

	/**
	 * @return Devuelve el objeto clonado de I_Contratable
	 */
	Object clone();
}
