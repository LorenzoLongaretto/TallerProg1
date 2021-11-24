package testCajaNegra;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import exceptions.NoExisteException;
import usuarios.Paciente;
import usuarios.PacienteFactory;

public class TestPacienteFactory {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreacionValida() {
		Paciente p = null;
		try {
			p = PacienteFactory.getPaciente("65761321", "Moreno 1239", "Mar del plata", "2234564687", "Veronica Galindo",
			        "Mayor");
		} catch (NoExisteException e) {
			Assert.fail("Fallo la creacion");
		}
	}
	@Test
	public void testCreacionInValida() {
		Paciente p = null;
		boolean fallo = false;
		try {
			p = PacienteFactory.getPaciente("65761321", "Moreno 1239", "Mar del plata", "2234564687", "Veronica Galindo",
			        "Mayorr");
		} catch (NoExisteException e) {
			fallo = true;
		}
		if(!fallo)
			Assert.fail("Deberia fallar la creacion");
	}


}
