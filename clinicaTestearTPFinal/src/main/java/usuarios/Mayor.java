package usuarios;

/**
 * Paciente concrecto de tipo Mayor
 */
public class Mayor extends Paciente {

    /**
     * Metodo que crea un paciente nuevo. <br>
     * <b>Pre: </b> Todos los parametros deben existir y ser validos. <br>
     * 
     * @param dni       String, contiene el DNI del paciente. <br>
     * @param domicilio String, contiene el Domicilio en nombre y número. <br>
     * @param ciudad    String, representa la ciudad de nacimiento. <br>
     * @param telefono  String, contiene el numero de telefono del paciente. <br>
     * @param nombre    Nombre y Apellido del paciente. <br>
     *                  <b>Post: </b> Crea un objeto de tipo Mayor <br>
     */

    public Mayor(String dni, String domicilio, String ciudad, String telefono, String nombre, String rangoEtario) {
        super(dni, domicilio, ciudad, telefono, nombre, rangoEtario);
    }

    public Mayor() {
    }

    /**
     * Metodo que se encarga de delegar al paciente p el juego de prioridad de la
     * sala respecto al paciente que invoca al metodo. <br>
     * <b>Pre:</b> El parametro priorizable debe ser no nulo. <br>
     * 
     * @param p Objeto de tipo paciente.
     * @return El valor de la invocacion al respectivo metodo que determina si el
     *         paciente p tiene prioridad sobre el paciente actual en la Sala de
     *         Espera.
     */

    @Override
    public boolean prioriza(Priorizable p) {
        return p.ganaMayor();
    }

    /**
     * @return true ya que el paciente Joven tiene prioridad sobre el paciente
     *         mayor.
     */

    @Override
    public boolean ganaJoven() {
        return true;
    }

    /**
     * @return false ya que un paciente mayor no tiene prioridad sobre otro paciente
     *         mayor.
     */

    @Override
    public boolean ganaMayor() {
        return false;
    }

    /**
     * @return false ya que un paciente nino tiene prioridad sobre un paciente
     *         mayor.
     */

    @Override
    public boolean ganaNino() {
        return false;
    }

}
