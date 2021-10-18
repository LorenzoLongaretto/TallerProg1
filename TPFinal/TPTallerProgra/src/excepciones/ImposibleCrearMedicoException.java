package excepciones;

public class ImposibleCrearMedicoException extends Exception{
private String dato;

public ImposibleCrearMedicoException(String msj,String dato) {
	super(msj);
	this.dato=dato;
	
}

public String getDato() {
	return dato;
}

}
