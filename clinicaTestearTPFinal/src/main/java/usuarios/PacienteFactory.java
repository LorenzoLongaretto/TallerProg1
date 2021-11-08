package usuarios;

import exceptions.NoExisteException;

/**
 * Clase que usa el Patron Factory para crear los pacientes, teniendo en cuenta
 * que estos pueden ser Nino, Joven o Mayor. <br>
 */

public class PacienteFactory {

    /**
     * Metodo que crea un paciente nuevo segun su rango etario <br>
     * <b>Pre: </b> Todos los parametros deben existir y ser validos. <br>
     * <b>Post: </b> En caso de haber sido posible, crea la clase Paciente, o lanza
     * una excepcion si es que no pudo. <br>
     *
     * @param dni         String, contiene el DNI del paciente. <br>
     * @param domicilio   String, contiene el Domicilio en nombre y número. <br>
     * @param ciudad      String, representa la ciudad de nacimiento. <br>
     * @param telefono    String, contiene el numero de telefono del paciente. <br>
     * @param nombre      Nombre y Apellido del paciente. <br>
     * @param rangoEtario Rango Etario del paciente, que es Nino, Joven o Mayor.<br>
     * @return Crea un objeto de tipo Nino, Joven o Mayor <br>
     * @throws NoExisteException Si el rango etareo es erroneo lanza la excepcion y
     *                           no crea el objeto <br>
     */

    public static Paciente getPaciente(String dni, String domicilio, String ciudad, String telefono, String nombre,
                                       String rangoEtario) throws NoExisteException {
        Paciente paciente = null;
        if (rangoEtario.equalsIgnoreCase("Nino"))
            paciente = new Nino(dni, domicilio, ciudad, telefono, nombre, rangoEtario);
        else if (rangoEtario.equalsIgnoreCase("Joven"))
            paciente = new Joven(dni, domicilio, ciudad, telefono, nombre, rangoEtario);
        else if (rangoEtario.equalsIgnoreCase("Mayor"))
            paciente = new Mayor(dni, domicilio, ciudad, telefono, nombre, rangoEtario);
        else
            throw new NoExisteException("Error en los parametros del constructor Paciente. Falta Alguno");
        return paciente;
    }
}
