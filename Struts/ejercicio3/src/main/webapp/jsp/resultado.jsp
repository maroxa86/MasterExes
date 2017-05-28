<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ejercicio 3</title>
</head>
<body>
	<s:property value="%{getText('usuario.usuario')}"/>: <s:property value="usuario.usuario"/><br/>
	<s:property value="%{getText('usuario.nombre')}"/>: <s:property value="usuario.nombre"/><br/>
	<s:property value="%{getText('usuario.apellidos')}"/>: <s:property value="usuario.apellidos"/><br/>
	<s:property value="%{getText('usuario.telefono')}"/>: <s:property value="usuario.telefono"/><br/>
	<s:property value="%{getText('usuario.fechaNacimiento')}"/>: <s:property value="usuario.fechaNacimiento"/><br/>
	<s:property value="%{getText('usuario.sueldo')}"/>: <s:property value="usuario.sueldo"/><br/>
	<s:property value="%{getText('usuario.numHijos')}"/>: <s:property value="usuario.numHijos"/><br/>
	<s:a action="formularioAction">Volver</s:a>
</body>
</html>