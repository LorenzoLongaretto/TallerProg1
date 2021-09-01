package controlador;

import modelo.Surtidor;
import vista.Ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Controlador implements ActionListener {
    private static Ventana ventana;
    private Surtidor surtidor;

    public Controlador() {
        Random rand = new Random();
        surtidor = new Surtidor(rand.nextInt(2000));
        ventana = new Ventana();
        ventana.setVisible(true);
        ventana.setActionListener(this);
        updateVentana(surtidor.getCantCombustible());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals("CargarSurtidor")) {
            this.surtidor.cargarSurtidor(Float.parseFloat(ventana.getCantidadCarga()));
        } else if (comando.equals("Activar1")) {
            new Thread(() -> this.surtidor.activarManguera1()).start();
            ventana.encendidaMangueraUno(true);
        } else if (comando.equals("Activar2")) {
            new Thread(() -> this.surtidor.activarManguera2()).start();
            ventana.encendidaMangueraDos(true);
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
