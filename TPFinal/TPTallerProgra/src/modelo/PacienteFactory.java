package modelo;
import personas.Paciente;
import personas.Nino;
import excepciones.NoExisteRangoEtarioException;
import personas.Joven;
import personas.Mayor;


/**
 * 
 *
 */

public class PacienteFactory {

	/**
	 * <b> Pre: El paciente debe tener DNI y rango etario.</b>
	 * <b> Post: Crea un nuevo paciente.</b>.
	 * @param dNI: parametro de tipo String que representa el DNI.
	 * @param nombre:parametro de tipo String que representa el nombre.
	 * @param apellido: parametro de tipo String que representa el apellido.
	 * @param ciudad:parametro de tipo String que representa el ciudad.
	 * @param telefono: parametro de tipo String que representa el telefono.
	 * @param domicilio: parametro de tipo String que representa el domicilio.
	 * @param rangoEtario: parametro de tipo String que representa el rango etario.
	 * 
	 * @throws NoExisteRangoEtarioException: excepcion lanzada cuando se ingresa un rango etario inexistente.
	 */
	public static Paciente getPaciente(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio,String rangoEtario) throws NoExisteRangoEtarioException /*throws NoExisteRangoEtarioException*/ {
		Paciente encapsulado=null;
		
		if(rangoEtario.equals("Nino")) 
			encapsulado = new Nino(dNI,nombre,apellido,ciudad,telefono,domicilio);
			else
				if(rangoEtario.equals("Joven"))
					encapsulado = new Joven(dNI,nombre,apellido,ciudad,telefono,domicilio);
				else
					if(rangoEtario.equals("Mayor"))
							encapsulado = new Mayor(dNI,nombre,apellido,ciudad,telefono,domicilio);
		                else
		                    throw new NoExisteRangoEtarioException("No existe rango Etario",rangoEtario);	               
		
		
		return encapsulado;
		
		
	}
}
