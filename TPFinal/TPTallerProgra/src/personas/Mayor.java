package personas;

public class Mayor extends Paciente{

	//Constructores
	public Mayor(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio) {
		super(dNI, nombre, apellido, ciudad, telefono, domicilio, "Mayor");
	}
	
	//Metodos
	@Override
	public boolean prioridad(Paciente paciente) {	
		return paciente.prioridadMayor();
	}
	@Override
	public boolean prioridadNino() {
		return true;
	}
    @Override
	public boolean prioridadJoven() {
		return false;
	}
	@Override
	public boolean prioridadMayor() {
		return false;
	}

}
