/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelodao;

import config.bd.ConectaBd;
import interfaces.CRUD_EDITORIAL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Editorial;

/**
 *
 * @author Josue Dominguez
 */
public class EditorialDAO implements CRUD_EDITORIAL{

    
    ConectaBd cn = new ConectaBd();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Editorial e = new Editorial();
    
    @Override
    public List listarEditorial() {
         ArrayList<Editorial> arreglo = new ArrayList<Editorial>();
        String consulta = "select * from editorial";
        try {
          con = cn.getConnection();
          pst = con.prepareStatement(consulta);
          rs = pst.executeQuery();
            while (rs.next()) {                
            Editorial libro = new Editorial();
             libro.setIdeditorial(rs.getInt("ideditorial"));
             libro.setNombre(rs.getString("nombre"));
             libro.setEstado(rs.getString("estado"));
       
             arreglo.add(libro);
            }         
        } catch (SQLException  e) {
            System.out.println(e.getMessage());
        }
        return arreglo;
    }

    @Override
    public List buscarEditorial(int ideditorial) {
        ArrayList<Editorial> array = new ArrayList<Editorial>();
      String consulta = "Select * " + " from editorial " + " where ideditorial = "+ ideditorial+ ";";
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {    
                e.setIdeditorial(rs.getInt("ideditorial"));
                e.setNombre(rs.getString("nombre"));
                e.setEstado(rs.getString("estado"));
              
                array.add(e);
            }
        } catch (Exception er) {
            System.out.println("Error: Problemas en el listar");
            System.out.println(er.getMessage());
        }
       return array;
    }

    @Override
    public boolean agregarEditorial(Editorial editorial) {
    String consulta = " insert into "+ 
                " editorial (nombre, estado)"+
              " values('"+editorial.getNombre() +"',"
                + " '"+editorial.getEstado()+ "'"
                + "); ";
                try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Problemas con la busqueda");
            return false;
        }
        return true;
    }

    @Override
    public boolean editarEditorial(Editorial editorial) {
         String consulta = " update  editorial  set nombre = ?, estado = ? where ideditorial = " 
                   + editorial.getIdeditorial();
                  
        try {
            con = cn.getConnection();
            pst = con.prepareStatement(consulta);
            pst.setString(1, editorial.getNombre().trim());
            pst.setString(2, editorial.getEstado());
            pst.executeUpdate();
        } catch (Exception er) {
            System.out.println("Error: Problemas en el listar");
            System.out.println(er.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminarEditorial(int ideditorial) {
         String consulta = " delete from editorial " + " where ideditorial = "+ ideditorial+ " ;";
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
