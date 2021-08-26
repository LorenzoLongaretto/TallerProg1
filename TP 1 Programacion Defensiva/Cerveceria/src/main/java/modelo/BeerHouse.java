package modelo;

import java.util.ArrayList;

public class BeerHouse {
    public ArrayList<Mesa> mesas = new ArrayList<Mesa>();
    public int cantMesas;
    public ArrayList<Producto> carta=new ArrayList<>();
    private String estado;
    public void abrirLocal(int cantMesas){
        this.estado="Abierto";
        for(int i=0;i<cantMesas;i++){
            this.mesas.add(new Mesa());
        }

    }

    public void cerrarLocal(){}

    public Mesa ocuparMesa(int nroMesa){
        return null;
    }
    public float cerrarMesa(int nroMesa){
        return (float)0.0;
    }




}
