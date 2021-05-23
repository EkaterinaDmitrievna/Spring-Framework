angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/geek';

    $scope.fillTable = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                console.log(response);
                $scope.Products = response.data;
            });
    };

    // $scope.fillTable = function () {
    //     $http({
    //         url: contextPath + '/products',
    //         method: 'GET',
    //         params: {
    //             min_price: $scope.filter ? $scope.filter.min_price : null,
    //             max_price: $scope.filter ? $scope.filter.max_price : null
    //         }
    //     }).then(function (response) {
    //         $scope.ProductsList = response.data;
    //     });
    // };

    $scope.saveProduct = function () {
        console.log($scope.NewProduct)
        $http.post(contextPath + '/products', $scope.NewProduct)
            .then(function (response){
                $scope.NewProduct = null
                $scope.fillTable();
            })

    };
    $scope.deleteProductById = function (Products) {
        const index = $scope.Products.indexOf(Products);
        console.log(index);
        $scope.Products.splice(index,1);

    };



    $scope.fillTable();
});