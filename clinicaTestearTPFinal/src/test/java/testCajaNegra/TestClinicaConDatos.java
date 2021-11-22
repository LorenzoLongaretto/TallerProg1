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
import lugares.HabCompartida;
import usuarios.Medico;
import usuarios.MedicoFactory;
import usuarios.Paciente;
import usuarios.PacienteFactory;

public class TestClinicaConDatos {
private Clinica clinica; 
	@Before
	public void setUp() throws Exception {
		clinica = Clinica.getInstance("Favaloro","Independencia","2236352472","Mar del Plata");
		clinica.addMedico("234565", "Marconi 2345", "Mar del Plata", "223456732", "Susana Ibanez", 1502, 3000,
                "Clinico", "Permanente");
		clinica.ingresaPaciente("65761321", "Moreno 1239", "Mar del plata", "2234564687", "Veronica Galindo",
                "Mayor");
	}

	@After
	public void tearDown() throws Exception {
		clinica.limpiarColecciones();
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
			if(act.getNombre().equals("Veronica Galindo"))
				encontro=true;
		}
		if(encontro==false)
			Assert.fail("No se atendio al paciente correctamente");
	}
	@Test
	public void testbuscaPaciente() {
		clinica.atiendePaciente();
		Paciente buscado = this.clinica.buscaPaciente(1);
		if(buscado==null)
			Assert.fail("Error en la busqueda del paciente");
	}
	@Test
	public void testbuscaMedico() {
		Medico buscado = this.clinica.buscaMedico(1502);
		if(buscado==null)
			Assert.fail("Error en la busqueda del medico");
	}
	@Test
	public void testagregaConsultaValida() {
		Medico medico=null;
		try {
			 medico = MedicoFactory.getMedico("867321", "Colon 1235", "Mar del Plata", "57658432", "Agustin Adan", 1410, 7000,
			        "Clinico", "Temporario", "Magister");
		} catch (NoExisteException e) {
			Assert.fail("No deberia dar error");
		}
		
		boolean respuesta = this.clinica.agregaConsultaAPaciente(1,medico);
		if(respuesta==false)
			Assert.fail("Error en la consulta");
		
	}
	@Test
	public void testagregaConsultaInValida() {
		Medico medico=null;
		try {
			 medico = MedicoFactory.getMedico("867321", "Colon 1235", "Mar del Plata", "57658432", "Agustin Adan", 1410, 7000,
			        "Clinico", "Temporario", "Magister");
		} catch (NoExisteException e) {
			Assert.fail("No deberia dar error");
		}
		
		boolean respuesta = this.clinica.agregaConsultaAPaciente(0,medico);
		if(respuesta!=false)
			Assert.fail("Error en la consulta");
		
	}
	@Test
	public void testagregaInternacionValida() {
		boolean respuesta=true;
		clinica.atiendePaciente();
		try {
			respuesta = this.clinica.agregaInternacionAPaciente(1,new HabCompartida(),3);
		} catch (DiasInvalidosException e) {
			Assert.fail("No deberia entrar");
		}
		if(respuesta==false)
			Assert.fail("Error en la internacion");
	}
	@Test
	public void testagregaInternacionInvalida() {
		boolean respuesta=false,fallo=false;
		clinica.atiendePaciente();
		try {
			respuesta = this.clinica.agregaInternacionAPaciente(1,new HabCompartida(),-1);
		} catch (DiasInvalidosException e) {
			fallo = true;
		}
		if(!fallo)
			Assert.fail("Error en la internacion");
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
