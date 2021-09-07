package modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class BeerHouse {
    public ArrayList<Mesa> mesas = new ArrayList<Mesa>();
    public int cantMesas;
    public ArrayList<Producto> carta=new ArrayList<>();
    private String estado = "Cerrado";
    private static 	BeerHouse instancia=null;
    
    private BeerHouse(){
    	
    	this.carta.add(new Producto("Fideos con Crema",200));
    	this.carta.add(new Producto("Cerveza",100));
    	this.carta.add(new Producto("Hamburguesa con papas",600));
    }
    public static BeerHouse getInstance(){
    	if(instancia == null)
    		instancia =  new BeerHouse();
    	
    	return instancia;
    }
    public void abrirLocal(int cantMesas){
    	assert cantMesas  > 1:"La cantidad de mesas debe ser mayor a 1";
    	assert carta.size() >  1: "La cantidad de productos debe ser mayor a 1";
        
    	this.estado="Abierto";
        for(int i=0;i<cantMesas;i++){
            this.mesas.add(new Mesa());
        }
    }   
    public void cerrarLocal(){
    	this.mesas = null;
    	this.estado = "Cerrado";
    }

    public void ocuparMesa(int nroMesa) throws NoExisteMesaException{
      Mesa mesa  = this.buscaMesa(nroMesa);
      if(mesa == null)
    	  throw new NoExisteMesaException("No existe la mesa que quiere ocupar");
      if(!mesa.ocupado())
    	  mesa.asignaMesa();
    }
    public void cerrarMesa(int nroMesa) throws NoExisteMesaException{
    	Mesa mesa  = this.buscaMesa(nroMesa);
        if(mesa == null)
      	  throw new NoExisteMesaException("No existe la mesa que quiere cerrar");
        
        if(mesa.ocupado())
        	mesa.liberaMesa();
    }

    public Mesa buscaMesa(int nroMesa) {
    	  Iterator<Mesa> it = this.mesas.iterator();
    	  Mesa mesa = null;
    	  boolean encontro = false;
          while(it.hasNext() && !encontro) {
        	  mesa  = it.next();
        	  if(mesa.getnMesa() == nroMesa)
        		  encontro = true;
          }
          
          if(!encontro)
        	  mesa  = null;
          return mesa;
   }
}
