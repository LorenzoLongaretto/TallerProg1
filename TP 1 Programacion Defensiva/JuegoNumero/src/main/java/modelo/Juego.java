package modelo;

import java.util.Random;

public class Juego {
    private int numero;
    private int intentos;

    public Juego() {
        Random rand = new Random();
        this.numero = 1+rand.nextInt(100);
        intentos = 10;
    }

    public String probarNumero(int num){
        if (num == this.numero)
            return "ACERTÓ";
        intentos--;
        if (intentos==0)
            return "PERDIÓ";
        else return (num>numero)?"ALTO":"BAJO";
    }


    public int getNumero() {
        return numero;
    }

    public int getIntentos() {
        return intentos;
    }
}
