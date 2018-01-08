<%-- 
    Document   : index
    Created on : 7 Dec, 2017, 3:13:16 AM
    Author     : mzv
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="modules/angular.min.js" type="text/javascript"></script>
        <link href="modules/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="modules/jquery-3.2.1.min.js" type="text/javascript"></script>
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
        
        <link rel="stylesheet" type="text/css" href="css/page.css">
    </head>

    <body class="container-fluid bg-2 ">
        <div class="bg-primary " align="center">
            <h1>Andrew Departmental Storet</h1>
        </div>
        <div>
            <form action="Login">
                <div class="row">
                    <div class="col-sm-3"></div>
                    <div class="col-sm-6">Email:</div>
                    <div class="col-sm-3"></div>   
                </div>
                <div class="row">
                    <div class="col-sm-3"></div>
                    <div class="col-sm-6"><input type="email" class="form-control"  placeholder="Enter email" name="email" value="andrew@indian.com"></div>
                    <div class="col-sm-3"></div>   
                </div>
                <div class="row">
                    <div class="col-sm-3"></div>
                    <div class="col-sm-6">Password:</div>
                    <div class="col-sm-3"></div>   
                </div>
                <div class="row">
                    <div class="col-sm-3"></div>
                    <div class="col-sm-6"><input type="password" class="form-control" placeholder="Enter password" name="pwd" value="password"></div>
                    <div class="col-sm-3"></div>   
                </div>
                <div class="row">
                    <div class="col-sm-12">&nbsp;</div>
                    <div class="col-sm-6"></div>
                    <div class="col-sm-3"></div>   
                </div>
                <div class="row">
                    <div class="col-sm-3"></div>
                    <div class="col-sm-6"><input type="submit" class="btn btn-success btn-block"value="Login"></div>
                    <div class="col-sm-3"></div>   
                </div>
            </form>
        </div> 
    </body>
</html>
