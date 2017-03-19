/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.controlador.EquipoCtrl;
import com.sv.udb.modelo.Equipos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Luis
 */
@WebServlet(name = "EquiposServ", urlPatterns = {"/EquiposServ"})
public class EquiposServ extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       boolean esValido = request.getMethod().equals("POST");
       String mens="";
       
       if(!esValido)
       {
            response.sendRedirect(request.getContextPath()+"/index.jsp");
       }
       else
       {
           String CRUD = request.getParameter("btnEqui");
           if (CRUD.equals("Guardar"))
           {
                Equipos obj = new Equipos();
                //obj.setCodiEqui(0);
                obj.setNombEqui(request.getParameter("nomb"));
                obj.setDescEqui(request.getParameter("desc"));
                if (new EquipoCtrl().guar(obj)) 
                {
                    mens = "Guardado";
                }
                else
                {
                    mens = "Error Guardado";
                }
               
            }
           if (CRUD.equals("Actualizar"))
           { System.out.println("hola");
                Equipos obj = new Equipos();
                obj.setCodiEqui(Integer.parseInt(request.getParameter("codi").isEmpty()?"-1":request.getParameter("codi")));
                //obj.setCodiEqui(8);
                obj.setNombEqui(request.getParameter("nomb"));
                obj.setDescEqui(request.getParameter("desc"));
                if (new EquipoCtrl().actu(obj)) 
                {
                    mens = "Actualizado";
                }
                else
                {
                    mens = "Error al actualizar";
                }
               
            }
           if (CRUD.equals("Eliminar"))
           {
                Equipos obj = new Equipos();
               obj.setCodiEqui(Integer.parseInt(request.getParameter("codiEquiRadi").isEmpty()?"-1":request.getParameter("codiEquiRadi")));
               if (new EquipoCtrl().eliminar(obj)) 
                {
                    mens = "Eliminar";
                }
                else
                {
               
                    mens = "Error al eliminar";
                }
               
            }
           if(CRUD.equals("Consultar"))
           {
               int codi = Integer.parseInt(request.getParameter("codiEquiRadi").isEmpty()?"-1":request.getParameter("codiEquiRadi"));
               System.out.println(codi);
               Equipos obje = new EquipoCtrl().ver2(codi);
             
               if(obje != null)
               {
                    request.setAttribute("codi", obje.getCodiEqui());
                    request.setAttribute("nomb", obje.getNombEqui());
                    request.setAttribute("desc", obje.getDescEqui());
              
               }
               else
                {
                    mens = "Error al consultar";
                }
               
           }
                request.setAttribute("mensAlert", mens);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
       }
      
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
