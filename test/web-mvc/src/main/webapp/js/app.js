var phonecatApp = angular.module('webApp', [ 'ngRoute', 'webAppControllers' ]);

phonecatApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/list', {
		templateUrl : 'part/index.html',
		controller : 'ListCtrl'
	}).when('/new', {
		templateUrl : 'part/new.html',
		controller : 'NewCtrl'
	}).otherwise({
		redirectTo : '/list'
	});

	// configure html5 to get links working on jsfiddle
	// $locationProvider.html5Mode(true);
} ]);