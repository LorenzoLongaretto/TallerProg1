package testVentana;

import clinica.Clinica;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Utils {
    public static final int delay = 250;

    public static void click(Robot robot) {
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(delay);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(delay);
    }

    public static void escribir(Robot robot, String cad) {
        for (char c : cad.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            if (KeyEvent.CHAR_UNDEFINED == keyCode) {
                throw new RuntimeException("Caracter invalido para que el robot escriba");
            }
            robot.keyPress(keyCode);
            robot.delay(delay/5);
            robot.keyRelease(keyCode);
            robot.delay(delay/5);
        }
    }

    public static void cargarDatosClinicaTesting(){
        Clinica clinica = Clinica.getInstance("Hospital de Pruebas", "Avenida de Testing", "404", "Mar del Testing");
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
        clinica.ingresaPaciente("65761321", "Moreno 1239", "Mar del plata", "2234564687", "Juan Carlos Lopez",
                "Mayor");
        clinica.ingresaPaciente("7561238", "Colon 1239", "Mar del plata", "6873213", "Agustin Adan", "Nino");
        clinica.ingresaPaciente("1354314", "Buenos Aires 1239", "Mar del plata", "2234564687",
                "Sergio Aguero", "Mayor");
        clinica.ingresaPaciente("17777047", "Rateriy 5", "Mar del plata", "2234569987",
                "Leonel Guccione", "Joven");
        clinica.ingresaPaciente("17777047", "Rateriy 55", "Mar del plata", "2235569987",
                "Guillermo Lazurri", "Joven");
        clinica.ingresaPaciente("17777047", "Mitre 475", "Mar del plata", "2234579987",
                "Adolfo Spinelli", "Joven");
    }

    public static void pausa(Robot r) {
        r.delay(delay);
    }
    public static void pausa(Robot r, int tiempo) {
        r.delay(tiempo);
    }
}
