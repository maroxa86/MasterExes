<%-- 
    Document   : editNombre
    Created on : 05-mar-2017, 14:07:12
    Author     : Xavi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form id="edit" name="edit" action="saveNombre.do">
            <table>
                <tr>
                    <td>
                        Nombre
                    </td>
                    <td>
                        <input type="text" id="nombre" name="nombre" value="${nombre.nombre}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Guardar"/>
                    </td>
                </tr>
            </table>
            <input type="hidden" id="idNombre" name="idNombre" value="${nombre.id}"/>
        </form>
    </body>
</html>
