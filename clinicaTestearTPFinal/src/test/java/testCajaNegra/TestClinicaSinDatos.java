package testCajaNegra;



import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import clinica.Clinica;
import exceptions.DiasInvalidosException;
import exceptions.NoExisteException;
import exceptions.PacienteInvalidoException;
import usuarios.Medico;
import usuarios.Paciente;
import usuarios.PacienteFactory;

public class TestClinicaSinDatos {

	private Clinica clinica;
	@Before
	public void setUp() throws Exception {
		clinica = Clinica.getInstance("Favaloro","Independencia","2236352472","Mar del Plata");
	}

	@After
	public void tearDown() throws Exception {
		clinica.limpiarColecciones();
	}
	@Test
	public void testAddMedicoInvalido() {
		int nro = clinica.getMedicos().size();
		clinica.addMedico("234565", "Marconi 2345", "Mar del Plata", "223456732", "Susana Ibanez", 1502, 3000,
                "Clinicoooo", "Permanenteee");
		if(nro!=clinica.getMedicos().size())
			Assert.fail("No se debe ingresar al medico");
	}
	@Test
	public void testIngresaPacienteValido() {
		clinica.ingresaPaciente("1354314", "Buenos Aires 1239", "Mar del plata", "2234564687",
                "Richard Palomo", "Joven");
		boolean encontro = false;
		Set<Paciente> pacientes = clinica.getPacientes();
		for(Paciente p : pacientes){
          if(p.getNombre().equals("Richard Palomo")) {
        	  encontro=true;
          }
        }
		
		if(encontro==false)
			Assert.fail("Error en el ingreso del paciente");
	}
	@Test
	public void testIngresaPacienteInValido() {
		int nro = clinica.getPacientes().size();
		clinica.ingresaPaciente("1354314", "Buenos Aires 1239", "Mar del plata", "2234564687",
                "Richard Palomo", "Joveen");
		if(nro!=clinica.getPacientes().size())
			Assert.fail("El paciente no debio ingresar");
	}
	@Test
	public void testIngresaPacienteRepetido() {
		int numero = this.clinica.getPacientes().size();
		clinica.ingresaPaciente("65761321", "Moreno 1239", "Mar del plata", "2234564687", "Veronica Galindo",
                "Mayor");
		if(numero!=this.clinica.getPacientes().size())
			Assert.fail("Error,ya que el paciente ya estaba ingresado");
	}
	@Test
	public void testAtiendePaciente() {
		clinica.ingresaPaciente("1354314", "Buenos Aires 1239", "Mar del plata", "2234564687",
                "Richard Palomo", "Joven");
		clinica.atiendePaciente();
		boolean encontro = false;
		Iterator<Paciente> it = clinica.getPacientesEnAtencion().iterator();
		while(it.hasNext() && encontro==false) {
			Paciente act = it.next();
			if(act.getNombre().equals("Richard Palomo"))
				encontro=true;
		}
		if(encontro==false)
			Assert.fail("No se atendio al paciente correctamente");
	}
	@Test
	public void testAddMedicoValido() {
		clinica.addMedico("234565", "Marconi 2345", "Mar del Plata", "223456732", "Susana Ibanez", 1502, 3000,
                "Clinico", "Permanente");
		 Set<Medico> medicos = this.clinica.getMedicos();
		if(medicos.size()==0)
			Assert.fail("El medico no se cargo correctamente");
	}
	@Test
	public void testbuscaPaciente() {
		Paciente buscado = this.clinica.buscaPaciente(0);
		if(buscado!=null)
			Assert.fail("La clinica no tiene ningun paciente");
	}
	@Test
	public void testbuscaMedico() {
		Medico buscado = this.clinica.buscaMedico(0);
		if(buscado!=null)
			Assert.fail("La clinica no tiene ningun medico");
	}
	@Test
	public void testagregaConsultaAPaciente() {
		boolean respuesta = this.clinica.agregaConsultaAPaciente(0,null);
		if(respuesta!=false)
			Assert.fail("No deberia haber encontrado al paciente");
		
	}
	@Test
	public void testagregaInternacionAPaciente() {
		boolean respuesta=true;
		try {
			respuesta = this.clinica.agregaInternacionAPaciente(0,null,0);
		} catch (DiasInvalidosException e) {
			Assert.fail("No deberia entrar");
		}
		if(respuesta)
			Assert.fail("No deberia haber encontrado al paciente");
	}
	@Test
	public void testAgregaFacturaInValida() {
		
		GregorianCalendar fecha = new GregorianCalendar(12,12,2021);
		boolean fallo = false;
		try {
			this.clinica.agregarFactura(null,fecha);
		} catch (PacienteInvalidoException e) {
			fallo = true;
		}
		if(!fallo)
		Assert.fail("Deberia dar error ya que el paciente es nulo");
	}
	@Test
	public void testAgregaFacturaValida() {
		Paciente paciente=null;
		try {
			paciente = PacienteFactory.getPaciente("7561238", "Colon 1239", "Mar del plata", "6873213", "Agustin Adan", "Nino");
		} catch (NoExisteException e1) {
			Assert.fail("No deberia dar error en la creacion del paciente");
		}
		GregorianCalendar fecha = new GregorianCalendar(12,12,2021);
		try {
			this.clinica.agregarFactura(paciente,fecha);
		} catch (PacienteInvalidoException e) {
			Assert.fail("No deberia dar error");
		}
	
	}
}
