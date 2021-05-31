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
    $scope.fillCategory = function () {
        $http.get(contextPath + '/categories', $scope.Category)
            .then(function (response) {
                $scope.Category = response.data;

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
                 $scope.SelectedCategory =$scope.fillCategory();
                $scope.fillTable();
            })

    };
    $scope.deleteProductById = function (productId) {
        $http.delete(contextPath + '/products/' + productId)
            .then(function (response) {
                $scope.fillTable();
            });
    }



    $scope.fillTable();
});