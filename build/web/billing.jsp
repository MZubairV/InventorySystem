<%-- 
    Document   : billing
    Created on : 7 Dec, 2017, 12:43:32 AM
    Author     : mzv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Billing</title>

        <script src="modules/angular.min.js" type="text/javascript"></script>
        <link href="modules/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="modules/jquery-3.2.1.min.js" type="text/javascript"></script>
        <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">

        <link rel="stylesheet" type="text/css" href="css/page.css">
        <link rel="stylesheet" type="text/css" href="css/searchProduct.css">

        <script src="js/InvoiceController.js"></script>
    </head>
    <body>
        <%@include file="header.jsp" %>


        <div class="container" ng-app="invoice" ng-controller="InvoiceController">
            <!--main div--> 
            <div class="container-fluid bg-2 ">
                <div class="bg-primary " align="center">
                    <h1>Billing Section</h1>
                </div>
                <table class="table">
                    <tbody>
                        <tr>
                            <td class="font-white">Customer Name</td>
                            <td><input type="text" ng-model="invoice.customer[0].name" class="form-control" placeholder="Customer Name"></td>
                            <td><span class="errorMessage" id="errorName"></span></td>
                            <td>&nbsp;</td>
                        </tr>  
                        <tr>
                            <td class="font-white">Place</td>
                            <td><input type="text" ng-model="invoice.customer[0].place" class="form-control" placeholder="Place"></td>
                            <td><span class="errorMessage" id="errorPlace"></span></td>
                            <td>&nbsp;</td>
                        </tr> 
                        <tr>
                            <td class="font-white">Mobile</td>
                            <td><input type="text" ng-model="invoice.customer[0].mobile" class="form-control" placeholder="mobile"></td>
                            <td><span class="errorMessage" id="errorMobile"></span></td>
                            <td>&nbsp;</td>                          
                        </tr> 
                        <tr>
                            <td class="font-white">Email</td>
                            <td><input type="text" ng-model="invoice.customer[0].email" class="form-control" placeholder="email"></td>
                            <td><span class="errorMessage" id="errorEmail"></span></td>
                            <td>&nbsp;</td>
                        </tr> 

                    </tbody>
                </table>
            </div>

            <div class="container-fluid bg-3 " style="background-color: #c5cae9">
                <!--Invoice-->
                <form>
                    <section class="row" >
                        <table class="table ">
                            <thead>
                            <th>NO</th>
                            <th>Product</th>
                            <th>Quantity</th>
                            <th>Category</th>
                            <th>Price</th>
                            <th>Sub Total</th>
                            <th>Delete</th>
                            </tr>

                            </thead>
                            <tbody>
                                <tr ng-repeat="item in invoice.items">
                                    <td>{{$index + 1}}</td>
                                    <td>
                                        <input type='text' ng-keyup='fetchProducts(item.name, $index)' placeholder="itemName"  ng-model='item.name' class="form-control"><br>
                                        <ul id='searchResult' ng-show="item.list" >
                                            <li ng-click='setValue($parent.$index, result)' ng-repeat="result in searchResult" style="font-size: 15px">{{ result.name}}</li>

                                        </ul>
                                    </td>
                                    <td><input type="number" ng-model="item.quantity" ng-init="item.quantity = 1" class="form-control" ng-keyup="checkAvailability(item)"/></td>
                                    <td>{{item.category}}</td>
                                    <td>₹ {{item.sellingPrice}}</td>
                                    <td>₹ {{item.sub_total = item.quantity * item.sellingPrice}}</td>
                                    <td hidden="true">{{item.sub_profit = item.quantity * item.unitProfit}}</td>
                                    <td><button type="button" class="btn btn-danger" ng-click="remove($index)">Delete</button></td>
                                </tr>
                                <tr>
                                    <td><button type="button" class="btn btn-primary" ng-click="add()">Add item</button></td>
                                    <td></td>
                                    <td></td>
                                    <td>Total : </td>
                                    <td>₹ {{total()}} </td>                      



                                </tr>
                            </tbody>
                        </table>
                        <div>
                            <button data-ng-click="generateBill(invoice.items, invoice.customer)" class="btn btn-success btn-group-justified" ng-disabled="!billingValidation()">Save{{}}</button>
                        </div>
                    </section>
                </form>
            </div>
        </div>

        <!-- Footer -->
        <%@include file="footer.jsp" %>
    </body>
</html>
