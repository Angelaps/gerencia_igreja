<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agenda de contatos</title>
<link rel="icon" href="imagens/telefone.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Ediar Cadastro</h1>
	<form action="update" name="frmContato">
		<table>
			<tr>
				<td><input type="text" name="id_membro" class="caixa1"
					value="<%out.print(request.getAttribute("id_membro"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" class="caixa1"
					value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td>
					<select name="cargo" class="caixa1">
							<option value="valor1" <%if ("valor1".equals(request.getAttribute("cargo"))) { out.print("selected"); }%>>Opção</option>
							<option value="Presbitero"<%if ("Presbitero".equals(request.getAttribute("cargo"))) {out.print("selected"); }%>>Presbitero</option>
							<option value="Cooperador"<%if ("Cooperador".equals(request.getAttribute("cargo"))) {out.print("selected");}%>>Coperador</option>
					</select>
				</td>
			</tr>
			<tr>
			    <td>
			        <select name="dizimista" class="caixa1">
			            <option value="valor1" <% if ("valor1".equals(request.getAttribute("dizimista"))) { out.print("selected"); } %>>Opção</option>
			            <option value="Sim" <% if ("Sim".equals(request.getAttribute("dizimista"))) { out.print("selected"); } %>>Sim</option>
			            <option value="Nao" <% if ("Nao".equals(request.getAttribute("dizimista"))) { out.print("selected"); } %>>Não</option>
			        </select>
			    </td>
			</tr>
		</table>
		<input type="submit" value="Salvar" class="botao1">

	</form>

</body>
</html>