package modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

import excepciones.HabitacionOcupadaException;
import personas.Paciente;
import infraestructura.SalaDeEspera;
import infraestructura.Factura;
import infraestructura.Habitacion;
import infraestructura.Prestacion;



/**
 * 
 *<br>
 * Clase que representa una clinica. Contiene la totalidad de los pacientes. Tambien contine un patio, una sala de espera, una lista de medicos, asociados ,habitaciones y una lista de facturas correspondientes a los pacientes.
 *
 */
public class Clinica {

	private int nroFactura = 0;
	//Atributos
	private static Clinica instance = null;  // aplico patron singleton
     
    private String nombre;
    private String direccion;
    /**
     * @aggregation composite
     */
    private SalaDeEspera salaEspera = new SalaDeEspera();

    /**
     * @aggregation composite
     */
    private ArrayList<Paciente> patio= new ArrayList<Paciente>();

    /**
     * @aggregation composite
     */
    private Queue<Paciente> listaEspera= new LinkedList<Paciente>();

    /**
     * @aggregation composite
     */
    private Queue<Paciente> listaAtencion= new LinkedList<Paciente>();

    /**
     * @aggregation composite
     */
    private TreeSet<Factura> facturas= new TreeSet<>();

    /**
     * @aggregation composite
     */
    private BDdePacientes pacientes = new BDdePacientes();
    private HashMap<Integer,Habitacion> habitaciones = new HashMap<Integer,Habitacion>();
    //Clave = Nro de habitacion
    private HashMap<Integer,IMedico> medicos = new HashMap<Integer,IMedico>();
   
   
	private int nroOrden=0;
	
	
	//Constructores
	/**
	 * 
	 */
	private Clinica() {
		this.nombre= "Hospital Favaloro";
		this.direccion = "Bypass 290700";
	}
	public static Clinica getInstance() {
		if(Clinica.instance==null) {
			Clinica.instance=new Clinica();		
		}
		return instance;
	}
	
	//Metodos
	
	/**Da de alta a un paciente si no esta dentro de la Base de Datos de la clinica, luego lo deriva al patio o sala de espera de acuerdo a su prioridad.<br>
	 * <b> Pre: El parametro paciente debe ser distinto de null</b>
	 * <b> Post : Se  ingresa el paciente a la clinica. </b>
	 * @param paciente : Parametro de tipo paciente que ingresa a la clinica.
	 */
	public void ingresoPaciente(Paciente paciente) {
		// busca en la lista pacientes y chequea si ya existe para ver si lo agrega 
		
	       if(!this.pacientes.buscarPaciente(paciente)) //this.pacientes.buscarPaciente(paciente)!=true
	    	   this.pacientes.altaDePaciente(paciente);	
	       this.derivarPaciente(paciente);
	}
	
	/**Deriva al paciente a el patio o sala de espera de acuerdo a su prioridad
	 * <b> Pre: El parametro paciente debe ser distinto de null.</b>
	 * <b> Post: Se agrega al paciente al patio o sala de espera segun corresponda.</b>
	 * 
	 * 
	 * @param paciente: Parametro de tipo paciente, que es derivado.
	 */
	public void derivarPaciente(Paciente paciente) {
		nroOrden++;
		paciente.setNroOrden(nroOrden);
		this.listaEspera.add(paciente);
		
		if(this.salaEspera.isOcupada()) {
			if(!this.salaEspera.getPaciente().prioridad(paciente)) {//si cumple, entonces entra this.salaEspera.paciente.prioridad(paciente)==false
				this.patio.add(this.salaEspera.getPaciente());
				this.salaEspera.ocupaSalaDeEspera(paciente);
			}
			else
				this.patio.add(paciente);
		}
		else 
			this.salaEspera.ocupaSalaDeEspera(paciente);	
	}
	
	/**Se quita a los pacientes del patio o sala de espera, y los introduce dentro de la lista de atencion.
	 * <b> Pre: El parametro paciente debe ser distinto de null.</b>
	 * <b> Post: Se agrega al paciente a la lista de atencion,y se le crea una factura correspondiente</b>
	 * @param paciente: Parametro de tipo paciente, que es atendido.
	 */
	public void atenderPaciente(Paciente paciente){
		
		this.listaEspera.remove(paciente);
        
        if(this.patio.contains(paciente)) // si esta en el patio lo elimino
            this.patio.remove(paciente);
        else                                   // esta en la sala privada
            this.salaEspera.desocupar();
        
        this.listaAtencion.add(paciente);        
        this.nroFactura++;
        Factura factura = new Factura(this.nroFactura,new GregorianCalendar(),paciente);
        this.facturas.add(factura);
    }
	
