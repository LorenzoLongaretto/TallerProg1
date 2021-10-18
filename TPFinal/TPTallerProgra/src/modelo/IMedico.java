package modelo;

import java.io.Serializable;

public interface IMedico extends Serializable{
	
	double getHonorario();
	
	String getMatricula();
	
	String getEspecialidad();
	
	String getNombre();

}
