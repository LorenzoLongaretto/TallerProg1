package testVentana;

import static org.junit.Assert.*;

import clinica.Clinica;
import controlador.Controlador;
import jdk.jshell.execution.Util;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import vistas.Ventana;
import java.awt.*;
import java.awt.event.InputEvent;


public class TestVentana {
	Robot robot;
	Ventana ventana;
	Controlador controlador;
	Clinica clinica = Clinica.getInstance("Hospital", "Avenida siempre viva", "123123", "Balcarce");
	@Before
	public void setUp() throws Exception {
		robot = new Robot();
		ventana = new Ventana();
		controlador = new Controlador(ventana);

		// Creacion de medicos
		clinica.addMedico("234565", "Marconi 2345", "Mar del Plata", "223456732", "Susana Ibanez", 1502, 3000,
				"Clinico", "Permanente");
		clinica.addMedico("82216", "Moreno 4562", "Mar del Plata", "6872312", "Davinia Pino", 1407, 5000,
				"Cirujano", "Temporario");
		clinica.addMedico("7432138", "Belgrano 2135", "Mar del Plata", "5761234", "Jose Rafael Novo", 1408, 6000,
				"Pediatra", "Permanente");
		clinica.addMedico("867321", "Colon 1235", "Mar del Plata", "57658432", "Luca Bermudez", 1409, 7000,
				"Clinico", "Temporario");
		clinica.addMedico("867321", "Colon 1235", "Mar del Plata", "57658432", "Agustin Adan", 1410, 7000,
				"Clinico", "Temporario", "Magister");
		// Creamos un par de pacientes
		clinica.ingresaPaciente("65761321", "Moreno 1239", "Mar del plata", "2234564687", "Veronica Galindo",
				"Mayor");
		clinica.ingresaPaciente("7561238", "Colon 1239", "Mar del plata", "6873213", "Agustin Adan", "Nino");
		clinica.ingresaPaciente("1354314", "Buenos Aires 1239", "Mar del plata", "2234564687",
				"Richard Palomo", "Joven");

		ventana.actualizaListaMedicos(Clinica.getInstance().getMedicos());
		ventana.actualizaListaPacientes(Clinica.getInstance().getPacientes());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDarDeAlta() throws InterruptedException {
		int cantInicial = Clinica.getInstance().getPacientes().size();
		robot.mouseMove((int)ventana.getListPacientes().getLocationOnScreen().x+5,(int)ventana.getListPacientes().getLocationOnScreen().y+7);
		Utils.click(robot);
		robot.mouseMove((int)ventana.getBtnDarAlta().getLocationOnScreen().x+2,(int)ventana.getBtnDarAlta().getLocationOnScreen().y+2);
		Utils.click(robot);
		if (cantInicial == Clinica.getInstance().getPacientes().size())
			Assert.fail("El paciente no se dio de alta! Sigue estando en la colección de pacientes");
	}

}
