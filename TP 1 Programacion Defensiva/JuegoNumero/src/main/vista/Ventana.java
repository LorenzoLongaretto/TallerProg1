package main.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {
    JPanel mainPanel;
    private JPanel panel_1;
    private JPanel panel_2;
    private JButton btnNuevaPartida;
    private JTextField textField;
    private JButton btnProbar;
    private JLabel lblNewLabel;
    private JLabel lblIntentos;
    private JButton btnIntentos;
    private JLabel lblNewLabel_2;
    private JLabel lblEstadoNro;
    public Ventana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 750, 350);
        setTitle("Adivinar el numero (1-100)");
        mainPanel = new JPanel();
        

        setContentPane(mainPanel);
        mainPanel.setLayout(new GridLayout(0, 1, 0, 0));
        
        panel_1 = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
        flowLayout_1.setVgap(50);
        mainPanel.add(panel_1);
        
        lblNewLabel_2 = new JLabel("El \u00FAltimo respecto al estado del \u00FAltimo n\u00FAmero probado es:");
        panel_1.add(lblNewLabel_2);
        
        lblEstadoNro = new JLabel("---");
        panel_1.add(lblEstadoNro);
        
        panel_2 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
        flowLayout.setVgap(50);
        mainPanel.add(panel_2);
        
        btnNuevaPartida = new JButton("Nueva partida");
        btnNuevaPartida.setActionCommand("NuevaPartida");
        btnNuevaPartida.setForeground(new Color(165, 42, 42));
        btnNuevaPartida.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel_2.add(btnNuevaPartida);
        
        lblNewLabel = new JLabel("          ");
        panel_2.add(lblNewLabel);
        
        textField = new JTextField();
        panel_2.add(textField);
        textField.setColumns(10);
        
        btnProbar = new JButton("Probar");
        btnProbar.setActionCommand("Probar");
        panel_2.add(btnProbar);
        
        btnIntentos = new JButton("Actualizar intentos restantes");
        btnIntentos.setActionCommand("Intentos");
        panel_2.add(btnIntentos);
        
        lblIntentos = new JLabel("[10]");
        lblIntentos.setFont(new Font("Arial", Font.BOLD, 20));
        panel_2.add(lblIntentos);
    }

    public void setIntentos(int intentos){
        this.lblIntentos.setText("["+String.valueOf(intentos)+"]");
    }

    public int getNro() throws NumberFormatException{
        return Integer.parseInt(textField.getText());
    }


    public void setActionListener(ActionListener listener){
        this.btnNuevaPartida.addActionListener(listener);
        this.btnIntentos.addActionListener(listener);
        this.btnProbar.addActionListener(listener);
    }

    public void setEstado(String estado){
        this.lblEstadoNro.setText(estado);
    }
}
