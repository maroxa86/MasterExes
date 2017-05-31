<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ejercicio4</title>
<s:head />
</head>
<body>
	Nombre: <s:property value="nombre" /><br />
	Contraseña: <s:property value="password" /><br /> 
	Area de Texto: <s:property value="textArea" /><br />
	Soy un robot:<br /> 
	Color: <s:property value="color" /><br />
	Intensidad: <s:property value="intensidad" /><br />
	Animal que te gusta:
	<s:if test="animales == 1">
		Perro
	</s:if>
	<s:elseif test="animales == 2">
		Gato
	</s:elseif>
	<s:elseif test="animales==3">
		Tortuga
	</s:elseif>
	<s:elseif test="animales == 4">
		Perro, Gato y Tortuga
	</s:elseif>
	<s:elseif test="animales == 5">
		Ningúno
	</s:elseif>
	<br />
	Tipo de comida que te gusta: <s:property value="comida" /><br />
	Fruta: <s:property value="fruta" /><br />
	<s:action name="accionAction" executeResult="false">
     Salida del tag s:action:<br />
	</s:action>
	<s:iterator value="#attr.nombres">
		<s:property />, 
	</s:iterator>
	<br/><br/>
	Utilizacion etiqutas bean, param
	<s:bean name="org.apache.struts2.util.Counter" var="contador">
	   <s:param name="first" value="20"/>
	   <s:param name="last" value="25" />
	</s:bean>
	<ul>
	   <s:iterator value="#contador">
	      <li><s:property /></li>
	   </s:iterator>
	</ul>
	<br/><br/>
	Fecha Actual: <s:date name="fechaActual" format="dd/MM/yyyy"/><br/>
	
	(Property) Nombre Entorno: 
    <s:property value="entorno.nombre"/><br/>

    (Push) Nombre Entorno: 
    <s:push value="entorno">
      <s:property value="nombre"/><br/>
    </s:push>

    (Set) Nombre Entorno:
    <s:set var="miEntorno" value="entorno.nombre"/>
    <s:property value="miEntorno"/><br/>
	
	<s:url action="bibliotecaAction" var="myurl">
	</s:url>

	<a href='<s:property value="#myurl"/>'>
	<s:property value="#myurl"/></a><br/>
	
	<s:a href="bibliotecaAction">Volver</s:a>
</body>
</html>