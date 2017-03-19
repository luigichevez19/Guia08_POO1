<%@page import="com.sv.udb.controlador.EquipoCtrl"%>
<%@page import="com.sv.udb.modelo.Equipos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${mensAlert}</h1>
        <form method="POST" action="EquiposServ" name="demo" >
            <input type="text" name="codi" id="codi" value= "${codi}" /><br>
            <input type="text" name="nomb" id="nomb" value="${nomb}"/><br>
             <input type="text" name="desc" id="desc" value="${desc}"/><br>
             <input type="submit" name="btnEqui" value="Guardar"/>  <br>
             <input type="submit" name="btnEqui" value="Actualizar"/>  <br>
          </form>
             <h1>La tabla</h1>
        <form method="POST" action="EquiposServ" name="Tabla">
        <table  border="1">  
                <tr>
                        <th>Cons</th>
                        <th>Nombre</th>
                        <th>Duracion</th>
                </tr>
                <%
                for(Equipos temp: new EquipoCtrl().ver())
                { %>
                <tr>
                    <td><input type="radio" name="codiEquiRadi" value="<%=temp.getCodiEqui()%>"></td>
                    <td><%=temp.getNombEqui()%></td>
                    <td><%=temp.getDescEqui()%></td>
                </tr>
                <%
                 }
                %>
        </table>
        <input type="submit" name="btnEqui" value="Consultar"/>  
        <input type="submit" name="btnEqui" value="Eliminar"/>  
    </form>
    </body>
</html>
