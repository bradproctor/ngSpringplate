exports.config = {
    seleniumAddress: 'http://localhost:4444/wd/hub',

    capabilities: {
        'browserName': 'chrome'
    },

    specs: ['test/e2e/**/*.spec.js'],

    jasmineNodeOpts: {
        showColors: true // use colors in the command line report
    }
};
