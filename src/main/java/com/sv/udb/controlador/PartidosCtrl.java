/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Partidos;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis
 */
public class PartidosCtrl {
    public boolean guar(Partidos obj)
    {
    boolean resp = false;
    Connection con = new Conexion().getConn();
        try 
        {
        PreparedStatement cmd = con.prepareStatement("Insert into partidos values(null,?,?,?,?,?,?)");
        cmd.setInt(1,obj.getCodi_equi1());
        cmd.setInt(2,obj.getCodi_equi2());
        cmd.setInt(3,obj.getMarcador());
        cmd.setInt(4,obj.getMarcador2());
        cmd.setString(5,obj.getFecha());
        cmd.setString(6,obj.getLugar());
        cmd.executeUpdate();
        resp=true;
        }
        catch (Exception e) 
        {
            System.out.println("Error:"+e.getMessage());
        }
         finally
        {
        try
        {
        if(con != null)
        {
        if(!con.isClosed())
        {
        con.close();
        }
        }
        }
        catch(Exception e)
        {
            System.out.println("Error:"+e.getMessage());
        }
        }
    return resp;
    }
     public boolean actu(Partidos obj)
    {
    boolean resp = false;
    Connection con = new Conexion().getConn();
        try 
        {
        PreparedStatement cmd = con.prepareStatement("update partidos set codi_equi=?,codi_equi2=?, marcador=?,marcador2=?,"
        + "Fecha=?, Lugar=? where Id_partido=?");
        cmd.setInt(1,obj.getCodi_equi1());
        cmd.setInt(2,obj.getCodi_equi2());
        cmd.setInt(3,obj.getMarcador());
        cmd.setInt(4,obj.getMarcador2());
        cmd.setString(5,obj.getFecha());
        cmd.setString(6,obj.getLugar());
       cmd.setInt(7, obj.getId_partido());
        cmd.executeUpdate();
        resp=true;
        }
        catch (Exception e) 
        {
           JOptionPane.showMessageDialog(null,"Ocurrio un error y no se guardo" );
        }
        finally
        {
        try
        {
        if(con != null)
        {
        if(!con.isClosed())
        {
        con.close();
        }
        }
        }
        catch(Exception e)
        {
            System.out.println("Error:"+e.getMessage());
        }
        }
    return resp;
    }
     public boolean elim(Partidos obj)
     {
     boolean resp=false;
     Connection con = new Conexion().getConn();
         try 
         {
         PreparedStatement cmd = con.prepareStatement("delete from partidos where Id_partido =?");
         cmd.setInt(1,obj.getId_partido());
         cmd.executeUpdate();
         resp=true;
         }
         catch (Exception e) 
         {
             System.out.println("Error:"+e.getMessage());
         }
      finally
        {
        try
        {
        if(con != null)
        {
        if(!con.isClosed())
        {
        con.close();
        }
        }
        }
        catch(Exception e)
        {
            System.out.println("Error:"+e.getMessage());
        }
        }
     return resp;
     }
    public List<Partidos> ver()
    {
    List<Partidos> resp= new ArrayList();
    Connection cn =new Conexion().getConn();
        try 
        {
           PreparedStatement cmd = cn.prepareStatement("Select d.Id_partido, d.nomb_equi,dd.nomb_equi,dd.marcador,"
         + "dd.marcador2, dd.Fecha,dd.Hora,dd.Lugar from Datos d, Datos2 dd "
          + "where dd.Id_partido = d.Id_partido  group by dd.Id_partido");
              ResultSet rs = cmd.executeQuery();
              while (rs.next())
              {
              resp.add(new Partidos(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5),rs.getDate(6).toString(),rs.getString(7),rs.getString(8)));
              }
        }
        catch (Exception e)
        {
       JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
        try
        {
        if(cn != null)
        {
        if(!cn.isClosed())
        {
        cn.close();
        }
        }
        }
        catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
    return resp;
    }
    
}
