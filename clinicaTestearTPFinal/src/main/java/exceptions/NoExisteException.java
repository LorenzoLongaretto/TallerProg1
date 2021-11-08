package exceptions;

/**
 * Esta excepcion se invoca cuando se quiere acceder a un objeto inexistente
 */
public class NoExisteException extends Exception {

    public NoExisteException(String message) {
        super(message);
    }

}
