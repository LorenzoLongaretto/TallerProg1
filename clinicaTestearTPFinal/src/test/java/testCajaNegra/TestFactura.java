package testCajaNegra;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import exceptions.NoExisteException;
import exceptions.PacienteInvalidoException;
import factura.Factura;
import usuarios.Paciente;
import usuarios.PacienteFactory;

public class TestFactura {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		Paciente paciente=null;
		try {
			paciente = PacienteFactory.getPaciente("7561238", "Colon 1239", "Mar del plata", "6873213", "Agustin Adan", "Nino");
		} catch (NoExisteException e1) {
			Assert.fail("No deberia dar error en la creacion del paciente");
		}
		GregorianCalendar fecha = new GregorianCalendar(12,12,2021);
		Factura f =null;
		try {
			f = new Factura(paciente,fecha);
		} catch (PacienteInvalidoException e) {
			Assert.fail("No deberia saltar la excepcion");
		}
		Paciente paciente2  = f.getPaciente();
		GregorianCalendar fecha2 = f.getFecha();
		Assert.assertEquals("El paciente no se cargo correctamente", paciente,paciente2);
		Assert.assertEquals("La fecha no se cargo correctamente", fecha,fecha2);
	}

}
