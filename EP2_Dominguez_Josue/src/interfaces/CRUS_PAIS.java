
package interfaces;

import java.util.List;
import modelo.Pais;

public interface CRUS_PAIS {
    
    public List listarPais(); // Listar
    public List buscarPais(int idpais); // buscar
    public boolean agregarPais(Pais pais); // agregar
    public boolean editarPais(Pais pais); // editar
    public boolean eliminarPais(int idpais);
}
