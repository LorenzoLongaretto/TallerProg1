package modelo;

public class Mesa {
    private static int numeroMesa=0;
    private final int nMesa;
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
            throw new MesaLibreException("La mesa esta libre, no tiene gastos");
        }
    }
    public void asignaMesa(){
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

	public int getnMesa() {
		return nMesa;
	}

}
