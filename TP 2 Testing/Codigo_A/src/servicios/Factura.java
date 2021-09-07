package servicios;

import java.util.ArrayList;
import agregado.Celular;
import agregado.DecoratorAgregado;
import agregado.TV_Cable;
import agregado.Telefono;
import interfaces.I_Contratable;
import interfaces.I_Pago;
import personas.Persona;

/**
 * @author Taller1
 * <br>
 *Clase que representa una Factura
 */
public class Factura implements Cloneable {
    private Persona persona;
    private ArrayList <I_Contratable> listaContrataciones;
    private double totalSinP; //porcentaje ya que, dependiendo del tipo de pago se hace un incremento o descuento
    private double totalConP;
        
	/**
	 * Constructor con un parametro de persona para setear la persona, inicializar la lista de Contrataciones e inicializar en cero totalSinP y totalConP
	 * <br>
	 * @param persona: Parametro de tipo Persona que representa al titular o abonado de la factura
	 */
	public Factura(Persona persona) {
		this.persona=persona;
		this.listaContrataciones=new ArrayList <I_Contratable>();
		this.totalConP=0;
		this.totalSinP=0;
	}
        
        /**
	* @return el cliente de la factura
        */
	public Persona getPersona() {
		return  this.persona;
	}
	 /**
	* @return el Total de la Factura sin impuestos
        */
	public double getTotalSinP() {
		return totalSinP;
	}
         /**
	* @return el total de la Factura con Impuestos
        
        */
	public double getTotalConP() {
		return totalConP;
	}
         /**
	* @return la lista de servicios contratados.
        */
	public ArrayList<I_Contratable> getListaContrataciones() {
		return listaContrataciones;
	}
	/**
	 * Agrega una nueva linea de contratacion a la factura
	 * <b>Pre: </b> I_Contratable debe ser distinto de null <br>
	 * <b>Post: </b> Se agrega una contratacion mas a la lista<br>
	 * @param iContratable : Parametro que sera agregado a nuestra factura
	 */
	public void nuevaContratacion(I_Contratable iContratable) {
    	this.listaContrataciones.add(iContratable);
    }
	
	/**
	 * Busca una linea contratacion de acuerdo al domicilio ingresado
	 * <b>Pre: </b> El parametro domicilio tiene que exisitr y distinto de null o cadena vacia <br>
	 * <b>Post: </b> Encuentra la posicion de la linea de contratacion<br>
	 * @param domicilioPersona: Parametro que se usa para buscar la linea de contratacion
	 * @return Devuelve el valor de tipo int la posicion de la linea de contratacion buscada
	 */
	public int buscaContratacion(String domicilioPersona) { 
		int res=0;
		if (!this.listaContrataciones.isEmpty()) {
			int i=0;
			while(i<this.listaContrataciones.size() && this.listaContrataciones.get(i).getDomicilio().getDireccion().equals(domicilioPersona) ) 
				i++;
			if (i<this.listaContrataciones.size())
				res=i;
		}
		return res;
	}
	/**
	 * Cambia o quitar algun servicio o agregado
	 * <b>Pre: </b> I_Contratable debe ser distinto de null <br>
	 * <b>Post: </b> Se agrega una contratacion mas a la lista<br>
	 * @param pos: Parametro de tipo int que representa el ID de la linea de contratacion
	 * @param accion: Parametro de tipo String que representa la accion tales como modificar o quitar
	 * @param servicio: Parametro de tipo String que representa el servicio a modificar o quitar algun agregado
	 */
	public void modificaContratacion(int pos,String accion,String servicio) { 
		int cantCelulares=0,cantFijo=0,cantTV=0;									
		accion=accion.toUpperCase();
		servicio=servicio.toUpperCase();
		I_Contratable contratable= this.listaContrataciones.get(pos);
		while(contratable.isCelular() || contratable.isTelefono() || contratable.isTV_Cable()) { 
			DecoratorAgregado decorador= (DecoratorAgregado) contratable;
			if (contratable.isCelular()) {
				cantCelulares= decorador.getCantLineas();
			}
			else if (contratable.isTelefono()) {
				cantFijo=decorador.getCantLineas(); 
			}
			else if (contratable.isTV_Cable()) {
				cantTV= decorador.getCantLineas();
			}
			contratable= decorador.getContratable();
		}	
		I_Contratable reemplazo= contratable;
		Servicio s= (Servicio) contratable;
		Domicilio domicilio= s.getDomicilio();
		
		if (accion.equals("CAMBIAR")) {
			if (servicio.equals("INTERNET100")) 
				reemplazo= new Internet100(domicilio,s.getID());
			 else if(servicio.equals("INTERNET500"))
				reemplazo= new Internet500(domicilio,s.getID());
		}
		else if (accion.equals("QUITAR")) {
			if (servicio.equals("TVCABLE"))
				 cantTV--;
			if (servicio.equals("CELULAR"))
				 cantCelulares--;
			if (servicio.equals("TELEFONO FIJO"))
				 cantFijo--;
		}
		else if (accion.equals("AGREGAR")) {
			if (servicio.equals("TVCABLE"))
				 cantTV++;
			if (servicio.equals("CELULAR"))
				 cantCelulares++;
			if (servicio.equals("TELEFONO FIJO"))
				 cantFijo++;
		}
		if (cantTV>0) { //ACTUALIZAR
			I_Contratable auxreemplazo= new TV_Cable(cantTV,reemplazo);
			reemplazo=auxreemplazo;
		}
		if (cantCelulares>0) {
			I_Contratable auxreemplazo= new Celular(cantCelulares,reemplazo);
			reemplazo=auxreemplazo;
		}
		if (cantFijo>0) {
			I_Contratable auxreemplazo= new Telefono(cantTV,reemplazo);
			reemplazo=auxreemplazo;
		}
		this.listaContrataciones.set(pos, reemplazo);
	}
	
