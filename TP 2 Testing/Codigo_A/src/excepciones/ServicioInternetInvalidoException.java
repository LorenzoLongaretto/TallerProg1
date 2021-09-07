package excepciones;
/**
 * @author Taller1
 *<br>
 *Excepcion para el caso de Servicio de internet Invalido
 */
@SuppressWarnings("serial")
public class ServicioInternetInvalidoException extends Exception {

	/**
	 * Metodo que se activa cuando se lanza la excepcion
	 * @param mensaje: parametro de tipo String que representa el mensaje del error
	 */
	public ServicioInternetInvalidoException(String mensaje) {
		super(mensaje);
	}
}

