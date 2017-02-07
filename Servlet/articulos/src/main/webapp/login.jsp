<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String error = (String)request.getAttribute("error");
		if( error != null && error.equals("loginInvalido")){
			%>
			<h4 style="color: red;">Usuario o contraseña erronea. Vuelva a intentarlo</h4>
			<%
		}
		else{
			if(error != null && error.equals("accesoProhibido")){
				%>
				<h4 style="color: red;">Hay que introducir el usuario y la contraseña</h4>
				<%	
			}
		}
	%>
	<form id="login" name="login" method="post" action="login.do">
		<table>
			<tr>
				<td>
					<label for="usuario">Usuario</label>
				</td>
				<td>
					<input type="text" id="usuario" name="usuario"/>
				</td>
			</tr>
			<tr>
				<td>
					<label for="password">Contraseña</label>
				</td>
				<td>
					<input type="password" id="password" name="password"/>
				</td>
			</tr>
		</table>
		<br/>
		<input type="submit" id="enviar" name="enciar" value="Enviar"/>
	</form>
</body>
</html>