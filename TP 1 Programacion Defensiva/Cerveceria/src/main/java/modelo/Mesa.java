package modelo;

public class Mesa {
    private static int numeroMesa=0;
    private int nMesa;
    private char estado;
    private float total;

    public Mesa(){
        numeroMesa++;
        this.nMesa=numeroMesa;
    }

    public int numeroDeMesa(){
        return this.nMesa;
    }
    public void sumarGasto(float nuevoGasto) throws Exception {
        if(this.ocupado()) {
            this.total += nuevoGasto;
        }else{
            throw new Exception();
        }
    }
    public void assignaMesa(){
        this.total=0;
        this.estado='O';
    }

    public float liberaMesa(){
        this.estado='L';
        return this.total;

    }
    public boolean ocupado(){
        return this.estado=='O';
    }

}