package vista;

import java.awt.BorderLayout;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import infraestructura.Factura;
import infraestructura.Habitacion;
import infraestructura.Prestacion;
import modelo.Clinica;
import modelo.IMedico;
import personas.Paciente;

import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Ventana extends JFrame implements IVistaPaciente,IVistaMedico,IVistaHabitacion,IVistaDatos,ActionListener{

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel_Pacientes;
	private JPanel panel_Medicos;
	private JLabel lbl_listaAtencion;
	private JList list_pacientes;
	private JScrollPane scrollPane;
	private JButton btn_Egreso;
	private JPanel panel_2;
	private JButton btn_PrestacionMedica;
	private JList list_medicos;
	private JScrollPane scrollPane_1;
	private JPanel panel_Habitaciones;
	private JList list_habitaciones;
	private JScrollPane scrollPane_2;
	private JPanel panel;
	private DefaultListModel<Paciente> modeloListaPaciente = new DefaultListModel<Paciente>();
	private DefaultListModel<IMedico> modeloListaMedico = new DefaultListModel<IMedico>();
	private DefaultListModel<Habitacion> modeloListaHabitacion = new DefaultListModel<Habitacion>();
	private DefaultListModel<Factura> modeloListaFacturas = new DefaultListModel<Factura>();
	
	private ActionListener actionListener;
	private JPanel panel_1;
	private JButton btn_Cargar;
	private JButton btn_PrestacionHabitacion;
	private JTextArea textArea_Factura;
	private JScrollPane scrollPane_3;
	private JLabel lbl_Factura;
	private JLabel lbl_ListaMedicos;
	private JLabel lbl_habitaciones;
	private JButton btn_Atender;
	private JPanel panel_38;
	private JPanel panel_39;
	private JPanel panel_40;
	private JPanel panel_41;
	private JPanel panel_42;
	private JPanel panel_43;
	private JPanel panel_44;
	private JPanel panel_12;
	private JPanel panel_13;
	private JButton btn_Serializar;
	private JLabel lbl_cantDias;
	private JPanel panel_25;
	private JPanel panel_29;
	private JPanel panel_32;
	private JTextField textField_cantDias;
	private JPanel panel_45;
	private JPanel panel_46;
	private JPanel panel_Datos;
	private JPanel panel_facturas;
	private JPanel panel_historias;
	private JList list_facturas;
	private JScrollPane scrollPane_4;
	private JLabel lbl_facturas;
	private JPanel panel_busqueda;
	private JTextField textField;
	private JButton btn_busqueda;
	

   	public Ventana() {
   		setResizable(false);
   		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana.class.getResource("/vista/descarga.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 598);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);
		this.setTitle("Clinica");
		this.tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.contentPane.add(this.tabbedPane, BorderLayout.CENTER);
		
		this.panel_Pacientes = new JPanel();
		this.tabbedPane.addTab("Pacientes", null, this.panel_Pacientes, null);
		this.panel_Pacientes.setLayout(new GridLayout(4, 1, 0, 0));
		
		this.panel_1 = new JPanel();
		this.panel_Pacientes.add(this.panel_1);
		this.panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.panel_12 = new JPanel();
		this.panel_1.add(this.panel_12);
		
		this.btn_Cargar = new JButton("Cargar");
		this.panel_12.add(this.btn_Cargar);
		
		this.btn_Serializar = new JButton("Serializar");
		this.panel_12.add(this.btn_Serializar);
		
		this.panel_13 = new JPanel();
		this.panel_1.add(this.panel_13);
		
		this.btn_Atender = new JButton("Atender");
		this.panel_13.add(this.btn_Atender);
		
		this.btn_Atender.setEnabled(false);
		
		this.panel_46 = new JPanel();
		this.panel_1.add(this.panel_46);
		
		this.lbl_listaAtencion = new JLabel("Lista de Atencion");
		this.panel_46.add(this.lbl_listaAtencion);
		this.lbl_listaAtencion.setFont(new Font("Tahoma", Font.BOLD, 15));
	
		
		this.panel_39 = new JPanel();
		this.panel_Pacientes.add(this.panel_39);
		this.panel_39.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.scrollPane = new JScrollPane();
		this.panel_39.add(this.scrollPane);
		
		this.list_pacientes = new JList();
		this.scrollPane.setViewportView(this.list_pacientes);
		this.list_pacientes.setModel(modeloListaPaciente);
		
		this.panel_2 = new JPanel();
		this.panel_Pacientes.add(this.panel_2);
		
		this.btn_PrestacionHabitacion = new JButton("Prestacion Habitacion");
		this.panel_2.add(this.btn_PrestacionHabitacion);
		
		this.btn_PrestacionMedica = new JButton("Prestacion Medica");
		this.panel_2.add(this.btn_PrestacionMedica);
		
		this.btn_Egreso = new JButton("Egreso");
		this.panel_2.add(this.btn_Egreso);
		
		this.panel = new JPanel();
		this.panel_Pacientes.add(this.panel);
		this.panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.scrollPane_3 = new JScrollPane();
		this.panel.add(this.scrollPane_3);
		
		this.textArea_Factura = new JTextArea();
		this.textArea_Factura.setColumns(10);
		this.textArea_Factura.setLineWrap(true);
		this.textArea_Factura.setWrapStyleWord(true);
		this.scrollPane_3.setViewportView(this.textArea_Factura);
		
		this.lbl_Factura = new JLabel("Factura");
		this.lbl_Factura.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.scrollPane_3.setColumnHeaderView(this.lbl_Factura);
		
		this.panel_Medicos = new JPanel();
		this.tabbedPane.addTab("Medicos", null, this.panel_Medicos, null);
		this.panel_Medicos.setLayout(new GridLayout(3, 1, 0, 0));
		
		this.panel_38 = new JPanel();
		this.panel_Medicos.add(this.panel_38);
		this.panel_38.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.scrollPane_1 = new JScrollPane();
		this.panel_38.add(this.scrollPane_1);
		
		this.list_medicos = new JList();
		this.scrollPane_1.setViewportView(this.list_medicos);
		this.list_medicos.setModel(modeloListaMedico);
		
		this.lbl_ListaMedicos = new JLabel("Lista de Medicos");
		this.lbl_ListaMedicos.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.scrollPane_1.setColumnHeaderView(this.lbl_ListaMedicos);
		
		this.panel_43 = new JPanel();
		this.panel_Medicos.add(this.panel_43);
		
		this.panel_44 = new JPanel();
		this.panel_Medicos.add(this.panel_44);
		
		this.panel_Habitaciones = new JPanel();
		this.tabbedPane.addTab("Habitaciones", null, this.panel_Habitaciones, null);
		this.panel_Habitaciones.setLayout(new GridLayout(3, 1, 0, 0));
		
		this.panel_40 = new JPanel();
		this.panel_Habitaciones.add(this.panel_40);
		this.panel_40.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.scrollPane_2 = new JScrollPane();
		this.panel_40.add(this.scrollPane_2);
		
		this.list_habitaciones = new JList();
		this.scrollPane_2.setViewportView(this.list_habitaciones);
		this.list_habitaciones.setModel(modeloListaHabitacion);
		
		this.lbl_habitaciones = new JLabel("Lista de Habitaciones");
		this.lbl_habitaciones.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.scrollPane_2.setColumnHeaderView(this.lbl_habitaciones);
		
		this.panel_41 = new JPanel();
		this.panel_Habitaciones.add(this.panel_41);
		this.panel_41.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panel_25 = new JPanel();
		this.panel_41.add(this.panel_25);
		this.panel_25.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.panel_32 = new JPanel();
		this.panel_25.add(this.panel_32);
		
		this.lbl_cantDias = new JLabel("Cantidad de Dias");
		this.panel_32.add(this.lbl_cantDias);
		
		this.panel_45 = new JPanel();
		this.panel_25.add(this.panel_45);
		
		this.textField_cantDias = new JTextField();
		this.panel_45.add(this.textField_cantDias);
		this.textField_cantDias.setColumns(10);
		
		this.panel_29 = new JPanel();
		this.panel_41.add(this.panel_29);
		
		this.panel_42 = new JPanel();
		this.panel_Habitaciones.add(this.panel_42);
		
		this.panel_Datos = new JPanel();
		this.tabbedPane.addTab("Datos", null, this.panel_Datos, null);
		this.panel_Datos.setLayout(new GridLayout(2, 0, 0, 0));
		
		this.panel_facturas = new JPanel();
		this.panel_Datos.add(this.panel_facturas);
		this.panel_facturas.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.scrollPane_4 = new JScrollPane();
		this.panel_facturas.add(this.scrollPane_4);
		
		this.list_facturas = new JList();
		this.scrollPane_4.setViewportView(this.list_facturas);
		this.list_facturas.setModel(modeloListaFacturas);
		
		this.lbl_facturas = new JLabel("Lista de Facturas");
		this.lbl_facturas.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.scrollPane_4.setColumnHeaderView(this.lbl_facturas);
		
		this.panel_busqueda = new JPanel();
		this.panel_facturas.add(this.panel_busqueda);
		
		this.textField = new JTextField();
		this.panel_busqueda.add(this.textField);
		this.textField.setColumns(10);
		
		this.btn_busqueda = new JButton("Buscar");
		this.panel_busqueda.add(this.btn_busqueda);
		
		this.panel_historias = new JPanel();
		this.panel_Datos.add(this.panel_historias);
		
		
		this.setVisible(true);
	}



	@Override
	public void setActionListenerHabitacion(ActionListener actionListener) {
		this.actionListener = actionListener;
		
	}

	@Override
	public void setActionListenerMedico(ActionListener actionListener) {
		this.actionListener = actionListener;
		
	}

	@Override
	public void setActionListenerPaciente(ActionListener actionListener) {
		this.btn_Cargar.addActionListener(actionListener);//Carga lista de atencion
		this.btn_Atender.addActionListener(actionListener);//Mueve de lista de espera a lista de atencion
		this.btn_PrestacionMedica.addActionListener(actionListener);
		this.btn_PrestacionHabitacion.addActionListener(actionListener);
		this.btn_Egreso.addActionListener(actionListener);
		this.btn_Serializar.addActionListener(actionListener);
		this.actionListener = actionListener;
	}
	@Override
	public void setActionListenerDatos(ActionListener actionListener) {
		this.actionListener = actionListener;
	}
	@Override
	public Paciente getPacienteSeleccionado() {
		
		return (Paciente) this.list_pacientes.getSelectedValue();
	}

	@Override
	public void actualizaLista(Queue<Paciente> atencion) {
		Iterator<Paciente> it = atencion.iterator();
        while(it.hasNext()) {
        	Paciente paciente  = it.next();
        	if(paciente!=null)
        		this.agregaPaciente(paciente);
        }
        this.btn_Cargar.setEnabled(false);
	}

	@Override
	public void agregaPaciente(Paciente paciente) {
		this.modeloListaPaciente.addElement(paciente);
		
	}

	@Override
	public void actualizaFactura(Factura factura) {
        this.textArea_Factura.append(factura.toString()+'\n');
		for (Prestacion prestaciones : factura.getPrestaciones()) {
			this.textArea_Factura.append(prestaciones.toString()+'\n');
			
			
		}
	
		this.textArea_Factura.append("Importe Total: "+factura.getImporteTotal());
	
	}

	@Override
	public String getCantidadDias() {
		return this.textField_cantDias.getText();
	}

	@Override
	public Habitacion getHabitacionSeleccionada() {
		
		return (Habitacion) this.list_habitaciones.getSelectedValue();
	}

	@Override
	public void actualizaListaHabitaciones(HashMap<Integer, Habitacion> habitaciones) {
		for (Integer key : habitaciones.keySet()) {
			   this.agregarHabitacion(habitaciones.get(key));
		}
	}

	@Override
	public IMedico getMedicoSeleccionado() {
		
		return (IMedico) this.list_medicos.getSelectedValue();
	}

	@Override
	public void actualizaListaMedicos(HashMap<Integer, IMedico> medicos) {
		for (Integer key : medicos.keySet()) {
		   this.agregaMedico(medicos.get(key));
		}
		
	}

	@Override
	public void agregaMedico(IMedico medico) {
		this.modeloListaMedico.addElement(medico);
		
	}
	@Override
	public void agregarHabitacion(Habitacion habitacion) {
		if(habitacion!=null)
		this.modeloListaHabitacion.addElement(habitacion);
		
	}
	@Override
	public void mensaje(String msj) {
		JOptionPane.showMessageDialog(this, msj);		
	}
	@Override
	public void borraLista() {
		this.modeloListaPaciente.removeAllElements();
  }

	@Override
	public void habilitarAtencion() {
		this.btn_Atender.setEnabled(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void borrarFactura() {
		this.textArea_Factura.setText("");
		
	}

}
