<%-- 
    Document   : reportDaily
    Created on : 9 Dec, 2017, 8:42:26 PM
    Author     : mzv
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daily Report</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>  

        <link rel="stylesheet" type="text/css" href="css/page.css">
    </head>
    <body ng-app="invoice" ng-controller="reportController">

        <!--connect to database-->
        <%
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/InventorySystem", "root", "root");
            Statement stmnt = con.createStatement();
        %>

        <!-- Navbar -->
        <%@include file="header.jsp" %>


        <div class="container-fluid bg-2">
            <div class="bg-primary " align="center">
                <h1>Daily Report</h1>
            </div>
            <div class="dropdown">
                <button class="btn btn-success dropdown-toggle" type="button" data-toggle="dropdown">Report
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="reportDaily.jsp">Daily</a></li>
                    <li><a href="reportWeekly.jsp">Weekly</a></li>
                    <li><a href="reportMonthly.jsp">Monthly</a></li>
                    <li><a href="reportCompletely.jsp">Completely</a></li>
                </ul>
            </div> 

            <!--Total sales-->
            <div class="container">          
                <table class="table bg-info">
                    <tbody>
                        <%  String sqlTotal = "SELECT sum(total),sum(totalProfit),count(id) FROM sales where date(date) = curdate()";
                            ResultSet rsReports = stmnt.executeQuery(sqlTotal);
                            while (rsReports.next()) {
                        %>
                        <tr>
                            <td><h2>Total Sale</h2></td>
                            <td><h2><%="₹ " + rsReports.getString(1)%></h2></td>
                        </tr>
                        <tr>
                            <td><h2>Total Profit</h2></td>
                            <td><h2><%="₹ " + rsReports.getString(2)%></h2></td>
                        </tr>
                        <tr>
                            <td><h2>No of customer</h2></td>
                            <td><h2><%=rsReports.getString(3)%></h2></td>
                        </tr>
                        <%
                            }
                        %>                        
                    </tbody>
                </table>
            </div>

            <!--Sales group by date-->
            <div class="container">          
                <table class="table bg-info">
                    <thead>
                        <tr>
                            <th>Day</th>
                            <th>Month</th>
                            <th>Year</th>
                            <th>Total Sale</th>                        
                            <th>Total Profit</th>                        
                            <th>No. of Customer</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            String sqlGroupByDay = "select day(date),month(date),year(date) ,sum(total),sum(totalProfit),count(id) from sales where date(date)= curdate() group by day(date),month(date),year(date) ";
                            ResultSet rsGroupByDay = stmnt.executeQuery(sqlGroupByDay);
                            while (rsGroupByDay.next()) {
                        %>
                        <tr>
                            <td><h2><%=rsGroupByDay.getString(1)%></h2></td>
                            <td><h2><%=rsGroupByDay.getString(2)%></h2></td>
                            <td><h2><%=rsGroupByDay.getString(3)%></h2></td>
                            <td><h2><%="₹ " + rsGroupByDay.getString(4)%></h2></td>
                            <td><h2><%="₹ " + rsGroupByDay.getString(5)%></h2></td>
                            <td><h2><%=rsGroupByDay.getString(6)%></h2></td>
                        </tr>
                        <%
                            }
                        %>                        
                    </tbody>
                </table>
            </div>

            <!--Daily sales report-->
            <table class="table able-striped bg-3 ">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Customer</th>
                        <th>Place</th>
                        <th>Mobile</th>                        
                        <th>Email</th>                        
                        <th>Total</th>                                                
                        <th>Date of Purchase</th>                        
                        <th>Total Profit</th>  
                    </tr>
                </thead>
                <tbody>
                    <%
                        String sqlSales = "SELECT * FROM sales WHERE DATE(date) = CURDATE()";
                        ResultSet rsSales = stmnt.executeQuery(sqlSales);
                        while (rsSales.next()) {
                    %>
                    <tr>
                        <td><%=rsSales.getString(1)%></td>
                        <td><%=rsSales.getString(2)%></td>
                        <td><%=rsSales.getString(3)%></td>
                        <td><%=rsSales.getString(4)%></td>
                        <td><%=rsSales.getString(5)%></td>
                        <td><%="₹ " + rsSales.getString(6)%></td>
                        <td><%=rsSales.getString(7)%></td>
                        <td><%="₹ " + rsSales.getString(8)%></td>
                    </tr>
                    <%
                        }
                    %>

                </tbody>
            </table>
        </div>

        <!-- Footer -->
        <%@include file="footer.jsp" %>
    </body>
</html>
