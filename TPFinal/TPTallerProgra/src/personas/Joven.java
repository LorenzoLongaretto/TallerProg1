package personas;

public class Joven extends Paciente{

	//Constructores
	public Joven(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio) {
		super(dNI, nombre, apellido, ciudad, telefono, domicilio,"Joven");
		
	}
	
	//Metodos
	@Override
	public boolean prioridad(Paciente paciente) {
		return paciente.prioridadJoven();
	}
	@Override
	public boolean prioridadNino() {	
		return false;
	}
	@Override
	public boolean prioridadJoven() {	
		return false;
	}
	@Override
	public boolean prioridadMayor() {
		return true;
	}

}
