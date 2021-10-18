package infraestructura;

public class TerapiaIntensiva extends Habitacion {

	//Atributos
	private static double costoExtra=600;
	
	//Constructores
	public TerapiaIntensiva(int nroHabitacion,double costoAsignacion) {
		super(nroHabitacion,costoAsignacion);
	}

	//Metodos
	@Override
	public double costoDeHabitacion(int cantDias) {
		return Math.pow(TerapiaIntensiva.costoExtra, cantDias) +this.getCostoAsignacion();
	}

	@Override
	public String toString() {
		return super.toString()+ "---Tipo: Terapia Intensiva"+" Disponibilidad: "+this.getCantPersonas()+" personas";
	}

}
