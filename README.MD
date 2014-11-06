# [ngSpringplate](https://github.com/cineris/ngSpringplate)

A [Spring MVC](http://spring.io) powered boilerplate project for [AngularJS](http://angularjs.org) projects.

***

## Quick Start

Install Node.js and then:

```sh
> git clone https://github.com/cineris/ngSpringplate.git
> cd ngSpringplate
> sudo npm -g install grunt-cli karma bower
> cd web/src/main/webapp
> npm install
> bower install
> cd ../../../..
> mvn clean install
```

You now have a `.war` file that you can deploy to your favorite server!

Happy hacking!

## Why?

`ngSpringplate` exists for one reason and one reason only: to make it easier
to spin up a Java-backed, enterprise level application with an AngularJS
front-end. It stubs out most of the wiring required for Spring MVC and Hibernate
on the back end, and contains a very scalable, modularized structure. It also
contains some specific support for development vs. production, particularly in
the `.jsp` file. This can be easily extended or stripped out.

This project is more focused more on the front end (AngularJS) than on the back end
(Java). This is because it is designed with two types of users in mind:

- Java developers that need a solid, scalable front end structure to kickstart
their project's development, as well as their knowledge of AngularJS.
- Javascript developers that want to hit the ground running with just enough back
end to get their enterprise project working.

Both the Java and Javascript are built to be as scalable and extensible as
possible, to allow this to very quickly become whatever you need it to be.

## What's Inside?

The front end is built out with popular frameworks to ensure extensibility
and continued support going forward:
[AngularJS](http://angularjs.org),
[Foundation](http://foundation.zurb.com),
[Angular-Foundation](https://github.com/pineconellc/angular-foundation),
[LESS](http://lesscss.org), and
[Grunt](http://gruntjs.org).

The back end is Spring MVC powered [Java](https://www.oracle.com/java/index.html)
that is already wired up from the web controller through the DAO layer.

## The Build

Grunt has been integrated into the `maven` build, so you don't have to worry about
drilling into the project and calling `grunt build` each time you want to build
the project. However, npm and bower are not integrated into the `maven` process,
since they do not need to run each time the project is built.

## Testing

Front end unit testing is already stubbed out and running with
[Karma](http://karma-runner.github.io/0.12/index.html), and end-to-end testing is
implemented through [Protractor](http://angular.github.io/protractor/).

The unit testing runs each time the project is built as part of the standard Grunt
build. The e2e tests have to be run manually, and requires the installation of some
additional packages.

NOTE: *The installation of phantomjs is optional. You can use it in place of a
standalone (real) browser for running e2e tests.*

Installing necessary packages:

```sh
> sudo npm -g install webdriver-manager phantomjs
> sudo webdriver-manager update --standalone
```

Run Selenium server:
```sh
> webdriver-manager start
```

Run Protractor e2e tests:
```sh
> cd ngSpringplate/web/src/main/webapp
> grunt protractor
```

## Contributing

Have ideas for improvement? Know of a best practice that is left out, violated, or
ignored? Let me know! This is an attempt at improving the quality and efficiency of
the code produced by our community, and I welcome any suggestions, tips, criticism,
etc. Feel free to contact me directly, or fork this project and improve it yourself.
If you have a gem that you would like to share with this project, please submit a
pull request!

### Thank you for checking this out and for being an awesome, progressive community.
