package controlador;

import modelo.Juego;
import vista.Ventana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
    Ventana ventana;
    Juego juego = null;

    public Controlador() {
        ventana = new Ventana();
        ventana.setVisible(true);
        ventana.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        String resultado;

        if (comando.equals("NuevaPartida")) {
            juego = new Juego();
        }
        if (juego != null) {
            if (comando.equals("Intentos")) {
                ventana.setIntentos(juego.getIntentos());
            } else if (comando.equals("Probar") && juego.getIntentos()>0) {
                try {
                    resultado = juego.probarNumero(ventana.getNro());
                    ventana.setEstado(resultado);
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"Debe ingresar un numero válido");
                }
            }

        } else {
            JOptionPane.showMessageDialog(null,"No estás en partida. Presioná el botón \"Nueva Partida\"");
        }
    }
}
