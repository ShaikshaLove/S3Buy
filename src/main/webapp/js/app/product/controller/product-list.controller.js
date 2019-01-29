angular.module("ProductApp").controller("ProductCtrl",function($scope,ProductService){
        $scope.products=[];
        $scope.show=false;
        ProductService.getProducts().then(function(serverdata){
            $scope.products=serverdata.data;
        },function(error){
                alert("Something went wrong!! During fetching products  [ "+error+" ]");
        });
});