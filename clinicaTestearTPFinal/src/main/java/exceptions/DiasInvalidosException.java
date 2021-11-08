package exceptions;

/**
 * Esta clase es una excepcion que es utilizada cuando se ingresan dias
 * negativos o cero
 * 
 */

public class DiasInvalidosException extends Exception {
    private int dias;

    public DiasInvalidosException(String arg0, int dias) {
        super(arg0);
        this.dias = dias;
    }

    public int getDias() {
        return dias;
    }
}