	/**
	 * Elimina o da de baja un servicio 
	 * <b>Pre: </b> El parametro posicion debe ser numero positivo y debe existir<br>
	 * <b>Post: </b> Se elimina una linea de contratacion de la factura<br>
	 * @param posicion: Parametro de tipo int que representa la posicion de dicha linea de contratacion dentro de la lista de contrataciones.
	 */
	public void eliminaContratacion(int posicion) {
		this.listaContrataciones.remove(posicion);
	}
	
	/**
	 * Calcula el precio total a abonar aplicando el medio de pago
	 * <b>Pre: </b> I_Contratable debe ser distinto de null <br>
	 * <b>Post: </b> Se agrega una contratacion mas a la lista<br>
	 * @param persona: Parametro de tipo Persona que representa al abonado de la factura
	 * @param tipo: Parametro de tipo I_Pago que representa el medio de pago
	 */
	public void precioFinal (Persona persona,I_Pago tipo) {
		double total=0;
		for(int i=0;i<this.listaContrataciones.size();i++) {
			total+=this.listaContrataciones.get(i).getPrecio();
		}
		this.totalSinP=total;
		this.totalConP=persona.aplicarPorcentaje(tipo, total);
	}
	
	/**
	 * Metodo de clonacion de factura
	 *@return Devuelve un clon de factura
	 *@throws CloneNotSupportedException : se lanza cuando no es posible clonar la factura
	 */
	@SuppressWarnings("unchecked")
	@Override
    public Object clone() throws CloneNotSupportedException 
    {
        Factura facturaClonada=null;
        facturaClonada=(Factura) super.clone();
        facturaClonada.persona=(Persona) this.persona.clone();
        facturaClonada.listaContrataciones=(ArrayList<I_Contratable>) this.listaContrataciones.clone(); 
        facturaClonada.listaContrataciones.clear();
        for(int i=0;i<this.listaContrataciones.size();i++)
        	facturaClonada.listaContrataciones.add((I_Contratable)this.listaContrataciones.get(i).clone());
        return facturaClonada;
        
        
    }
	/**
	 * @return Devuelve toda la informacion detallada de la lista de contrataciones
	 */
	public String listarContrataciones() {
		StringBuilder sb= new StringBuilder();
		int i=0;
		while(i<this.listaContrataciones.size()) {
			sb.append("ID: " + this.listaContrataciones.get(i).getID()+" "+ this.listaContrataciones.get(i).toString()+"\n");
			i++;
		}
		return sb.toString();	
	}
	
	/**
	 * Actualiza el precio del plan de internet + Servicios de una factura antes de abonar.
	 */
	public void actualizaPrecio() {
		if (this.totalConP==0) 
			for (int i=0;i<this.listaContrataciones.size();i++) 
				this.totalConP+=this.listaContrataciones.get(i).getPrecio();	
	}
	
}
