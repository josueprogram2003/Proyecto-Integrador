
package modelodao;
import config.bd.ConectaBd;
import java.sql.*;
import interfaces.CRUD_LIBROS;
import java.util.ArrayList;
import java.util.List;
import modelo.Libros;

public class LibrosDAO implements CRUD_LIBROS{
    ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Libros l = new Libros();
    
    @Override
    public ArrayList<List> listarLibros() {
        ArrayList<List> arreglo = new ArrayList();
        String consulta = "select l.idlibro, a.apellidos, a.nombre, e.nombre, p.nombre, l.codigo, l.estado " + 
" from libro l, autor a, editorial e, pais p " + 
 " where " + 
 " a.idautor = l.idautor and  " +
 " e.ideditorial = l.ideditorial and "+
  " p.idpais = l.idpais ";   
        

        try {
          con = cn.getConnection();
          pst = con.prepareStatement(consulta);
          rs = pst.executeQuery();
            while (rs.next()) {                
           List libro = new ArrayList();
           libro.add(rs.getInt("l.idlibro"));
           libro.add(rs.getString("a.apellidos"));
           libro.add(rs.getString("a.nombre"));
           libro.add(rs.getString("e.nombre"));
           libro.add(rs.getString("p.nombre"));
           libro.add(rs.getInt("l.codigo"));
           libro.add(rs.getString("l.estado"));
           arreglo.add(libro);
            }         
        } catch (SQLException  e) {
            System.out.println(e.getMessage());
        }
        return arreglo;
    }

    @Override
    public List buscarLibros(int idlibro) {
        ArrayList<Libros> array = new ArrayList<Libros>();
      String consulta = "Select * " + " from libro " + " where idlibro = "+ idlibro+ ";";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {    
                l.setIdlibro(rs.getInt("idlibro"));
                l.setNombre(rs.getString("nombre"));
                l.setCodigo(rs.getString("codigo"));
                l.setISBN(rs.getString("ISBN"));
                l.setFecha_publicacion(rs.getString("fecha_publicacion"));
                l.setEstado(rs.getString("estado"));
                l.setIdautor(rs.getInt("idautor"));
                l.setIdeditorial(rs.getInt("ideditorial"));
                array.add(l);
            }
        } catch (Exception er) {
            System.out.println("Error: Problemas en el listar");
            System.out.println(er.getMessage());
        }
       return array;
    }

    @Override
    public boolean agregarLibros(Libros libro) {
        String consulta = " insert into "+ 
                " libro (nombre, codigo, ISBN, fecha_publicacion,idautor,ideditorial, idpais, estado ) "+
              " values( '"+libro.getNombre() +"',"
                + " '"+libro.getCodigo()+ "',"
                + " '"+libro.getISBN() + "',"
                + " '"+libro.getFecha_publicacion()+ "',"
                +" ' "+libro.getIdautor() + " ', "
                + " ' " +libro.getIdeditorial()+ " ',"
                 + " ' " +libro.getIdpais()+ " ',"
               +" ' "+libro.getEstado()+ " '"
                + " );";
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
    public boolean editarLibros(Libros libro) {
         String consulta = " update  libro  set nombre = ?, codigo = ?,"
                 + " ISBN = ?, fecha_publicacion =  ? , idautor=? , ideditorial=? , idpais=? , estado = ? where idlibro = " + libro.getIdlibro(); 
                  
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.setString(1, libro.getNombre().trim());
            pst.setString(2, libro.getCodigo());
            pst.setString(3, libro.getISBN());
            pst.setString(4, libro.getFecha_publicacion());
            pst.setInt(5, libro.getIdautor());
            pst.setInt(6, libro.getIdeditorial());
            pst.setInt(7, libro.getIdpais());
            pst.setString(8, libro.getEstado());
            pst.executeUpdate();
        } catch (Exception er) {
            System.out.println("Error: Problemas en el listar");
            System.out.println(er.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminarLibros(int idlibro) {
         String consulta = " delete from libro " + " where idlibro = "+ idlibro+ " ;";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception er) {
            System.out.println("Error: Problemas en el listar");
            System.out.println(er.getMessage());
        }
       return true;
    }
    
}
