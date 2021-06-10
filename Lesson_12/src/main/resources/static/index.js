angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8183/geek/api/v1';

    $scope.fillTable = function (pageIndex = 1) {
        console.log($scope.filter)
        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                title: $scope.filter ? $scope.filter.title : null,
                price: $scope.filter ? $scope.filter.price: null,
                category: $scope.filter ? $scope.filter.category: null,
                page: pageIndex
            }
        }).then(function (response) {
            console.log($scope.ProductsPage)
            $scope.ProductsPage = response.data;

            let minPageIndex = pageIndex - 2;
            if (minPageIndex < 1) {
                minPageIndex = 1;
            }

            let maxPageIndex = pageIndex + 2;
            if (maxPageIndex > $scope.ProductsPage.totalPages) {
                maxPageIndex = $scope.ProductsPage.totalPages;
            }

            $scope.PaginationArray = $scope.generatePagesIndexes(minPageIndex, maxPageIndex);
        });
    };

    $scope.generatePagesIndexes = function(startPage, endPage) {
        let arr = [];
        for (let i = startPage; i < endPage + 1; i++) {
            arr.push(i);
        }
        return arr;
    }

    $scope.saveProduct = function () {
        console.log($scope.NewProduct)
        $http.post(contextPath + '/products', $scope.NewProduct)

             .then(function (response){
                $scope.NewProduct = null
                 $scope.fillTable();
            })

    };



    $scope.deleteProductById = function (productId) {
        $http.delete(contextPath + '/products/' + productId)
            .then(function (response) {
                $scope.fillTable();
            });
    }

    $scope.orderByMe = function(x) {
        $scope.myOrderBy = x;
    }

    $scope.fillCart = function () {
        $http({
            url: contextPath + '/cart',
            method: 'GET',
        }).then(function (response) {
            console.log($scope.Cart)
            $scope.Cart = response.data;

        });
    };
    $scope.addToCart = function (productId) {
        console.log($scope.productId)
        $http.get(contextPath + '/cart/add/'+ productId)

            .then(function (response){
                $scope.fillCart();
            })

    };
    $scope.deleteFromCart= function (productId) {
        $http.get(contextPath + '/cart/delete/' + productId)
            .then(function (response) {
                $scope.fillCart();
            });
    }
    $scope.clearCart=function (){
        $http.get(contextPath + '/cart/clear')
            .then(function (response) {
                $scope.fillCart();
            });
    }

    $scope.fillCart();
    $scope.fillTable();
});