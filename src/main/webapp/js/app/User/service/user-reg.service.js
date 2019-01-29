angular.module("UserApp").service("UserRegService",function($http){

    this.saveUser=function (user) {
        return $http.post("http://192.168.43.157:7755/api/users",user);
    };
    }
);