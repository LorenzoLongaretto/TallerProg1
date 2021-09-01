public class Materia {
    private String nombre;
    private String estado;
    private Integer nota;

    public Materia(String nombre) {
        this.nombre=nombre;
        this.estado="A Cursar";
    }
    public Materia(String nombre,String estado){
        this.nombre=nombre;
        this.estado="Cursando";
        assert this.nota!=null : "No puede existir nota si la materia se esta curdando!!!";
    }
    public Materia(String nombre,Integer nota){
        this.nombre=nombre;
        this.estado="Aprobado";
        assert (this.nota>=0 && this.nota<=10) : "No puede existir nota ingresada!!!";
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }
}
