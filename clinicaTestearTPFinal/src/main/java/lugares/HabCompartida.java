package lugares;

import exceptions.DiasInvalidosException;

/**
 * Esta clase es usada para calcular parte del arancel que debe pagar el cliente
 * 
 */

public class HabCompartida extends Habitacion {

    public HabCompartida() {
        super(500);
    }

    /**
     * Pre: La cantidad de dias debe ser mayor a cero <br>
     * Post: Retorna el arancel que se le debe cobrar POR la habitacion
     * especifica<br>
     * 
     * @param cantDias
     * @return double
     * @throws DiasInvalidosException
     */
    @Override
    public double calculaArancel(int cantDias) throws DiasInvalidosException {
        if (cantDias > 0)
            return (costoAsignacion * cantDias) + costoInicial;
        else
            throw new DiasInvalidosException("Dias menores que cero", cantDias);
    }

    /**
     * Retorna el nombre de la habitacion
     * 
     * @return String
     */
    @Override
    public String IDTipoHabitacion() {

        return "Habitacion Compartida";
    }

    /**
     * Retorna el costo asignacion especifico de esta habitacion
     * 
     * @return double
     */
    public double getCostoAsignacion() {
        return costoAsignacion;
    }

}
