
package modelo;


public class Libros {
    
    private int idlibro;
    private String nombre;
    private String codigo;
    private String ISBN;
    private String fecha_publicacion;
    private int idautor;
    private int ideditorial;
    private int idpais;
    private String estado;

    public Libros() {
    }

    public Libros(String nombre, String codigo, String ISBN, String fecha_publicacion, int idautor, int ideditorial, int idpais, String estado) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.ISBN = ISBN;
        this.fecha_publicacion = fecha_publicacion;
        this.idautor = idautor;
        this.ideditorial = ideditorial;
        this.idpais = idpais;
        this.estado = estado;
    }

    
    
    
    public Libros(int idlibro, String nombre, String codigo, String ISBN, String fecha_publicacion, int idautor, int ideditorial, int idpais, String estado) {
        this.idlibro = idlibro;
        this.nombre = nombre;
        this.codigo = codigo;
        this.ISBN = ISBN;
        this.fecha_publicacion = fecha_publicacion;
        this.idautor = idautor;
        this.ideditorial = ideditorial;
        this.idpais = idpais;
        this.estado = estado;
    }

    
    
    public int getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(int idlibro) {
        this.idlibro = idlibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getFecha_publicacion() {
        return fecha_publicacion;
    }

    public void setFecha_publicacion(String fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }

    public int getIdautor() {
        return idautor;
    }

    public void setIdautor(int idautor) {
        this.idautor = idautor;
    }

    public int getIdeditorial() {
        return ideditorial;
    }

    public void setIdeditorial(int ideditorial) {
        this.ideditorial = ideditorial;
    }

    public int getIdpais() {
        return idpais;
    }

    public void setIdpais(int idpais) {
        this.idpais = idpais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
