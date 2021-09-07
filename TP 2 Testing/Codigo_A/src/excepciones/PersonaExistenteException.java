package excepciones;
/**
 * @author Taller1
 *<br>
 *Excepcion para el caso de Persona Invalida
 */
@SuppressWarnings("serial")
public class PersonaExistenteException extends Exception {
	
	/**
	 * Metodo que se activa cuando se lanza la excepcion
	 * @param mensaje: parametro de tipo String que representa el mensaje del error
	 * @param mensaje
	 */
	public PersonaExistenteException(String mensaje) {
		super(mensaje);
	}

}
