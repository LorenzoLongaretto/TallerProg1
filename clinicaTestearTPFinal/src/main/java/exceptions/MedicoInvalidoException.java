package exceptions;

/**
 * Esta clase se lanza cuando el medico es invalido o no se encuentra
 */
public class MedicoInvalidoException extends Exception {

    public MedicoInvalidoException(String arg0) {
        super(arg0);
    }

}
