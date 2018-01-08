<%-- 
    Document   : puchasing
    Created on : 7 Dec, 2017, 3:15:33 AM
    Author     : mzv
--%>


<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Purchasing</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="modules/angular.min.js" type="text/javascript"></script>
        <link href="modules/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="modules/jquery-3.2.1.min.js" type="text/javascript"></script>
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">

        <script src="js/purchaseController.js"></script>

        <link rel="stylesheet" type="text/css" href="css/page.css">
        <link rel="stylesheet" type="text/css" href="css/searchProduct.css">
    </head>
    <body  ng-app="invoice" ng-controller="purchaseController">
        <!--connect to database-->
        <%
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/InventorySystem", "root", "root");
            String sql = "SELECT * FROM InventorySystem.product order by(id) desc";
//            SELECT * FROM   sales WHERE  date > (NOW() - INTERVAL 1 MONTH)
            Statement stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery(sql);
        %>

        <!-- Navbar -->
        <%@include file="header.jsp" %>

        <div class="container-fluid bg-2">
            <div class="container"> 
                <table class="table bg-info">
                    <thead>   
                        <tr>                  
                            <td> <form action="SendMail" method="post">
                                    <input type="submit"  class="form-control btn btn-success" value="Send purchase order">
                                </form>
                            </td>
                        </tr> 
                    </thead>
                </table>
            </div>


            <h1>Add new product</h1>
            <table class="table bg-info">
                <thead>   
                    <tr>                  
                        <td>Product name</td>
                        <td>Category</td>
                        <td>Cost price</td>
                        <td>Profit percentage</td>
                        <td>Count</td>
                        <td>Min. Count</td>         
                    </tr> </thead>
                <tbody>
                <form action="AddProduct">
                    <tr>
                        <td><input type="text" class="form-control" placeholder="Product name" name="product"></td>
                        <td><input type="text" class="form-control" placeholder="category" name="category"></td>
                        <td><input type="number" class="form-control" placeholder="cost price" name="costPrice" min="0"></td>
                        <td><input type="number" class="form-control" placeholder="profit percentage" name="profitPercentage"></td>
                        <td><input type="number" class="form-control" placeholder="Count" name="count"></td>
                        <td><input type="number" class="form-control" placeholder="Min. Count" name="minCount"></td>                        
                        <td><input type="submit" class="form-control btn btn-success" value="Add"></td>
                    </tr>
                </form>
                </tbody>
            </table>


            <h1>Update product</h1>
            <table class="table bg-info">
                <thead>   
                    <tr>                  
                        <td>Product name</td>
                        <td>Category</td>
                        <td>Cost price</td>
                        <td>Profit percentage</td>
                        <td>Available Count</td>
                        <td>Count</td>
                        <td>Min. Count</td>         
                    </tr> 
                </thead>
                <tbody>
                <form action="UpdateProduct">
                    <tr>
                        <!--<td><input type="text" class="form-control" placeholder="Product name" name="product"></td>-->
                        <td>            
                            <input type="hidden" name="productId" value={{items.id}} />
                            <input type='text' ng-keyup='fetchProducts(items.name)' placeholder="Product name"  ng-model='items.name' class="form-control" name="product"><br>
                            <ul id='searchResult' ng-show="listView" >
                                <li ng-click='setValue(result)' ng-repeat="result in searchResult" style="font-size: 15px">{{ result.name}}</li>

                            </ul>
                        </td>
                        <td><input type="text" class="form-control" placeholder="category" name="category" ng-model="items.category" readonly></td>
                        <td><input type="number" class="form-control" placeholder="cost price" name="costPrice" min="0" ng-model="items.costPrice" readonly></td>
                        <td><input type="number" class="form-control" placeholder="profit percentage" name="profitPercentage" ng-model="items.profitPercentage" readonly></td>
                        <td><input type="number" class="form-control" placeholder="Count" ng-model="items.remainingCount" readonly></td>
                        <td><input type="number" class="form-control" placeholder="Count" name="count" ng-model="items.count"></td>
                        <td><input type="number" class="form-control" placeholder="Min. Count" name="minCount" ng-model="items.minCount"></td>      
                        <td><input type="submit" class="form-control btn btn-success" value="Update"></td>
                    </tr>
                </form>
                </tbody>
            </table>


            <table class="table able-striped bg-3 ">
                <thead>
                    <tr>

                        <th>ID</th>
                        <th>Product</th>
                        <th>Category</th>
                        <th>Cost Price</th>                        
                        <th>Profit Percentage</th>                        
                        <th>Selling Price</th>                                                
                        <th>Profit</th>                        
                        <th>Count</th>                        
                        <th>Min. Count</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        while (rs.next()) {
                    %>
                    <tr>
                        <td><%=rs.getString(1)%></td>
                        <td><%=rs.getString(2)%></td>
                        <td><%=rs.getString(3)%></td>
                        <td><%=rs.getString(4)%></td>
                        <td><%=rs.getString(5)%></td>
                        <td><%=rs.getString(6)%></td>
                        <td><%=rs.getString(7)%></td>
                        <td><%=rs.getString(8)%></td>
                        <td><%=rs.getString(9)%></td>
                    </tr>
                    <%
                        }
                    %>
                    <tr>


                    </tr>                    
                </tbody>
            </table>
        </div>

        <!-- Footer -->
        <%@include file="footer.jsp" %>
    </body>
</html>
