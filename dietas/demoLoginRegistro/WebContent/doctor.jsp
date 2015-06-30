<%-- 
    Document   : index
    Created on : 23/06/2015, 12:30:12 AM
    Author     : Nedorowsky
    --%>

    <%@page contentType="text/html" pageEncoding="UTF-8" import="modelo.Usuario"%>
    <%
  //tipo 1 autorizar pacientes, tipo 2 pcientes del doctor
    HttpSession sesion = request.getSession();
    int tipo;
    if(sesion.getAttribute("tipo").equals("Paciente"))
    	tipo =1;
    else
    	tipo=2;
	
    System.out.println(sesion.getAttribute("tipo"));
   
    %> 
    <!DOCTYPE html>
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport"    content="width=device-width, initial-scale=1.0">
        <link href="./css/bootstrap.min.css" rel="stylesheet">
        
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
              <li><h3> <%
                   	Usuario user =(Usuario)session.getAttribute("Usuario");
                   	String nombre =user.getNombre();
                    out.println(nombre);
                    %></h3></li>
              <li><a href="CerrarSesion.jsp">Cerrar Sesion</a></li>

          </ul>
      </div>
  </div>
</nav> <% if (tipo==2){%>
<div class="container">
    <div class="row">
        <div class="col-lg-3">
            
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3> <%
                   	
                    out.println(nombre);
                    %></h3>
                    
                </div>
                <div class="panel-body">
                  <div class="list-group">
                    <a href="#" class="list-group-item acve">
                        <img src="img/iconos/pacientes.svg" id="icn"/> Pacientes
                    </a>
                    <a href="#" class="list-group-item"><img src="img/iconos/agenda.svg" id="icn"/> Agenda
                    </a>
                    <a href="#" class="list-group-item"><img src="img/iconos/registro.svg" id="icn"/> Registro de pacientes
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
            <tr>
                <td><img src="img/iconos/imagenGenerica3.svg"/></td>
                <td><h4><%="#NOMBRE PACIENTE"%></h4><h4>Edad: <%="#EDAD"%></h4></td>
                <td><a href="#"><img src="img/iconos/Dieta.svg" id="icn"/></a><a href="#"><img id="icn" src="img/iconos/mensajes.svg"/></a><a href="#"><img id="icn" src="img/iconos/historial.svg"/></a><a href="#"><img  id="icn" src="img/iconos/Progreso.svg"/></a><a href="#"><img src="img/iconos/perfil.svg" id="icn"/></a><a href="#"><img src="img/iconos/agenda.svg" id="icn"/></a></td>
                
            </tr>
            <tr>
                <td><img src="img/iconos/imagenGenerica3.svg"/></td>
                <td><h4><%="#NOMBRE PACIENTE"%></h4><h4>Edad: <%="#EDAD"%></h4></td>
                <td><a href="#"><img src="img/iconos/Dieta.svg" id="icn"/></a><a href="#"><img id="icn" src="img/iconos/mensajes.svg"/></a><a href="#"><img id="icn" src="img/iconos/historial.svg"/></a><a href="#"><img  id="icn" src="img/iconos/Progreso.svg"/></a><a href="#"><img src="img/iconos/perfil.svg" id="icn"/></a><a href="#"><img src="img/iconos/agenda.svg" id="icn"/></a></td>
                
            </tr>
        </table>
        <%} else if(tipo==1){                                 
        %><div class="container">
    <div class="row">
        <div class="col-lg-3">
            
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3> <%
                   	
                    out.println(nombre);
                    %></h3>
                    
                </div>
                <div class="panel-body">
                  <div class="list-group">
                   
                    <a href="#" class="list-group-item"><img src="img/iconos/Dieta.svg" id="icn"/> Dieta
                    </a>
                    <a href="#" class="list-group-item"><img src="img/iconos/Progreso.svg" id="icn"/> Progreso
                    </a>
                    </a>
                    <a href="#" class="list-group-item"><img src="img/iconos/historial.svg" id="icn"/> Historial
                    </a>
                    </a>
                    <a href="#" class="list-group-item"><img src="img/iconos/agenda.svg" id="icn"/> Agenda
                    </a>
                    </a>
                    <a href="#" class="list-group-item"><img src="img/iconos/mensajes.svg" id="icn"/> Mensajes
                    </a>
                    </a>
                    <a href="#" class="list-group-item"><img src="img/iconos/perfil.svg" id="icn"/> Perfil
                    </a>
                </div>
            </div>
           
      </div>
      
  </div>
        
    <%    
} %>                              
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
