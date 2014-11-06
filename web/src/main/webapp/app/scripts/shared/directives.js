angular.module("app.shared")

    .directive('userInfo', function () {
        return {
            restrict: 'E',
            replace: true,
            scope: {
                info: '='
            },
            templateUrl: 'app/scripts/shared/userInfo.tpl.html'
        };
    });