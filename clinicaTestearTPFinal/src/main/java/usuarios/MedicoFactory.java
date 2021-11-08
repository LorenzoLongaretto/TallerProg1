package usuarios;

import exceptions.NoExisteException;

/**
 * Clase utilizada para la creacion de los medicos
 */
public abstract class MedicoFactory {

    /**
     * Crea el medico segun su especialidad, tipo de Contratacion y posgrado (en
     * caso de tenerlo).
     * 
     * @param dni              Contiene el DNI del medico
     * @param domicilio        contiene el domicilio del medico
     * @param ciudad           representa la ciudad de origen
     * @param telefono         contiene el telefono del medico
     * @param nombre           Nombre y apellido del medico
     * @param numero           representa el numero de licencia medico (unico por
     *                         medico)
     * @param honorarioBasico  Honorario basico del medico
     * @param especialidad     especialidad del medico (clinico, cirujano, pediatra)
     * @param tipoContratacion tipo de contratacion (permanente, temporario)
     * @return Un medico especifico
     * @throws NoExisteException Una advertencia sobre algun parametro mal ingresado
     */
    public static Medico getMedico(String dni, String domicilio, String ciudad, String telefono, String nombre,
                                   int numero, double honorarioBasico, String especialidad, String tipoContratacion) throws NoExisteException {
        MedicoBase medicoBase;
        Medico respuesta;

        if (especialidad.equalsIgnoreCase("CLINICO"))
            medicoBase = new MedicoClinico(dni, domicilio, ciudad, telefono, nombre, numero, honorarioBasico);
        else if (especialidad.equalsIgnoreCase("CIRUJANO"))
            medicoBase = new MedicoCirujano(dni, domicilio, ciudad, telefono, nombre, numero, honorarioBasico);
        else if (especialidad.equalsIgnoreCase("PEDIATRA"))
            medicoBase = new MedicoPediatra(dni, domicilio, ciudad, telefono, nombre, numero, honorarioBasico);
        else
            throw new NoExisteException("La especialidad ingresada no existe");

        if (tipoContratacion.equalsIgnoreCase("PERMANENTE"))
            respuesta = new MedicoPermanenteDecorator(medicoBase);
        else if (tipoContratacion.equalsIgnoreCase("TEMPORARIO"))
            respuesta = new MedicoTemporarioDecorator(medicoBase);
        else
            throw new NoExisteException("El tipo de contratacion ingresado no existe");

        return respuesta;
    }

    /**
     * Crea el medico segun su especialidad, tipo de Contratacion y posgrado (en
     * caso de tenerlo).
     * 
     * @param dni              Contiene el DNI del medico
     * @param domicilio        contiene el domicilio del medico
     * @param ciudad           representa la ciudad de origen
     * @param telefono         contiene el telefono del medico
     * @param nombre           Nombre y apellido del medico
     * @param numero           representa el numero de licencia medico (unico por
     *                         medico)
     * @param honorarioBasico  Honorario basico del medico
     * @param especialidad     especialidad del medico (clinico, cirujano, pediatra)
     * @param tipoContratacion tipo de contratacion (permanente, temporario)
     * @param posgrado         posgrado del medico en caso de tenerlo (magister,
     *                         doctorado)
     * @return Un medico especifico
     * @throws NoExisteException Una advertencia sobre algun parametro mal ingresado
     */

    public static Medico getMedico(String dni, String domicilio, String ciudad, String telefono, String nombre,
                                   int numero, int honorarioBasico, String especialidad, String tipoContratacion, String posgrado)
            throws NoExisteException {
        Medico respuesta;

        respuesta = MedicoFactory.getMedico(dni, domicilio, ciudad, telefono, nombre, numero, honorarioBasico,
                especialidad, tipoContratacion);

        if (posgrado.equalsIgnoreCase("MAGISTER"))
            respuesta = new MagisterMedicoDecorator(respuesta);
        else if (posgrado.equalsIgnoreCase("DOCTORADO"))
            respuesta = new DoctoradoMedicoDecorator(respuesta);
        else
            throw new NoExisteException("El posgrado ingresado no existe");

        return respuesta;
    }

}
