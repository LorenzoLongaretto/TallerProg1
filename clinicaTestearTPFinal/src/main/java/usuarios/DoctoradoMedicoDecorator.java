package usuarios;

/**
 * Crea un medico con Doctorado
 */
public class DoctoradoMedicoDecorator extends MedicoDecorator {

    public DoctoradoMedicoDecorator(Medico medico) {
        super(medico);
        setHonorario();
    }

    /**
     * Incrementa el honorario del medico en un diez porciento
     */
    @Override
    public void setHonorario() {
        double honorario = medico.getHonorario();

        this.Honorario = honorario * 1.1;

    }
}
