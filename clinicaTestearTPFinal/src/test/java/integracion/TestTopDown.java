package integracion;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import testCajaNegra.TestClinicaConDatos;
import testCajaNegra.TestPaciente;

@RunWith(Suite.class)
@SuiteClasses({TestClinicaConDatos.class, TestPaciente.class})
public class TestTopDown {


}
