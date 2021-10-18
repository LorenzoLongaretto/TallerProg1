package infraestructura;

import java.io.Serializable;

import personas.Paciente;

public class SalaDeEspera implements Serializable{

	//Atributos
	private boolean ocupada;
    private Paciente paciente;
	
	//Constructores
	public SalaDeEspera() {
		this.ocupada = false;
		this.paciente=null;
	}
	
	//Metodos
	public boolean isOcupada() {
		return this.ocupada;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void ocupaSalaDeEspera(Paciente paciente) {
		this.paciente=paciente;
		this.ocupada=true;
		
	}
	public void desocupar() {
		this.ocupada = false;
		this.paciente=null;		
	}

	@Override
	public String toString() {
		return "SalaDeEspera [paciente=" + paciente + "]";
	}
	
	
	
}
