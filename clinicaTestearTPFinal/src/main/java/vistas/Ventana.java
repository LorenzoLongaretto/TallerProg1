package vistas;

import clinica.Clinica;
import usuarios.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;

import java.awt.event.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.awt.Font;

public class Ventana extends JFrame implements IVista, ListSelectionListener, ActionListener, KeyListener, WindowListener {
    private JPanel contentPane;
    private JList<Paciente> listPacientes;
    private JList<Medico> listMedicos;
    private JLabel lblPacientes;
    private JLabel lblMedicos;
    private JButton btnConsulta;
    private JButton btnInternacion;
    private JTextField diasText;
    private JLabel lblCantDias;
    private JButton btnDarAlta;
    private DefaultListModel<Paciente> modeloPaciente = new DefaultListModel<>();
    private DefaultListModel<Medico> modeloMedico = new DefaultListModel<>();
    private JPanel panelFacturacion;
    private JTabbedPane tabbedPane;
    private JPanel panelConsultaFactura;
    private JButton btnConsultar;
    private JFormattedTextField FechaFinal;
    private JFormattedTextField FechaInicial;
    private JTextArea textPane;
    private Clinica clinica = Clinica.getInstance();
    private JScrollPane scrollPaneFactura ;
    private JPanel contentPanel;

