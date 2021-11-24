package testCajaBlanca;

import clinica.Clinica;
import exceptions.NoExisteException;
import exceptions.PacienteInvalidoException;
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

    @Test
    public void noExisteFactura_1() {
        nroFactura = -1;
        fecha = new GregorianCalendar(2010, Calendar.OCTOBER,10);
        listaInsumos = new ArrayList<>();
        listaInsumos.add(2.5);

        double rta = clinica.calculoImporteAdicionales(nroFactura,fecha,listaInsumos);
        System.out.println(rta);
    }

    @Test
    public void fechasMenos10Dias_2() {
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
        listaInsumos.add(2.5);

        double rta = clinica.calculoImporteAdicionales(nroFactura,fecha,listaInsumos);
        System.out.println(rta);

    }

}
