package modelo;

import java.util.GregorianCalendar;

import personas.Paciente;

public class DecoratorDoctorado extends DecoratorPosgrado {

	//Constructores
	public DecoratorDoctorado(IMedico encapsulado) {
		super(encapsulado);
		// TODO Auto-generated constructor stub
	}
	
	//Metodos
	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario()*1.1;
	}
	@Override
	public String getEspecialidad() {
		return super.getEspecialidad();
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.encapsulado.getNombre();
	}

	@Override
	public String toString() {
		return this.encapsulado.toString()+" Doctorado";
	}

	
	
	
}
