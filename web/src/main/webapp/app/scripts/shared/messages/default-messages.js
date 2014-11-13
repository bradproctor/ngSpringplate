angular.module('app.shared')
    .provider("default-messages", function() {
        return {
            $get: function () {
                return [];
            }
        };
    });