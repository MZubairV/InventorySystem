<%-- 
    Document   : header
    Created on : 7 Dec, 2017, 12:57:08 AM
    Author     : mzv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <!-- Navbar -->
        <nav class="navbar navbar-inverse">
            <div class="container" id="menu">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                    <a class="navbar-brand" href="billing.jsp" style="font-size: 25px">Andrew Departmental Store</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="billing.jsp">Billing</a></li>
                        <li><a href="puchasing.jsp">Purchasing</a></li>
                        <li><a href="reportCompletely.jsp">Reports</a></li>
                        <li><a href="logout.jsp">Logout</a></li>
                    </ul>
                </div>
            </div>
        </nav>

    </body>
</html>
