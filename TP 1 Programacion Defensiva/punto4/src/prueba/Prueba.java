package prueba;

import interefaz.InterfaseDeUsuario;

public class Prueba {

	public static void main(String[] args) {
		InterfaseDeUsuario interfaz=new InterfaseDeUsuario();
		interfaz.Calcular(-1,2,"*");
		interfaz.mostraResultado();
		
		interfaz.Calcular(1,-2,"+");
		interfaz.mostraResultado();
		
		interfaz.Calcular(1,2,"-");
		interfaz.mostraResultado();
		
		interfaz.Calcular(1,2,"/");
		interfaz.mostraResultado();
		
		interfaz.Calcular(1,1,"+");
		interfaz.mostraResultado();
	}

}
