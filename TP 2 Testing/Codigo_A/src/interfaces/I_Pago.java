package interfaces;

/**
 * @author Taller1
 * <br>
 * Interfaz para los medios de pagos
 */
public interface I_Pago {
	
	/**
	 * Metodo para obtener el porcentaje para aplicar descuento o incremento dependiendo del tipo de pago.
	 * <br>
	 * @return Devuelve el porcentaje correspondiente a la persona fisica
	 */
	double porcentajeFisica();
	/**
	 * Metodo para obtener el porcentaje para aplicar descuento o incremento dependiendo del tipo de pago.
	 * <br>
	 * @return Devuelve el porcentaje correspondiente a la persona juridica
	 */
	double porcentajeJuridica();
}