	/**Se elimina a un paciente de la lista de atencion para realizar su egreso de la clinica, primero se verifica si lo contiene.
	 * <b> Pre: El parametro paciente  debe ser distinto de null.</b>
	 * <b> Post: Se elimina al paciente de la lista de atencion</b>
	 * @param paciente: Parametro de tipo paciente.
	 */
	
	//pasar paciente  --> buscar factura y mostrarla
	public void egreso(Paciente paciente) {
		if(this.listaAtencion.contains(paciente)) {
			this.listaAtencion.remove(paciente);
		  Factura factura = this.buscaUltima(paciente);
			if(factura!=null)
			factura.liberarHabitaciones();
		}
	}
	
	/**Metodo que agrega un medico a la clinica.
	 * <b>Pre: El parametro IMedico debe ser distinto de null</b>
	 * <b>Post: Se agrega al medico a la lista de medicos</b>
	 * @param medico: Parametro de tipo medico.
	 */
	public void agregarMedico(IMedico medico){
		this.medicos.put(Integer.parseInt(medico.getMatricula()) , medico);
	}
	
	/**Metodo que agrega una habitacion a la clinica.
	 * <b>Pre: El parametro de tipo Habitacion debe ser distinto de null</b>
	 * <b>Post: Se agrega una habitacion a la clinica</b>
	 * @param habitacion:  Parametro de tipo habitacion.
	 */
	public void asignarHabitacion(Habitacion habitacion) {
		this.habitaciones.put(habitacion.getNroHabitacion(), habitacion);
	}
	
	/**Metodo que agrega un medico a la factura y a la historia Clinica del paciente.
	 * <b>Pre: Los parametros de tipo Paciente e IMedico deben ser distintos de null</b>
	 * <b>Post: Se agrega una prestacion de tipo medico a la factura</b>
	 * @param paciente: Parametro de tipo Paciente.
	 * @param medico: Parametro de tipo IMedico.
	 */
	public void derivarMedico(Paciente paciente,IMedico medico) {
		Factura factura = this.buscaUltima(paciente);
		factura.asignarMedico(medico);		
		HistoriaClinica historia = this.buscaHistoria(paciente.getNumeroHistoria());
		historia.agregarPractica(medico);
	}
	
	/**Metodo que agrega una habitacion a la factura y a la historia clinica del paciente.
	 * <b>Pre: Los parametros de tipo Paciente y Habitacion deben ser distintos de null</b>
	 * <b>Post: Se agrega una una prestacion de tipo habitacion a la factura y a su historia clinica</b>
	 * @param paciente: Parametro de tipo Paciente.
	 * @param habitacion:  Parametro de tipo Habitacion.
	 * @throws HabitacionOcupadaException: Excepcion que se lanza si la habitacion esta ocupada.
	 */
	public void derivarHabitacion(Paciente paciente,Habitacion habitacion) throws HabitacionOcupadaException {
		Factura factura = this.buscaUltima(paciente);
		HistoriaClinica historia = this.buscaHistoria(paciente.getNumeroHistoria());
		if(habitacion.getCantPersonas()!=0) { // si esta en 0 significa que no hay espacio 
			 factura.asignarHabitacion(habitacion);
			 historia.agregarInstalacion(habitacion);
		}
	    else
			throw new HabitacionOcupadaException("La habitacion esta ocupada");
			
	}
	/**Metodo que busca y devuelve un medico segun su numero de matricula.
	 * @param matricula:Parametro de tipo entero que representa la matricula de algun medico.
	 * @return Medico buscado en la lista de medicos o null.
	 */
	public IMedico buscaMedico(int matricula) {
		return this.medicos.get(matricula);
	}
	
