<%-- 
    Document   : index
    Created on : 04-mar-2017, 16:22:57
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
        <table>
            <tr>
                <td>
                    Identificador
                </td>
                <td>
                    Nombre
                </td>
            </tr>
        <c:forEach var="nombre" items="${listadoNombres}">
            <tr>
                <td>
                   ${nombre.id} 
                </td>
                <td>
                    ${nombre.nombre}
                </td>
                <td>
                    <a href="editNombre.do?idNombre=${nombre.id}">Editar Nombre</a>
                </td>
                <td>
                    <a href="deleteNombre.do?idNombre=${nombre.id}">Borrar Nombre</a>
                </td>
            </tr>
        </c:forEach>
        </table>
        <a href="addNombre.do">Nuevo Nombre</a>
    </body>
</html>
