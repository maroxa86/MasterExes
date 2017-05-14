<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<s:property value="%{getText('formulario.nombre')}"/>: <s:property value="nombre"/><br/>
	<s:property value="%{getText('formulario.apellidos')}"/>: <s:property value="apellidos"/><br/>
	<s:property value="%{getText('formulario.telefono')}"/>: <s:property value="telefono"/><br/>
	<s:property value="%{getText('formulario.fechaNacimiento')}"/>: <s:property value="fechaNacimiento"/><br/>
	<s:property value="%{getText('formulario.sueldo')}"/>: <s:property value="sueldo"/><br/>
	<s:property value="%{getText('formulario.numHijos')}"/>: <s:property value="numHijos"/><br/>
	<s:a action="FormularioAction">Volver</s:a>
</body>
</html>