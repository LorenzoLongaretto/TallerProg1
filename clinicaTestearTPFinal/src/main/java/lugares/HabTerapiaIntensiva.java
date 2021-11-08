package lugares;

import exceptions.DiasInvalidosException;

/**
 * Esta clase es usada para calcular parte del arancel que debe pagar el cliente
 */
public class HabTerapiaIntensiva extends Habitacion {

    public HabTerapiaIntensiva() {
        super(1000);
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
            return Math.pow(costoAsignacion, cantDias) + costoInicial;
        } else
            throw new DiasInvalidosException("Dias no mayores a 0", cantDias);
    }

    /**
     * Retorna el costo asignacion especifico de esta habitacion
     * 
     * @return double
     */
    @Override
    public String IDTipoHabitacion() {
        // TODO Auto-generated method stub
        return "Terapia Intensiva";
    }

}
