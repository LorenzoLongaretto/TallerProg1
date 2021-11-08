package usuarios;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TreeSet;

import exceptions.FechaInvalidaException;
import factura.Reporte;

/**
 * Interfaz de medico, define el calculo de Honorario de cada tipo de medico
 */
public abstract class Medico extends Usuarios {
   protected double Honorario;
   protected TreeSet<Reporte> reporte = new TreeSet<Reporte>();

   public Medico(String dni, String domicilio, String ciudad, String telefono, String nombre, int numero,
                 double honorarioBasico) {
      super(dni, domicilio, ciudad, telefono, nombre, numero);
      this.Honorario = honorarioBasico;
   }

   public Medico() {
   }

   public void setHonorario(double honorario) {
      Honorario = honorario;
   }

   public void setReporte(TreeSet<Reporte> reporte) {
      this.reporte = reporte;
   }

   /**
    * Obtiene el Honorario del medico generado
    * 
    * @return honorario con su aumento dependiendo de su especialidad, tipo de
    *         contratacion y posgrado
    */
   public abstract void setHonorario();

   /**
    * Retorna el honorario del medico
    * 
    * @return double
    */
   public double getHonorario() {
      return Honorario;
   }

   /**
    * Retorna el treeset de reportes
    * 
    * @return TreeSet<Reporte>
    */
   public TreeSet<Reporte> getReporte() {
      return reporte;
   }

   /**
    * PRE: Se espera que f1 sea una fecha en la que mas adelante se encuentre algun
    * reporte<br>
    * POST: Muestra por cada reporte los datos: Nombre del paciente, fecha de
    * facturacion, cantidad de consultas realizadas por el paciente, y el subtotal
    * que cobra el medico
    * 
    * @param f1
    * @param f2
    * @throws FechaInvalidaException
    */
   public void muestraReporte(GregorianCalendar f1, GregorianCalendar f2) throws FechaInvalidaException {
      double total = 0;
      Iterator<Reporte> it = reporte.iterator();
      Reporte[] aux = reporte.toArray(new Reporte[reporte.size()]);

      // it.next().getFecha().compareTo(f1) < 0
      System.out.println("Reporte medico: " + this.nombre);
      System.out.format("Fecha: %tF - %tF%n", f1, f2);

      // While que busca f1 en adelante
      int i = 0;
      while (i < aux.length && aux[i].getFecha().compareTo(f1) < 0) {
         i++;
      }
      if (i < aux.length) {
         while (i < aux.length && aux[i].getFecha().compareTo(f2) <= 0) {
            System.out.println(aux[i]);
            total += aux[i].getSubtotal();
            i++;
         }
         System.out.format("El total generado por este medico es: %8.2f", total);
      } else {
         throw new FechaInvalidaException("No se ha encontrado reportes a partir de la fecha ingresada\n");
      }

   }

   @Override
   public String toString() {
      return nombre;
   }
}
