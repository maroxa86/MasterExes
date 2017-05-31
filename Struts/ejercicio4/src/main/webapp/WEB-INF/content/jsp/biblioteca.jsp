<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ejercicio4</title>
<s:head/>
</head>
<body>
	<s:property value="parametro"/>
	<s:form name="formulario" method="post" action="resultadoAction">
		<s:label for="nombre" value="Nombre"/>
		<s:textfield name="nombre" maxlength="10"/>
		<s:password name="password" maxlength="5" label="contraseña"/>
		<s:textarea rows="2" cols="10" name="textArea" label="area de texto"/>
		<s:checkbox name="soyRobot" label="Soy un Robot?"/>
		<s:select list="listaColores" name="colores" label="colores">
			<s:optgroup label="Intensidad Color" list="listaIntensidadColor"/>
		</s:select>
		<s:radio list="listaAnimales" name="animales" label="¿Que animal te gusta?"/>
		<s:checkboxlist list="listaComida" name="comida" label="¿Que tipo de comida te gusta?" listKey="id" listValue="comida"/>
		<s:combobox list="listaFrutas" headerValue="Selecione Fruta" name="fruta" label="Seleciona una fruta"></s:combobox>
		<s:submit value="Enviar"/>
		<s:reset value="limpiar"/>
	</s:form>
</body>
</html>