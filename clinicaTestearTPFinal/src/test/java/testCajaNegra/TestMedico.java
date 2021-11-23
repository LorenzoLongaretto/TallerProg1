package testCajaNegra;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import exceptions.FechaInvalidaException;
import exceptions.NoExisteException;
import factura.Reporte;
import lugares.HabCompartida;
import usuarios.Medico;
import usuarios.MedicoFactory;
import usuarios.Paciente;
import usuarios.PacienteFactory;

public class TestMedico {
private Medico medico;
	@Before
	public void setUp() throws Exception {
		 medico = null;
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
		String dni = medico.getDni();
		String domicilio = medico.getDomicilio();
		String ciudad = medico.getCiudad();
		String telefono = medico.getTelefono();
		String nombre = medico.getNombre();
		String nro = ""+medico.getNumero();
		
		
		Assert.assertEquals("El dni no se cargo correctamente","234565",dni);
		Assert.assertEquals("El domicilio no se cargo correctamente","Marconi 2345",domicilio);
		Assert.assertEquals("La ciudad no se cargo correctamente","Mar del Plata",ciudad);
		Assert.assertEquals("El telefono no se cargo correctamente","223456732",telefono);
		Assert.assertEquals("El nombre no se cargo correctamente","Susana Ibanez",nombre);
		Assert.assertEquals("El nro no se cargo correctamente","1502",nro);

	}
	@Test
	public void testReporteFechaValida() {
		Paciente p = null;
		try {
			 p = PacienteFactory.getPaciente("65761321", "Moreno 1239", "Mar del plata", "2234564687", "Veronica Galindo",
			        "Mayor");
		} catch (NoExisteException e) {
			Assert.fail("Deberia crearse correctamente");
		}
		GregorianCalendar fecha1 = new GregorianCalendar(2020,4,16);
		GregorianCalendar fecha2 = new GregorianCalendar(2020,4,19);
		
		medico.getReporte().add(new Reporte(fecha1,p.getNombre(),2,2400));
		try {
			medico.muestraReporte(fecha1, fecha2);
		} catch (FechaInvalidaException e) {
			Assert.fail("No deberia dar error, ya que las fechas son validas");
		}
	}
	@Test
	public void testReporteFechaInvalida() {
		Paciente p = null;
		try {
			 p = PacienteFactory.getPaciente("65761321", "Moreno 1239", "Mar del plata", "2234564687", "Veronica Galindo",
			        "Mayor");
		} catch (NoExisteException e) {
			Assert.fail("Deberia crearse correctamente");
		}
		GregorianCalendar fecha1 = new GregorianCalendar(2020,4,16);
		GregorianCalendar fecha2 = new GregorianCalendar(2020,4,19);
		
		medico.getReporte().add(new Reporte(fecha1,p.getNombre(),2,2400));
		boolean fallo = false;
		try {
			medico.muestraReporte(new GregorianCalendar(2021,4,16), fecha2);
		} catch (FechaInvalidaException e) {
			fallo = true;
		}
		if(!fallo)
		Assert.fail("Deberia dar error, ya que las fechas no son validas");
	}

}
