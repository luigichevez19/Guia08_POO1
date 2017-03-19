/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.controlador.JugadoresCtrl;
import com.sv.udb.modelo.Jugadores;
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
@WebServlet(name = "JugadoresServ", urlPatterns = {"/JugadoresServ"})
public class JugadoresServ extends HttpServlet {

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
       String CRUD = request.getParameter("btnJuga");
       if(!esValido)
       {
            response.sendRedirect(request.getContextPath()+"/jugadores.jsp");
       }
       else
       {
            if(CRUD.equals("Guardar"))
            {
                Jugadores obj = new Jugadores();
                 //obj.setCodiJ(Integer.parseInt(request.getParameter("codi")));
                obj.setNombreJ(request.getParameter("nomb"));
                obj.setEdad(Integer.parseInt(request.getParameter("edad")));
                obj.setAltura(Double.parseDouble(request.getParameter("altura")));
                obj.setPeso(Double.parseDouble(request.getParameter("peso")));
                obj.setCodiEqui(Integer.parseInt(request.getParameter("cmbEquipo")));
                if(new JugadoresCtrl().guar(obj))
                {
                    mens="Guardado";
                }
                else
                {
                mens="Error al guardar";
                }
            }
            if(CRUD.equals("Eliminar"))
            {
                Jugadores obj = new Jugadores();
                 obj.setCodiJ(Integer.parseInt(request.getParameter("codiJugaRadi").isEmpty()?"-1":request.getParameter("codiJugaRadi")));
            
                if(new JugadoresCtrl().elim(obj))
                {
                    mens="Eliminado";
                }
                else
                {
                mens="Error al eliminar";
                }
            }
            if(CRUD.equals("Actualizar"))
            {
               
                Jugadores obj = new Jugadores();
                 obj.setCodiJ(Integer.parseInt(request.getParameter("codi").isEmpty()?"-1":request.getParameter("codi")));
                obj.setNombreJ(request.getParameter("nomb"));
                obj.setEdad(Integer.parseInt(request.getParameter("edad")));
                obj.setAltura(Double.parseDouble(request.getParameter("altura")));
                obj.setPeso(Double.parseDouble(request.getParameter("peso")));
                obj.setCodiEqui(Integer.parseInt(request.getParameter("cmbEquipo")));
                if(new JugadoresCtrl().actu(obj))
                {
                    mens="Actualizado";
                }
                else
                {
                mens="Error al actualizar";
                }
            }
            if(CRUD.equals("Consultar"))
            {
                int codi = Integer.parseInt(request.getParameter("codiJugaRadi").isEmpty()?"-1":request.getParameter("codiJugaRadi"));
                Jugadores obj = new JugadoresCtrl().ver2(codi);
                if(obj != null)
                {
                    request.setAttribute("codi", obj.getCodiJ());
                    request.setAttribute("nomb", obj.getNombreJ());
                    request.setAttribute("edad", obj.getEdad());
                    request.setAttribute("altura", obj.getAltura());
                    request.setAttribute("peso", obj.getPeso());
                    request.setAttribute("nomb_equi", obj.getNombreE());

                }
                 
               else
                {
                    mens = "Error al consultar";
                }
            }
       request.setAttribute("mensAlert", mens);
                request.getRequestDispatcher("/jugadores.jsp").forward(request, response);
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
