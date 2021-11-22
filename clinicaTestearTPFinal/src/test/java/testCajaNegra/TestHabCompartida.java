package testCajaNegra;

import  org.junit.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.DiasInvalidosException;
import lugares.HabCompartida;

public class TestHabCompartida {
private HabCompartida hab;
	@Before
	public void setUp() throws Exception {
		hab = new HabCompartida();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		String costo = ""+hab.getCostoAsignacion();
		Assert.assertEquals("El costo no se creo correctamente","500.0", costo);
	}
	@Test
	public void testArancelInvalido() {
		double costo;
		try {
			costo = hab.calculaArancel(0);
			Assert.fail("No se debio calcular ya que los dias son invalidos");
		} catch (DiasInvalidosException e) {
			
		}	
   }
	@Test
	public void testArancelValido() {
		double costo;
		try {
			costo = hab.calculaArancel(1);
		
		} catch (DiasInvalidosException e) {
			Assert.fail("No debe saltar la excepcion, los dias son validos");
		}	
   }
}
