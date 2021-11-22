package testVentana;

import clinica.Clinica;
import controlador.Controlador;
import jdk.jshell.execution.Util;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import usuarios.Paciente;
import vistas.Ventana;

import java.awt.*;
import java.awt.event.KeyEvent;


public class TestVentana {
    Robot robot;
    Ventana ventana;
    Controlador controlador;
    Clinica clinica;

    @BeforeClass
    public static void beforeClass() throws Exception {
      //
    }

    @Before
    public void setUp() throws Exception {
        robot = new Robot();
        ventana = new Ventana();
        controlador = new Controlador(ventana);
        clinica = Clinica.getInstance();
        Utils.cargarDatosClinicaTesting();
        ventana.actualizaListaMedicos(Clinica.getInstance().getMedicos());
        ventana.actualizaListaPacientes(Clinica.getInstance().getPacientes());
    }

    @After
    public void tearDown() throws Exception {
        clinica.hacerNullTests();
    }

    @Test
    public void testDarDeAltaVacio() throws InterruptedException {
        int cantInicial = Clinica.getInstance().getPacientes().size();
        robot.mouseMove(ventana.getListPacientes().getLocationOnScreen().x + 5, ventana.getListPacientes().getLocationOnScreen().y + 7);
        Utils.click(robot);
        Paciente paciente = ventana.getPacienteSelcted();
        robot.mouseMove(ventana.getBtnDarAlta().getLocationOnScreen().x + 2, ventana.getBtnDarAlta().getLocationOnScreen().y + 2);
        Utils.click(robot);
        if (null != clinica.buscaPaciente(paciente.getNumero()))
            Assert.fail("El paciente no se dio de alta! Sigue estando en la colección de pacientes" + cantInicial);
    }

    @Test
    public void testDarDeAltaCargado() {
        int cantInicial = Clinica.getInstance().getPacientes().size();
        robot.mouseMove(ventana.getListPacientes().getLocationOnScreen().x + 5, ventana.getListPacientes().getLocationOnScreen().y + 20);
        Utils.click(robot);
        Paciente paciente = ventana.getPacienteSelcted();
        robot.mouseMove(ventana.getListMedicos().getLocationOnScreen().x + 5, ventana.getListMedicos().getLocationOnScreen().y + 7);
        Utils.click(robot);
        robot.mouseMove(ventana.getBtnConsulta().getLocationOnScreen().x + 5, ventana.getBtnConsulta().getLocationOnScreen().y + 5);
        Utils.click(robot);
        robot.mouseMove(ventana.getListMedicos().getLocationOnScreen().x + 5, ventana.getListMedicos().getLocationOnScreen().y + 23);
        Utils.click(robot);
        robot.mouseMove(ventana.getBtnConsulta().getLocationOnScreen().x + 5, ventana.getBtnConsulta().getLocationOnScreen().y + 5);
        Utils.click(robot);

        robot.mouseMove(ventana.getDiasText().getLocationOnScreen().x + 5, ventana.getDiasText().getLocationOnScreen().y + 5);
        Utils.click(robot);
        Utils.escribir(robot, "5");
        robot.mouseMove(ventana.getBtnInternacion().getLocationOnScreen().x + 5, ventana.getBtnInternacion().getLocationOnScreen().y + 5);
        Utils.click(robot);

        robot.mouseMove(ventana.getBtnDarAlta().getLocationOnScreen().x + 2, ventana.getBtnDarAlta().getLocationOnScreen().y + 2);
        Utils.click(robot);


        if (null != clinica.buscaPaciente(paciente.getNumero()))
            Assert.fail("El paciente no se dio de alta! Sigue estando en la colección de pacientes" + cantInicial);
    }

    @Test
    public void internarCeroDias() {
        Paciente seleccionado;
        robot.mouseMove(ventana.getListPacientes().getLocationOnScreen().x + 5, ventana.getListPacientes().getLocationOnScreen().y + 7);
        Utils.click(robot);
        seleccionado = ventana.getPacienteSelcted();
        robot.mouseMove(ventana.getListMedicos().getLocationOnScreen().x + 5, ventana.getListMedicos().getLocationOnScreen().y + 7);
        Utils.click(robot);
        robot.mouseMove(ventana.getDiasText().getLocationOnScreen().x + 5, ventana.getDiasText().getLocationOnScreen().y + 5);
        Utils.click(robot);
        Utils.escribir(robot, "0");
        robot.mouseMove(ventana.getBtnInternacion().getLocationOnScreen().x + 5, ventana.getBtnInternacion().getLocationOnScreen().y + 5);
        Utils.click(robot);
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_ENTER);

