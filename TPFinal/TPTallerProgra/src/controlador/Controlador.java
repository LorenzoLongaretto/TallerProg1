package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


import excepciones.HabitacionOcupadaException;

import infraestructura.Factura;
import infraestructura.Habitacion;
import modelo.Clinica;
import modelo.IMedico;
import persistencia.ClinicaDTO;
import persistencia.IPersistencia;
import persistencia.Persistencia;
import vista.IVistaDatos;
import vista.IVistaHabitacion;
import vista.IVistaMedico;
import vista.IVistaPaciente;
import personas.Paciente;
import util.Util;


public class Controlador implements ActionListener,WindowListener{

	private IVistaPaciente vistaPaciente;
	private IVistaMedico vistaMedico;
	private IVistaHabitacion vistaHabitacion;
	private IVistaDatos vistaDatos;
	
	
	
	public Controlador(IVistaPaciente vistaPaciente, IVistaMedico vistaMedico, IVistaHabitacion vistaHabitacion,IVistaDatos vistaDatos) {
		this.setVistaPaciente(vistaPaciente);
		this.setVistaMedico(vistaMedico);
		this.setVistaHabitacion(vistaHabitacion);
	
		
	}
	public IVistaPaciente getVistaPaciente() {
		return vistaPaciente;
	}
	public IVistaMedico getVistaMedico() {
		return vistaMedico;
	}

	public IVistaHabitacion getVistaHabitacion() {
		return vistaHabitacion;
	}
	

	public void setVistaPaciente(IVistaPaciente vistaPaciente) {
		this.vistaPaciente = vistaPaciente;
		this.vistaPaciente.setActionListenerPaciente(this);
		this.vistaPaciente.addWindowListener(this);
	}

	public void setVistaMedico(IVistaMedico vistaMedico) {
		this.vistaMedico = vistaMedico;
		this.vistaMedico.setActionListenerMedico(this);
	}

	public void setVistaHabitacion(IVistaHabitacion vistaHabitacion) {
		this.vistaHabitacion = vistaHabitacion;
		this.vistaHabitacion.setActionListenerHabitacion(this);
	}

    public void setVistaDatos(IVistaDatos vistaDatos) {
    	this.vistaDatos = vistaDatos;
    	this.vistaDatos.setActionListenerDatos(this);
    }
	@Override
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();
		if(comando.equalsIgnoreCase("Cargar")) {
			
			this.vistaPaciente.actualizaLista(Clinica.getInstance().getListaAtencion());
			this.vistaMedico.actualizaListaMedicos(Clinica.getInstance().getMedicos());
			this.vistaHabitacion.actualizaListaHabitaciones(Clinica.getInstance().getHabitaciones());
			this.vistaPaciente.habilitarAtencion();
		}
		if(comando.equalsIgnoreCase("Atender") ) {
			Paciente paciente  = Clinica.getInstance().getListaEspera().poll();
			if(paciente!=null) {
				Clinica.getInstance().atenderPaciente(paciente);
				this.vistaPaciente.borraLista();
				this.vistaPaciente.actualizaLista(Clinica.getInstance().getListaAtencion());
			}
			else
				this.vistaPaciente.mensaje("No hay mas pacientes en la lista de espera");
		}
		if(comando.equalsIgnoreCase("Serializar")) {
			IPersistencia idao = new Persistencia();
			try {
	        	idao.abrirOutput("clinica.bin");
	        	System.out.println("Creacion archivo escritura");
	        	ClinicaDTO cdto= new ClinicaDTO("Hospital Favaloro","Bypass 290700");
	        	cdto = Util.clinicaDTOFromCLinica();
	        	idao.escribir(cdto);
	        	System.out.println("Clinica serializada al apretar boton");
	        	idao.cerrarOutput();
	        	System.out.println("Archivo cerrado");
	        	
	        }catch(Exception e1) {
	        	System.out.println(e1.getMessage());
	        }
		}
		if(comando.equalsIgnoreCase("Prestacion Medica")) {
			
			Paciente paciente  = this.vistaPaciente.getPacienteSeleccionado();
			IMedico medico  = this.vistaMedico.getMedicoSeleccionado();
			
			if(medico!=null && paciente!=null) {
				Clinica.getInstance().derivarMedico(paciente, medico);
				this.vistaPaciente.mensaje("Se agrego la prestacion medica: "+medico.getNombre()+" "+medico.getMatricula()+" al paciente");
			}
			else
				this.vistaPaciente.mensaje("Debe seleccionar un paciente y un medico");
		}
        if(comando.equalsIgnoreCase("Prestacion Habitacion")) {
        	try {
        		Integer.parseInt(this.vistaHabitacion.getCantidadDias());
        		Paciente paciente  = this.vistaPaciente.getPacienteSeleccionado();
            	Habitacion habitacion = this.vistaHabitacion.getHabitacionSeleccionada();
            	
            	
            	if(habitacion!= null && paciente!=null) {
            		try {
            			habitacion.setCantDias(Integer.parseInt(this.vistaHabitacion.getCantidadDias()));
    					Clinica.getInstance().derivarHabitacion(paciente, habitacion);
    					this.vistaPaciente.mensaje("Se agrego la habitacion: "+habitacion.toString()+ " al paciente");
    				} catch (HabitacionOcupadaException e1) {
    				this.vistaPaciente.mensaje(e1.getMessage());
    				}
            		
            	}
            	else 
            		this.vistaPaciente.mensaje("Debe seleccionar una habitacion y un paciente");
        	}catch(NumberFormatException e1) {
        		this.vistaPaciente.mensaje("Debe ingresar una cantidad numerica de dias");
        	}   	
		}
        if(comando.equalsIgnoreCase("Egreso")) {
        	this.vistaPaciente.borrarFactura();
            Paciente paciente  = this.vistaPaciente.getPacienteSeleccionado();
            if(paciente!=null) {
            	Factura factura = Clinica.getInstance().buscaUltima(paciente);
            	if(factura!=null) {
            		Clinica.getInstance().egreso(paciente);
                	this.vistaPaciente.borraLista();
                	this.vistaPaciente.actualizaLista(Clinica.getInstance().getListaAtencion());
                	this.vistaPaciente.actualizaFactura(factura);
            	}
            	else
            		this.vistaPaciente.mensaje("Ese paciente no tiene una factura en el sistema");
            	
            }
            else
            	this.vistaPaciente.mensaje("Debe seleccionar un paciente de la lista de Atencion");
			
		}

     
   

	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		IPersistencia idao = new Persistencia();
		try {
        	idao.abrirOutput("clinica.bin");
        	System.out.println("Creacion archivo escritura");
        	ClinicaDTO cdto= new ClinicaDTO("Hospital Favaloro","Bypass 290700");
        	cdto = Util.clinicaDTOFromCLinica();
        	idao.escribir(cdto);
        	System.out.println("Clinica serializada al cerrar");
        	idao.cerrarOutput();
        	System.out.println("Archivo cerrado");
        	
        }catch(Exception e1) {
        	System.out.println(e1.getMessage());
        }
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
 

}
