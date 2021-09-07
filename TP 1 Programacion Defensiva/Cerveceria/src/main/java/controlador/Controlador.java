package controlador;

import vista.Ventana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.BeerHouse;
import modelo.NoExisteMesaException;

public class Controlador implements ActionListener {
    Ventana ventana;
    public Controlador() {
        ventana = new Ventana();
        ventana.setVisible(true);
        ventana.setActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando  = e.getActionCommand();
        
        if(comando.equalsIgnoreCase("Abrir")) {
         int mesas = this.ventana.devolverCantMesas();
         BeerHouse.getInstance().abrirLocal(mesas);
         System.out.println("Abrir");
        }
        if(comando.equalsIgnoreCase("Cerrar")) {
        	 int nro = this.ventana.mesaACerrar();
        	 try {
				BeerHouse.getInstance().cerrarMesa(nro);
			} catch (NoExisteMesaException e1) {
				this.ventana.msj(e1.getMessage());
			}
        }
        if(comando.equalsIgnoreCase("Ocupar")) {
        	 int nro = this.ventana.mesaAOcupar();
        	 try {
				BeerHouse.getInstance().ocuparMesa(nro);;
			} catch (NoExisteMesaException e1) {
				this.ventana.msj(e1.getMessage());
			}
        }
    }
}
