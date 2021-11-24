package app;

public class NumeroAzar {
    private static int numero;

    private NumeroAzar(int numero) {
        this.numero = numero;
    }

    public static int getNumero() {
    if (numero != -1)
        return numero;
    else
        return (int) Math.floor(Math.random()*31+1);
    }

    public static void setNumero(int numero) {
        NumeroAzar.numero = numero;
    }
}
