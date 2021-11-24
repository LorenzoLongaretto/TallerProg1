package integracion;


import clinica.Clinica;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import vistas.Ventana;


public class TestTopDown {
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
    public void testAltaPaciente(){
        Ventana ventana ;
    }

}
