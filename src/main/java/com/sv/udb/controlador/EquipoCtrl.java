/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;


import com.sv.udb.modelo.Equipos;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author Luis
 */
public class EquipoCtrl {
    public boolean guar(Equipos obj)
    {
    boolean resp = false;
    Connection con = new Conexion().getConn();
        try 
        {
            PreparedStatement cmd = con.prepareStatement("Insert into equipos values(Null,?,?)");
            cmd.setString(1,obj.getNombEqui());
            cmd.setString(2,obj.getDescEqui());
            cmd.executeUpdate();
            resp = true;
            
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
    public List<Equipos> ver()
    {
    List<Equipos> resp= new ArrayList();
    Connection cn =new Conexion().getConn();
        try 
        {
           PreparedStatement cmd = cn.prepareStatement("Select * from equipos");
              ResultSet rs = cmd.executeQuery();
              while (rs.next())
              {
              resp.add(new Equipos (rs.getInt(1),rs.getString(2),rs.getString(3)));
              }
        }
        catch (Exception e)
        {
        e.printStackTrace();
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
    public Equipos ver2(int Codi)
    {
   Equipos resp= null;
    Connection cn =new Conexion().getConn();
        try 
        {
           PreparedStatement cmd = cn.prepareStatement("Select * from equipos where codi_equi=?");
           cmd.setInt(1,Codi);
              ResultSet rs = cmd.executeQuery();
              while (rs.next())
              {
                  System.out.println(Codi+"consola");
              resp=(new Equipos (rs.getInt(1),rs.getString(2),rs.getString(3)));
              }
        }
        catch (Exception e)
        {
            System.out.println("Error:"+e.getMessage());
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
 public boolean eliminar(Equipos obje)
 {
boolean resp = false;
  Connection con = new Conexion().getConn(); 
try 
     {  
     PreparedStatement cmd = con.prepareStatement("delete from equipos where codi_equi = ?");
     cmd.setInt(1, obje.getCodiEqui());
     cmd.executeUpdate();
     resp = true;
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
         catch (Exception e)
         {
             System.out.println("Error: "+e.getMessage());
         }
     }
 return resp;
 }
 public boolean actu(Equipos obj)
 {
 boolean resp = false;
 Connection con = new Conexion().getConn();
     try 
     {
     PreparedStatement cmd = con.prepareStatement("update equipos set nomb_equi =?,desc_equi =? where codi_equi=?");
     cmd.setString(1,obj.getNombEqui());
     cmd.setString(2,obj.getDescEqui());
     cmd.setInt(3,obj.getCodiEqui());
     cmd.executeUpdate();
     resp=true;
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
    catch (Exception e) 
    {
        System.out.println("Error: "+e.getMessage());
    }
    
     }
 return resp;
 }
}
