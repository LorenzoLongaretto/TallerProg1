package exceptions;

/**
 * Cuando a un medico se le pide el reporte de una fecha y no tiene ninguna
 * factura mayor a la fecha inicial indicada
 */
public class FechaInvalidaException extends Exception {

    public FechaInvalidaException(String message) {
        super(message);
    }

}
