import java.util.ArrayList;

public class Facultad {
    private ArrayList<Alumno>alumnos=null;
    public String nombre;
    public String direccion;
    public String telefono;
    public String ciudad;
    private static Facultad instanciaFacultad=null;

    private Facultad(){
        this.nombre="facultad 'Todos aprueban'";
        this.direccion = "Av.Siempreviva 742";
        this.telefono = "2231597536";
        this.ciudad = "Mar Del Plata";
        this.alumnos=new ArrayList<>();
    }
    public static Facultad getInstance(){
        if (instanciaFacultad==null)
            instanciaFacultad=new Facultad();
        return instanciaFacultad;
    }

    public void agregoAlumno(String nombre,String apellido){
        assert nombre!=null && !nombre.isEmpty():"El nombre no puede ser vacio!!!";
        assert apellido!=null && !apellido.isEmpty():"El apellido no puede ser vacio!!!";
        this.alumnos.add(new Alumno(nombre,apellido));
    }
    public Alumno pedirCertificado(int legajo) throws NoExisteAlumnoException {
        assert legajo>0:"El Legajo tiene que ser positivos panflin!!!";
        for(Alumno alumno :alumnos){
            if(alumno.getLegajo()==legajo)
                return alumno;
        }
        throw new NoExisteAlumnoException("No se encontro alumno legajo numero:" +legajo);
    }
}
