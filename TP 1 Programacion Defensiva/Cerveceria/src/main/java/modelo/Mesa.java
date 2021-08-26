package modelo;

public class Mesa {
    private char estado;
    private float total;

    public void assignaMesa(){

    }
    public void cambiaEstado(char nuevoEstado){
        this.estado=nuevoEstado;
    }
    public boolean ocupado(){
        return this.estado=='O';
    }

}
