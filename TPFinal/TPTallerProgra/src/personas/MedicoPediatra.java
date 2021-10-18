package personas;

public class MedicoPediatra extends Medico {

	public MedicoPediatra(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio,
			String matricula) {
		super(dNI, nombre, apellido, ciudad, telefono, domicilio, matricula,"Pediatria");
		
	}

	@Override
	public double getHonorario() {
		// TODO Auto-generated method stub
		return super.getHonorario()*1.07;
	}

}
