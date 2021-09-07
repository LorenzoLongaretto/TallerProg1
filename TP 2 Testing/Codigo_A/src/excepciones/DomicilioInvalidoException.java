package excepciones;



/**
 * @author Taller1
 *<br>
 *Excepcion para el caso de Domicilio Invalido
 */
@SuppressWarnings("serial")
public class DomicilioInvalidoException extends Exception {

	/**
	 * Metodo que se activa cuando se lanza la excepcion
	 * @param mensaje: parametro de tipo String que representa el mensaje del error
	 */
	public DomicilioInvalidoException(String mensaje) {
		super(mensaje);
	}
}
