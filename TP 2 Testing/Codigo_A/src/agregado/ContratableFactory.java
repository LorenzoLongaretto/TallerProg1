package agregado;

import excepciones.DomicilioInvalidoException; 
import excepciones.ServicioInternetInvalidoException;
import interfaces.I_Contratable;
import servicios.Domicilio;
import servicios.Internet100;
import servicios.Internet500;

/**
 * @author Taller1
 * <br>
 * Clase para crear nuevos Servicios utilizando el patron Factory.
 */
public class ContratableFactory {

	/**	 
	 * Metodo para crear un nuevo Servicio<br>
	 * @param internet: parametro de tipo String que representa el tipo de servicio de internet deseado<br>
	 * @param cantCel: Si es mayor que cero, indica la cantidad de lineas de celular que seran agregadas al Servicio.<br>
	 * @param cantTel: Si es mayor que cero, indica la cantidad de lineas de telefono fijo que seran agregadas al Servicio.<br>
	 * @param cantTV: Si es mayor que cero, indica la cantidad de lineas de TV_Cable que seran agregadas al Servicio.<br>
	 * @param domicilio: Domicilio al que estara asociado el Servicio<br>
	 * @return Devuelve un objeto de tipo I_Contratable, con el Servicio y todos sus Agregados contratados, asociado al Domicilio especificado.<br>
	 * @throws ServicioInternetInvalidoException: Se lanza en el caso de que el parametro internet sea null o un tipo de Servicio que no esta definido actualmente<br>
	 * @throws DomicilioInvalidoException: Se lanza en el caso de que el parametro domicilio sea null<br>
	 */
	public static I_Contratable nuevoServicio(String internet, int cantCel, int cantTel, int cantTV, Domicilio domicilio) throws ServicioInternetInvalidoException,
		DomicilioInvalidoException { 
		I_Contratable servicio= null; 
		if (domicilio == null || domicilio.equals("")) {
			throw new DomicilioInvalidoException("No se ingreso un domicilio");
		}
		else {
			if (internet == null || internet.equals("")) { //pues usamos scanner
				throw new ServicioInternetInvalidoException("No se ingreso un servicio de internet");
			}
			else {
				if (internet.equalsIgnoreCase("internet100") || internet.equalsIgnoreCase("internet500")) {
					if(internet.equalsIgnoreCase("internet100"))
						servicio= new Internet100(domicilio);
					else
						servicio= new Internet500(domicilio);
					I_Contratable agregado= null; 
					
					if (cantCel > 0) {
						agregado= new Celular(cantCel, servicio);
						servicio= agregado;
					}
					if (cantTel > 0) {
						agregado= new Telefono(cantTel, servicio);
						servicio= agregado;
					}
					if (cantTV > 0) {
						agregado= new TV_Cable(cantTV, servicio);
						servicio= agregado;
					}
				}
				else {
					throw new ServicioInternetInvalidoException("El servicio de internet ingresado no existe"); 
				}
				
			}
		}
		return servicio;
	}
}
