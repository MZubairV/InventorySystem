<%-- 
    Document   : logout
    Created on : 8 Dec, 2017, 1:09:14 AM
    Author     : mzv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%session.invalidate();
         response.sendRedirect("index.jsp");
        %>
    </body>
</html>
