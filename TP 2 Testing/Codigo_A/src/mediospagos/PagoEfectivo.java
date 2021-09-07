package mediospagos;

import interfaces.I_Pago;

/**
 * @author Taller1
 * <br>
 * Clase para el tipo de pago Efectivo
 */
public class PagoEfectivo implements I_Pago {
	/**
	 * Metodo que devuelve un porcentaje correspondiente por el pago usando efectivo siendo una persona fisica
	 *@return devuelve un valor de tipo double 
	 */
	public double porcentajeFisica() { //Abona con efectivo, recibe un descuento de 20%
		return 0.8;
	}
	/**
	 * Metodo que devuelve un porcentaje correspondiente por el pago usando efectivo siendo una persona juridica
	 *@return devuelve un valor de tipo double 
	 */
	public double porcentajeJuridica() { //Abona con efectivo, recibe un descuento de 10%
		return 0.9;
	}
}
