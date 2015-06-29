<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
<head>
	<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<link href="css/bootstrap.min.css" rel="stylesheet">
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
        <ul class="nav navbar-nav">
          <li class="active"><a href="#">Inicio <span class="sr-only">(current)</span></a></li>
          <li ><a href="#">Contacto</a></li>
          <li><a href="#">Mas de nosotros</a></li>
        </ul>
      </div>
    </div>
  </nav>
  <div class="container">
    <div class="jumbotron">
      <form class="form-horizontal">
        <fieldset>
          <legend>Formulario - Registro</legend>
          <div class="form-group">
            <label for="inputEmail" class="col-lg-2 control-label">Correo</label>
            <div class="col-lg-10">
              <input name="correo" type="text" class="form-control" id="inputEmail" placeholder="Email" required>
            </div>
          </div>
          <div class="form-group">
            <label for="inputPassword" class="col-lg-2 control-label">Contraseña</label>
            <div class="col-lg-10">
              <input name="contrasena" type="password" class="form-control" id="inputPassword" placeholder="Password" required>
            </div>
          </div>
          <div class="form-group">
            <label for="inputPassword" class="col-lg-2 control-label">Confirmar Contraseña</label>
            <div class="col-lg-10">
              <input name="confirmaContrasena" type="password" class="form-control" id="inputPassword" placeholder="Password" required>
            </div>
          </div>

          <div class="form-group">
            <label class="control-label" for="inputSmall">Nombre</label>
            <input name="nombre" class="form-control input-sm" type="text" id="inputSmall" required>
          </div>

          <div class="form-group">
            <label class="control-label" for="inputSmall">Apellidos</label>
            <input name="apellidos" class="form-control input-sm" type="text" id="inputSmall"required>
          </div>

          <div class="form-group">
            <label class="control-label" for="inputSmall">Domicilio</label>
            <input name="domicilio" class="form-control input-sm" type="text" id="inputSmall" required>
          </div>

          <div class="form-group">
            <label class="control-label" for="inputSmall">Ciudad</label>
            <input name="ciudad" class="form-control input-sm" type="text" id="inputSmall" required>
          </div>

          <div class="form-group">
            <label class="control-label" for="inputSmall">Número</label>
            <input name="numeroConsultorio" class="form-control input-sm" type="text" id="inputSmall" required>
          </div>

          <div class="form-group">
            <div class="col-lg-10 col-lg-offset-2">
              <button type="reset" class="btn btn-default">Cancelar</button>
              <button type="submit" class="btn btn-primary">Aceptar y Guardar</button>
            </div>
          </div>
        </fieldset>
      </form>
    </div>

    

  </div>	<!-- /container -->



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
      Conocenos
    </div>
    
  </div> <!-- /row -->

  

</div>	<!-- /container -->
<!-- Bootstrap core JavaScript
  ================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>

</html>