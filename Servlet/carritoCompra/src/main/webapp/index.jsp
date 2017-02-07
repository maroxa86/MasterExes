<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<% List<String> listadoProductos = (List<String>) request.getAttribute("listadoProductos"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	La lista de productos de la tienda es la siguiente: 
	<br/>
    <table>
    	<tr>
    		<td>Producto</td>
    		<td></td>
    	</tr>
        <%for(String producto : listadoProductos){%>
            	
        <tr>
        	<td><%=producto %></td>
        	<td>
        		<a href='addProducto?producto=<%=producto%>'>Añadir producto</a>
        	</td>
        </tr>
            <%}%>
	</table>
    <%List<String> listadoProductosCarrito = (List<String>) request.getSession().getAttribute("listadoProductosCarrito");
      if(listadoProductosCarrito != null){%>
      	Productos en el carrito: <%=listadoProductosCarrito.size()%>
     <%} 
     else{%>
       	Productos en el carrito: 0
     <%} %>
</body>
</html>