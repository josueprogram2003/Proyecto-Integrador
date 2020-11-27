

package modelo;


public class Editorial {
    int ideditorial;
    String nombre;
     String estado;

    public Editorial(int ideditorial, String nombre, String estado) {
        this.ideditorial = ideditorial;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Editorial(String nombre, String estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

     public Editorial(){
     }
     
    public int getIdeditorial() {
        return ideditorial;
    }

    public void setIdeditorial(int ideditorial) {
        this.ideditorial = ideditorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
     
     
}
