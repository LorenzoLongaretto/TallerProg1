package testCajaBlanca;

import app.NumeroAzar;
import clinica.Clinica;
import exceptions.NoExisteException;
import exceptions.PacienteInvalidoException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import usuarios.Paciente;
import usuarios.PacienteFactory;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class testCajaBlanca {
    Clinica clinica;
    int nroFactura;
    GregorianCalendar fecha;
    ArrayList<Double> listaInsumos;

    @Before
    public void setUp() throws Exception {
        clinica = Clinica.getInstance("Favaloro","Independencia","2236352472","Mar del Plata");
    }

    @After
    public void tearDown() throws Exception {
        clinica.limpiarColecciones();
    }

    @Test
    public void Camino_1() {
        nroFactura = -1;
        fecha = new GregorianCalendar(2010, Calendar.OCTOBER,10);
        listaInsumos = new ArrayList<>();
        listaInsumos.add(2.5);

        double rta = clinica.calculoImporteAdicionales(nroFactura,fecha,listaInsumos);
        System.out.println(rta);
    }

    @Test
    public void Camino_2() {
        nroFactura = 1;
        LocalDate fechaHoy = LocalDate.now();
        LocalDate fechaFactura = fechaHoy.minus(Period.ofDays(1));
        GregorianCalendar fechaFacturacion = new GregorianCalendar(fechaFactura.getYear(),fechaFactura.getMonthValue(),fechaFactura.getDayOfMonth());

        Paciente pacienteJoven = null;
        try {
            pacienteJoven = PacienteFactory.getPaciente("120047896","Mitre 123","MdP","22345784707","Abuelo Juan","Mayor");
            clinica.agregarFactura(pacienteJoven,fechaFacturacion);
        } catch (NoExisteException | PacienteInvalidoException e) {
            //No deberia lanzarse nunca, está bien creado
        }

        fecha = new GregorianCalendar(fechaHoy.getYear(),fechaHoy.getMonthValue(),fechaHoy.getDayOfMonth());
        listaInsumos = new ArrayList<>();
        listaInsumos.add(2.0);
        listaInsumos.add(3.0);

        NumeroAzar.setNumero(fechaFactura.getDayOfMonth());
        double rta = clinica.calculoImporteAdicionales(nroFactura,fecha,listaInsumos);
        System.out.println(rta);

    }

    @Test
    public void Camino_3() {
        nroFactura = 2;
        LocalDate fechaHoy = LocalDate.now();
        LocalDate fechaFactura = fechaHoy.minus(Period.ofDays(15));
        GregorianCalendar fechaFacturacion = new GregorianCalendar(fechaFactura.getYear(),fechaFactura.getMonthValue(),fechaFactura.getDayOfMonth());

        Paciente pacienteMayor = null;
        try {
            pacienteMayor = PacienteFactory.getPaciente("420047896","Mitre 123","MdP","22345784707","Joven Juan","Joven");
            clinica.agregarFactura(pacienteMayor,fechaFacturacion);
        } catch (NoExisteException | PacienteInvalidoException e) {
            //No deberia lanzarse nunca, está bien creado
        }

        fecha = new GregorianCalendar(fechaHoy.getYear(),fechaHoy.getMonthValue(),fechaHoy.getDayOfMonth());
        listaInsumos = new ArrayList<>();
        listaInsumos.add(2.0);
        listaInsumos.add(-1.5);//valor invalido

        NumeroAzar.setNumero(fechaFactura.getDayOfMonth()+1);//Para asegurarse que no coincidan
        double rta = clinica.calculoImporteAdicionales(nroFactura,fecha,listaInsumos);
        System.out.println(rta);

    }
    @Test
    public void Camino_4() {
        nroFactura = 3;
        LocalDate fechaHoy = LocalDate.now();
        LocalDate fechaFactura = fechaHoy.minus(Period.ofDays(15));
        GregorianCalendar fechaFacturacion = new GregorianCalendar(fechaFactura.getYear(),fechaFactura.getMonthValue(),fechaFactura.getDayOfMonth());

        Paciente pacienteJoven = null;
        try {
            pacienteJoven = PacienteFactory.getPaciente("420047896","Mitre 123","MdP","22345784707","Joven Juan","Joven");
            clinica.agregarFactura(pacienteJoven,fechaFacturacion);
        } catch (NoExisteException | PacienteInvalidoException e) {
            //No deberia lanzarse nunca, está bien creado
        }

        fecha = new GregorianCalendar(fechaHoy.getYear(),fechaHoy.getMonthValue(),fechaHoy.getDayOfMonth());
        listaInsumos = new ArrayList<>();
        //lista vacia

        NumeroAzar.setNumero(fechaFactura.getDayOfMonth()+1);//Para asegurarse que no coincidan
        double rta = clinica.calculoImporteAdicionales(nroFactura,fecha,listaInsumos);
        System.out.println(rta);

    }


}
