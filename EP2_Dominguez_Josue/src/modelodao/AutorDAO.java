
package modelodao;

import java.sql.*;
import config.bd.ConectaBd;
import interfaces.CRUD_AUTOR;
import java.util.ArrayList;
import java.util.List;
import modelo.Autor;

public class AutorDAO implements CRUD_AUTOR{
    ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
     
    @Override
    public List listarAutor() {
        ArrayList<Autor> arreglo = new ArrayList<Autor>();
        String consulta = "select * from autor";
        try {
          con = cn.getConnection();
          pst = con.prepareStatement(consulta);
          rs = pst.executeQuery();
            while (rs.next()) {                
             Autor autor = new Autor(); 
             autor.setIdautor(rs.getInt("idautor"));
             autor.setNombre(rs.getString("nombre"));
             autor.setApellidos(rs.getString("apellidos"));
             autor.setEstado(rs.getString("estado"));
             arreglo.add(autor);
            }         
        } catch (SQLException  e) {
            System.out.println(e.getMessage());
        }
        return arreglo;
    }
   @Override
   public List buscarAutor(int idautor) {
       ArrayList<Autor> arreglo = new ArrayList<Autor>();
       Autor e = new Autor();
        String consulta = " select *  "
                + " from autor  "
                + " where idautor = " + idautor + " ;";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                 e.setIdautor(rs.getInt("idautor"));
                e.setNombre(rs.getString("nombre"));
                e.setApellidos(rs.getString("apellidos"));
                e.setEstado(rs.getString("estado"));
                arreglo.add(e);
            }
        } catch (SQLException ec) {
        }

        return arreglo;
       
    }

    @Override
    public boolean agregarAutor(Autor autor) {
        String consulta = " insert into autor(nombre, apellidos, estado)  "
                + " values( "
                + "'" +  autor.getNombre()+ "', "
                + "'" + autor.getApellidos() + "', "
                + "'" + autor.getEstado() + "'); ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (SQLException er) {
            System.out.println(er.getMessage());
            return false;
        }
        return true;

    }
   

 @Override
    public boolean editarAutor(Autor autor) {
   String consulta = " update autor "
                        + " set "
                        + " nombre = '"+ autor.getNombre() +"', "
                        + " apellidos = '"+ autor.getApellidos() +"', "
                        + " estado = '"+ autor.getEstado() +"' "
                        + " where "
                        + " idautor = " + autor.getIdautor()+ "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminarAutor(int idautor) {
            String consulta = " delete from autor "
                        + " where "
                        + " idautor = " + idautor + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
}


    


    
    

