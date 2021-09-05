package modelo;

import controlador.Controlador;
import excepciones.ExcesoCombustibleException;
import excepciones.MangueraActivadaException;
import excepciones.NoHayMasCombustibleException;

public class Surtidor {
    private float cantCombustible;
    private boolean mangueraActivada1,mangueraActivada2;
    private static final int MAX_CANT = 2000;
    float acumuladoManguera1, acumuladoManguera2, ultimaventaManguera1, ultimaventaManguera2;

    public Surtidor(float cantCombustible) {
        this.cantCombustible = cantCombustible;
        acumuladoManguera1 = 0;
        acumuladoManguera2 = 0;
        ultimaventaManguera1 = 0;
        ultimaventaManguera2 = 0;
        mangueraActivada1=false;
        mangueraActivada2=false;
    }

    public void cargarSurtidor(float carga) throws ExcesoCombustibleException {
        if (this.cantCombustible + carga <= MAX_CANT)
            this.cantCombustible += carga;
        else throw new ExcesoCombustibleException();

    }

    public void activarManguera1() throws MangueraActivadaException {
        float acumulador =0;
        if (!mangueraActivada1){
            mangueraActivada1 = true;
            while (mangueraActivada1){
                try {
                    this.quitarLitro();
                    acumulador++;
                    Controlador.updateVentana(this.cantCombustible);
                    Thread.sleep(1000);
                } catch (NoHayMasCombustibleException e){
                    mangueraActivada1 = false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ultimaventaManguera1 = acumulador;
            acumuladoManguera1 += acumulador;
        } else {
            throw new MangueraActivadaException();
        }
    }

    public void activarManguera2() throws MangueraActivadaException {
        float acumulador =0;
        if (!mangueraActivada2){
            mangueraActivada2 = true;
            while (mangueraActivada2){
                try {
                    this.quitarLitro();
                    acumulador++;
                    Controlador.updateVentana(this.cantCombustible);
                    Thread.sleep(1000);
                } catch (NoHayMasCombustibleException e){
                    mangueraActivada2 = false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ultimaventaManguera2 = acumulador;
            acumuladoManguera2 += acumulador;
        } else {
            throw new MangueraActivadaException();
        }
    }

    public void desactivarManguera1(){
        mangueraActivada1 = false;
    }

    public void desactivarManguera2(){
        mangueraActivada2 = false;
    }

    private synchronized void quitarLitro() throws NoHayMasCombustibleException {
        if (cantCombustible>0)
            this.cantCombustible--;
        else throw new NoHayMasCombustibleException();
    }

    public float getCantCombustible() {
        return cantCombustible;
    }

    public void setCantCombustible(float cantCombustible) {
        this.cantCombustible = cantCombustible;
    }

    public float getAcumuladoManguera1() {
        return acumuladoManguera1;
    }

    public void setAcumuladoManguera1(float acumuladoManguera1) {
        this.acumuladoManguera1 = acumuladoManguera1;
    }

    public float getAcumuladoManguera2() {
        return acumuladoManguera2;
    }

    public void setAcumuladoManguera2(float acumuladoManguera2) {
        this.acumuladoManguera2 = acumuladoManguera2;
    }

    public float getUltimaventaManguera1() {
        return ultimaventaManguera1;
    }

    public void setUltimaventaManguera1(float ultimaventaManguera1) {
        this.ultimaventaManguera1 = ultimaventaManguera1;
    }

    public float getUltimaventaManguera2() {
        return ultimaventaManguera2;
    }

    public void setUltimaventaManguera2(float ultimaventaManguera2) {
        this.ultimaventaManguera2 = ultimaventaManguera2;
    }
}
