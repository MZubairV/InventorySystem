var invoice = angular.module('invoice', []);
invoice.controller('InvoiceController', function ($scope, $http) {
    $scope.totalBill = 0.0;
    $scope.totalProfit = 0.0;
    $scope.searchText;
    $scope.invoice = {
        items: [
            {
                sellingPrice: 0
            }
        ],
        customer: [
            {
                name: "",
                place: "",
                mobile: "",
                email: ""

            }
        ]
    };

    $scope.add = function () {
        $scope.invoice.items.push({
            quantity: ''
        });
    };

    $scope.remove = function (index) {
        $scope.invoice.items.splice(index, 1);
    };

    $scope.total = function () {
        totalBill = 0;
        totalProfit = 0;
        angular.forEach($scope.invoice.items, function (item) {
            totalBill += item.quantity * item.sellingPrice;
            totalProfit += item.sub_profit;
        });
        return totalBill;
    };

    $scope.checkAvailability = function (item) {
        if (item.quantity > item.remainingCount) {
            alert("Not available " + item.quantity + " units\n available only " + item.remainingCount);
            item.quantity = 1;
        }
    };

    $scope.fetchProducts = function (data, index) {
        $scope.invoice.items[index].list = true;
        $.post("SearchProduct", {
            searchText: data,
            searchFrom: "BillingSection"
        }, function (response) {
            console.log(response);
//            var res = JSON.parse(response);
            var data = JSON.parse(response);
            for (var i = 0; i < data.length; i++) {
                var key = data[i];
                console.log(key.name);
            }
            $scope.searchResult = data;
        });
    };

    $scope.setValue = function (index, data) {
        $scope.invoice.items[index].list = false;
// Fetched data
        $scope.invoice.items[index].id = data.id;
        $scope.invoice.items[index].name = data.name;
        $scope.invoice.items[index].category = data.category;
        $scope.invoice.items[index].costPrice = data.costPrice;
        $scope.invoice.items[index].profitPercentage = data.profitPercentage;
        $scope.invoice.items[index].sellingPrice = data.sellingPrice;
        $scope.invoice.items[index].unitProfit = data.profit;
        $scope.invoice.items[index].remainingCount = data.count;
        $scope.invoice.items[index].minCount = data.minCount;
    };

//    $scope.generateBill = function (data, cust) {
//        console.log("This data will be store in sales sales detail table:" + JSON.stringify(data));
//
//        $.post("UpdateSles", {
//            invoiceItem: JSON.stringify(data),
//            total: JSON.stringify(totalBill),
//            totalProfit: JSON.stringify(totalProfit),
//            customer: JSON.stringify(cust)
//        }, function (data) {
//            alert("Database update ");
//        });
//    };

    $scope.generateBill = function (data, cust) {
        var validated = true;

        document.getElementById("errorName").innerHTML = "";
        document.getElementById("errorPlace").innerHTML = "";
        document.getElementById("errorMobile").innerHTML = "";
        document.getElementById("errorEmail").innerHTML = "";

        console.log("This data will be store in sales sales detail table:" + JSON.stringify(data));

        //name field validating
        if ($scope.invoice.customer[0].name.length == 0) {
            document.getElementById("errorName").innerHTML = "Please enter customer name";
            validated = false;
        }

        //place field validating
        if ($scope.invoice.customer[0].place.length == 0) {
            document.getElementById("errorPlace").innerHTML = "Please enter customer place";
            validated = false;
        }

        //mobile number validation        
        var mobile = $scope.invoice.customer[0].mobile;
        if (mobile.length == 0) {
            document.getElementById("errorMobile").innerHTML = "Enter customer mobile number";
            validated = false;
        } else if (isNaN(mobile)) {
            document.getElementById("errorMobile").innerHTML = "Enter numbers only";
            validated = false;
        } else if (mobile.length > 10) {
            document.getElementById("errorMobile").innerHTML = "Enter valid mobile number";
            validated = false;
        }

        //email validation
        var email = $scope.invoice.customer[0].email;
        var emailFormat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
        if (email.length == 0) {
            document.getElementById("errorEmail").innerHTML = "Enter customer email ID";
            validated = false;
        } else if (!email.match(emailFormat)) {
            document.getElementById("errorEmail").innerHTML = "Enter valid email ID";
            validated = false;
        }


        if (validated) {
            $.post("SaveSales", {
                invoiceItem: JSON.stringify(data),
                total: JSON.stringify(totalBill),
                totalProfit: JSON.stringify(totalProfit),
                customer: JSON.stringify(cust)
            }, function (data) {
                //Database update                
                alert("Sales details added");
                window.location.href = 'http://localhost:9999/InventorySystem/billing.jsp';
            });
        }
    };

    $scope.billingValidation = function () {
        if (totalBill > 0) {
            return true;
        }
    };
});