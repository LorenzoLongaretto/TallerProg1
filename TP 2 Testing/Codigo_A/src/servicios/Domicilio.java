package servicios;


/**
 * @author Taller1
 * <br>
 * Clase abstracta que representa Domicilio
 */
public abstract class Domicilio {
	
	private String calle;
	private int altura;
	/**
	 * Constructor para setear la calle y la altura del Domicilio
	 * @param calle: Parametro de tipo String que representa la calle del Domicilio
	 * @param altura: Parametro de tipo int que representa la altura del Domicilio
	 */
	public Domicilio(String calle, int altura) {
		this.calle = calle;
		this.altura = altura;
	}
        
	/**
        * @return
        * devuelve la calle
        */
        
	public String getCalle() {
		return calle;
	}
	
	/**
	 * Setea la calle del Domicilio, no debe ser una cadena vacia
	 * @param calle: Parametro de tipo String que representa la calle del Domicilio
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}
        
        /**
        * @return
        * devuelve la Altura
        */
	
	public int getAltura() {
		return altura;
	}
	
	/**
	 * Setea la altura del Domicilio, debe ser un número positivo
	 * @param altura: Parametro de tipo int que representa la altura del Domicilio
	 */
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	/**
	 * @return devuelve un String de calle y altura, es para buscar el id para modificar algun servicio
	 */
	public String getDireccion() {  
		return this.calle + " " +this.altura;
	}
	
	/**
	 *@return devuelve un String de toda la informacion de domicilio
	 */
	@Override
	public String toString() {
		return "Domicilio: "+this.calle + " " +this.altura;
	}
	/**
	 * @return devuelve un clon del Domicilio. Estos siempre son clonables
	 */
	@Override
	protected Object clone() {		
		Object domClonado= null;
		try {
			domClonado= super.clone();
		} catch (CloneNotSupportedException e) {
			// Nunca entra en este bloque porque Domicilio siempre es clonable
			e.printStackTrace();
		}
		return domClonado;
	}
	
	
	
}
