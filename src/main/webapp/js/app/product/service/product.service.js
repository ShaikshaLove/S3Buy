angular.module("ProductApp").service("ProductService",function($http){

    this.getProducts=function(){
        return $http.get("http://192.168.43.157:7755/api/products");
    }

    this.saveProduct=function(product){
        return $http.post("",product);
    }

});