/** Created on 2016/7/3 */

/**
 *   home.jsp
 *
 **/

app.controller("mainCtrl", ["$scope", function ($scope) {


}]);

/**
 *   one.jsp
 *
 **/

app.controller("StudentsCtl", ["$scope", "baseMethod", function ($scope, baseMethod) {


	function getAllStudentsInfo(pageNo) {

		baseMethod.toGetStudentList(pageNo).then(function (result) {

			$scope.stus = result.data.content;
			$scope.totalItems = result.data.totalElements;
			$scope.pageCount = result.data.totalPages;

		});
	}


	getAllStudentsInfo(1);

	$scope.onPageChange = function () {

		getAllStudentsInfo($scope.currentPage);

	};

}]);

/**
 *   two.jsp
 *
 **/
app.controller('twoCtrl', ['$scope', function ($scope) {

	$scope.photos = [
		{id: 'photo-1', name: 'Awesome photo', src: '/images/001.jpg'},
		{id: 'photo-2', name: 'Great photo', src: '/images/002.jpg'},
		{id: 'photo-3', name: 'Strange photo', src: '/images/003.jpg'},
		{id: 'photo-4', name: 'A photo?', src: '/images/004.jpg'},
		{id: 'photo-5', name: 'What a photo', src: '/images/005.jpg'},
		{id: 'photo-6', name: 'Silly photo', src: '/images/006.jpg'},
		{id: 'photo-7', name: 'Weird photo', src: '/images/007.jpg'},
		{id: 'photo-8', name: 'Modern photo', src: '/images/008.jpg'},
		{id: 'photo-9', name: 'Classical photo', src: '/images/009.jpg'},
		{id: 'photo-10', name: 'Dynamic photo', src: '/images/010.jpg'},
		{id: 'photo-11', name: 'Neat photo', src: 'http://lorempixel.com/400/300/sports'},
		{id: 'photo-12', name: 'Bumpy photo', src: 'http://lorempixel.com/400/300/nightlife'},
		{id: 'photo-13', name: 'Brilliant photo', src: 'http://lorempixel.com/400/380/nature'},
		{id: 'photo-14', name: 'Excellent photo', src: 'http://lorempixel.com/480/300/technics'},
		{id: 'photo-15', name: 'Gorgeous photo', src: 'http://lorempixel.com/400/300/sports'},
		{id: 'photo-16', name: 'Lovely photo', src: 'http://lorempixel.com/400/300/nightlife'},
		{id: 'photo-17', name: 'A "wow" photo', src: 'http://lorempixel.com/400/300/nature'},
		{id: 'photo-18', name: 'Bodacious photo', src: 'http://lorempixel.com/400/300/abstract'},
		{id: 'photo-19', name: 'Bodacious photo', src: 'http://d.hiphotos.baidu.com/image/pic/item/2cf5e0fe9925bc3157dbbede5bdf8db1ca1370f5.jpg'},
		{id: 'photo-19', name: 'Bodacious photo', src: 'http://img5.imgtn.bdimg.com/it/u=3603943369,1952417318&fm=21&gp=0.jpg'}
	];


	$scope.info = function (x) {

		alert("hello: picture "+x);

	};
}]);

/**
 *   POI test controller
 *
 **/
app.controller('poiCtrl', ["$scope","$uibModal","$log", function ($scope, $uibModal, $log) {
	$scope.items = ['item1', 'item2', 'item3'];

	$scope.animationsEnabled = true;

	$scope.hello = function () {

		var modalInstance = $uibModal.open({
			animation: $scope.animationsEnabled,
			templateUrl: 'myModalContent.html',
			controller: 'ModalInstanceCtrl',
			size: "lg",
			resolve: {
				items: function () {
					return $scope.items;
				}
			}
		});

		modalInstance.result.then(function (selectedItem) {
			$scope.selected = selectedItem;
		}, function () {
			$log.info('Modal dismissed at: ' + new Date());
		});

	};
}]);

app.controller('ModalInstanceCtrl', function ($scope, $uibModalInstance, items) {

	$scope.items = items;
	$scope.selected = {
		item: $scope.items[0]
	};

	$scope.ok = function () {
		$uibModalInstance.close($scope.selected.item);
	};

	$scope.cancel = function () {
		$uibModalInstance.dismiss('cancel');
	};
});