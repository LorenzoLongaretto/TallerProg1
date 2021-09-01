package controlador;

import vista.Ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
    private static Ventana ventana;
    public Controlador() {
        ventana = new Ventana();
        ventana.setVisible(true);
        ventana.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void updateVentana(float value){
        this.ventana.updateBar(value);
    }
}
