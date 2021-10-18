package vista;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.Queue;

import infraestructura.Factura;
import personas.Paciente;



public interface IVistaPaciente{

	
	 void setActionListenerPaciente(ActionListener actionListener);
	 void addWindowListener(WindowListener windowListener);
	 Paciente getPacienteSeleccionado(); // devuelve el paciente seleccionado
	 void borraLista();
	 void actualizaLista(Queue<Paciente> atencion);// actualiza la lista de pacientes en la lista
	 void agregaPaciente(Paciente paciente);
	
	 void actualizaFactura(Factura factura);
	
	void habilitarAtencion();
	void mensaje(String msj);
	void borrarFactura();
	
}
