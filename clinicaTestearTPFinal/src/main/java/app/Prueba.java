package app;

import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Set;

import clinica.Clinica;
import controlador.Controlador;
import exceptions.FechaInvalidaException;
import exceptions.PacienteInvalidoException;
import lugares.HabPrivada;
import lugares.Habitacion;
import persistencia.PersistenciaXML;
import usuarios.Medico;
import usuarios.Paciente;
import vistas.Ventana;

public class Prueba {

    public static void main(String[] args) {
        PersistenciaXML xml = new PersistenciaXML();
        // Creamos la Clinica
        Clinica clinica = Clinica.getInstance("Hospital", "Avenida siempre viva", "123123", "Balcarce");
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
        // Ingreso del paciente a la clinica

//        System.out.println("PACIENTES");
//        for (Paciente paciente : clinica.getPacientes()) {
//            System.out.println(paciente.getNombre());
//        }
//
//        System.out.println("MEDICOS");
//        for (Medico medico : clinica.getMedicos()) {
//            System.out.format("%20s $%8.2f%n", medico.getNombre(), medico.getHonorario());
//        }
//
//
//        Set<Paciente> pacientes = clinica.getPacientes();
//        Iterator<Paciente> pacientesIterator = pacientes.iterator();
//        Paciente pacientePrueba = pacientesIterator.next();
//
//        Set<Medico> medicos = clinica.getMedicos();
//        Iterator<Medico> medicosIterator = medicos.iterator();
//        Medico medicoPrueba1 = medicosIterator.next();
//        Medico medicoPrueba2 = medicosIterator.next();
//
//        Habitacion habPrueba = new HabPrivada();
//
//
//        clinica.agregaConsultaAPaciente(pacientePrueba, medicoPrueba1);
//        clinica.agregaConsultaAPaciente(pacientePrueba, medicoPrueba2);
//
//
//        try {
//            clinica.agregaInternacionAPaciente(pacientePrueba, habPrueba, 5);
//        } catch (Exception e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//        }
//
//        try {
//            clinica.agregarFactura(pacientePrueba, new GregorianCalendar(2021, 5, 14));
//        } catch (PacienteInvalidoException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        System.out.println("********************************");
//
//        try {
//            clinica.buscaMedico(1408).muestraReporte(new GregorianCalendar(2021, 5, 13),
//                    new GregorianCalendar(2021, 5, 16));
//        } catch (FechaInvalidaException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

        clinica.persistenciaFacturasIn();


        Ventana ventana = new Ventana();
        Controlador controlador = new Controlador(ventana);
        ventana.actualizaListaMedicos(Clinica.getInstance().getMedicos());
        ventana.actualizaListaPacientes(Clinica.getInstance().getPacientes());


    }
}
