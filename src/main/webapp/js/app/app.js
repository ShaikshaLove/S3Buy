angular.module("S3BazaarApp",["UserApp","ngRoute","ProductApp"]);


// conguring urls



angular.module("S3BazaarApp").config(function($routeProvider){

    $routeProvider.when("/userLogin",{

        "templateUrl":"js/app/User/html/UserLogin.html",
        "controller":"UserLoginController"

    });


    $routeProvider.when("/userReg",{

        "templateUrl":"js/app/User/html/UserRegistration.html",
        "controller":"UserRegController"



    });

    $routeProvider.when("/cnfReg",{

        "templateUrl":"js/app/User/html/ConformReg.html",
        "controller":"UserRegCnfController"
    });

    $routeProvider.otherwise(
        {
            "templateUrl":"js/app/User/html/home.html",
        });


});