package vista;

import java.awt.event.ActionListener;
import java.util.HashMap;

import infraestructura.Habitacion;



public interface IVistaHabitacion {

	 void setActionListenerHabitacion(ActionListener actionListener);
	 Habitacion getHabitacionSeleccionada();
	 void actualizaListaHabitaciones(HashMap<Integer,Habitacion> habitaciones);
	 void agregarHabitacion(Habitacion habitacion);
	 String getCantidadDias();
	
}
