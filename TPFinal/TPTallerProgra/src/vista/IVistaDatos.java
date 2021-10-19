package vista;

import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

public interface IVistaDatos {
	void setActionListenerDatos(ActionListener actionListener);
	
	GregorianCalendar getFechaInicio();
	GregorianCalendar getFechaFin();
	
}
