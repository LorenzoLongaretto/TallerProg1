package modelo;

public abstract class DecoratorContratacion implements IMedico {
protected IMedico encapsulado;

	//Constructores
	public DecoratorContratacion(IMedico encapsulado) {
		super();
		this.encapsulado = encapsulado;
	}

	//Metodos
	@Override
	public String getMatricula() {
		return this.encapsulado.getMatricula();
	}
	@Override
	public String getEspecialidad() {
		return this.encapsulado.getEspecialidad();
	}

}
