package testCajaNegra;

import exceptions.DiasInvalidosException;
import exceptions.NoExisteException;
import exceptions.NoIngresaSalaPrivadaException;
import lugares.HabCompartida;
import lugares.Habitacion;
import lugares.SalaEsperaPrivada;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import usuarios.Paciente;
import usuarios.PacienteFactory;


public class TestHabitacion {

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}
	

	@Test
	public void testDoubleDispatch() throws NoExisteException {
		SalaEsperaPrivada sala = new SalaEsperaPrivada();
		Paciente joven = PacienteFactory.getPaciente("45123789","Mitre 123","MdP","2234784578","Juan","Joven");
		Paciente nene = PacienteFactory.getPaciente("45123789","Mitre 123","MdP","2234784578","Juancito","Nino");
		Paciente adulto = PacienteFactory.getPaciente("45123789","Mitre 123","MdP","2234784578","Juan Grande","Mayor");

		try {
			sala.ingresaPaciente(adulto);
			sala.ingresaPaciente(joven);
			sala.ingresaPaciente(nene);
		} catch (NoIngresaSalaPrivadaException e) {
			Assert.fail("Error en el double dispatch esta mal hecho, deberian ingresar todos");
		}
	}
}
