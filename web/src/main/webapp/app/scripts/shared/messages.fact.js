angular.module('app.shared').
    factory('i18n', ['$http', '$rootScope', '$window', '$filter', function ($http, $rootScope, $window, $filter) {
        var localize = {
            language:$window.navigator.userLanguage || $window.navigator.language,
            messages: [],
            messagesLoaded: false,

            onMessageFileLoad: function (data) {
                localize.messages = data;
                localize.messagesLoaded = true;
            },
            initMessages: function () {
                var url = 'app/messages/' + localize.language + '-messages.json';

                $http({ method: "GET", url: url, cache: false })
                    .success(localize.onMessageFileLoad)
                    .error(function () {
                        var url = 'app/messages/en-US-messages.json';

                        $http({ method: "GET", url: url, cache: false })
                            .success(localize.onMessageFileLoad);
                });
            },
            getMessage: function (value) {
                var message = '';
                if ((localize.messages !== []) && (localize.messages.length > 0)) {
                    var entry = $filter('filter')(localize.messages, {key: value})[0];
                    if ((entry !== null) && (typeof entry !== 'undefined')) {
                        message = entry.value;
                    }
                }
                return message;
            }
        };
        localize.initMessages();

        return localize;
    }]).
    filter('i18n', ['i18n', function (i18n) {
        return function (input) {
            return i18n.getMessage(input);
        };
    }]);


