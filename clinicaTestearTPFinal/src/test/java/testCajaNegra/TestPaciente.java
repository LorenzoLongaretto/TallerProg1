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

public class TestPaciente {
private Paciente p;
	@Before
	public void setUp() throws Exception {
		p = PacienteFactory.getPaciente("65761321", "Moreno 1239", "Mar del plata", "2234564687", "Veronica Galindo",
                "Mayor");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		String dni = p.getDni();
		Assert.assertEquals("El dni no se cargo correctamente",dni,dni);
		// Falta ver los demas atributos
		
	}
	@Test
	public void testAgregaInternacionValida() {
		p.AgregaInternacion(new HabCompartida(),1);
		if(p.getInternaciones().size()==0)
			Assert.fail("No se interno correctamente");
		
	}
	@Test
	public void testagregaInternacionInvalida() {
		p.AgregaInternacion(new HabCompartida(),-1);
		if(p.getInternaciones().size()!=0)
			Assert.fail("La internacion no se deberia haber cargado");
	}

	@Test
	public void testagregaConsultaValida() {
		Medico medico = null;
		try {
			 medico = MedicoFactory.getMedico("234565", "Marconi 2345", "Mar del Plata", "223456732", "Susana Ibanez", 1502, 3000,
			        "Clinico", "Permanente");
		} catch (NoExisteException e) {
			Assert.fail("El medico se deberia crear correctamente");
		}
		p.AgregaConsulta(medico);
		if(p.getConsultas().size()==0)
			Assert.fail("La consulta no se cargo correctamente");
	}
	@Test
	public void testagregaConsultaInValida() {
		p.AgregaConsulta(null);
		if(p.getConsultas().size()!=0)
			Assert.fail("La consulta no se debio cargar");
	}
	
	@Test
	public void testReseteaPrestaciones() {
		p.ReseteaPrestaciones();
		if(p.getConsultas().size()!=0 && p.getInternaciones().size()!=0)
			Assert.fail("No se resetearon las prestaciones correctamente");
	}
}
