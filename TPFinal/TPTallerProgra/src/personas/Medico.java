package personas;



import modelo.IMedico;

public class Medico extends Persona implements IMedico{
private String matricula,especialidad;	
private final double honorarioBasico=1000;

	//Constructores
	public Medico(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio, String matricula, String especialidad) {
		super(dNI, nombre, apellido, ciudad, telefono, domicilio);
		this.matricula = matricula;
		this.especialidad = especialidad;
	}
	//Metodos

	@Override
	public double getHonorario() {
		return this.honorarioBasico;
		}
				
	@Override
	public String getMatricula() {
		return this.matricula;
	}
	@Override
	public String getEspecialidad() {
		return this.especialidad;
	}

	@Override
	public String getNombre() {
		return this.nombre;
	}

	@Override
	public String toString() {
		return nombre +" "+apellido+" " + matricula + " " + especialidad ;
				
	}

}




