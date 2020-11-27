
package interfaces;

import java.util.ArrayList;
import java.util.List;
import modelo.Libros;


public interface CRUD_LIBROS {
    public ArrayList<List> listarLibros(); // Listar
    public List buscarLibros(int idlibro); // buscar
    public boolean agregarLibros(Libros libro); // agregar
    public boolean editarLibros(Libros libro); // editar
    public boolean eliminarLibros(int idlibro); // eliminar
}
