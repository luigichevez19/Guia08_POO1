/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.Jugadores;
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
public class JugadoresCtrl {
    public boolean guar(Jugadores obj)
    {
    boolean resp = false;
    Connection con = new Conexion().getConn();
    try 
        {
            PreparedStatement cmd = con.prepareStatement("Insert into jugadores values (Null,?,?,?,?,?)");
            cmd.setInt(1, obj.getCodiEqui());
            cmd.setString(2,obj.getNombreJ());
            cmd.setInt(3, obj.getEdad());
            cmd.setDouble(4, obj.getAltura());
            cmd.setDouble(5, obj.getPeso());
            cmd.executeUpdate();
            resp=true;
        }
        catch (Exception e) 
        {
            System.out.println("Ocurrio un error: "+e.getMessage());
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
        catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
    return resp;
    
    }
    public  List<Jugadores> ver()
    {
     List<Jugadores> resp = new ArrayList<>();
     Connection con = new Conexion().getConn();
        try 
        {
         PreparedStatement cmd = con.prepareStatement("select j.codi_juga,e.nomb_equi,j.nomb_juga,"
         + "j.edad_juga,j.altu_juga,j.peso_juga from jugadores j,equipos e where j.codi_equi = e.codi_equi ");
         ResultSet rs = cmd.executeQuery();
         while(rs.next())
         {
         resp.add(new Jugadores(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDouble(5),rs.getDouble(6)));
         }
        }
        catch (Exception e) 
        {
            System.out.println("Error: "+e.getMessage());
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
        catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
     return resp;
    }
    public Jugadores ver2(int id)
    {
     Jugadores resp =null;
     Connection con = new Conexion().getConn();
        try 
        {
         PreparedStatement cmd = con.prepareStatement("select j.codi_juga,e.nomb_equi,j.nomb_juga,"
         + "j.edad_juga,j.altu_juga,j.peso_juga from jugadores j,equipos e where j.codi_equi = e.codi_equi and j.codi_juga=?");
         cmd.setInt(1,id);
         ResultSet rs = cmd.executeQuery();
         while(rs.next())
         {
         resp=(new Jugadores(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getDouble(5),rs.getDouble(6)));
         }
        }
        catch (Exception e) 
        {
            System.out.println("Error: "+e.getMessage());
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
        catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
     return resp;
    }
    public boolean actu (Jugadores obj)
    {
    Connection con = new Conexion().getConn();
    boolean resp = false;
        try 
        {
         PreparedStatement cmd = con.prepareStatement("update jugadores set codi_equi=?, nomb_juga=?, edad_juga=?, altu_juga=?, peso_juga=? where codi_juga=?");
         cmd.setInt(1,obj.getCodiEqui());
         cmd.setString(2,obj.getNombreJ());
         cmd.setInt(3,obj.getEdad());
         cmd.setDouble(4,obj.getAltura());
         cmd.setDouble(5,obj.getPeso());
         cmd.setInt(6,obj.getCodiJ());
         cmd.executeUpdate();
         resp=true;
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,"Error:"+e.getMessage());
        }
    return resp;
    }
    public boolean actu2 (Jugadores obj)
    {
    Connection con = new Conexion().getConn();
    boolean resp = false;
        try 
        {
         PreparedStatement cmd = con.prepareStatement("update jugadores set nomb_juga=?, edad_juga=?, altu_juga=?, peso_juga=? where codi_juga=?");
         cmd.setString(1,obj.getNombreJ());
         cmd.setInt(2,obj.getEdad());
         cmd.setDouble(3,obj.getAltura());
         cmd.setDouble(4,obj.getPeso());
         cmd.setInt(5,obj.getCodiJ());
         cmd.executeUpdate();
         resp=true;
       
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,"Error:"+e.getMessage());
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
        catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
    return resp;
    }
    public boolean elim(Jugadores obj)
    {
    boolean resp=false;
    Connection con = new Conexion().getConn();
        try 
        {
         PreparedStatement cmd = con.prepareStatement("Delete from jugadores where codi_juga=?");
         cmd.setInt(1,obj.getCodiJ());
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
        catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
    return resp;
    }
}
