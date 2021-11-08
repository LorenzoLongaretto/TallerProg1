package lugares;

import exceptions.NoIngresaSalaPrivadaException;
import usuarios.Paciente;

/**
 *
 * La sala de espera privada contendra a un paciente antes de ser atentido, e
 * ingresado a la lista de espera
 */
public class SalaEsperaPrivada {
    private Paciente pacienteActual;

    /**
     * Pre: El paciente no debe ser null<br>
     * Post: Intenta ingresar al paciente, de no ser posible lo manda al patio<br>
     * Nino gana contra joven y contra adulto<br>
     * Joven gana contra adulto<br>
     * Adulto pierde siempre
     * 
     * @param ingresante
     * @throws NoIngresaSalaPrivadaException
     */
    public void ingresaPaciente(Paciente ingresante) throws NoIngresaSalaPrivadaException {
        if (!this.vacia())
            if (pacienteActual.prioriza(ingresante)) // Si el paciente actual tiene prioridad por sobre el ingresante
                throw new NoIngresaSalaPrivadaException();
            else {
                SalaDeEspera.getinstance().getPatio().ingresaPaciente(pacienteActual);
                pacienteActual = ingresante;
            }
        else
            pacienteActual = ingresante;
    }

    /**
     * Retorna el paciente que contiene
     * 
     * @return Paciente
     */
    public Paciente getPacienteActual() {
        return pacienteActual;
    }

    /**
     * Retorna si tiene espacio o no la sala
     * 
     * @return boolean
     */
    public boolean vacia() {
        return pacienteActual == null;
    }

    /**
     * Saca al paciente que estaba en la sala
     */
    public void retira() {
        pacienteActual = null;
    }

}
