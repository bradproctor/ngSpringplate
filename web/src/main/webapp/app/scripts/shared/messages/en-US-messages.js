angular.module('app.shared')
    .provider("en-US-messages", function() {
        return {
            $get: function () {
                return [
                    {
                        key: '_title_',
                        value: 'ngSpringPlate'
                    }, {
                        key: '_users_',
                        value: 'Users'
                    }, {
                        key: '_firstName_',
                        value: 'First Name'
                    }, {
                        key: '_lastName_',
                        value: 'Last Name'
                    }, {
                        key: '_email_',
                        value: 'Email'
                    }
                ];
            }
        };
    });