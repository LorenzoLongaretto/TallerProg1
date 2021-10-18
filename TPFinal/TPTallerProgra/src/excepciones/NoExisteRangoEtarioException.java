package excepciones;

public class NoExisteRangoEtarioException extends Exception{

	private String rango;
	public NoExisteRangoEtarioException(String msj,String rango) {
		super(msj);
		this.rango=rango;
	}
	public String getRango() {
		return rango;
	}

	
}
