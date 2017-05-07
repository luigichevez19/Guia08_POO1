<%-- 
    Document   : jugadores
    Created on : 03-18-2017, 07:50:09 PM
    Author     : Luis
--%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.Base64"%>
<%@page import="com.sv.udb.controlador.JugadoresCtrl"%>
<%@page import="com.sv.udb.modelo.Jugadores"%>
<%@page import="com.sv.udb.modelo.Equipos"%>
<%@page import="com.sv.udb.controlador.EquipoCtrl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.me.jsp.bundle.file" />
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
        <li><a href="EquiposServ"><fmt:message key="label.name10"/></a></li>
        <li><a href="JugadoresServ"><fmt:message key="label.name12"/></a></li>
      </ul>
    </div>
  </nav>
         </div>
        
          <div class="row">
              <div class="input-field col  s8">
          <form class="col  s8 offset-s5">
       <fmt:message key="label.select_language" />: 
       <select id="language" name="language" onchange="submit();">
           <option value="es_ES"
            <c:if test="${language=='es_SV'}">selected</c:if>>
            <fmt:message key="label.spanish" />
          </option>
          <option value="en_US" 
            <c:if test="${language=='en_US'}">selected</c:if>>
            <fmt:message key="label.english" />
          </option>
       </select>
     </form>
          </div>
        <h1 class="col  s8 offset-s5">${mensAlert}</h1>
           
      <form method="POST" enctype="multipart/form-data" action="JugadoresServ" name="demo" class="col  s8 offset-s2" >
           <div class="row">
            <input type="text" name="codi" id="codi" value= "${codi}" hidden="hidden" /><br>
           <div class="input-field col  s12 ">
           <input type="text" name="nomb" id="nomb" class="validate"  value="${nomb}" required/>
            <label for="nomb"><fmt:message key="label.name4"/></label>
              </div>
           <div class="input-field col  s6 ">
           <input type="number" name="edad" id="edad" min="3" step="1" class="validate"  value="${edad}" required/><br>
            <label for="edad"><fmt:message key="label.name5"/></label>
           </div>
            <div class="input-field col  s6 ">
           <input type="number" name="peso" id="peso" min="0.01" step="0.01" class="validate"  value="${peso}" required/><br>
              <label for="peso"><fmt:message key="label.name6"/></label>
            </div>
            <div class="input-field col  s6">
           <input type="number" name="altura" id="altura"  min="0.01" step="0.01" class="validate"  value="${altura}" required/><br>
             <label for="altura"><fmt:message key="label.name7"/></label>
            </div>  
             <div class="input-field col  s6">
           <select id="cmbEquipo" name="cmbEquipo" >
      <option value="" disabled selected><fmt:message key="label.name8"/></option>
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
                  <label><fmt:message key="label.name10"/></label>
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
                <h1 class="col s7 offset-s3"><fmt:message key="label.name9"/></h1>
                <form method="POST" action="JugadoresServ" name="demo2" class="col s8 offset-s2" >
   <table class="striped">
        <thead>
          <tr>
              <th>Cons</th>
              <th><fmt:message key="label.name4"/></th>
              <th><fmt:message key="label.name5"/></th>
              <th><fmt:message key="label.name6"/></th>
              <th><fmt:message key="label.name7"/></th>
              <th><fmt:message key="label.name10"/></th>
              <th><fmt:message key="label.name3"/></th>
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
