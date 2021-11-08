package exceptions;

/**
 * Excepcion lanzada cuando el paciente es invalido
 */
public class PacienteInvalidoException extends Exception {
    public PacienteInvalidoException(String arg0) {
        super(arg0);
    }
}
