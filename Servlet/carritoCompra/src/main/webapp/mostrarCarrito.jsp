<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%List<String> listadoProductosCarrito = (List<String>) request.getSession().getAttribute("listadoProductosCarrito");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	El listado de productos en el carrito son:
	<%if(listadoProductosCarrito != null){%>
    <table>
    	<tr>
    		<td>Producto</td>
    		<td></td>
    	</tr>
        <%for(String producto : listadoProductosCarrito){%>
        <tr>
        	<td><%=producto %></td>
        </tr>
   	   	<%} 
   	}%>
	</table>
     <%if(listadoProductosCarrito != null){%>
      	Productos en el carrito: <%=listadoProductosCarrito.size()%>
     <%} 
     else{%>
       	Productos en el carrito: 0
     <%} %>
     <a href='index'>Volver</a>
</body>
</html>