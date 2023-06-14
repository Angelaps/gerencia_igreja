<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Secretaria</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="styles.css" rel="stylesheet" />
</head>


<body>
	<div class="d-flex" id="wrapper">
		<!-- Sidebar-->
		<div class="border-end bg-white" id="sidebar-wrapper">
			<div class="sidebar-heading border-bottom bg-light">Secretaria</div>
			<div class="list-group list-group-flush">
				<a class="list-group-item list-group-item-action list-group-item-light p-3" href="novo.html">Cadastrar</a> 
				<a class="list-group-item list-group-item-action list-group-item-light p-3" href="Controller?listagem">Presbiteros</a> 
				<a class="list-group-item list-group-item-action list-group-item-light p-3"href="Controller?listagemCoperadores">Cooperadores</a>
			</div>
		</div>
		<!-- Page content wrapper-->
		<div id="page-content-wrapper">
			<!-- Top navigation-->
			<nav
				class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
				<div class="container-fluid">
					<button class="btn btn-primary" id="sidebarToggle">Toggle
						Menu</button>
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
				</div>
			</nav>
			<!-- Page content-->
			<div class="container-fluid">
				<form action="update" name="frmContato">
					<div class="form-group">
						<input type="text" class="form-control" name="id_membro" id="exampleInputEmail1" placeholder="nome" value="<%out.print(request.getAttribute("id_membro"));%>">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Nome</label> <input type="text"
							class="form-control" id="exampleInputEmail1" placeholder="nome"
							name="nome" value="<%out.print(request.getAttribute("nome"));%>">
					</div>
					<div class="form-group">
						<label for="exampleFormControlSelect1">Cargo</label> 
						<select class="form-control" id="exampleFormControlSelect1" name="cargo">
							<option value="valor1">Opção</option>
							<option value="valor1"
								<%if ("valor1".equals(request.getAttribute("cargo"))) { out.print("selected"); }%>>Opção</option>
							<option value="Presbitero"
								<%if ("Presbitero".equals(request.getAttribute("cargo"))) {out.print("selected"); }%>>Presbitero</option>
							<option value="Cooperador"
								<%if ("Cooperador".equals(request.getAttribute("cargo"))) {out.print("selected");}%>>Coperador</option>
						</select>
					</div>
					<div class="form-group">
							<label for="exampleFormControlSelect1">Dizimista</label> 
							<select class="form-control" id="exampleFormControlSelect1" name="dizimista">
								<option value="valor1">Opção</option>
									<% if ("valor1".equals(request.getAttribute("dizimista"))) { out.print("selected"); } %>>Opção</option>
								<option value="Sim"
									<% if ("Sim".equals(request.getAttribute("dizimista"))) { out.print("selected"); } %>>Sim</option>
								<option value="Nao"
									<% if ("Nao".equals(request.getAttribute("dizimista"))) { out.print("selected"); } %>>Não</option>
							</select><br>
					</div>
						<button type="submit" class="btn btn-primary">Salvar</button>
				</form>
			</div>
		</div>
	</div>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="scripts.js"></script>

</body>
</html>