package testCajaNegra;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import exceptions.NoExisteException;
import usuarios.Medico;
import usuarios.MedicoFactory;

public class TestMedicoFactory {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreacionValida() {
		 Medico medico = null;
			try {
				 medico = MedicoFactory.getMedico("234565", "Marconi 2345", "Mar del Plata", "223456732", "Susana Ibanez", 1502, 3000,
				        "Clinico", "Permanente");
			} catch (NoExisteException e) {
				Assert.fail("El medico se deberia crear correctamente");
			}
	}
	@Test
	public void testCreacionInValida() {
		 Medico medico = null;
		 boolean fallo = false;
			try {
				 medico = MedicoFactory.getMedico("234565", "Marconi 2345", "Mar del Plata", "223456732", "Susana Ibanez", 1502, 3000,
				        "Clinicooo", "Permanenteee");
			} catch (NoExisteException e) {
				fallo = true;
			}
			if(!fallo)
			Assert.fail("Deberia fallar la creacion del medico");
	}

}
