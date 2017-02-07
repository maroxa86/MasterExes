<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="articulos.beans.Articulo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% Articulo articulo = (Articulo) request.getAttribute("articulo"); %>
	<form id="editarArticulo" name="editarArticulo" method="post" action="salvarArticulo.do">
		<table>
			<tr>
				<td>
					<label for="nombre">Nombre</label>
				</td>
				<td>
					<input type="text" id="nombre" name="nombre" value="<%= articulo.getNombre()%>">
				</td>
			</tr>
			<tr>
				<td>
					<label for="tipo">Tipo</label>
				</td>
				<td>
					<input type="text" id="tipo" name="tipo" value="<%= articulo.getTipo()%>">
				</td>
			</tr>
			<tr>
				<td>
					<label for="precio">Precio</label>
				</td>
				<td>
					<input type="text" id="precio" name="precio" value="<%= articulo.getPrecio()%>">
				</td>
			</tr>
		</table>
		<input type="submit" id="editar" name="editar" value="Guardar"/>
		<input type="hidden" id="idArticulo" name="idArticulo" value="<%=articulo.getId() %>"/>
	</form>
</body>
</html>