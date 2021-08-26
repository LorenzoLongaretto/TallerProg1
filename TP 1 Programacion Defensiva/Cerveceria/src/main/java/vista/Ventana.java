package vista;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {

    private JPanel mainPanel;
    private JPanel northPanel;
    private JPanel centerPanel;


    private JLabel titulo;

    public Ventana(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 250, 200);
        setTitle("Cerveceria");
        mainPanel = new JPanel();
        setContentPane(mainPanel);
        mainPanel.setLayout(new BorderLayout(0, 0));

        northPanel = new JPanel();
        titulo = new JLabel("Cerveceria NoSomosAntares S.A");
        northPanel.add(titulo);

        mainPanel.add(northPanel,BorderLayout.NORTH);

        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3,2));
        mainPanel.add(centerPanel,BorderLayout.CENTER);

        for (int i=0;i<6;i++){
            JTextArea text = new JTextArea();
        }
    }
}
