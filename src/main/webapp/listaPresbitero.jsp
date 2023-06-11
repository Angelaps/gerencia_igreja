<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("presbiteros");


%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=], initial-scale=1.0">
    <title>Cooperador</title>
    <link rel="stylesheet" href="./tables/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
    <link rel="icon" type="image/x-icon" href="img/291924.png">
</head>
<body>
<a href="central.jsp">Adicionar um novo presbitero</a>
	<table>
		<thead>
			<th>Id</th>
			<th>Nome</th>
			<th>Cargo</th>
			<th>Dizimista</th>
			<th>Ação</th>
		</thead>
		<tbody>
			<%for (int i = 0; i < lista.size(); i++) {	%>
			<tr>
				<td><%=lista.get(i).getId_membro()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getCargo()%></td>
				<td><%=lista.get(i).getDizimista()%></td>
				<td>
					<a href="select?id_membro=<%=lista.get(i).getId_membro()%>">Editar</a>
					<a href="javascript: confirmar(<%=lista.get(i).getId_membro()%>)" class="botao2">Excluir</a>
				</td> 
			</tr>
			<%}%>
		</tbody>
	</table>
<script>
function confirmar(id_membro){
	 let resposta = confirm("confirmar a exclusão do contato ? ")
	  if (resposta === true) {
		//alert(id_member)
		window.location.href = "delete?id_membro=" + id_membro
	}
}

</script>
</body>

</html>