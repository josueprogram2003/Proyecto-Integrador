
package modelodao;

import config.bd.ConectaBd;
import interfaces.CRUS_PAIS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Pais;


public class PaisDAO implements CRUS_PAIS {
    ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Pais p = new Pais();
    
    @Override
    public List listarPais() {
        ArrayList<Pais> arreglo = new ArrayList<Pais>();
        String consulta = "select * from pais";
        try {
          con = cn.getConnection();
          pst = con.prepareStatement(consulta);
          rs = pst.executeQuery();
            while (rs.next()) {                
             Pais p = new Pais(); 
             p.setIdpais(rs.getInt("idpais"));
             p.setNombre(rs.getString("nombre"));
             p.setEstado(rs.getString("estado"));
             arreglo.add(p);
            }         
        } catch (SQLException  e) {
            System.out.println(e.getMessage());
        }
        return arreglo;
    }

    @Override
    public List buscarPais(int idpais) {
       ArrayList<Pais> arreglo = new ArrayList<Pais>();
       Pais e = new Pais();
        String consulta = " select *  "
                + " from pais  "
                + " where idpais = " + idpais + " ;";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                e.setIdpais(rs.getInt("idautor"));
                e.setNombre(rs.getString("nombre"));
                e.setEstado(rs.getString("estado"));
                arreglo.add(e);
            }
        } catch (SQLException ec) {
            System.out.println(ec.getMessage());
        }

        return arreglo;
       
    }

    @Override
    public boolean agregarPais(Pais pais) {
        String consulta = " insert into pais(nombre, estado)  "
                + " values( "
                + "'" +  pais.getNombre()+ "', "
                + "'" + pais.getEstado() + "'); ";
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
    public boolean editarPais(Pais pais) {
      String consulta = " update pais "
                        + " set "
                        + " nombre = '"+ pais.getNombre() +"', "
                        + " estado = '"+ pais.getEstado() +"' "
                        + " where "
                        + " idpais = " + pais.getIdpais()+ "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminarPais(int idpais) {
          String consulta = " delete from pais "
                        + " where "
                        + " idapais = " + idpais + "; ";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    
}
