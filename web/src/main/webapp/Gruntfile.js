module.exports = function(grunt) {

    grunt.initConfig({
        copy: {
            build: {
                cwd: 'app',
                src: [
                    'vendor/angular*/*.min.js',
                    'vendor/jquery/dist/*.min.js',
                    'vendor/less/dist/*1.7.5.min.js',
                    'vendor/foundation/css/*.css',
                    'styles/*.css',
                    'styles/*.less',
                    'scripts/**/*.html',
                    'messages/*-messages.json',
                    'images/**'
                ],
                dest: 'build',
                expand: true
            }
        },

        clean: {
            build: {
                src: ['build/**/*.*', 'build/**']
            }
        },

        concat: {
            options: {
                separator: '\r\n'
            },
            dist: {
                src: ['app/scripts/app.js', 'app/scripts/*/**/app.js', 'app/scripts/**/*.js'],
                dest: 'build/release.js'
            }
        },

        jshint: {
            options: {
                camelcase: true,
                curly: true,
                eqeqeq: true,
                browser: true,
                noempty: true,
                unused: true,
                undef: true,
                devel: true,
                globals: {
                    angular: false,
                    jQuery: false
                }
            },
            files: ['app/scripts/**/*.js']
        },

        karma: {
            unit: {
                configFile: 'karma.conf.js',
                singleRun: true,
                logLevel: 'ERROR'
            }
        },

        less: {
            development: {
                files: {
                    "app/styles/app.css": "app/styles/app.less"
                }
            }
        },

        protractor: {
            options: {
                configFile: "node_modules/protractor/referenceConf.js", // Default config file
                keepAlive: true, // If false, the grunt process stops when the test fails.
                noColor: false, // If true, protractor will not use colors in its output.
                args: {
                    // Arguments passed to the command
                }
            },
            all: {   // Grunt requires at least one target to run so you can simply put 'all: {}' here too.
                options: {
                    configFile: "e2e.conf.js", // Target-specific config file
                    args: {} // Target-specific arguments
                }
            }
        },

        uglify: {
            my_target: {
                files: {
                    'build/release.js': 'build/release.js'
                }
            },
            options: {
                mangle: true,
                compress: true,
                wrap: true,
                preserveComments: false,
                unused: true
            }
        }
    });

    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-jshint');
    grunt.loadNpmTasks('grunt-contrib-less');
    grunt.loadNpmTasks('grunt-contrib-uglify');

    grunt.loadNpmTasks('grunt-karma');
    grunt.loadNpmTasks('grunt-protractor-runner');

    grunt.registerTask(
        'build',
        'Cleans build directory, syntactically validates .js files, compiles javascript into output file, compiles LESS styles, populates build directory, runs unit tests.',
        ['clean', 'jshint', 'concat', 'less', 'copy', 'karma']
    );

    grunt.registerTask(
        'release',
        'Builds and minifies for release.',
        ['build', 'uglify']
    );
}