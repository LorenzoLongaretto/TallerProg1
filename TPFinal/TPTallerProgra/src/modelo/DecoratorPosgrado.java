package modelo;

public abstract class DecoratorPosgrado implements IMedico {
protected IMedico encapsulado;

	//Constructores
	public DecoratorPosgrado(IMedico encapsulado) {
		super();
		this.encapsulado = encapsulado;
	}

	//Metodos
	@Override
	public double getHonorario() {
		return this.encapsulado.getHonorario();
	}
	@Override
	public String getMatricula() {
		return this.encapsulado.getMatricula();
	}
	@Override
	public String getEspecialidad() {
		return this.encapsulado.getEspecialidad();
	}

}
