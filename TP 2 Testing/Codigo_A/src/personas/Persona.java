package personas;

import interfaces.I_Pago;

/**
 * @author Taller1
 * <br>
 * Clase abstracta que representa una Persona
 */
public abstract class Persona implements Cloneable{
	
	private String nombre;
    
	/**
	 * Constructor con un parametro para setear el nombre de la persona
	 * <br>
	 * @param nombre: parametro de tipo String que representa el nombre de la persona 
	 */
	public Persona(String nombre) {
		this.nombre = nombre;
	}

    /**
     *
     * @return devuelve el Nombre
     */
        
    public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre Setea el nombre de la persona, debe ser distinto de null y no repetido
	 */
	public void setNombre(String nombre) { 
		this.nombre = nombre;
	}
	
	/**
	 *Metodo de clonacion condicional
	 *<br>
	 *La clase Persona conserva la propagacion de la excepcion, ya que no sabemos si las clases hijas seran o no cloneables
	 */
	
	@Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
	/**
	 *Realiza el calculo del total a abonar aplicando el tipo de pago correspondiente<br>
	 *<b>Pre: </b> tipo debe ser distinto de null y el total debe ser positivo <br>
	 * <b>Post: </b> sera calculado el total aplicando el tipo de pago
	 * @param tipo: medio de pago para aplicar el porcentaje correspondiente
	 * @param total: total de la factura a pagar para calcular su precio final aplicando el porcentaje
	 * @return devuelve el valor del total calculado con el porcentaje aplicado
	 */
	public abstract double aplicarPorcentaje(I_Pago tipo,double total); 
    
}