        Assert.assertEquals("El paciente deberia no tener internaciones, cantidad de dias invalida", seleccionado.getInternaciones().size(), 0);
    }

    @Test
    public void internarDiasNegativos() {
        robot.mouseMove(ventana.getListPacientes().getLocationOnScreen().x + 5, ventana.getListPacientes().getLocationOnScreen().y + 7);
        Utils.click(robot);
        robot.mouseMove(ventana.getListMedicos().getLocationOnScreen().x + 5, ventana.getListMedicos().getLocationOnScreen().y + 7);
        Utils.click(robot);
        robot.mouseMove(ventana.getDiasText().getLocationOnScreen().x + 5, ventana.getDiasText().getLocationOnScreen().y + 5);
        Utils.click(robot);
        Utils.escribir(robot, "-6");

        Assert.assertFalse("El boton de internar debe estar desactivado si los dias son negativos",ventana.getBtnInternacion().isEnabled());
        Utils.pausa(robot);
    }


    @Test
    public void consultaFacturaVacio() {
        try {
            Utils.pausa(robot);
            robot.mouseMove(ventana.getTabbedPane().getLocationOnScreen().x + 150, ventana.getTabbedPane().getLocationOnScreen().y + 10);
            Utils.click(robot);
            robot.mouseMove(ventana.getBtnConsultar().getLocationOnScreen().x + 10, ventana.getBtnConsultar().getLocationOnScreen().y + 10);
            Utils.click(robot);
            Assert.assertFalse("El boton no deberia estar activado", ventana.getBtnConsultar().isEnabled());

        } catch (Exception e) {
            Assert.fail("No se verifica que los campos esten vacios");
        }

    }

    @Test
    public void consultaFacturasCorrecto() {
        Utils.pausa(robot);
        robot.mouseMove(ventana.getTabbedPane().getLocationOnScreen().x + 150, ventana.getTabbedPane().getLocationOnScreen().y + 10);
        Utils.click(robot);

        robot.mouseMove(ventana.getFechaInicial().getLocationOnScreen().x + 15, ventana.getFechaInicial().getLocationOnScreen().y + 5);
        Utils.click(robot);
        Utils.escribir(robot, "14102019");
        robot.mouseMove(ventana.getFechaFinal().getLocationOnScreen().x + 15, ventana.getFechaFinal().getLocationOnScreen().y + 5);
        Utils.click(robot);
        Utils.escribir(robot, "25122021");

        robot.mouseMove(ventana.getBtnConsultar().getLocationOnScreen().x + 10, ventana.getBtnConsultar().getLocationOnScreen().y + 10);
        Utils.click(robot);

        Utils.pausa(robot);

    }

    @Test
    public void consultaFinAntesQueInicio() {
        try {
            Utils.pausa(robot);
            robot.mouseMove(ventana.getTabbedPane().getLocationOnScreen().x + 150, ventana.getTabbedPane().getLocationOnScreen().y + 10);
            Utils.click(robot);

            robot.mouseMove(ventana.getFechaInicial().getLocationOnScreen().x + 15, ventana.getFechaInicial().getLocationOnScreen().y + 5);
            Utils.click(robot);
            Utils.escribir(robot, "19122020");
            robot.mouseMove(ventana.getFechaFinal().getLocationOnScreen().x + 15, ventana.getFechaFinal().getLocationOnScreen().y + 5);
            Utils.click(robot);
            Utils.escribir(robot, "14022003");

            robot.mouseMove(ventana.getBtnConsultar().getLocationOnScreen().x + 10, ventana.getBtnConsultar().getLocationOnScreen().y + 10);
            Utils.click(robot);

            Utils.pausa(robot);
            Assert.fail("Deberia lanzarse un error si la fecha de inicio es posterior a la de fin");
        }
        catch (Exception e){
            //funcionamiento correcto, deberia lanzarse una excepcion
        }
    }
}
