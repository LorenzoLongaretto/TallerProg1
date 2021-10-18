package infraestructura;

public class HabitacionPrivada extends Habitacion {

	//Atributos
	private static double costoExtra=100;
	
	//Constructores
	public HabitacionPrivada(int nroHabitacion,double costoAsignacion) {
		super(nroHabitacion,costoAsignacion);
	}

	//Metodos
	@Override
	public double costoDeHabitacion(int cantDias) {
		double auxiliar=0;
		if(cantDias == 1)
			auxiliar = HabitacionPrivada.costoExtra;
		else
			if(cantDias>=2 && cantDias<=5)
				auxiliar = HabitacionPrivada.costoExtra*1.3;
			else
				if(cantDias>=6)
					auxiliar = HabitacionPrivada.costoExtra*2;
		return auxiliar + this.getCostoAsignacion();
	}

	@Override
	public String toString() {
		return super.toString()+"---Tipo:  Habitacion Privada"+" Disponibilidad: "+this.getCantPersonas()+" personas";
	}

}
