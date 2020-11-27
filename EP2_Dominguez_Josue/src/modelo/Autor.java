
package modelo;

public class Autor {
    
private int idautor;
private String nombre;
private String apellidos;
private String estado;

    public Autor(int idautor, String nombre, String apellidos, String estado) {
        this.idautor = idautor;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.estado = estado;
    }

    public Autor() {
    }

    public Autor(String nombre, String apellidos, String estado) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.estado = estado;
    }


    


    public int getIdautor() {
        return idautor;
    }

    public void setIdautor(int idautor) {
        this.idautor = idautor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

  
}
