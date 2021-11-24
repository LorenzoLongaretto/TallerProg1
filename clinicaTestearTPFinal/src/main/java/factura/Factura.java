package factura;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

import exceptions.DiasInvalidosException;
import exceptions.PacienteInvalidoException;
import lugares.Habitacion;
import usuarios.Medico;
import usuarios.Paciente;

import javax.swing.*;

import clinica.Clinica;

/**
 * Esta clase brinda informacion sobre el transcurso del paciente en la clinica
 */

public class Factura implements Comparable<Factura> {
    private static int numFacturaMax = 0;
    private int numFactura;
    private Paciente paciente;
    private GregorianCalendar fecha;
    private LinkedList<Double> prestaciones=new LinkedList<>();
    private double costoTotalFactura;

    private final float valorAgregadoConsulta = 0.2f;
	public Factura(Paciente paciente, GregorianCalendar fecha) throws PacienteInvalidoException {
        numFacturaMax++;
        numFactura = numFacturaMax;
        this.fecha = fecha;
        if (paciente != null)
            this.paciente = paciente;
        else
            throw new PacienteInvalidoException("Se trato de crear una factura con un paciente null");
    }

    public Factura() {
    }
    
    
        public static int getNumFacturaMax() {
        return numFacturaMax;
    }

    public static void setNumFacturaMax(int numFacturaMax) {
        Factura.numFacturaMax = numFacturaMax;
    }

    public int getNumFactura() {
        return numFactura;
    }

    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public float getValorAgregadoConsulta() {
        return valorAgregadoConsulta;
    }
    
    private void agregaprestacion(double valor)
    {
    	this.prestaciones.add(valor);
    }
   
    public double sumaprestacionesimpares() 
    {
    	double respuesta=0;
    	for(int i=0;i<this.prestaciones.size();i++) {
    		if(this.prestaciones.get(i)%2 != 0)
    		respuesta+=(double)this.prestaciones.get(i);
    	}
    	return respuesta;
    }
    
    
    public double getCostoTotalFactura() {
		return costoTotalFactura;
	}

	public void setCostoTotalFactura(double costoTotalFactura) {
		this.costoTotalFactura = costoTotalFactura;
	}

	/**
     * Imprime la factura con los datos de Prestacion, Valor, Cantidad, Subtotal
     * Post: Imprime en formato de tabla la informacion
     */
    public void ImprimeFacturaConsola() {
        System.out.print("\nFactura numero: " + numFactura + "\n");

        int contadorDatos = 0;

        float costoTotal = 0;

        Hashtable<Medico, Integer> consultas = paciente.getConsultas();
        Hashtable<Habitacion, Integer> internaciones = paciente.getInternaciones();

        Object[][] datos = new Object[consultas.size() + internaciones.size()][4];

        Enumeration<Medico> enumMedicos = consultas.keys();
        while (enumMedicos.hasMoreElements()) {
            Medico medActual = enumMedicos.nextElement();
            datos[contadorDatos][0] = medActual.getNombre();
            datos[contadorDatos][1] = medActual.getHonorario() * valorAgregadoConsulta;
            datos[contadorDatos][2] = consultas.get(medActual);
            datos[contadorDatos][3] = medActual.getHonorario() * valorAgregadoConsulta * consultas.get(medActual);
            costoTotal += medActual.getHonorario() * valorAgregadoConsulta * consultas.get(medActual);
         
          
            	agregaprestacion((double)datos[contadorDatos][3]);
            
            contadorDatos++;
        }

        Enumeration<Habitacion> enumHabitaciones = internaciones.keys();
        while (enumHabitaciones.hasMoreElements()) {
            Habitacion habActual = enumHabitaciones.nextElement();
            datos[contadorDatos][0] = habActual.IDTipoHabitacion();
            datos[contadorDatos][1] = habActual.getCostoAsignacion();
            datos[contadorDatos][2] = internaciones.get(habActual);
            try {
                datos[contadorDatos][3] = habActual.calculaArancel(internaciones.get(habActual));
                costoTotal += habActual.calculaArancel(internaciones.get(habActual));
            } catch (DiasInvalidosException e) {
                e.fillInStackTrace();
            }
            
           
            	agregaprestacion((double)datos[contadorDatos][3]); 
        
            contadorDatos++;
        }

        System.out.format("%25s | %11s | %8s | %7s%n", "Prestacion", "Valor", "Cantidad", "Subtotal");

        for (final Object[] entrada : datos) {
            System.out.format("%25s | $%10.2f | %8d | $%7.2f%n", entrada);
        }
        
        this.costoTotalFactura=costoTotal;
        System.out.format("\nTotal: $%8.2f%n", costoTotal);

    }

    /**
     * Genera la factura con los datos de Prestacion, Valor, Cantidad, Subtotal
     *
     * @return Retorna un StringBuilder con la factura del mismo.
     */
    public StringBuilder ImprimeFactura() {
        StringBuilder sb = new StringBuilder();

        sb.append("\nFactura numero: " + numFactura + "\n" +
                "Fecha: " + this.fecha.getTime() + '\n');

        int contadorDatos = 0;

        float costoTotal = 0;

        Hashtable<Medico, Integer> consultas = paciente.getConsultas();
        Hashtable<Habitacion, Integer>  internaciones = paciente.getInternaciones();

        Object[][] datos = new Object[consultas.size() + internaciones.size()][4];

        Enumeration<Medico> enumMedicos = consultas.keys();

        while (enumMedicos.hasMoreElements()) {
            Medico medActual = enumMedicos.nextElement();
            datos[contadorDatos][0] = medActual.getNombre();
            datos[contadorDatos][1] = medActual.getHonorario() * valorAgregadoConsulta;
            datos[contadorDatos][2] = consultas.get(medActual);
            datos[contadorDatos][3] = medActual.getHonorario() * valorAgregadoConsulta * consultas.get(medActual);
            costoTotal += medActual.getHonorario() * valorAgregadoConsulta * consultas.get(medActual);

            contadorDatos++;
        }

        Enumeration<Habitacion> enumHabitaciones = internaciones.keys();
        while (enumHabitaciones.hasMoreElements()) {
            Habitacion habActual = enumHabitaciones.nextElement();
            datos[contadorDatos][0] = habActual.IDTipoHabitacion();
            datos[contadorDatos][1] = habActual.getCostoAsignacion();
            datos[contadorDatos][2] = internaciones.get(habActual);
            try {
                datos[contadorDatos][3] = habActual.calculaArancel(internaciones.get(habActual));
                costoTotal += habActual.calculaArancel(internaciones.get(habActual));
            } catch (DiasInvalidosException e) {
                e.fillInStackTrace();
            }

            contadorDatos++;
        }

        sb.append(String.format("%25s \t| %20s \t| %10s \t| %10s \n", "Prestacion", "Valor", "Cantidad", "Subtotal"));

        for (final Object[] entrada : datos) {
            sb.append(String.format("%25s \t| $%15.2f \t| %10d \t| $%10.2f \n", entrada));
        }

        sb.append(String.format("\nTotal: $%8.2f\n", costoTotal));
        

        return sb;
    }


    public GregorianCalendar getFecha() {
        return fecha;
    }

    @Override
    public int compareTo(Factura o) {
        return this.fecha.compareTo(o.fecha);

    }
}
