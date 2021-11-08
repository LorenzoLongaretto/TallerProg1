package lugares;

import exceptions.NoIngresaSalaPrivadaException;
import usuarios.Paciente;

/**
 * Clase que contiene la Sala de Espera Privada y el patio, se encarga de
 * acomodar los nuevos pacientes a la sala que le corresponda. <br>
 */

public class SalaDeEspera {
    private static SalaDeEspera _instance = null;
    private Patio patio;
    private SalaEsperaPrivada salaprivada;

    /**
     * Genera las instancias del patio y de la sala privada.<br>
     */
    private SalaDeEspera() {
        this.patio = new Patio();
        this.salaprivada = new SalaEsperaPrivada();
    }

    /**
     * Patron singleton que genera una instancia de la Sala de Espera en caso de que
     * no haya sido creada, o retorna la ya creada. <br>
     * 
     * @return
     */
    public static SalaDeEspera getinstance() {
        if (_instance == null)
            _instance = new SalaDeEspera();
        return _instance;
    }

    /**
     * Metodo que se encarga de retirar al paciente invocado de la sala de espera
     * privada o del patio. <br>
     * <b>Pre: </b> El paciente debe existir, y debe estar en la lista de espera.
     * <br>
     * <b>Post: </b> El paciente es retirado de la lista del patio, o de la sala de
     * espera privada. <br>
     * 
     * @param paciente
     */

    public void retiraPaciente(Paciente paciente) {
        if (salaprivada.getPacienteActual().equals(paciente))
            this.salaprivada.retira();
        else
            this.patio.retira(paciente);
    }

    /**
     * Metodo que se encarga de ingresar al paciente. Primero intenta ingresarlo en
     * la sala privada, si no es posible lo mueve al patio.<br>
     * <b>Pre: </b> El paciente debe existir. <br>
     * <b>Post: </b> El paciente es acomodado a la sala correspondiente. <br>
     * 
     * @param paciente Paciente a ingresar a alguna sala de espera
     */
    public void ingresaSala(Paciente paciente) {
        try {
            this.salaprivada.ingresaPaciente(paciente);
        } catch (NoIngresaSalaPrivadaException e) {
            this.patio.ingresaPaciente(paciente);
        }
    }

    /**
     * Metodo que retorna la instancia de patio creada anteriormente.<br>
     * 
     * @return instancia de patio
     */
    public Patio getPatio() {
        return patio;
    }

    /**
     * Metodo que retorna la instancia de la Sala Privada de la clinica.<br>
     * 
     * @return instancia de salaprivada.
     */
    public SalaEsperaPrivada getSalaprivada() {
        return salaprivada;
    }
}
