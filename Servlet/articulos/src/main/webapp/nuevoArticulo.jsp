<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form id="nuevoArticulo" name="nuevoArticulo" method="post" action="insertarArticulo.do">
		<table>
			<tr>
				<td>
					<label for="nombre">Nombre</label>
				</td>
				<td>
					<input type="text" id="nombre" name="nombre">
				</td>
			</tr>
			<tr>
				<td>
					<label for="tipo">Tipo</label>
				</td>
				<td>
					<input type="text" id="tipo" name="tipo">
				</td>
			</tr>
			<tr>
				<td>
					<label for="precio">Precio</label>
				</td>
				<td>
					<input type="text" id="precio" name="precio">
				</td>
			</tr>
		</table>
		<input type="submit" id="insertar" value="Insertar">
	</form>
</body>
</html>