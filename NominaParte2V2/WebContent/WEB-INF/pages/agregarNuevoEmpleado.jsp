<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion de Nominas 3.1</title>
</head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<style>
h1 {
	justify-content: flex end;
	font-size: 52px;
	color: #6061b1;
	text-decoration: underline;
}
</style>
<body>

	<div class="container">
		<h1 class="text-center">Gestion de nominas 3.1</h1>
	</div>

	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<h2>Nuevo empleado</h2>

				<form method="post"
					action="/NominaParte2V2/EmpleadoServlet?accion=insertarEmpleado">

					<fieldset class="form-group">
						<label>Nombre</label> <input type="text" class="form-control"
							name="nombre" required>
					</fieldset>

					<fieldset class="form-group">
						<label>DNI</label> <input type="text" class="form-control"
							name="dni" required>
					</fieldset>

					<fieldset class="form-group">
						<label>Sexo</label> <input type="text" class="form-control"
							name="sexo" required>
					</fieldset>

					<fieldset class="form-group">
						<label>Años</label> <input class="form-control" name="anyos"
							required>
					</fieldset>

					<fieldset class="form-group">
						<label>Categoría</label> <input pattern="^([1-9]|10)$"
							class="form-control" name="categoria" required>
					</fieldset>


					<input type="submit" value="Guardar" class="btn btn-success">
				</form>
			</div>
		</div>
		<a class="btn btn-primary" href="/NominaParte2V2/EmpleadoServlet">
			Volver </a>
	</div>

</body>
</html>