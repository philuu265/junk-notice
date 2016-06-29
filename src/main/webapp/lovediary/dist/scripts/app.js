'use strict';

/**
 * @ngdoc overview
 * @name lovediaryApp
 * @description
 * # lovediaryApp
 *
 * Main module of the application.
 */
var app = angular
  .module('lovediaryApp', [
    'ui.router',
    'oc.lazyLoad',
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngSanitize',
    'ngTouch'
  ])

app.config(function ($stateProvider, $urlRouterProvider, $ocLazyLoadProvider, $controllerProvider, $locationProvider) {
    //$routeProvider
    //  .when('/', {
    //      templateUrl: 'views/main.html',
    //      controller: 'MainCtrl',
    //      controllerAs: 'main'
    //  })
    //  .when('/about', {
    //      templateUrl: 'views/about.html',
    //      controller: 'AboutCtrl',
    //      controllerAs: 'about'
    //  })
    //  .when('/login', {
    //      templateUrl: 'views/login.html',
    //      controller: 'LoginCtrl',
    //      controllerAs: 'login'
    //  })
    //  .when('/registration', {
    //      templateUrl: 'views/registration.html',
    //      controller: 'RegistrationCtrl',
    //      controllerAs: 'registration'
    //  })
    //  .otherwise({
    //      redirectTo: '/'
    //  });

    app.controller = $controllerProvider.register;

    $urlRouterProvider.otherwise('404');

    $stateProvider
        .state('main', {
            url: '/',
            templateUrl: 'views/main.html',
            controller: 'MainCtrl',
            controllerAs: 'main',
            title: 'Main Page'
        })
        .state('about', {
            url: '/about',
            templateUrl: 'views/about.html',
            controller: 'AboutCtrl',
            controllerAs: 'about',
            title: 'About Us'
        })
        .state('login', {
            url: '/login',
            templateUrl: 'views/login.html',
            controller: 'LoginCtrl',
            controllerAs: 'login',
            title: 'Login Page'
        })
        .state('registration', {
            url: '/registration',
            templateUrl: 'views/registration.html',
            controller: 'RegistrationCtrl',
            controllerAs: 'registration',
            title: 'Registration Page'
        })
        .state('pageNotFound', {
            url: '/404',
            templateUrl: '404.html',
            title: '404 - Not Found'
        })

    $locationProvider.html5Mode(true);

    function lazyLoad() {
        var args = [];
        for (var i = 0, n = arguments.length; i < n; i++) {
            args[i] = arguments[i];
        }
        return {
            load: ['$ocLazyLoad', function ($ocLazyLoad) {
                return $ocLazyLoad.load(args);
            }]
        }
    };
});

app.run(function ($rootScope, $state, authenService, $window) {
    $rootScope.$on('$stateChangeSuccess', function (evt, toState, toParams, fromState, fromParams) {
        $window.document.title = toState.title;
    });
});