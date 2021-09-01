import java.util.ArrayList;

public class Alumno {
    private static Integer canLegajo=0;
    private Integer legajo;
    private String nombre;
    private String apellido;
    private String condicion;
    private ArrayList<Materia> listadoMaterias=new ArrayList<>();

    public Alumno(String nombre,String apellido){
        this.nombre=nombre;
        this.apellido=apellido;
        this.listadoMaterias.add(new Materia("Fisica"));
        this.listadoMaterias.add(new Materia("Matematica"));
        this.listadoMaterias.add(new Materia("Literatura"));
        this.listadoMaterias.add(new Materia("Historia"));
        Alumno.canLegajo++;
        this.legajo=Alumno.canLegajo;
    }


    public Integer getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public ArrayList<Materia> getListadoMaterias() {
        return listadoMaterias;
    }

    public void setListadoMaterias(ArrayList<Materia> listadoMaterias) {
        this.listadoMaterias = listadoMaterias;
    }
}
