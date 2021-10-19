package vista;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import infraestructura.Factura;

public interface IVistaDatos {
	void setActionListenerDatos(ActionListener actionListener);
	
	GregorianCalendar getFechaInicio();
	GregorianCalendar getFechaFin();
	void muestraLista(ArrayList<Factura> facturas);
	
}
