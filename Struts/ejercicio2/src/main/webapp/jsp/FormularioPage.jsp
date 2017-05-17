<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">@import url("css/estilos.css")</style>
<title>Ejercicio 2</title>
</head>
<body>
	<s:debug/>	
	<div id="formDiv">
		<s:form id="formulario" action="resultadoAction" method="post">
			<s:textfield name="formulario.nombre" id="formulario.nombre" label="%{getText('formulario.nombre')}" />
			<s:textfield id="formulario.apellidos" name="formulario.apellidos" label="%{getText('formulario.apellidos')}" />
			<s:textfield id="formulario.telefono" name="formulario.telefono" label="%{getText('formulario.telefono')}" />
			<s:textfield id="formulario.fechaNacimiento" name="formulario.fechaNacimiento" label="%{getText('formulario.fechaNacimiento')}" />
			<s:textfield id="formulario.sueldo" name="formulario.sueldo" label="%{getText('formulario.sueldo')}" />
			<s:textfield id="formulario.numHijos" name="formulario.numHijos" label="%{getText('formulario.numHijos')}" />
			<s:submit value="Enviar Datos" />
		</s:form>
	</div>
</body>
</html>