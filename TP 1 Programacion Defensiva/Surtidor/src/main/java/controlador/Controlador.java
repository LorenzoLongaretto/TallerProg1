package controlador;

import excepciones.ExcesoCombustibleException;
import excepciones.MangueraActivadaException;
import modelo.Surtidor;
import vista.Ventana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Controlador implements ActionListener {
    private static Ventana ventana;
    private Surtidor surtidor;

    public Controlador() {
        Random rand = new Random();
        surtidor = new Surtidor(5/*rand.nextInt(2000)*/);
        ventana = new Ventana();
        ventana.setVisible(true);
        ventana.setActionListener(this);
        updateVentana(surtidor.getCantCombustible());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals("CargarSurtidor")) {
            try {
                this.surtidor.cargarSurtidor(ventana.getCantidadCarga());
            } catch (ExcesoCombustibleException ex) {
                JOptionPane.showMessageDialog(null, "No se puede realizar la carga! Se excedería del límite del depósito");
            }
        } else if (comando.equals("Activar1")) {
            new Thread(() ->{
                ventana.encendidaMangueraUno(true);
                try {
                    this.surtidor.activarManguera1();
                    ventana.encendidaMangueraUno(false);
                } catch (MangueraActivadaException ex) {
                    JOptionPane.showMessageDialog(null, "Usted está activando una manguera que ya estaba encendida. Tenga cuidado");
                }

            }).start();

        } else if (comando.equals("Activar2")) {
            new Thread(() ->{
                ventana.encendidaMangueraDos(true);
                try {
                    this.surtidor.activarManguera2();
                    ventana.encendidaMangueraDos(false);
                } catch (MangueraActivadaException ex) {
                    JOptionPane.showMessageDialog(null, "Usted está activando una manguera que ya estaba encendida. Tenga cuidado");
                }

            }).start();
        } else if (comando.equals("Desactivar1")) {
            this.surtidor.desactivarManguera1();
            ventana.encendidaMangueraUno(false);
        } else if (comando.equals("Desactivar2")) {
            this.surtidor.desactivarManguera2();
            ventana.encendidaMangueraDos(false);
        }


        updateVentana(surtidor.getCantCombustible());
    }

    public static void updateVentana(float value) {
        ventana.updateBar(value);
    }


}
