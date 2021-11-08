package usuarios;

/**
 * Interfaz que establece el juego de prioridades de asignación de la sala
 * privada. <br>
 */

public interface Priorizable {

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

    boolean prioriza(Priorizable p);

    /**
     * @return true si el joven tiene prioridad en la sala por sobre el paciente de
     *         la clase actual actual, false en caso contrario.
     */

    boolean ganaJoven();

    /**
     * @return true si el Mayor tiene prioridad en la sala por sobre el paciente de
     *         la clase actual. False en caso contrario.
     */

    boolean ganaMayor();

    /**
     * @return true si el Nino tiene prioridad en la sala por sobre el paciente de
     *         la clase actual. False en caso contrario.
     */

    boolean ganaNino();

}
