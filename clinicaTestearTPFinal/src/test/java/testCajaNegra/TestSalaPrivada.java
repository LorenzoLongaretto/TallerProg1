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


public class TestSalaPrivada {

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
	@Test
	public void testVacia(){
		SalaEsperaPrivada sala = new SalaEsperaPrivada();
		boolean vacia = sala.vacia();
		if(!vacia)
			Assert.fail("La sala deberia estar vacia");
	}
	@Test
	public void testRetira(){
		SalaEsperaPrivada sala = new SalaEsperaPrivada();
		Paciente joven = null;
		try {
			 joven = PacienteFactory.getPaciente("45123789","Mitre 123","MdP","2234784578","Juan","Joven");
		} catch (NoExisteException e) {
			Assert.fail("No deberia fallar en la creacion del paciente");
		}
		try {
			
			sala.ingresaPaciente(joven);
			
		} catch (NoIngresaSalaPrivadaException e) {
			Assert.fail("Error en el ingreso");
		}
		sala.retira();
		if(sala.getPacienteActual()!=null)
			Assert.fail("La sala deberia estar vacia, ya que se retiro el paciente");
	}
	
}
