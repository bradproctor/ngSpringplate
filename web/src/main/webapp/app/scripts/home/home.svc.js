angular.module("app.home")
    .factory("HomeService", ['$http', function($http){

        return {
            getUsers: function() {
                return $http({
                    url: '/web/users',
                    method: 'GET'
                });
            }
        };
    }]);