package agregado;

import interfaces.I_Contratable;
import servicios.Domicilio;

/**
 * @author Taller1
 * <br>
 * Clase para aniadir nuevos agregados al Servicio, utilizando el patron Decorator
 */
public abstract class DecoratorAgregado implements I_Contratable {
	
	private I_Contratable contratable;
	private int cantLineas;

	/**
	 * Constructor general para un nuevo Agregado
	 * @param cantLineas: parametro de tipo int que representa la cantidad de lineas del nuevo agregado
	 * @param contratable: parametro de tipo I_Contratable que representa el servicio al que se le aniade el Agregado
	 */
	public DecoratorAgregado(int cantLineas, I_Contratable contratable) {
		this.cantLineas = cantLineas;
		this.contratable= contratable;
	}

	/**
	 * @return Devuelve la cantidad de lineas contratadas de este Agregado
	 */
	public int getCantLineas() {
		return cantLineas;
	}

	/**
	 * Modifica la cantidad de lineas para este agregado
	 * @param cantLineas: Nuevo numero de lineas de este agregado, tiene que ser un numero positivo
	 */
	public void setCantLineas(int cantLineas) {
		this.cantLineas = cantLineas;
	}

	/**
	 * @return Devuelve el Servicio de Internet, o en caso de haber mas de un agregado devuelve el siguiente Agregado
	 */
	public I_Contratable getContratable() {
		return contratable;
	}

    /**
     *
     * @return : Su implementación debe retornar el precio del servicio
     * 
     */
    @Override
  	public abstract double getPrecio();
   
    /**
     *
     * @return : Su implementación debe retornar la ID del servicio
     */
    @Override
	public abstract int getID();
       
    /**
     *
     * @return : Su implementación debe retornar el Domicilio
     */
    @Override
	public abstract Domicilio getDomicilio();
     
    /**
     *
     * @return : Su implementación debe retornar si es un servicio de Interner100
     */
    @Override
	public abstract boolean isInternet100();

    /**
     *
     * @return : Su implentación debe retornar si es un servicio de Internet500
     */
    @Override
	public abstract boolean isInternet500();
        
    /**
     *
     * @return : Su implentación debe retornar si es un servicio de Celular
     */
    @Override
	public abstract boolean isCelular();

    /**
     *
     * @return : Su implementación debe retornar si es un servicio de teléfono
     */
    @Override
	public abstract boolean isTelefono();

    /**
     *
     * @return : Su implementación debe retornar si es un servicio de TV_Cable
     */
        @Override
	public abstract boolean isTV_Cable();
	
	/**
	 * @return Devuelve un clon del Agregado. Estos siempre son clonables
	 */
	@Override
	public Object clone() {
		DecoratorAgregado agregadoClonado=null;
		try {
			agregadoClonado=(DecoratorAgregado) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return agregadoClonado;
	}
}
