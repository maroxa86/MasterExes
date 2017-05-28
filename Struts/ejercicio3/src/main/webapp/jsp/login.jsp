<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Ejercicio3</title>
		<style type="text/css">
			.errors {
				background-color:#FFCCCC;
				border:1px solid #CC0000;
				width:400px;
				margin-bottom:8px;
			}
			.errors li{
				list-style: none;
			}
		</style>
	</head>
	<body>
		<s:debug />
		<s:if test="hasActionErrors()">
		   <div class="errors">
		      <s:actionerror/>
		   </div>
		</s:if>
		<div id="formDiv">
			<s:form id="login" action="checkLoginAction" method="post">
				<s:textfield name="user" id="user" label="%{getText('login.usuario')}" />
				<s:textfield id="password" name="password" label="%{getText('login.password')}" />
				<s:submit value="%{getText('login.entrar')}" />
			</s:form>
		</div>
	</body>
</html>