package testCajaNegra;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestClinicaConDatos.class, TestClinicaSinDatos.class, TestFactura.class, TestHabCompartida.class,
		TestMedico.class, TestMedicoFactory.class, TestPaciente.class, TestPacienteFactory.class,
		TestSalaPrivada.class })
public class AllTests {

}
