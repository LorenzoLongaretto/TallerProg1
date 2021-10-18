package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import infraestructura.Prestacion;
import personas.Paciente;

public class BDdePacientes implements Serializable{	
	private int generaNumHist=0;

    /**
     * @aggregation shared
     */
    ArrayList<HistoriaClinica> pacientesBD= new ArrayList<>();

	public BDdePacientes() {

	}
	
	public boolean buscarPaciente(Paciente paciente) {
		Iterator<HistoriaClinica> it = this.pacientesBD.iterator();
		boolean existe=false;
		while(it.hasNext() && !existe) {
			HistoriaClinica historiaActual = it.next();
			Paciente pacienteActual = historiaActual.getPaciente();
			if(pacienteActual.getDNI().equals(paciente.getDNI()) ) {//haces la busqueda por dni y si no encontras generas un nro de historia
				existe=true;
				paciente.setNumeroHistoria(pacienteActual.getNumeroHistoria());			
			}
		}
		return existe;
	}
	public void altaDePaciente(Paciente nuevo) {
		generaNumHist++;
		nuevo.setNumeroHistoria(generaNumHist);
		HistoriaClinica nueva = new HistoriaClinica(nuevo,new ArrayList<Prestacion>());
		this.pacientesBD.add(nueva);
	}

	public ArrayList<HistoriaClinica> getPacientesBD() {
		return pacientesBD;
	}

	@Override
	public String toString() {
		return "BDdePacientes [pacientesBD=" + pacientesBD + "]";
	}
	
}
