package usuarios;

/**
 * Crea un medico con contratacion Permanente
 */
public class MedicoPermanenteDecorator extends MedicoDecorator {

    public MedicoPermanenteDecorator(Medico medico) {
        super(medico);
        setHonorario();
    }

    public MedicoPermanenteDecorator() {
    }

    /**
     * Delega el seteo del honorario al medico que tiene como atributo, es decir
     * llama al setHonorario del medico que es quien calcula el honorario
     */
    @Override
    public void setHonorario() {
        double honorario = medico.getHonorario();

        this.Honorario = honorario * 1.1;

    }
}
