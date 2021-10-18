package excepciones;

public class NoExistePosgradoException extends ImposibleCrearMedicoException{

	public NoExistePosgradoException(String msj, String dato) {
		super(msj, dato);
		
	}


}
