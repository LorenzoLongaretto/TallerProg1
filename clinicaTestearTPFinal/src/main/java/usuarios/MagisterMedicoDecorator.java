package usuarios;

/**
 * Crea un medico con Magister
 */
public class MagisterMedicoDecorator extends MedicoDecorator {

    public MagisterMedicoDecorator(Medico medico) {
        super(medico);
        setHonorario();
    }

    public MagisterMedicoDecorator() {
    }

    @Override
    public void setHonorario() {
        double honorario = medico.getHonorario();

        this.Honorario = honorario * 1.05;

    }
}
