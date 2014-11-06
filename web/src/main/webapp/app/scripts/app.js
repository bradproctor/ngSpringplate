angular.module("app", ['ngRoute', 'app.home'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider
            .otherwise({
                redirectTo: '/home'
            });
    }])

    .controller("AppCtrl", ['$scope', function($scope) {
        $scope.pageTitle = "ngSpringplate";

        $scope.getPageTitle = function() {
            return $scope.pageTitle;
        };
    }]);