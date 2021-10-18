package vista;

import java.awt.event.ActionListener;
import java.util.HashMap;

import modelo.IMedico;

public interface IVistaMedico {
    
	public void setActionListenerMedico(ActionListener actionListener);
	public IMedico getMedicoSeleccionado();
	public void actualizaListaMedicos(HashMap<Integer,IMedico> medicos);
	public void agregaMedico(IMedico medico);
	
	
}
