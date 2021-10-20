package util;


import java.util.Random;

import modelo.Clinica;
import persistencia.ClinicaDTO;

public class Util
{
       
    public static ClinicaDTO clinicaDTOFromCLinica() 
    {
	ClinicaDTO respuesta=new ClinicaDTO();
	//comento las lineas que creo que no van
	
	respuesta.setDireccion(Clinica.getInstance().getDireccion());
	respuesta.setFacturas(Clinica.getInstance().getFacturas());
	//respuesta.setHabitaciones(Clinica.getInstance().getHabitaciones());
	//respuesta.setListaAtencion(Clinica.getInstance().getListaAtencion());
	//respuesta.setListaEspera(Clinica.getInstance().getListaEspera());
	respuesta.setMedicos(Clinica.getInstance().getMedicos());
	respuesta.setNombre(Clinica.getInstance().getNombre());
	//respuesta.setPatio(Clinica.getInstance().getPatio());
	//respuesta.setSalaEspera(Clinica.getInstance().getSalaEspera());
	respuesta.setPacientes(Clinica.getInstance().getPacientes());
	//respuesta.setHabitaciones(Clinica.getInstance().getHabitaciones());
//	respuesta.setNroOrden(Clinica.getInstance().getNroOrden());
//	respuesta.setNroFactura(Clinica.getInstance().getNroFactura());
	return respuesta;
    }
    
    public static void clinicaFromClinicaDTO(ClinicaDTO clinicaDTO) 
    {
    	
    	Clinica.getInstance().setDireccion(clinicaDTO.getDireccion());
    	Clinica.getInstance().setFacturas(clinicaDTO.getFacturas());
    	//Clinica.getInstance().setHabitaciones(clinicaDTO.getHabitaciones());
    	//Clinica.getInstance().setListaAtencion(clinicaDTO.getListaAtencion());
    	//Clinica.getInstance().setListaEspera(clinicaDTO.getListaEspera());
    	Clinica.getInstance().setMedicos(clinicaDTO.getMedicos());
    	Clinica.getInstance().setNombre(clinicaDTO.getNombre());
    	//Clinica.getInstance().setPatio(clinicaDTO.getPatio());
    	//Clinica.getInstance().setSalaEspera(clinicaDTO.getSalaEspera());
    	Clinica.getInstance().setPacientes(clinicaDTO.getPacientes());
    	//Clinica.getInstance().setHabitaciones(clinicaDTO.getHabitaciones());
   // 	Clinica.getInstance().setNroOrden(clinicaDTO.getNroOrden());
    //	Clinica.getInstance().setNroFactura(clinicaDTO.getNroFactura());
	
    }
    
    
}
