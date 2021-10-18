package infraestructura;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Prestacion implements Serializable{
private String prestacion;
private double valor,subtotal;
private int cantidad;
private GregorianCalendar fecha;

public Prestacion(String prestacion, double valor,int cantidad) {
	this.prestacion = prestacion;
	this.valor = valor;
	this.cantidad = cantidad;
}


public double getValor() {
	return valor;
}


public void setValor(double valor) {
	this.valor = valor;
}


public int getCantidad() {
	return cantidad;
}


public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}


public String getPrestacion() {
	return prestacion;
}


public double getSubtotal() {
	return subtotal;
}


public void setSubtotal(double subtotal) {
	this.subtotal = subtotal;
}


public GregorianCalendar getFecha() {
	return fecha;
}


public void setFecha(GregorianCalendar fecha) {
	this.fecha = fecha;
}


@Override
public String toString() {
	return prestacion + "      " + valor + "        " + cantidad + "      "
			+ subtotal;
}



}
