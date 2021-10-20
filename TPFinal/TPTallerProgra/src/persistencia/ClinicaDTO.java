package persistencia;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

import infraestructura.Factura;
import infraestructura.Habitacion;
import infraestructura.SalaDeEspera;
import modelo.BDdePacientes;
import modelo.IMedico;
import personas.Paciente;



public class ClinicaDTO implements Serializable
{
    private String nombre;
    private String direccion;
    private ArrayList<Paciente> patio= new ArrayList<Paciente>();
    private Queue<Paciente> listaEspera= new LinkedList<Paciente>();
    private Queue<Paciente> listaAtencion= new LinkedList<Paciente>();
    private TreeSet<Factura> facturas= new TreeSet<>();
    private BDdePacientes pacientes = new BDdePacientes();
    private HashMap<Integer,IMedico> medicos = new HashMap<Integer,IMedico>();
	private int nroOrden=0;
	private int nroFactura =0;
	
	
	

    public ClinicaDTO()
    {
    }

    public ClinicaDTO(String nombre, String direccion)
    {
	super();
	this.nombre = nombre;
	this.direccion = direccion;
    }

    public String getNombre()
    {
	return nombre;
    }

    public void setNombre(String nombre)
    {
	this.nombre = nombre;
    }

    public String getDireccion()
    {
	return direccion;
    }

    public void setDireccion(String direccion)
    {
	this.direccion = direccion;
    }


	public ArrayList<Paciente> getPatio() {
		return patio;
	}


	public Queue<Paciente> getListaEspera() {
		return listaEspera;
	}


	public Queue<Paciente> getListaAtencion() {
		return listaAtencion;
	}


	public TreeSet<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(TreeSet<Factura> facturas) {
		this.facturas = facturas;
	}

	public BDdePacientes getPacientes() {
		return pacientes;
	}

	public void setPacientes(BDdePacientes pacientes) {
		this.pacientes = pacientes;
	}

	public HashMap<Integer, IMedico> getMedicos() {
		return medicos;
	}

	public void setMedicos(HashMap<Integer, IMedico> medicos) {
		this.medicos = medicos;
	}

	public int getNroOrden() {
		return nroOrden;
	}

	public void setNroOrden(int nroOrden) {
		this.nroOrden = nroOrden;
	}

	public int getNroFactura() {
		return nroFactura;
	}

	public void setNroFactura(int nroFactura) {
		this.nroFactura = nroFactura;
	}

}
