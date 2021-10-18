package personas;

public class MedicoClinico extends Medico {

	public MedicoClinico(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio,
			String matricula) {
		super(dNI, nombre, apellido, ciudad, telefono, domicilio, matricula,"Clinica");
		
	}

	@Override
	public double getHonorario() {
		// TODO Auto-generated method stub
		return super.getHonorario()*1.05;
	}

	
	
}
