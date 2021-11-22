package testCajaNegra;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import exceptions.NoExisteException;
import lugares.HabCompartida;
import usuarios.Medico;
import usuarios.MedicoFactory;
import usuarios.Paciente;
import usuarios.PacienteFactory;

public class TestMedico {

	@Before
	public void setUp() throws Exception {
		Medico medico = null;
		try {
			 medico = MedicoFactory.getMedico("234565", "Marconi 2345", "Mar del Plata", "223456732", "Susana Ibanez", 1502, 3000,
			        "Clinico", "Permanente");
		} catch (NoExisteException e) {
			Assert.fail("El medico se deberia crear correctamente");
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		
	}
	@Test
	public void testReporte() {
		
	}

}
