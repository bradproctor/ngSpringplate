describe('Home', function () {

    beforeEach(function () {
        browser.get('http://localhost:8080/web');
    });

    it("should have details for two users", function() {
        expect(element.all(by.css('.userInfoContainer')).count()).toBe(2);
    });
});
