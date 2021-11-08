package usuarios;

import java.util.Objects;

/**
 * Define tipo de Usuario que pasa por la clinica (Medico y Paciente)
 */
public abstract class Usuarios implements Comparable<Usuarios> {
    protected String dni, domicilio, ciudad, telefono, nombre;
    protected int numero;

    public Usuarios(String dni, String domicilio, String ciudad, String telefono, String nombre, int numero) {
        this.dni = dni;
        this.domicilio = domicilio;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.nombre = nombre;
        this.numero = numero;
    }

    public Usuarios() {
    }

    /**
     * Retorna el dni del usuario
     * 
     * @return String
     */
    public String getDni() {
        return dni;
    }

    /**
     * Retorna el domicilio del usuario
     * 
     * @return String
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * Retorna la ciudad del usuario
     * 
     * @return String
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Retorna el telefono del usuario
     * 
     * @return String
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Retorna el nombre del usuario
     * 
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     *
     * Post: retorna true si los objetos tienen la misma referencia<br>
     * Retorna false si o es null o si las clases son distintas<br>
     * Si nada de lo anterior se cumplio, retorna true si this.numero ==
     * parametro.usuarios y si no retorna falso
     * 
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Usuarios usuarios = (Usuarios) o;
        return numero == usuarios.numero;
    }

    /**
     * Retorna el hash del usuario
     * 
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    /**
     * Retorna el numero del usuario<br>
     * 
     * @return int
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Pre: o no es null <br>
     * Post: retorna un valor positivo si this.numero es mayor que
     * parametro.numero<br>
     * <br>
     * Retorna cero si los numeros son iguales<br>
     * Retorna negativo si this.numero es menos que parametro.numero<br>
     * 
     * @param o
     * @return int
     */
    @Override
    public int compareTo(Usuarios o) {
        return this.numero - o.numero;
    }
}
