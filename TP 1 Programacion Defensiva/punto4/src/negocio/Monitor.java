package negocio;

import excepciones.NumeroNegativoExcepcion;
import excepciones.OperacionInexistenteExcepcion;
import excepciones.ResultadoNoEnteroExepcion;
import modelo.Calculadora;

public class Monitor {
private Calculadora calculadora;
private int resultado;

public Monitor() {
	this.calculadora=new Calculadora() ;
}
public void Calcular(Integer PrimerOperando, Integer SegundoOperando, String Operacion) throws OperacionInexistenteExcepcion, NumeroNegativoExcepcion, ResultadoNoEnteroExepcion {
	this.calculadora.Calcular(PrimerOperando, SegundoOperando, Operacion);
	this.resultado=this.calculadora.traerResultado();
}

public int traeResultado(){
	return resultado;
}

}
