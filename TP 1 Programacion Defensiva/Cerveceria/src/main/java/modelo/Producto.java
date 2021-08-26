package modelo;

public class Producto {
    private static int cantProductos=0;
    private int numProducto;
    private String nombre;
    private float precio;

    public Producto(String nombre,float precio ){
        this.nombre=nombre;
        this.precio=precio;
        cantProductos++;
        this.numProducto=cantProductos;
    }

}
