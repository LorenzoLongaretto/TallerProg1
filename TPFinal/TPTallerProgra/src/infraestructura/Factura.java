package infraestructura;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import personas.Paciente;
import modelo.Clinica;
import modelo.IMedico;

/**
 *
 * <br>
 * Clase que corresponde a una factura.
 *
 */
public class Factura implements Serializable,Comparable{
	
	private int nroFactura;
	private GregorianCalendar fecha;

    /**
     * @aggregation composite
     */
    private Paciente paciente;
	private double importeTotal=0;

    /**
     * @aggregation composite
     */
    private ArrayList <Prestacion> prestaciones = new ArrayList <Prestacion>();
	
	
	 public Factura(int nroFactura, GregorianCalendar fecha,Paciente paciente) {
		 this.paciente=paciente;
		this.nroFactura = nroFactura;
		this.fecha = fecha;
	}

	/**Se le asigna una prestacion medica a la factura.
	 * <b> Pre: El medico debe ser distinto de null.</b>
	 * <b> Post: Se le agrega una prestacion medica a la factura, en base a los honorarios del medico.</b>
	 * @param medico: Parametro de tipo medico.
	 */
	public void asignarMedico(IMedico medico) {
		Iterator<Prestacion> it = this.prestaciones.iterator();
		int existe=0;
		while(it.hasNext()) {
			Prestacion prestacionActual = it.next();
			if((medico.getNombre()+" "+medico.getMatricula()).equals(prestacionActual.getPrestacion())) {
				existe=1;
				prestacionActual.setCantidad(prestacionActual.getCantidad() + 1);
				prestacionActual.setSubtotal(prestacionActual.getValor()*prestacionActual.getCantidad());
			}
				
		}
		if(existe==0) {
			Prestacion nueva = new Prestacion(medico.getNombre()+" "+medico.getMatricula(),medico.getHonorario()*1.2,1);  // Ponemos nombre y matricula por si hay dos medicos con el mismo nombre
			nueva.setSubtotal(nueva.getCantidad()*nueva.getValor());
			this.prestaciones.add(nueva);
			
		}
		this.importeTotal+=medico.getHonorario()*1.2;
	}
	 
	 /**Se le asigna una prestacion de tipo internacion a la factura.
	  * <b> Pre:La habitacion de ser distinto de null.</b>
	 * <b> Post: Se le agrega una prestacion de internacion a la factura, en base a los costos de la habitacion.</b>
	 * @param habitacion: Parametro de tipo habitacion.
	 */
	public void asignarHabitacion(Habitacion habitacion) {
		 Prestacion nueva = new Prestacion(habitacion.toString(),habitacion.getCostoAsignacion(),habitacion.getCantDias());
		 nueva.setSubtotal(habitacion.costoDeHabitacion(habitacion.getCantDias()));	
		 this.prestaciones.add(nueva);
		 this.importeTotal+=habitacion.costoDeHabitacion(habitacion.getCantDias());
		 habitacion.setCantPersonas(habitacion.getCantPersonas()-1);
			
		}

    /**Metodo que libera las habitaciones ocupadas por la factura, para que luego las mismas puedan ser utilizadas.
     * 
     */
    public void liberarHabitaciones() {
    	Iterator<Prestacion> it = this.prestaciones.iterator();
    	String nro="";
    	while(it.hasNext()) {
    		Prestacion  actual = it.next();
    		if(actual.getPrestacion().startsWith("H")) {// es habitacion
    			int i=0;
    			while(actual.getPrestacion().charAt(i)!='D') { // recorro hasta encontrar un nro
    				if(actual.getPrestacion().charAt(i)>='1' && actual.getPrestacion().charAt(i)<='9' )// es nro
    					nro+=actual.getPrestacion().charAt(i);	
    			i++;	
    			}
    			
    		}
    		if(!nro.equals("")) {
				int nroHabitacion = Integer.parseInt(nro);
				Habitacion habitacion = Clinica.getInstance().buscaHabitacion(nroHabitacion);
				habitacion.setCantPersonas(habitacion.getCantPersonas() + 1);
			}
    	}	
    }
	public Paciente getPaciente() {
		return paciente;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat sdf =
				new SimpleDateFormat("EEEEE dd 'de' MMMMMMMMM 'de' yyyy");
		return "--Factura Nro: "+nroFactura +"--Fecha: "+sdf.format(fecha.getTime()) +"--Paciente: "+this.paciente.getNombre() +" "+this.paciente.getApellido();   // Hay que cambiar esto para que muestre bien la fecha
	 
	}
	/*public void muestraFactura() {
		
		for (Prestacion prestaciones : this.prestaciones) 
		       System.out.println(prestaciones.toString());
		
		System.out.println("Importe Total: "+this.importeTotal);
		
	
	}*/
	public double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}

	public ArrayList<Prestacion> getPrestaciones() {
		return prestaciones;
	}

	public void setPrestaciones(ArrayList<Prestacion> prestaciones) {
		this.prestaciones = prestaciones;
	}

	@Override
	public int compareTo(Object o) {
		
		Factura factura = (Factura) o; 
		int respuesta;
		
		if(this.fecha.compareTo(factura.fecha)!=0)
			respuesta = this.fecha.compareTo(factura.fecha);
		else {
			respuesta = this.paciente.getNumeroHistoria() - factura.paciente.getNumeroHistoria();
		}
			
		return respuesta;
	}
}
