angular.module("app.home", ['ngRoute', 'app.shared'])

    .config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/home', {
            templateUrl: 'app/scripts/home/home.tpl.html',
            controller: 'HomeCtrl'
        });
    }]);