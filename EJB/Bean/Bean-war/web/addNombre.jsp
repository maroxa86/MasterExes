<%-- 
    Document   : insertar
    Created on : 05-mar-2017, 11:50:05
    Author     : Xavi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form id="insertar" name="insertar" action="insertNombre.do">
            <table>
                <tr>
                    <td>
                        Nombre
                    </td>
                    <td>
                        <input type="text" id="nombre" name="nombre"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Guardar"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
