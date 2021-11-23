package testPersistencia;

import  org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.NoExisteException;
import persistencia.IPersistencia;
import persistencia.PersistenciaXML;
import usuarios.Paciente;
import usuarios.PacienteFactory;

public class TestPersistenciaPacientes {
private  IPersistencia persistencia = new PersistenciaXML();
private Set<Paciente> pacientes = new TreeSet<>();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCrearArchivo() {
		try {
			persistencia.abrirOutput("pacientesPrueba.xml");
			File archivo = new File("pacientesPrueba.xml");
			Assert.assertTrue("Deberia existir el archivo de pacientes",archivo.exists());
		} catch (IOException e) {
		Assert.fail("No deberia fallar: "+e.getMessage());
		}
		
	}
	@Test
	public void testEscrituraPacientesVacio() {
		 try {
	         persistencia.abrirOutput("pacientesPrueba.xml");
	         persistencia.escribir(this.pacientes);
	         persistencia.cerrarOutput();
	     } catch (IOException e) {
	         Assert.fail("Error en la escritura Vacia");
	     }
	}
	@Test
	public void testEscrituraConPacientes() {
		try {
	         persistencia.abrirOutput("pacientesPrueba.xml");
	         this.llenaPacientes(this.pacientes);
	         persistencia.escribir(this.pacientes);
	         persistencia.cerrarOutput();
	     } catch (IOException e) {
	         Assert.fail("Error en la escritura de pacientes");
	     }
	}
	@Test
	public void despersistirSinArchivo() {
		try {
			persistencia.abrirInput("pacieentes.xml");
            this.pacientes = (Set<Paciente>) persistencia.leer();
            Assert.fail("Deberia dar error ya que no existe ese archivo");
        } catch (IOException | ClassNotFoundException e) {
            
        }
	}
	@Test
	public void despersistirConArchivo() {
		try {
            persistencia.abrirInput("pacientesPrueba.xml");
            this.pacientes = (Set<Paciente>) persistencia.leer();
            persistencia.cerrarInput();
        } catch (IOException | ClassNotFoundException e) {
           Assert.fail("No deberia dar error ya que el archivo existe");
        }
	}
	
	
	private void llenaPacientes(Set<Paciente> pacientes) {
	try {
		this.pacientes.add(PacienteFactory.getPaciente("65761321", "Moreno 1239", "Mar del plata", "2234564687", "Veronica Galindo",
                "Mayor"));
		this.pacientes.add(PacienteFactory.getPaciente("7561238", "Colon 1239", "Mar del plata", "6873213", "Agustin Adan", "Nino"));
	} catch (NoExisteException e) {
		Assert.fail("No dberia dar error en la carga de pacientes");
	}
}
}
