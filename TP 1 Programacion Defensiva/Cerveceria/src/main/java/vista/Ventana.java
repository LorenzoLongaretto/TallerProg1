package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Ventana extends JFrame implements IVista{

    private JPanel mainPanel;
    private JPanel northPanel;
    private JPanel centerPanel;

    ArrayList<JButton> botones = new ArrayList<JButton>();

    private JLabel titulo;

    public Ventana(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 550, 250);
        setTitle("Cerveceria");
        mainPanel = new JPanel();
        setContentPane(mainPanel);
        mainPanel.setLayout(new BorderLayout(0, 0));

        northPanel = new JPanel();
        titulo = new JLabel("Cerveceria NoSomosAntares S.A");
        northPanel.add(titulo);

        mainPanel.add(northPanel,BorderLayout.NORTH);

        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3,2,10,15));
        mainPanel.add(centerPanel,BorderLayout.CENTER);

        ArrayList<String> mensajes = new ArrayList<String>();
        mensajes.add("Abrir local con esta cant mesas");
        mensajes.add("Cierra esta mesa");
        mensajes.add("Ocupa esta mesa");

        ArrayList<String> comandos = new ArrayList<String>();
        comandos.add("Abrir");
        comandos.add("Cerrar");
        comandos.add("Ocupar");
        for (int i=0;i<3;i++){
            JTextArea text = new JTextArea();
            JButton button = new JButton(mensajes.get(i));
            button.setActionCommand(comandos.get(i));
            botones.add(button);
            centerPanel.add(text);
            centerPanel.add(button);
        }
        
    }
    public void setActionListener(ActionListener controlador){

        for (JButton boton: botones) {
            boton.addActionListener(controlador);
        }

    }
	@Override
	public void abrirLocal(int nro) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void cerrarMesa(int nro) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void ocuparMesa(int nro) {
		// TODO Auto-generated method stub
		
	}
}
