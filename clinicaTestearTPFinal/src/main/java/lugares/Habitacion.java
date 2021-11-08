package lugares;

import exceptions.DiasInvalidosException;

/**
 * Esta clase es una abstrccion de las habitaciones, contiene parametros tales
 * como el costo inicial, comun a todas, y el costo asignacion que depende de la
 * habitacion concreta
 */
public abstract class Habitacion {
    protected static double costoInicial = 1000;// preguntar que valor darle
    protected double costoAsignacion;

    public Habitacion(double costoAsignacion) {
        this.costoAsignacion = costoAsignacion;
    }

    /**
     * Pre: Los dias son > 0 <br>
     * Post: Retorna el valor de la internacion completo <br>
     * 
     * @param cantDias
     * @return double
     * @throws DiasInvalidosException si los dias <=0
     */
    public abstract double calculaArancel(int cantDias) throws DiasInvalidosException;

    public double getCostoAsignacion() {
        return costoAsignacion;
    }

    public String IDTipoHabitacion() {
        return "Habitacion";
    }
}
