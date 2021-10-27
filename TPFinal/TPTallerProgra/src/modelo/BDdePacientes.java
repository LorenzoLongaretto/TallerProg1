package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import infraestructura.Prestacion;
import personas.Paciente;

/**
 * Clase que representa y simula una Base de Datos de tipo Paciente.
 *
 */
public class BDdePacientes implements Serializable{	
	private int generaNumHist=0;

    /**
     * @aggregation shared
     */
    ArrayList<HistoriaClinica> pacientesBD= new ArrayList<>();

	public BDdePacientes() {

	}
	
	/** Clase que busca a un paciente dentro de la base de datos. 
	 * <b>Pre: El parametro paciente debe ser distinto de null</b>
	 * <b>Post: Devuelve si encontro o no al pacente.</b>
	 * @param paciente: Parametro que representa el paciente a buscar, de tipo Paciente.
	 * @return: Devuelve true o false, dependiendo si encontro o no al paciente.
	 */
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
	/** Metodo que da de alta a un paciente dentro de la base, creando su historia clinica.
	 *  <b>Pre: El parametro nuevo debe ser distinto de null</b>
	 * <b>Post: Se da de alta al nuevo paciente en la base.</b>
	 * @param nuevo: Parametro de tipo que representa a un paciente, distinto de null.
	 */
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
