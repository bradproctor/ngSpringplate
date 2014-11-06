angular.module("app.home")

    .config(['LogServiceProvider', function (LogServiceProvider) {
        LogServiceProvider.debugEnabled(true);
    }])

    .controller("HomeCtrl", ['$scope', '$location', 'HomeService', 'LogService', function($scope, $location, HomeService, LogService) {

        $scope.userInfo = [];

        HomeService.getUsers().success(function(users) {
            $scope.users = users;
        }).error(function(error) {
            LogService.log(error);
        });
        LogService.log("Users: ", $scope.users);
    }]);