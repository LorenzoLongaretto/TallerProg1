package lugares;

import exceptions.DiasInvalidosException;

/**
 * Esta clase es usada para calcular parte del arancel que debe pagar el cliente
 */
public class HabPrivada extends Habitacion {

    public HabPrivada() {
        super(600);
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
        if (cantDias > 0) {
            if (cantDias == 1)
                return costoAsignacion + costoInicial;
            else if (cantDias <= 5)
                return cantDias * costoAsignacion * 1.3 + costoInicial;
            else
                return cantDias * costoAsignacion * 2 + costoInicial;
        } else
            throw new DiasInvalidosException("Dias menores a 0", cantDias);
    }

    /**
     * Retorna el costo asignacion especifico de esta habitacion
     * 
     * @return double
     */
    @Override
    public String IDTipoHabitacion() {
        // TODO Auto-generated method stub
        return "Habitacion Privada";
    }

}
