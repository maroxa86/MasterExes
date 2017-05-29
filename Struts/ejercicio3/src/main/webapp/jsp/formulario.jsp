<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">@import url("css/estilos.css")</style>
<title>Ejercicio 3</title>
</head>
<body>
	<s:debug/>	
	<div id="formDiv">
		<s:if test="hasActionMessages()">
		   <div class="welcome">
		      <s:actionmessage/>
		   </div>
		</s:if>
		<s:if test="hasActionErrors()">
		   <div class="errors">
		      <s:actionerror/>
		   </div>
		</s:if>
		<s:form id="usuario" action="resultadoAction" method="post">
			<s:property value="%{getText('usuario.usuario')}"/>: <s:property value="usuario.usuario"/><br/>
			<s:textfield name="usuario.nombre" id="usuario.nombre" label="%{getText('usuario.nombre')}" />
			<s:textfield id="usuario.apellidos" name="usuario.apellidos" label="%{getText('usuario.apellidos')}" />
			<s:textfield id="usuario.telefono" name="usuario.telefono" label="%{getText('usuario.telefono')}" />
			<s:textfield id="usuario.fechaNacimiento" name="usuario.fechaNacimiento" label="%{getText('usuario.fechaNacimiento')}" />
			<s:textfield id="usuario.sueldo" name="usuario.sueldo" label="%{getText('usuario.sueldo')}" />
			<s:textfield id="usuario.numHijos" name="usuario.numHijos" label="%{getText('usuario.numHijos')}" />
			<s:submit value="%{getText('formulario.submit')}" />
		</s:form>
		<s:a href="logout">Desconectar</s:a>
	</div>
</body>
</html>