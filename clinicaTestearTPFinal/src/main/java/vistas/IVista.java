package vistas;

import usuarios.Medico;
import usuarios.Paciente;

import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Set;

public interface IVista {

    void addActionListener(ActionListener controlador);
    Paciente getPacienteSelcted();
    Medico getMedicoSelected();

    void actualizaListaPacientes(Set<Paciente> pacientes);
    void actualizaListaMedicos(Set<Medico> medicos);

    void actualizaListaFacturas(StringBuilder facturas);

    int getCantidadDias() throws NumberFormatException;

    GregorianCalendar[] getIntervaloFechas() throws Exception;

    void valueChanged(ListSelectionEvent e);

    void setTextField();

    boolean diasVacio();

    void reiniciaVista();

    void reiniciaFacturas();
}
