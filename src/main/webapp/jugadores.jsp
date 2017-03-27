<%-- 
    Document   : jugadores
    Created on : 03-18-2017, 07:50:09 PM
    Author     : Luis
--%>

<%@page import="java.util.Base64"%>
<%@page import="com.sv.udb.controlador.JugadoresCtrl"%>
<%@page import="com.sv.udb.modelo.Jugadores"%>
<%@page import="com.sv.udb.modelo.Equipos"%>
<%@page import="com.sv.udb.controlador.EquipoCtrl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <!-- Import Google Icon Font -->
    <link type='text/css' rel='stylesheet' href='css/icons.css'/>
    <!-- Import materialize.css -->
    <link type='text/css' rel='stylesheet' href='webjars/materialize/0.98.0/dist/css/materialize.min.css'  media='screen,projection'/>
    <!-- Let browser know website is optimized for mobile -->
    <meta name='viewport' content='width=device-width, initial-scale=1.0'/>
     <script type="text/javascript" src="webjars/jquery/3.2.1/dist/jquery.min.js"></script>
    <script type='text/javascript' src='webjars/materialize/0.98.0/dist/js/jquery.min.js'></script>
    <script type='text/javascript' src='webjars/materialize/0.98.0/dist/js/materialize.min.js'></script>

        <title>Jugadores</title>
    </head>
    <body>
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
          <div class="row">
        <h1 class="col  s8 offset-s5">${mensAlert}</h1>
           
      <form method="POST" enctype="multipart/form-data" action="JugadoresServ" name="demo" class="col  s8 offset-s2" >
           <div class="row">
            <input type="text" name="codi" id="codi" value= "${codi}" hidden="hidden" /><br>
           <div class="input-field col  s12 ">
           <input type="text" name="nomb" id="nomb" class="validate"  value="${nomb}" required/>
            <label for="nomb">Nombre Jugador</label>
              </div>
           <div class="input-field col  s6 ">
           <input type="number" name="edad" id="edad" min="3" step="1" class="validate"  value="${edad}" required/><br>
            <label for="edad">Edad Jugador</label>
           </div>
            <div class="input-field col  s6 ">
           <input type="number" name="peso" id="peso" min="0.01" step="0.01" class="validate"  value="${peso}" required/><br>
              <label for="peso">Peso Jugador</label>
            </div>
            <div class="input-field col  s6">
           <input type="number" name="altura" id="altura"  min="0.01" step="0.01" class="validate"  value="${altura}" required/><br>
             <label for="altura">Altura Jugador</label>
            </div>  
             <div class="input-field col  s6">
           <select id="cmbEquipo" name="cmbEquipo" >
      <option value="" disabled selected>Seleccione un equipo</option>
       <%
                for(Equipos temp: new EquipoCtrl().ver())
               
                { 
                    int id=-1;
                   if (request.getAttribute("codi_equi") != null)
                   {                       
                        id =(Integer)request.getAttribute("codi_equi");
                   }                      
                   
                    if(temp.getCodiEqui() == id)
                    {
                 %>
                        <option value="<%=temp.getCodiEqui()%>" SELECTED><%=temp.getNombEqui()%></option>;
                
               
                <%}
                    else
                    {
                 %>
                        <option value="<%=temp.getCodiEqui()%>" ><%=temp.getNombEqui()%></option>;
                
               
                <%}
                }
                %>
     
    </select>
                  <label>Equipo</label>
             </div>
           </div>
                <div class="file-field input-field">
                    <button class="btn red darken-2">
                         <i class="material-icons">insert_photo</i>
                        <input type="file" name="imagen" id="imagen">
                    </button>
                    <div class="file-path-wrapper">
                      <input class="file-path validate" name="imagen" type="text" placeholder='1200x1200px máx., 2MB máx., PNG/JPG/GIF'>
                    </div>  
                </div>
                 <br><br>
               <input type="submit" class="btn blue-grey col s3 offset-s2" name="btnJuga" value="Guardar"/> 
             <input type="submit" class="btn blue-grey col s3 offset-s1 " name="btnJuga" value="Actualizar"/>  
             </form>
                </div>
                
                <div class="row">
                <h1 class="col s7 offset-s3">Jugadores registrados</h1>
                <form method="POST" action="JugadoresServ" name="demo2" class="col s8 offset-s2" >
   <table class="striped">
        <thead>
          <tr>
              <th>Opcion</th>
              <th>Nombre</th>
              <th>Edad</th>
              <th>Peso</th>
              <th>Altura</th>
              <th>Equipo</th>
              <th>Foto</th>
            </tr>
        </thead>

        <tbody>
          
              <%
               for (Jugadores temp: new JugadoresCtrl().ver())
               {
                    byte[] photo = temp.getFoto();
                    String bphoto = Base64.getEncoder().encodeToString(photo);
              %>
                    <tr> 
                         <td> 
   <input name="codiJugaRadi" type="radio" id="<%=temp.getCodiJ()%>" value="<%=temp.getCodiJ()%>" />
      <label for="<%=temp.getCodiJ()%>"></label></td>
                     <td><%=temp%></td>
                     <td><%=temp.getEdad()%></td>
                     <td><%=temp.getPeso()%></td>
                     <td><%=temp.getAltura()%></td>
                     <td><%=temp.getNombreE()%></td>
                     <td> <div><img src="data:image/*;base64,<%=bphoto%>" class='materialboxed' width='50px' height='50px'/><div></td>
                     </tr>
              <% }
              %>
                   
        </tbody>
      </table>
              <br><br>
             <input type="submit" class="btn blue-grey col s3 offset-s2" name="btnJuga" value="Consultar"/>  
        <input type="submit" class="btn blue-grey col s3 offset-s1" name="btnJuga" value="Eliminar"/>  
      </form>
  </div>
          
          <script>
               $(document).ready(function() {
    $('select').material_select();
  });
          </script>
    </body>
</html>
