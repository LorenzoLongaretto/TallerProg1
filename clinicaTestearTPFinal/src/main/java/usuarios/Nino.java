package usuarios;

/**
 * Paciente concrecto de tipo Nino.
 */
public class Nino extends Paciente implements Priorizable {

    /**
     * Metodo que crea un paciente nuevo. <br>
     * <b>Pre: </b> Todos los parametros deben existir y ser validos. <br>
     * 
     * @param dni       String, contiene el DNI del paciente. <br>
     * @param domicilio String, contiene el Domicilio en nombre y número. <br>
     * @param ciudad    String, representa la ciudad de nacimiento. <br>
     * @param telefono  String, contiene el numero de telefono del paciente. <br>
     * @param nombre    Nombre y Apellido del paciente. <br>
     *                  <b>Post: </b>@return Crea un objeto de tipo Nino <br>
     */

    public Nino(String dni, String domicilio, String ciudad, String telefono, String nombre, String edad) {
        super(dni, domicilio, ciudad, telefono, nombre, edad);
    }

    public Nino() {
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
        return p.ganaNino();
    }

    /**
     * @return false ya que el Nino tiene prioridad en la sala por sobre el paciente
     *         Joven.
     */

    @Override
    public boolean ganaJoven() {
        return false;
    }

    /**
     * @return true ya que el paciente Mayor tiene prioridad en la sala por sobre el
     *         Nino.
     */

    @Override
    public boolean ganaMayor() {
        return true;
    }

    /**
     * @return false ya que el Nino no tiene prioridad en la sala por sobre otro
     *         Nino.
     */

    @Override
    public boolean ganaNino() {
        return false;
    }

}
