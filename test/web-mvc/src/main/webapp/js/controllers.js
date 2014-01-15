var webAppControllers = angular.module('webAppControllers', []);

webAppControllers.controller('ListCtrl', [ '$scope', '$http', function($scope, $http) {
	$http.get('home/index').success(function(data) {
		$scope.persons = data;
	});

	$scope.deletePerson = function(id) {
		alert(id);
		$http({
			method : 'DELETE',
			url : 'home/delete/' + id
		}).success(function(status) {
			$location.path("/index");
			$http.get('home/index').success(function(data) {
				$scope.persons = data;
			});
		}).error(function(status) {
			alert(status);
		});
	};
} ]);

webAppControllers.controller('NewCtrl', [ '$scope', '$http', '$location', function($scope, $http, $location) {
	$scope.submit = function() {
		var postObject = new Object();
		postObject.name = $scope.name;
		postObject.address = $scope.street;

		$http.post("home/new", postObject).success(function(data) {
			$location.path("/index");
		}).error(function(status) {
			alert(status);
		});
	};
} ]);