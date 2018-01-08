var invoice = angular.module('invoice', []);
invoice.controller('purchaseController', function ($scope, $http) {
    $scope.searchResult;
    $scope.listView = true;
    $scope.items = {};

    $scope.fetchProducts = function (data) {
        $scope.listView = true;
        $.post("SearchProduct", {
            searchText: data,
            searchFrom: "PurchaseSection"
        }, function (response) {
            console.log(response);
            var data = JSON.parse(response);
            for (var i = 0; i < data.length; i++) {
                var key = data[i];
                console.log(key.name);
            }
            $scope.searchResult = data;
        });
    };

    $scope.setValue = function (data) {
        $scope.listView = false;
// Fetched data
        $scope.items.id = data.id;
        $scope.items.name = data.name;
        $scope.items.category = data.category;
        $scope.items.costPrice = data.costPrice;
        $scope.items.profitPercentage = data.profitPercentage;
        $scope.items.sellingPrice = data.sellingPrice;
        $scope.items.unitProfit = data.profit;
        $scope.items.remainingCount = data.count;
        $scope.items.minCount = data.minCount;
    };
});