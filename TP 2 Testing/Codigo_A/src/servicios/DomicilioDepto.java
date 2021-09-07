package servicios;

/**
 *@author Taller1
 *<br>
 *Clase para domicilios con departamentos
 */
public class DomicilioDepto extends Domicilio {
	
	private int piso;
	private String departamento;

	/**
	 * Constructor para un domicilio con departamento<br>
	 * @param numero: Numero de la direccion del domicilio.
	 * @param calle: Nombre de la calle del domicilio.
	 * @param piso: Piso del departamento
	 * @param departamento: Detalles del departamento, sea letra, otro numero o caso especial
	 */
	public DomicilioDepto(String calle, int altura, int piso, String departamento) {
		super(calle, altura);
		this.piso= piso;
		this.departamento= departamento;
	}

	public int getPiso() {
		return piso;
	}

	/**
	 * Setea el piso del departamento, debe ser positivo
	 * @param piso: parametro que representa al piso del departamento
	 */
	public void setPiso(int piso) {
		this.piso = piso;
	}

	public String getDepartamento() {
		return departamento;
	}

	/**
	 * Setea el detalle del departamento ya sea, letra, otro numero o caso especial. No debe ser cadena vacia
	 * @param departamento: parametro que representa al detalle del departamento
	 */
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	/**
	 *@return Devuelve un String con los detalles del domicilio y del departamento
	 */
	@Override
	public String toString() {
		return super.toString() + " PISO: " + this.piso + " DEPARTAMENTO: " + this.departamento + " ";
	}

	
	

}
