angular.module('app.shared')
    .factory('localize', ['$http', '$rootScope', '$window', '$filter', '$injector', function ($http, $rootScope, $window, $filter, $injector) {

        var localize = {
            language:$window.navigator.userLanguage || $window.navigator.language,
            dictionary: [],
            supportedLangs: [
                'en-US'
            ],

            initLocalizedResources: function () {
                localize.language = localize.supportedLangs.indexOf(localize.language) !== -1 ? localize.language : 'default';

                $injector.invoke([localize.language + '-messages', function(messages) {
                    localize.dictionary = messages;
                }]);
            },

            getLocalizedString: function (value) {
                var result = value;
                if ((localize.dictionary !== []) && (localize.dictionary.length > 0)) {
                    var entry = $filter('filter')(localize.dictionary, {key: value})[0];
                    if ((entry !== null) && (typeof entry !== 'undefined')) {
                        result = entry.value;
                    }
                }
                return result;
            }
        };
        localize.initLocalizedResources();

        return localize;
    }])
    .filter('i18n', ['localize', function (localize) {
        return function (input) {
            return localize.getLocalizedString(input);
        };
    }]);