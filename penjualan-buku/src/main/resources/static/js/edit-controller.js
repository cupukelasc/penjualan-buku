bkuApp.controller('EditController',
	function($scope, $window, $http){


		$scope.bku={};

		$scope.simpan = function() {
			$http.post('/tambah-bku', $scope.bku).then(sukses, gagal);

            function sukses(response){
                $window.location.href = '/';
            };
            function gagal(response){
                console.log(response);
            };
		};

		$scope.batal = function() {
			$window.location.href = "/";
		};

		$scope.updateById = function() {
			id=$window.location.search.split('=')[1];
			//console.log(nim);
			$scope.bku.id = id;

			$http.get("/get-bku-by-id/" + id).then(sukses, gagal);

			function sukses(response){
                //$window.location.href = '/';
                $scope.bku = response.data;
            };
            function gagal(response){
                console.log(response);
            };
		};

		$scope.updateById();

	});