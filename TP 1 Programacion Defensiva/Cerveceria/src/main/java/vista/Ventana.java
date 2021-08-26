package vista;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    private JPanel mainPanel;

    private JLabel titulo;

    public Ventana(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 950, 800);
        setTitle("Cerveceria");
        mainPanel = new JPanel();
        setContentPane(mainPanel);
        mainPanel.setLayout(new BorderLayout(0, 0));

        titulo = new JLabel("Cerveceria NoSomosAntares S.A");
        mainPanel.add(titulo, BorderLayout.NORTH);
    }
}
