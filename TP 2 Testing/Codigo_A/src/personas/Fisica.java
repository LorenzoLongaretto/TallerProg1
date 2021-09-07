package personas;

import interfaces.I_Pago;

/**
 * @author Taller1
 * <br>
 * Clase que representa a una Persona Fisica
 */
public class Fisica extends Persona {
	private int DNI;
	
	/**
	 * Constructor  con dos parametros para setear el nombre y el documento  de la persona fisica
	 * <br>
	 * @param nombre : parametro de tipo String que representa el nombre de la persona fisica
	 * @param DNI : parametro de tipo int que representa el documento de la persona fisica
	 */
	public Fisica(String nombre,int DNI) {
		super(nombre);
		this.DNI=DNI;
	}
        
    /**
     *
     * @return retorna el DNI
     */
    public int getDNI() {
		return DNI;
	}

	/**
	 * Setea el documento de la persona fisica
	 * @param dNI: parametro de tipo int, debe ser positivo
	 */
	public void setDNI(int dNI) {
		DNI = dNI;
	}

	 /**
	 *Metodo para la clonacion de persona fisica, en este caso SIEMPRE SERA CLONABLE
	 */
	@Override
	 public Object clone() { 
	        Object clon = null;
	        try
	        {
	            clon = super.clone();
	        } catch (CloneNotSupportedException e)
	        {
	            //NUNCA entraremos a este bloque porque siempre sera clonable
	            e.printStackTrace();
	        }
	        return clon;
	 }

	
	/**
	 *Realiza el calculo del total a abonar la persona fisica aplicando el tipo de pago correspondiente(DOUBLE DISPATCH)<br>
	 *<b>Pre: </b> tipo debe ser distinto de null y el total debe ser positivo <br>
	 * <b>Post: </b> sera calculado el total aplicando el tipo de pago
	 * @param tipo: medio de pago para aplicar el porcentaje correspondiente
	 * @param total: total de la factura a pagar para calcular su precio final aplicando el porcentaje
	 * @return devuelve el valor del total calculado con el porcentaje aplicado
	 */
	@Override
	public double aplicarPorcentaje(I_Pago tipo, double total) { 
		return total*tipo.porcentajeFisica();
	}
	/**
	 *@return devuelve la informacion detallada de la persona fisica
	 */
	@Override
	public String toString() {
		return "Persona fisica Nombre= " + this.getNombre() + " DNI=" + DNI;
	}
}