	/**Metodo que busca y devuelve una habitacion segun su numero.
	 * @param nro:Parametro de tipo entero que representa el numero de habitacion.
	 * @return Habitacion buscada en la lista de medicos o null.
	 */
	public Habitacion buscaHabitacion(int nro) {
		return this.habitaciones.get(nro);
	}
	/**Metodo que busca en la lista de facturas, la ultima factura de un paciente (la mas actual).
	 * <b>Pre: El paciente debe ser distinto de null</b>
	 * <b>Post: Devuelve la factura del paciente</b>
	 * @param paciente: Parametro de tipo Paciente.
	 * @return Factura mas actual del paciente.
	 */
	public Factura buscaUltima(Paciente paciente) {// busca la ultima factura del paciente (la actual)
		Factura retorno = null;
		 Iterator<Factura> it = this.facturas.iterator();
		 while(it.hasNext()) {
			 Factura factura = it.next();
			 if((factura.getPaciente().getDNI().equals(paciente.getDNI())) && ((retorno!=null && factura.getFecha().compareTo(retorno.getFecha())>0) || retorno==null)) {
				 retorno = factura;
			 }
		 }
		
		
		return retorno;
		
	}
	/**Se realiza un reporte de los pacientes atendidos, dentro de un periodo de fechas determinado.
	 * <b> Pre: El parametro medico, fecha1 y fecha2 debe ser distinto de null.</b>
	 * <b> Post:Se muestra el reporte de pacientes del medico introducido.</b>
	 * @param medico:Parametro de tipo medico.
	 * @param fecha1: Parametro de tipo GregorianCalendar.
	 * @param fecha2  Parametro de tipo GregorianCalendar.
	 */
	public void reporteMedico(IMedico medico, GregorianCalendar fecha1,GregorianCalendar fecha2) {
		 double importeTotal = 0;
          Iterator<Factura> it = this.facturas.iterator();
		  
		   while(it.hasNext()) {
			Factura actual = it.next(); // nodo de la lista
		    Iterator<Prestacion> prestaciones = actual.getPrestaciones().iterator();  // sublista
		    while(prestaciones.hasNext()) {
		    	Prestacion prestacionActual = prestaciones.next(); // nodo de sublista
		    	if(actual.getFecha().compareTo(fecha1)>=0 && actual.getFecha().compareTo(fecha2)<=0 && prestacionActual.getPrestacion().equals(medico.getNombre()+" "+medico.getMatricula())) {
		    		System.out.println("Paciente: "+actual.getPaciente().getNombre()+" "+ actual.getPaciente().getApellido()+" -Cantidad: "+prestacionActual.getCantidad()+" -Subtotal: "+prestacionActual.getSubtotal());
		    		importeTotal+=prestacionActual.getSubtotal();
		    	}	
		    }			
		   }
		   System.out.println("Importe Total: "+importeTotal);
	}
	
	/** Metodo que busca la historia clinica de un paciente mediante su nro de historia clinica
	 * @param nro: numero de historia cliniaca.
	 * @return: Devuelve la historia clinica correspondiente a el nro.
	 */
	public HistoriaClinica buscaHistoria(int nro) {
		HistoriaClinica retorno = null;
		boolean existe = false;
		Iterator<HistoriaClinica> it = this.pacientes.getPacientesBD().iterator();
		while(it.hasNext() && !existe) {
			HistoriaClinica actual = it.next();
			if(actual.getPaciente().getNumeroHistoria()==nro) {
				existe=true;
				retorno = actual;
			}
				
		}
		
		return retorno;
	}

	/**Metodo que busca y devuelve una coleccion de facturas en un rango de fechas
	 *  <b> Pre: El  fecha1 y fecha2 debe ser distinto de null.</b>
	 * <b> Post:Se devuelve una coleccion de facturas.</b>
	 * @param inicio: Parametro de tipo Gregorian Calendar.
	 * @param fin: Parametro de tipo Gregorian Calendar.
	 * @return: Coleccion de tipo Factura.
	 */
	public ArrayList<Factura> buscaFacturas(GregorianCalendar inicio, GregorianCalendar fin){
		ArrayList<Factura> aux = new ArrayList<>();

		for (Factura fac:facturas) {
			
			if (fac.getFecha().compareTo(inicio)>=0 && fac.getFecha().compareTo(fin)<=0 && fac.getPrestaciones().size() >0){
				aux.add(fac);
			}
		}
		return aux;
	}


	public SalaDeEspera getSalaEspera() {
		return salaEspera;
	}
	public ArrayList<Paciente> getPatio() {
		return patio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Queue<Paciente> getListaEspera() {
		return listaEspera;
	}
	public void setListaEspera(Queue<Paciente> listaEspera) {
		this.listaEspera = listaEspera;
	}
	public Queue<Paciente> getListaAtencion() {
		return listaAtencion;
	}
	public void setListaAtencion(Queue<Paciente> listaAtencion) {
		this.listaAtencion = listaAtencion;
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
	public HashMap<Integer, Habitacion> getHabitaciones() {
		return habitaciones;
	}
	public void setHabitaciones(HashMap<Integer, Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
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
	public void setSalaEspera(SalaDeEspera salaEspera) {
		this.salaEspera = salaEspera;
	}
	public void setPatio(ArrayList<Paciente> patio) {
		this.patio = patio;
	}
	public int getNroFactura() {
		return nroFactura;
	}
	public void setNroFactura(int nroFactura) {
		this.nroFactura = nroFactura;
	}
	

	@Override
	public String toString() {
		return "Clinica [ nombre=" + nombre + ", direccion=" + direccion + ", salaEspera="
				+ salaEspera + ", patio=" + patio + ", listaEspera=" + listaEspera + ", listaAtencion=" + listaAtencion
				+ ", habitaciones=" + habitaciones + ", medicos=" + medicos;
	}
	
					
	}