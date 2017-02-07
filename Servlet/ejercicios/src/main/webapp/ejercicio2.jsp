<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%Enumeration<String> parametros = request.getParameterNames();
            while(parametros.hasMoreElements()){
            	String param = parametros.nextElement();
            	String[] valores = request.getParameterValues(param);
            	for(String valor : valores){%>
            		Parametro <%=param%> : <%=valor %><br/>
            	<%}
            }%>
</body>
</html>