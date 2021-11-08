package usuarios;

/**
 * Crea un medico con contratacion Temporal
 */
public class MedicoTemporarioDecorator extends MedicoDecorator {

    public MedicoTemporarioDecorator(Medico medico) {
        super(medico);
        setHonorario();
    }

    public MedicoTemporarioDecorator() {
    }

    /**
     * Delega el seteo del honorario al medico que tiene como atributo, es decir
     * llama al setHonorario del medico que es quien calcula el honorario
     */
    @Override
    public void setHonorario() {
        double honorario = medico.getHonorario();

        this.Honorario = honorario * 1.05;

    }

}
