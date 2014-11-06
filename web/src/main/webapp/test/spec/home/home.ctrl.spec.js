'use strict';

describe('Unit: HomeCtrl', function () {

    // load the controller's module
    beforeEach(module('app.home', 'app.shared'));

    var httpBackend, rootScope, ctl;

    beforeEach(inject(function($controller, $rootScope, $httpBackend) {

        // Set up the mock http service responses
        httpBackend = $httpBackend;

        // Get hold of a scope (i.e. the root scope)
        rootScope = $rootScope;

        // The $controller service is used to create instances of controllers
        ctl = $controller('HomeCtrl', {
            $scope: rootScope
        });
    }));

    it('should load the server response into "$scope.users" for rendering.', function () {

        var responseData = [{"id":1,"firstName":"John","lastName":"Smith","email":"jsmith@email.net"},{"id":2,"firstName":"Jane","lastName":"Doe","email":"jdoe@email.net"}];

        httpBackend.expectGET('/web/users').respond(responseData);
        httpBackend.flush();

        expect(rootScope.users).toEqual(responseData);
    });
});