var bkuApp= angular.module('BkuApp', []);

bkuApp.controller('BkuController', 
    function($scope, $http, $window) {
        $scope.daftarBku = [];
        $scope.updateDaftarBku = function(){
            $http.get('/daftar-buku').then(sukses, gagal);
            
            function sukses(response){
            	console.log(response);
            	//isidata mahasiswa
            	$scope.daftarBku = response.data;
            };
            function gagal(response){
            	console.log(response);
        	};
        };

        $scope.ubah = function(bku){
            //console.log(mhs);
            $window.location.href="/form-edit?id=" + bku.id;
        };
        
        $scope.hapus = function(bku){
            $http.delete('/hapus-data/' + bku.id).then(sukses, gagal);

            function sukses(response){
                $scope.updateDaftarBku();
            } ;

            function gagal(response){
                console.log(response);
            } ;
        };

        $scope.keluar = function() {
            $http.get('/keluar').then(sukses, gagal);

            function sukses(response){
                $window.location.href="/";
                
                
            };
            function gagal(response){
                console.log(response);
            };
        

        };

        $scope.updateDaftarBku();
    });
bkuApp.controller('FormController', 
    function($scope, $http, $window){
        $scope.simpan = function() {
            //console.log('nim : '+ $scope.mhs.nim);
            //console.log('nama : '+ $scope.mhs.nama);
            //console.log('jurusan : '+ $scope.mhs.jurusan);

            $http.post('/tambah-bku', $scope.bku).then(sukses, gagal);

            function sukses(response){
                $window.location.href = '/';
            };
            function gagal(response){
                console.log(response);
            };
        };

        $scope.batal = function() {
            $window.location.href = '/';
        };
    });