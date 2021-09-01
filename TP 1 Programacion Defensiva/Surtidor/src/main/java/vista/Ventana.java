package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.border.MatteBorder;


public class Ventana extends JFrame {
    JPanel mainPanel;
    private JPanel panelNorte;
    private JProgressBar progressBar;
    private JLabel lbCantidadCarga;
    private JPanel panelCentral;
    private JLabel lbValor;
    private JPanel panelCarga;
    private JPanel panelActivar;
    private JPanel panelDesactivar;
    private JTextField textField;
    private JButton btnCargarSurtidor;
    private JButton btnActivar1;
    private JButton btnActivar2;
    private JButton btnDesactivar1;
    private JButton btnDesactivar2;

    public Ventana() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 550, 250);
        setTitle("Surtidor de gasolina");
        mainPanel = new JPanel();
        setContentPane(mainPanel);
        mainPanel.setLayout(new BorderLayout(0, 0));
        
        panelNorte = new JPanel();
        panelNorte.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        panelNorte.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.add(panelNorte, BorderLayout.NORTH);
        panelNorte.setLayout(new BorderLayout(0, 0));
        
        progressBar = new JProgressBar();
        progressBar.setMaximum(2000);
        panelNorte.add(progressBar, BorderLayout.CENTER);
        
        lbCantidadCarga = new JLabel("  Cantidad actual de combustible:  ");
        panelNorte.add(lbCantidadCarga, BorderLayout.WEST);
        
        lbValor = new JLabel("500/2000");
        panelNorte.add(lbValor, BorderLayout.EAST);
        
        panelCentral = new JPanel();
        mainPanel.add(panelCentral, BorderLayout.CENTER);
        panelCentral.setLayout(new GridLayout(3, 1, 5, 0));
        
        panelCarga = new JPanel();
        panelCarga.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
        FlowLayout flowLayout = (FlowLayout) panelCarga.getLayout();
        flowLayout.setVgap(20);
        panelCentral.add(panelCarga);
        
        btnCargarSurtidor = new JButton("Cargar surtidor");
        btnCargarSurtidor.setActionCommand("CargarSurtidor");
        panelCarga.add(btnCargarSurtidor);
        
        textField = new JTextField();
        panelCarga.add(textField);
        textField.setColumns(10);
        
        panelActivar = new JPanel();
        FlowLayout flowLayout_1 = (FlowLayout) panelActivar.getLayout();
        flowLayout_1.setVgap(20);
        panelActivar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        panelCentral.add(panelActivar);
        
        btnActivar1 = new JButton("Activar manguera 1");
        btnActivar1.setActionCommand("Activar1");
        panelActivar.add(btnActivar1);
        
        btnDesactivar1 = new JButton("Desactivar manguera 1");
        btnDesactivar1.setActionCommand("Desactivar1");
        panelActivar.add(btnDesactivar1);
        
        panelDesactivar = new JPanel();
        FlowLayout flowLayout_2 = (FlowLayout) panelDesactivar.getLayout();
        flowLayout_2.setVgap(20);
        panelDesactivar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
        panelCentral.add(panelDesactivar);
        
        btnActivar2 = new JButton("Activar manguera 2");
        btnActivar2.setActionCommand("Activar2");
        panelDesactivar.add(btnActivar2);
        
        btnDesactivar2 = new JButton("Desactivar manguera 2");
        btnDesactivar2.setActionCommand("Desactivar2");
        panelDesactivar.add(btnDesactivar2);

    }
    public void setActionListener(ActionListener list){
        this.btnActivar1.addActionListener(list);
        this.btnActivar2.addActionListener(list);
        this.btnDesactivar1.addActionListener(list);
        this.btnDesactivar2.addActionListener(list);
        this.btnCargarSurtidor.addActionListener(list);
    }

    public void updateBar(float value){
        this.progressBar.setValue(Math.round(value));
        this.lbValor.setText(String.valueOf(value));
    }
}
