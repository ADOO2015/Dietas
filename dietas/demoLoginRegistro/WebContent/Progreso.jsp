<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="utf-8">
	<meta name="viewport"    content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/boots1.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="js/Chart.js"></script>
	
	
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

		
<center>
		<div class="row">
			<div class="col-md-12">
			
								<h1>Historial de Progreso</h1>
				<div style="width:50%">
					<div>
						<canvas id="canvas" height="450" width="600"></canvas>
					</div>
				</div>
			
				
			</div>
			
			
			
			
			<br/><br/>
			
			
			
			
			<div class="col-md-12">
			
			
			<h1>Actualiza tu progreso</h1>
			
				<form class="form-horizontal" action="MiProgreso" method="post">
				  <fieldset>
					<div class="form-group">
					  <div class="col-lg-10">
						<input class="form-control" id="altura" placeholder="Altura" type="text" name="altura">
						 <input class="form-control" id="peso" placeholder="Peso" type="text" name="peso">
						  <input class="form-control" id="cadera" placeholder="Cadera" type="text" name="cadera">
						   <input class="form-control" id="cintura" placeholder="Cintura" type="text" name="cintura">
					  </div>
					</div>
					
					
				   
					
					<div class="form-group">
					  <div class="col-lg-10 col-lg-offset-2">
						<button type="submit" class="btn btn-primary">Actualizar Progreso</button>
					  </div>
					</div>
				  </fieldset>
				</form>
				</div>
			</div>
			
			
			
			
			
</div></center>



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


</body>
<% HttpSession sesion = request.getSession();
String x[]=(String[])sesion.getAttribute("x");
String y[]=(String[])sesion.getAttribute("y");%>

<script type="text/javascript">
	
		var lineChartData = {
			labels : [<% for (int i=0; i< x.length; i++) { out.print("\""+x[i]+"\"");if(i<x.length-1)out.print(", "); } %>],
			
			datasets : [
				{
					label: "My First dataset",
					fillColor : "rgba(220,220,220,0.2)",
					strokeColor : "#0B6BB0",
					pointColor : "rgba(220,220,220,1)",
					pointStrokeColor : "#fff",
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(220,220,220,1)",
					data :[<% for (int i=0; i< y.length; i++) {out.print("\""+y[i]+"\"");if(i<y.length-1)out.print(", "); } %>]
				}
			]

		}

	window.onload = function(){
		var ctx = document.getElementById("canvas").getContext("2d");
		window.myLine = new Chart(ctx).Line(lineChartData, {
			responsive: true
		});
	}


	</script>


</html>

