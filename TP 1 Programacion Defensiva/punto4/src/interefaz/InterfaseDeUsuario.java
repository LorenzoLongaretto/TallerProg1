package interefaz;

import excepciones.NumeroNegativoExcepcion;
import excepciones.OperacionInexistenteExcepcion;
import excepciones.ResultadoNoEnteroExepcion;
import negocio.Monitor;

public class InterfaseDeUsuario {
private Monitor monitor;
private int resultado;


	
	public InterfaseDeUsuario() {
	this.monitor = new Monitor();
	this.resultado = 0;
}
	public void Calcular(Integer PrimerOperando, Integer SegundoOperando, String Operacion) {
		try {
			this.monitor.Calcular(PrimerOperando, SegundoOperando, Operacion);
		} catch (OperacionInexistenteExcepcion | NumeroNegativoExcepcion | ResultadoNoEnteroExepcion e) {
			mostrarEstado(e);
		}
		resultado=monitor.traeResultado();
	}
	public void mostrarEstado(Exception e) {
		System.out.println(e);
	}
	public void mostraResultado() {
		if(resultado!=0)
			System.out.println("el resultado es: "+resultado);
		else
			System.out.println("Imposible mostrar resultado");
	}
}
