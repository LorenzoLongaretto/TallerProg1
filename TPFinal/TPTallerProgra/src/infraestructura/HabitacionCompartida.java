package infraestructura;

public class HabitacionCompartida extends Habitacion {

	private static double costoExtra=200;//PREGUNTAR
	
	//Constructores
	public HabitacionCompartida(int nroHabitacion,double costoAsignacion) {
		super(nroHabitacion,costoAsignacion);
		this.cantPersonas=3; // cantidad de personas en una habitacion		
	}

	//Metodos
	@Override
	public double costoDeHabitacion(int cantDias) {
		return (this.getCantDias() * HabitacionCompartida.costoExtra)+this.getCostoAsignacion();
	}

	@Override
	public String toString() {
		return super.toString()+ "---Tipo:Habitacion Compartida"+" Disponibilidad: "+this.getCantPersonas()+" personas";
	}

}
