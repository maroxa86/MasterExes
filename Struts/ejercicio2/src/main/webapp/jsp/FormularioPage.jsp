<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">@import url("css/estilos.css")</style>
<title>Ejercicio 2</title>
</head>
<body>
	<ul>
	    <li>
	        <s:url var="en" action="Welcome">
	            <s:param name="request_locale">en</s:param>
	        </s:url>
	        <s:a href="%{en}">English</s:a>
	    </li>
	    <li>
	        <s:url var="es" action="Welcome">
	            <s:param name="request_locale">es</s:param>
	        </s:url>
	        <s:a href="%{es}">Español</s:a>
	    </li>
	    
	</ul>	

	<br/>
	<s:if test="errors.size() > 0">
		<div id="mensaje_error">
			<label>Se han producido los siguientes errores</label>
			<ul>
				<s:fielderror/>
			</ul>
		</div>
	</s:if>
	<div id="formDiv">
		<s:form id="formulario" action="resultadoAction" method="post">
			<s:textfield name="nombre" id="nombre" label="%{getText('formulario.nombre')}"/>
			<s:textfield id="apellidos" name="apellidos" label="%{getText('formulario.apellidos')}"/>
			<s:textfield id="telefono" name="telefono" label="%{getText('formulario.telefono')}"/>
			<s:textfield id="fechaNacimiento" name="fechaNacimiento" label="%{getText('formulario.fechaNacimiento')}"/>
			<s:textfield id="sueldo" name="sueldo" label="%{getText('formulario.sueldo')}"/>
			<s:textfield id="numHijos" name="numHijos" label="%{getText('formulario.numHijos')}"/>
			<s:submit value="Enviar Datos"/>
		</s:form>
	</div>
</body>
</html>