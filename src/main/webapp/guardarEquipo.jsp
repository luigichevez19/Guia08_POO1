<%-- 
    Document   : guardarEquipo
    Created on : 04-22-2017, 12:14:10 PM
    Author     : Luis
--%>

<%@page import="com.sv.udb.controlador.EquipoCtrl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="objx" class="com.sv.udb.modelo.Equipos"/>
<jsp:setProperty property="*" name="objx"/>
<%
    if(new EquipoCtrl().guar(objx))
    {
        response.sendRedirect("index.jsp");
    }
    else
    {
        System.out.println("No se guardo");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
