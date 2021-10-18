package modelo;

import personas.MedicoCirujano;
import personas.MedicoClinico;
import personas.MedicoPediatra;
import excepciones.NoExisteContratacionException;
import excepciones.NoExisteEspecialidadException;
import excepciones.NoExistePosgradoException;

/**
 * Clase que representa la contratacion de un medico a la clinica
 *
 */
public class MedicoFactory {
	
	/**
	 * <b> Pre: El medico debe tener especialidad, posgrado y un tipo de contratacion definida.</b>
	 * <b> Post: Crea un nuevo medico.</b>.
	 * @param dNI:parametro de tipo String que representa el DNI.
	 * @param nombre:parametro de tipo String que representa el nombre.
	 * @param apellido:parametro de tipo String que representa el apellido.
	 * @param ciudad:parametro de tipo String que representa el ciudad.
	 * @param telefono:parametro de tipo String que representa el telefono.
	 * @param domicilio:parametro de tipo String que representa el domicilio.
	 * @param matricula:parametro de tipo String que representa la matricula.
	 * @param especialidad:parametro de tipo String que representa la especialidad.
	 * @param contratacion:parametro de tipo String que representa el tipo de contratacion.
	 * @param posgrado:parametro de tipo String que representa el posgrado.
	 * 
	 * @throws NoExisteEspecialidadException: excepcion lanzada cuando se ingresa un tipo de especialidad inexistente.
	 * @throws NoExisteContratacionException: excepcion lanzada cuando se ingresa un tipo de contratacion inexistente.
	 * @throws NoExistePosgradoException: excepcion lanzada cuando se ingresa un tipo de posgrado inexistente.
	 */
	public static IMedico getMedico(String dNI, String nombre, String apellido, String ciudad, String telefono, String domicilio, String matricula, String especialidad, String contratacion,String posgrado) throws NoExisteEspecialidadException, NoExisteContratacionException, NoExistePosgradoException {
		IMedico encapsulado = null;
		IMedico respuesta = null;
		
		if(especialidad.equals("Cirujia"))
		   encapsulado = new MedicoCirujano(dNI,nombre,apellido,ciudad,telefono,domicilio,matricula);
		else
			if(especialidad.equals("Pediatria"))
				encapsulado = new MedicoPediatra(dNI,nombre,apellido,ciudad,telefono,domicilio,matricula);
			else 
				if(especialidad.equals("Clinica"))
					encapsulado = new MedicoClinico(dNI,nombre,apellido,ciudad,telefono,domicilio,matricula);
		        else
		            throw new NoExisteEspecialidadException("No existe especialidad",especialidad);

		
		if (encapsulado != null)
		{
			
			if (posgrado.equals("Magister"))
				respuesta = new DecoratorMagister(encapsulado);
			else
				if(posgrado.equals("Doctor"))
					respuesta = new DecoratorDoctorado(encapsulado);
				else
					throw new NoExistePosgradoException("No Existe Posgrado ",posgrado);//***
			
			if (contratacion.equals("Permanente"))
				respuesta = new DecoratorPermanente(respuesta);
			else
				if(contratacion.equals("Residente") || contratacion.equals("Temporario"))
					respuesta = new DecoratorTemporario(respuesta);
				else
				    throw new NoExisteContratacionException("No existe Contratacion ",contratacion);
		}
		return respuesta;
	}

}
