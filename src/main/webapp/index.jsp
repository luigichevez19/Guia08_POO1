<%@page import="com.sv.udb.controlador.EquipoCtrl"%>
<%@page import="com.sv.udb.modelo.Equipos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <!-- Import Google Icon Font -->
    <link type='text/css' rel='stylesheet' href='css/icons.css'/>
  
    <!-- Import materialize.css -->
    <link type='text/css' rel='stylesheet' href='css/materialize.min.css'  media='screen,projection'/>
  <link type='text/css' rel='stylesheet' href='css/styles.css'  media='screen,projection'/>
    <!-- Let browser know website is optimized for mobile -->
    <meta name='viewport' content='width=device-width, initial-scale=1.0'/>
    <script type='text/javascript' src='js/jquery.min.js'></script>
    <script type='text/javascript' src='js/materialize.min.js'></script>
        <title>Equipos</title>
    </head>
    <body background="fondo.jpg">
         <div class="row">
       <nav >
    <div class="nav-wrapper">
        <a href="#" class="brand-logo center"><img src="img/soccer.png"></a>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
        <li><a href="EquiposServ">Equipos</a></li>
        <li><a href="JugadoresServ">Jugadores</a></li>
      </ul>
    </div>
  </nav>
         </div>
        <h1 class="col s4 offset-s4">${mensAlert}</h1>
        <div class="row">
        <form method="POST" class="col  s8 offset-s2" action="EquiposServ" name="demo" >
          <div class="row">
            <input type="text" name="codi" id="codi" value= "${codi}" hidden="hidden"/><br>
            <div class="input-field col  s6 ">
            <input type="text" name="nomb" id="nomb" value="${nomb}"/>
            <label for="nomb">Nombre Equipo</label>
              </div>
            <div class="input-field col  s6 ">
             <input type="text" name="desc" id="desc" value="${desc}"/>
              <label for="edad">Descricion</label>
           </div>
             <input type="submit" class="btn blue-grey col s3 offset-s2" name="btnEqui" value="Guardar"/>  
             <input type="submit" class="btn blue-grey col s3 offset-s1" name="btnEqui" value="Actualizar"/>  <br>
          </form>
               </div>
             <h1  class="col s7 offset-s3">Equipos registrados</h1>
        <form method="POST" action="EquiposServ" name="Tabla"  class="col s8 offset-s2">
        <table  class="striped ">  
                <tr>
                        <th>Cons</th>
                        <th>Nombre</th>
                        <th>Duracion</th>
                </tr>
                <%
                for(Equipos temp: new EquipoCtrl().ver())
                { %>
                <tr>
                    <td> 
   <input name="codiEquiRadi" type="radio" id="<%=temp.getCodiEqui()%>" value="<%=temp.getCodiEqui()%>" />
      <label for="<%=temp.getCodiEqui()%>"></label></td>
                    <td><%=temp.getNombEqui()%></td>
                    <td><%=temp.getDescEqui()%></td>
                </tr>
                <%
                 }
                %>
        </table>
        <input type="submit" class="btn blue-grey col s3 offset-s2" name="btnEqui" value="Consultar"/>  
        <input type="submit" class="btn blue-grey col s3 offset-s1" name="btnEqui" value="Eliminar"/>  
    </form>
        </div>
       <a href='JugadoresServ'>Ir a jugadores</a>
    </body>
</html>