    public Ventana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 735, 474);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(this.contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        contentPane.add(tabbedPane);

        this.addWindowListener(this);

        panelFacturacion = new JPanel();
        tabbedPane.addTab("Facturacion", null, panelFacturacion, null);
        panelFacturacion.setLayout(null);

        this.listPacientes = new JList<Paciente>();
        listPacientes.setBounds(0, 39, 193, 337);
        panelFacturacion.add(listPacientes);
        this.listPacientes.setModel(this.modeloPaciente);
        this.listPacientes.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);

        this.listMedicos = new JList<Medico>();
        listMedicos.setBounds(222, 36, 193, 337);
        panelFacturacion.add(listMedicos);
        this.listMedicos.setModel(this.modeloMedico);
        this.listMedicos.setSelectionMode(DefaultListSelectionModel.SINGLE_SELECTION);

        this.lblPacientes = new JLabel("Lista de Pacientes");
        lblPacientes.setBounds(19, 0, 139, 27);
        panelFacturacion.add(lblPacientes);

        this.lblMedicos = new JLabel("Lista de Medicos");
        lblMedicos.setBounds(232, 0, 139, 27);
        panelFacturacion.add(lblMedicos);

        this.btnConsulta = new JButton("Generar Consulta");
        btnConsulta.setBounds(473, 40, 145, 23);
        panelFacturacion.add(btnConsulta);
        this.btnConsulta.setActionCommand("GenerarConsulta");
        this.btnConsulta.setEnabled(false);

        this.btnInternacion = new JButton("Generar Internacion");
        btnInternacion.setBounds(473, 183, 139, 23);
        panelFacturacion.add(btnInternacion);
        this.btnInternacion.setActionCommand("GenerarInternacion");
        this.btnInternacion.setEnabled(false);

        this.diasText = new JTextField();
        diasText.setBounds(497, 152, 96, 20);
        panelFacturacion.add(diasText);
        this.diasText.setColumns(10);

        this.lblCantDias = new JLabel("Cantidad de dias");
        lblCantDias.setBounds(497, 127, 102, 14);
        panelFacturacion.add(lblCantDias);

        this.btnDarAlta = new JButton("Dar de alta");
        btnDarAlta.setBounds(473, 283, 139, 23);
        panelFacturacion.add(btnDarAlta);
        this.btnDarAlta.setActionCommand("DardeAlta");
        this.btnDarAlta.setEnabled(false);

        panelConsultaFactura = new JPanel();
        tabbedPane.addTab("ConsultaFactura", null, panelConsultaFactura, null);
        panelConsultaFactura.setLayout(null);

        JLabel lblNewLabel = new JLabel("Fecha Inicial");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel.setBounds(198, 10, 88, 16);
        panelConsultaFactura.add(lblNewLabel);

        JLabel lblFechaFinal = new JLabel("Fecha Final");
        lblFechaFinal.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblFechaFinal.setBounds(198, 42, 88, 16);
        panelConsultaFactura.add(lblFechaFinal);

        this.btnConsultar = new JButton("Consultar");
        btnConsultar.setBounds(437, 22, 114, 26);
        this.btnConsultar.setActionCommand("Consultar");
        panelConsultaFactura.add(btnConsultar);


        this.textPane = new JTextArea();
        this.scrollPaneFactura = new JScrollPane(this.textPane);
        this.scrollPaneFactura.setBounds(25, 68, 658, 311);
        this.panelConsultaFactura.add(scrollPaneFactura);


        MaskFormatter mascara = null;
        try {
            mascara = new MaskFormatter("##/##/####");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        this.FechaInicial = new JFormattedTextField(mascara);
        FechaInicial.setBounds(296, 10, 101, 19);
        panelConsultaFactura.add(FechaInicial);


        this.FechaFinal = new JFormattedTextField(mascara);
        FechaFinal.setBounds(296, 42, 101, 19);
        panelConsultaFactura.add(FechaFinal);
        this.diasText.addKeyListener(this);
        this.listMedicos.addListSelectionListener(this);
        this.listPacientes.addListSelectionListener(this);

        this.setVisible(true);
    }



    @Override
    public void addActionListener(ActionListener controller) {
        this.btnDarAlta.addActionListener(controller);
        this.btnInternacion.addActionListener(controller);
        this.btnConsulta.addActionListener(controller);
        this.btnConsultar.addActionListener(controller);
    }

    @Override
    public Paciente getPacienteSelcted() {
        return this.listPacientes.getSelectedValue();
    }

    @Override
    public Medico getMedicoSelected() {
        return this.listMedicos.getSelectedValue();
    }

    @Override
    public void actualizaListaPacientes(Set<Paciente> pacientes) {
        Iterator<Paciente> it = pacientes.iterator();
        Paciente paciente;
        this.modeloPaciente = new DefaultListModel<>();
        while (it.hasNext()) {
            paciente = it.next();
            this.modeloPaciente.addElement(paciente);
            listPacientes.clearSelection();
        }
        this.listPacientes.setModel(this.modeloPaciente);

    }


    public void setTextField() {
        this.diasText.setText("");
    }



    @Override
    public void actualizaListaMedicos(Set<Medico> medicos) {
        Iterator<Medico> it = medicos.iterator();
        Medico medico;

        this.modeloMedico = new DefaultListModel<>();

        while (it.hasNext()) {
            medico = it.next();
            if (!this.modeloMedico.contains(medico)) {
                this.modeloMedico.addElement(medico);
                this.setTextField();
            } else {

                this.modeloMedico.remove(this.modeloMedico.indexOf(medico));
//                if (this.modeloPaciente.isEmpty())
////                    this.btnComenzar.setEnabled(false);
            }
            listMedicos.clearSelection();
        }
        this.listMedicos.setModel(this.modeloMedico);
    }

    @Override
    public void actualizaListaFacturas(StringBuilder facturas) {
        this.textPane.append(facturas.toString());
    }

    @Override
    public int getCantidadDias() throws NumberFormatException {
        return Integer.parseInt(this.diasText.getText());
    }

    @Override
    public GregorianCalendar[] getIntervaloFechas() throws Exception {
        GregorianCalendar[] fechas = new GregorianCalendar[2];

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = df.parse(FechaInicial.getText());
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        fechas[0] = cal;

        Date date2 = df.parse(FechaFinal.getText());
        GregorianCalendar cal2 = new GregorianCalendar();
        cal2.setTime(date2);
        cal2.add(GregorianCalendar.HOUR,23);
        cal2.add(GregorianCalendar.MINUTE,59);
        cal2.add(GregorianCalendar.SECOND,59);
        fechas[1] = cal2;


        return fechas;
    }

    /**
     * Cuando se selecciona algun objeto de la lista, habilita los botones respectivos.
     *
     * @param e
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        this.btnConsulta.setEnabled(!this.listPacientes.isSelectionEmpty() && !this.listMedicos.isSelectionEmpty());
        this.btnDarAlta.setEnabled(!this.listPacientes.isSelectionEmpty());
        if (!this.diasVacio()) {
            this.btnInternacion.setEnabled(!this.listPacientes.isSelectionEmpty() && !this.listMedicos.isSelectionEmpty());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (!this.diasVacio())
            this.btnInternacion.setEnabled(!this.listPacientes.isSelectionEmpty() && !this.listMedicos.isSelectionEmpty());
        else
            this.btnInternacion.setEnabled(false);
    }

    public boolean diasVacio() {
        int dias = -1;
        try {
            dias = Integer.parseInt(this.diasText.getText());
        } catch (NumberFormatException e) {
        }
        return dias == -1;
    }

    public void reiniciaVista(){
        this.btnInternacion.setEnabled(false);
        this.btnConsulta.setEnabled(false);
        this.btnDarAlta.setEnabled(false);
        this.listMedicos.clearSelection();
        this.listPacientes.clearSelection();
    }

    @Override
    public void reiniciaFacturas() {
        this.textPane.setText("");
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Guardando datos");
        this.clinica.persistenciaFacturasOut();
        this.clinica.persistenciaMedicosOut();
        this.clinica.persistenciaPacientesOut();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}