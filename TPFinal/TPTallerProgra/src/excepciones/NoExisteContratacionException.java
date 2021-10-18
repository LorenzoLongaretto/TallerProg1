package excepciones;

public class NoExisteContratacionException extends ImposibleCrearMedicoException{

	public NoExisteContratacionException(String msj, String dato) {
		super(msj, dato);
	}

   
}
