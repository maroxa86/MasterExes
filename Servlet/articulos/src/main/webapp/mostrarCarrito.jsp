<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="articulos.beans.Articulo" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Los articulos del carrito son</h1>
	<table>
		<tr>
			<td>Articulo</td>
			<td>Cantidad</td>
		</tr>
		<%
			Map<String, Integer> listaArticulos = (Map<String, Integer>)request.getAttribute("listadoArticulos");
			for(Map.Entry<String, Integer> entry : listaArticulos.entrySet()){
				%>
				<tr>
					<td>
						<%=entry.getKey() %>
					</td>
					<td>
						<%=entry.getValue() %>
					</td>
				</tr>
				<%
			}
		%>
	</table>
	<a href="volver.do">Volver</a>
</body>
</html>