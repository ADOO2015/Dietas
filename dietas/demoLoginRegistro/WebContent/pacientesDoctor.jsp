<%-- 
    Document   : index
    Created on : 23/06/2015, 12:30:12 AM
    Author     : Nedorowsky
    --%>
    <%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@page import = 
    "modelo.AccessUsuarioDAO,
    modelo.UsuarioDAO,
    modelo.Usuario,
    java.util.ArrayList"%>
    <%!
    	Usuario user = (Usuario)getServletContext().getAttribute("Usuario");
    %>
    <%!
    	AccessUsuarioDAO pacientes = new AccessUsuarioDAO();
    	ArrayList<Usuario> usuarios = (ArrayList)pacientes.findByMedico(user.getId());    	
    %> 
    <!DOCTYPE html>
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport"    content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        
        <title>Layout</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
          <div class="container-fluid">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Logo</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
          <ul class="nav navbar-nav navbar-right">
              <li><h3><%="#Usuario"%></h3></li>
              <li><a href="#">Cerrar Sesion</a></li>

          </ul>
      </div>
  </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-lg-3">
            
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 class="panel-title"><%="#USUARIO"%></h3>
                </div>
                <div class="panel-body">
                  <div class="list-group">
                    <a href="pacientesDoctor.jsp" class="list-group-item acve">
                        <img src="img/iconos/pacientes.svg" id="icn"/> Pacientes
                    </a>
                    <a href="#" class="list-group-item"><img src="img/iconos/agenda.svg" id="icn"/> Agenda
                    </a>
                    <a href="confirmacionPacientes.jsp" class="list-group-item"><img src="img/iconos/registro.svg" id="icn"/> Registro de pacientes
                    </a>
                </div>
            </div>
            <div class="panel-body">
                <div class="input-group">                              
                    <input type="text" class="form-control" placeholder="Buscar...">
                    <span class="input-group-btn">
                      <button class="btn btn-default" type="button">Q</button>
                  </span>
              </div>
          </div>
      </div>
      
  </div>
  <div class="col-md-8">
    <div class="jumbotron">
        <table class="table">
        <%
        String salida = "";
        if(user != null){
        	for(int i = 0; i < usuarios.size(); i++){ 
         	 salida = ""
          		+"<tr>"
           	     +"<td><img src= 'img/iconos/imagenGenerica3.svg' /></td>"
            	    + "<td><h4>Nombre: " + usuarios.get(i).getNombre() + "</h4><h4>Apellidos:" + usuarios.get(i).getApellidos() + "</h4></td>"
            	    +"<td><a href='#'><img src='img/iconos/Dieta.svg' id='icn'/></a><a href='#'><img id='icn' src='img/iconos/mensajes.svg'/></a><a href='#'><img id='icn' src='img/iconos/historial.svg'/></a><a href='#'><img  id='icn' src='img/iconos/Progreso.svg'/></a><a href='#'><img src='img/iconos/perfil.svg' id='icn'/></a><a href='#'><img src='img/iconos/agenda.svg' id='icn'/></a></td>" 
           	 +"</tr>";
          	out.print(salida);
       		 }
        }
        else
        	salida = "<tr><td>No tiene pacientes registrados</td></tr>";
        %>
        </table>                      
</div>
</div>
</div>

</div>
<div class="container" style="margin-top:100px;background:#213029;color:#FFF;width:100%;">

  <div class="row">
     <div class="col-md-12">
         <p style="text-align:center;">Empresa</p>	
         
     </div>
     
     
     
     
 </div> <!-- /row -->
 <hr>
 <div class="row">
     <div class="col-md-4">
       Mas información
       
   </div>
   
   
   <div class="col-md-4">
    Datos legales
</div>

<div class="col-md-4">
    Conoceno
</div>

</div> <!-- /row -->
<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>	

</div>   
</body>
</html>