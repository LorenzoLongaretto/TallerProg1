package controlador;

import vista.Ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
    Ventana ventana;
    public Controlador() {
        ventana = new Ventana();
        ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
