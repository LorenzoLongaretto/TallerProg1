package personas;

public class MedicoCirujano extends Medico {

	public MedicoCirujano(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio,
			String matricula) {
		super(dNI, nombre, apellido, ciudad, telefono, domicilio, matricula,"Cirujia");
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getHonorario() {
		// TODO Auto-generated method stub
		return super.getHonorario()*1.1;
	}

}
