package lugares;

import usuarios.Paciente;

import java.util.ArrayList;

/**
 * Esta clase es utilizada para alojar<br>
 * pacientes antes de ser atendidos
 */
public class Patio {
    ArrayList<Paciente> pacientes = new ArrayList<>();

    /**
     * Pre: el paciente no es null Post:agrega el paciente a un arraylist de
     * pacientes
     * 
     * @param paciente
     */
    public void ingresaPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    /**
     * Pre: el parametro no puede ser null<br>
     * Post: Remueve el paciente del arraylist
     * 
     * @param paciente
     */
    public void retira(Paciente paciente) {
        this.pacientes.remove(paciente);
    }

}
