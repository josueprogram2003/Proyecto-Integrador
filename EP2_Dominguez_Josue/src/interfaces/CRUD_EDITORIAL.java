
package interfaces;

import java.util.List;
import modelo.Editorial;

public interface CRUD_EDITORIAL {
    
    public List listarEditorial(); // Listar
    public List buscarEditorial(int ideditorial); // buscar
    public boolean agregarEditorial(Editorial editorial); // agregar
    public boolean editarEditorial(Editorial editorial); // editar
    public boolean eliminarEditorial(int ideditorial); // eliminar

}
