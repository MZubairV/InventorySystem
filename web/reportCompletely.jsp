<%-- 
    Document   : reportCompletely
    Created on : 9 Dec, 2017, 9:48:44 PM
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
        <title>Complete Report</title>
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
            //            String sql = "SELECT * FROM sales WHERE DATE(date) = CURDATE()";
            Statement stmnt = con.createStatement();
        %>

        <!-- Navbar -->
        <%@include file="header.jsp" %>


        <div class="container-fluid bg-2">
            <div class="bg-primary " align="center">
                <h1>Complete Report</h1>
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
                        <%  String sqlTotal = "SELECT sum(total),sum(totalProfit),count(id) FROM sales";
                            ResultSet rsReports = stmnt.executeQuery(sqlTotal);
                            while (rsReports.next()) {
                        %>
                        <tr>
                            <td><h2>Total Sale from the start</h2></td>
                            <td><h2><%="₹ " + rsReports.getString(1)%></h2></td>
                        </tr>
                        <tr>
                            <td><h2>Total Profit from the start</h2></td>
                            <td><h2><%="₹ " + rsReports.getString(2)%></h2></td>
                        </tr>
                        <tr>
                            <td><h2>Total No of customer from the start</h2></td>
                            <td><h2><%=rsReports.getString(3)%></h2></td>
                        </tr>
                        <%
                            }
                        %>                        
                    </tbody>
                </table>
            </div>

            <!--Most and Least-->
            <div class="container">    
                <%
                    String sqlMost = "SELECT product_id, sum(quantity) from sales_details  group by (product_id) order by  sum(quantity) desc";
                    ResultSet rsMost = stmnt.executeQuery(sqlMost);
                    int productId = 0;
                    int countOfSale = 0;
                    while (rsMost.next()) {
                        productId = rsMost.getInt(1);
                        countOfSale = rsMost.getInt(2);
                        break;
                    }
//                    System.out.println("productId:" + productId);
//                    System.out.println("countOfSale:" + countOfSale);

//                    System.out.println("@@@@@@@" + "select * from product where id=" + productId);
                    String sqlMostDetails = "select * from product where id=" + productId;
                    ResultSet rsMostDetails = stmnt.executeQuery(sqlMostDetails);
                    while (rsMostDetails.next()) {

                %>
                <table class="table bg-info">
                    <!--<h1>Fast Moving Item is <span style="color: red"><%=rsMostDetails.getString(2)%></span> Purchased by <b><%=countOfSale%> times</b></h1>-->
                    <h1>Fast Moving Item is <span style="background-color: green"><%=rsMostDetails.getString(2)%></span>

                    <tbody>
                        <tr>
                            <td>Product Id</td>
                            <td>Product Name</td>
                            <td>Category</td>
                            <td>Cost Price</td>
                            <td>Profit Percentage</td>
                            <td>Selling Price</td>
                            <td>Profit</td>
                            <td>Available Count</td>
                            <td>Min Count</td>
                        </tr>
                        <tr>
                            <td><%=rsMostDetails.getString(1)%></td>
                            <td><%=rsMostDetails.getString(2)%></td>
                            <td><%=rsMostDetails.getString(3)%></td>
                            <td><%=rsMostDetails.getString(4)%></td>
                            <td><%=rsMostDetails.getString(5)%></td>
                            <td><%=rsMostDetails.getString(6)%></td>
                            <td><%=rsMostDetails.getString(7)%></td>
                            <td><%=rsMostDetails.getString(8)%></td>
                            <td><%=rsMostDetails.getString(9)%></td>
                        </tr>

                        <%
                            }
                        %>                 
                    </tbody>
                </table>
            </div>

            <!--non-moving items-->
            <div class="container">          
                <table class="table bg-info">
                    <h1>Non Moving Items</h1>
                    <tbody>
                        <tr>
                            <td>Product Id</td>
                            <td>Product Name</td>
                            <td>Category</td>
                            <td>Cost Price</td>
                            <td>Profit Percentage</td>
                            <td>Selling Price</td>
                            <td>Profit</td>
                            <td>Available Count</td>
                            <td>Min Count</td>
                            <td>Original Count</td>
                        </tr>
                        <%  String sqlNonMoving = "SELECT * FROM InventorySystem.product where originalCount=count";
                            ResultSet rsNonMoving = stmnt.executeQuery(sqlNonMoving);
                            while (rsNonMoving.next()) {
                        %>                        
                        <tr>
                            <td><%=rsNonMoving.getString(1)%></td>
                            <td><%=rsNonMoving.getString(2)%></td>
                            <td><%=rsNonMoving.getString(3)%></td>
                            <td><%=rsNonMoving.getString(4)%></td>
                            <td><%=rsNonMoving.getString(5)%></td>
                            <td><%=rsNonMoving.getString(6)%></td>
                            <td><%=rsNonMoving.getString(7)%></td>
                            <td><%=rsNonMoving.getString(8)%></td>
                            <td><%=rsNonMoving.getString(9)%></td>
                            <td><%=rsNonMoving.getString(9)%></td>
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
                    <h1>Every Day Sales details</h1>
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
                            String sqlGroupByDay = "select day(date),month(date),year(date) ,sum(total),sum(totalProfit),count(id) from sales group by day(date),month(date),year(date)";
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

            <!--Compete sales report-->
            <table class="table able-striped bg-3 ">
                <h1>Complete Bills</h1>
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
                        String sqlSales = "SELECT * FROM sales order by(id) desc";
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
