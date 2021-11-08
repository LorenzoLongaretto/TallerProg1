package controlador;

import clinica.Clinica;
import exceptions.DiasInvalidosException;
import exceptions.PacienteInvalidoException;
import factura.Factura;
import lugares.HabCompartida;
import lugares.HabPrivada;
import usuarios.Medico;
import usuarios.Paciente;
import vistas.IVista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Controlador implements ActionListener {

    private IVista ventanaMovimientos;
    private Clinica clinica = Clinica.getInstance();


    public Controlador(IVista ventanaMovimientos) {
        setVentanaMovimientos(ventanaMovimientos);
    }

    public void setVentanaMovimientos(IVista ventanaMovimientos) {
        this.ventanaMovimientos = ventanaMovimientos;
        this.ventanaMovimientos.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        Paciente pacienteAct = this.ventanaMovimientos.getPacienteSelcted();
        Medico medicoAct = this.ventanaMovimientos.getMedicoSelected();

        if (action.equalsIgnoreCase("GenerarConsulta")) {

            if (pacienteAct != null && medicoAct != null) {
                this.clinica.agregaConsultaAPaciente(pacienteAct, medicoAct);
            } else if (pacienteAct == null)
                JOptionPane.showMessageDialog((Component) ventanaMovimientos, "Tiene que seleccionar un paciente");
            else
                JOptionPane.showMessageDialog((Component) ventanaMovimientos, "Tiene que seleccionar un medico");
        } else if (action.equalsIgnoreCase("GenerarInternacion")) {
            try {
                int dias = ventanaMovimientos.getCantidadDias();
                Clinica.getInstance().agregaInternacionAPaciente(pacienteAct, new HabPrivada(), dias);
            } catch (Exception x) {
                JOptionPane.showMessageDialog((Component) ventanaMovimientos, "Seleccione una cantidad de dias valida");
            }
            this.ventanaMovimientos.setTextField();
        } else if (action.equalsIgnoreCase("DardeAlta")) {
            GregorianCalendar fecha = new GregorianCalendar();

            try {
                this.clinica.agregarFactura(pacienteAct, fecha);
                Clinica.getInstance().getPacientes().remove(pacienteAct);
                ventanaMovimientos.actualizaListaPacientes(Clinica.getInstance().getPacientes());
            } catch (PacienteInvalidoException ex) {
                JOptionPane.showMessageDialog((Component) ventanaMovimientos, "Seleccione un paciente valido");
            }
            ventanaMovimientos.reiniciaVista();
        } else if (action.equalsIgnoreCase("Consultar")) {
            try {

                GregorianCalendar[] fechas = ventanaMovimientos.getIntervaloFechas();
                ArrayList<Factura> facturas = Clinica.getInstance().getFacturasOrdenadas();
                StringBuilder stringBuilder = new StringBuilder();
                this.ventanaMovimientos.reiniciaFacturas();
                for (Factura factura : facturas) {

                    if (factura.getFecha().compareTo(fechas[0]) >= 0 && factura.getFecha().compareTo(fechas[1]) <= 0) {
                        stringBuilder.append(factura.ImprimeFactura());
                    }
                }
                ventanaMovimientos.actualizaListaFacturas(stringBuilder);


            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }


}
