<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="articulos.beans.*" %>
<%@ page import="java.util.List" %>
<%Usuario usuario = (Usuario) request.getSession().getAttribute("usuario"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="logout.do">Salir</a>
	<%
	if("admin".equals(usuario.getRol())){
	%>
		<a href="nuevoArticulo.do">Nuevo Producto</a>
	<%} %>
	<table>
		<tr>
			<td>
				Nombre
			</td>
			<td>
				Tipo
			</td>
			<td>
				Precio
			</td>
		</tr>
		<%
			List<Articulo> listaArticulos = (List<Articulo>)request.getAttribute("listadoArticulos");
			for(Articulo articulo : listaArticulos){
				%>
				<tr>
					<td>
						<%=articulo.getNombre() %>
					</td>
					<td>
						<%=articulo.getTipo() %>
					</td>
					<td>
						<%=articulo.getPrecio() %>
					</td>
					<%
					if("usuario".equals(usuario.getRol())){
					%>
						<td>
							<a href="addCarrito.do?idArticulo=<%=articulo.getId() %>">Añadir Carrito</a>
						</td>
					<%}
					if("admin".equals(usuario.getRol())){
					%>
					<td>
						<a href="editarArticulo.do?idArticulo=<%=articulo.getId() %>">Editar Articulo</a>
					</td>
					<td>
						<a href="borrarArticulo.do?idArticulo=<%=articulo.getId() %>">Borrar Articulo</a>
					</td>
					<%}	%>
				</tr>
				<%
			}
		%>
	</table>
	<%
	if("usuario".equals(usuario.getRol())){
	%>
	<a href="mostrarCarrito.do">Mostrar Carrito</a>
	<%}%>
	
</body>
</html>