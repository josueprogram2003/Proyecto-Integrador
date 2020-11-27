
package interfaces;

import java.util.List;
import modelo.Autor;

public interface CRUD_AUTOR {
    
    public List listarAutor(); // Listar
    public List buscarAutor(int idautor); // buscar
    public boolean agregarAutor(Autor autor); // agregar
    public boolean editarAutor(Autor autor); // editar
    public boolean eliminarAutor(int idautor); // eliminar

}
