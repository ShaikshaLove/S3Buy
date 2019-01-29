angular.module("UserApp").controller("UserRegController",function ($scope,UserRegService,$window){
      $scope.firstName="";
      $scope.lastName="";
      $scope.email="";
      $scope.user={};
      $scope.message="";
      $scope.showMsg=false;
      $scope.register=function(){
          $scope.user.firstName=$scope.firstName;
          $scope.user.lastName=$scope.lastName;
          $scope.user.email=$scope.email;

          UserRegService.saveUser($scope.user).then(function(serverdata){
              $scope.showMsg=true;
              $window.sucMsg=serverdata.data;
              $scope.firstName="";
              $scope.lastName="";
              $scope.email="";
              <!-- redirect to Conform Registration-->
              $window.location.href="#cnfReg";
          },function(error){

               alert("Something Went wrong !!!!!");
          });
      };






});
