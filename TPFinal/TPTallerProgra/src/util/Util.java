package util;


import java.util.Random;

import modelo.Clinica;
import persistencia.ClinicaDTO;

public class Util
{
       
    public static ClinicaDTO clinicaDTOFromCLinica() 
    {
	ClinicaDTO respuesta=new ClinicaDTO();
	
	
	respuesta.setDireccion(Clinica.getInstance().getDireccion());
	respuesta.setFacturas(Clinica.getInstance().getFacturas());
	respuesta.setMedicos(Clinica.getInstance().getMedicos());
	respuesta.setNombre(Clinica.getInstance().getNombre());
	respuesta.setPacientes(Clinica.getInstance().getPacientes());
	respuesta.setNroOrden(Clinica.getInstance().getNroOrden());
	respuesta.setNroFactura(Clinica.getInstance().getNroFactura());
	return respuesta;
    }
    
    public static void clinicaFromClinicaDTO(ClinicaDTO clinicaDTO) 
    {
    	
    	Clinica.getInstance().setDireccion(clinicaDTO.getDireccion());
    	Clinica.getInstance().setFacturas(clinicaDTO.getFacturas());
    	Clinica.getInstance().setMedicos(clinicaDTO.getMedicos());
    	Clinica.getInstance().setNombre(clinicaDTO.getNombre());
    	Clinica.getInstance().setPacientes(clinicaDTO.getPacientes());
    	Clinica.getInstance().setNroOrden(clinicaDTO.getNroOrden());
    	Clinica.getInstance().setNroFactura(clinicaDTO.getNroFactura());
	
    }
    
    
}
