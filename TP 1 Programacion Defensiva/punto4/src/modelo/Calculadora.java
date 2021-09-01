package modelo;

import excepciones.NumeroNegativoExcepcion;
import excepciones.OperacionInexistenteExcepcion;
import excepciones.ResultadoNoEnteroExepcion;

public class Calculadora {
private int resultado;


	public Calculadora() {
		this.resultado = 0;
	}

	public void Calcular(Integer PrimerOperando, Integer SegundoOperando, String Operacion) throws OperacionInexistenteExcepcion,NumeroNegativoExcepcion,ResultadoNoEnteroExepcion{
		if(!(PrimerOperando>0 && SegundoOperando>0)) 
			throw new NumeroNegativoExcepcion("Ambos operandos deben ser mayores a cero");
		if(Operacion.equals("+"))
			this.resultado=PrimerOperando+SegundoOperando;
		else if(Operacion.equals("-")) {
				this.resultado=PrimerOperando-SegundoOperando;
				if(this.resultado<=0) 
					throw new NumeroNegativoExcepcion("El resultado es negativo");
		}
		else if(Operacion.equals("*"))
			this.resultado=PrimerOperando*SegundoOperando;
		else if(Operacion.equals("/")) {
			if(PrimerOperando%SegundoOperando==0)
				this.resultado=PrimerOperando/SegundoOperando;
			else
				throw new ResultadoNoEnteroExepcion("El resultado de la operacion debe ser entero");
		}
		else
			throw new OperacionInexistenteExcepcion("La operacion solicitada no existe");
		
	}
	
	public int traerResultado() {
		return resultado;
	}
}
