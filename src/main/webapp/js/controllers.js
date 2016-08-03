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
		{
			id: 'photo-19',
			name: 'Bodacious photo',
			src: 'http://d.hiphotos.baidu.com/image/pic/item/2cf5e0fe9925bc3157dbbede5bdf8db1ca1370f5.jpg'
		},
		{
			id: 'photo-19',
			name: 'Bodacious photo',
			src: 'http://img5.imgtn.bdimg.com/it/u=3603943369,1952417318&fm=21&gp=0.jpg'
		}
	];


	$scope.info = function (x) {

		alert("hello: picture " + x);

	};
}]);


/**
 * POI test controller
 */
app.controller('poiCtrl',
	["$scope", "$uibModal", "$log", "baseMethod", '$rootScope','$http', function ($scope, $uibModal, $log, baseMethod, $rootScope, $http) {

		// alert(message);
		/**
		 * alert顶端关闭按钮
		 */
		$rootScope.showAlertToggle = false;
		$scope.closeAlert = function () {

			$rootScope.showAlertToggle = false;

		};


		/**  loading图标初始化不显示 **/
		$rootScope.showLoading = false;
		/**   设置loading的显示文字  **/
		$scope.loading_text = "数据加载中.......";

		$scope.items = ['item1', 'item2', 'item3'];

		$scope.animationsEnabled = true;

		/**   弹出菜单点击事件  导入数据**/
		$scope.importData = function () {

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

		/**   导出数据  **/
		/**   初始化checkbox容器，保存已经选择的id  **/
		$scope.checkbox = [];
		$scope.exportData = function () {

			if ($scope.checkbox.length != 0) {
				/**   获取已经选择的id  **/
				var goalArr = [];

				for (var i in $scope.checkbox) {

					goalArr.push(parseInt(i));

				}

				/**   发送导出的请求，发送要导出的数据的id的集合  **/
				/**   angularjs的特殊处理，后端返回的文件流。否则，像正常那样处理result，只会得到乱码  **/
				$http.post('toExportData.req', {"array": angular.toJson(goalArr)}, {responseType: "blob"}).success(
					function (data) {

						var blob = new Blob([data], {type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"});

						/**   用时间戳作为文件名  **/
						var time = Date.now();
						var fileName = time + ".xlsx";

						var a = document.createElement("a");
						document.body.appendChild(a);
						a.download = fileName;
						a.href = URL.createObjectURL(blob);
						a.click();

					});

			} else {
				alert("请选择要导出的数据.....");
			}

		};

		/**   监听全选 按钮  **/

		$scope.selAllOrNot = function () {

			if ($scope.selectAll) {

				$scope.checkbox = [];
				angular.forEach($scope.datas, function (item) {

					$scope.checkbox[item.id] = true;
				});

			} else {
				$scope.checkbox = [];
			}
		};


		/**   请求数据 table datas  **/
		function getAllStudentsInfo(pageNo) {


			baseMethod.toGetProfitDatas(pageNo).then(function (result) {

				if (result.data.content.length != 0) {

					$scope.datas = result.data.content;
					$scope.totalItems = result.data.totalElements;
					$scope.pageCount = result.data.totalPages;

				} else {

					alert("数据库返回的数据为空.......");

				}

			});
		}


		getAllStudentsInfo(1);

		$scope.onPageChange = function () {

			/**   把勾选的去掉  **/
			$scope.selectAll = false;
			getAllStudentsInfo($scope.currentPage);

		};


	}]);

app.controller('ModalInstanceCtrl',
	['$scope', '$uibModalInstance', 'items', 'Upload', '$rootScope', function ($scope, $uibModalInstance, items, Upload, $rootScope) {

		$scope.ok = function () {

			if ($scope.file) {

				$scope.upload($scope.file);

			} else {

				alert("sorry, you didn't choose anything,please choose me and then do it again");

			}
		};

		/**   检测文件后缀名是否符合要求  **/
		$scope.seefile = function (file) {

			var fileName = file.name;
			var begin = fileName.lastIndexOf(".");
			var end = fileName.length;
			var getName = fileName.substring(begin, end);
			if (getName == "xlxs") {

				$scope.isOkFile = true;

			} else {

				$scope.isOkFile = false;

			}

		};


		/**
		 * 上传的方法
		 * @param file: the file customer choose to upload
		 */
		$scope.upload = function (file) {

			if ($scope.isOkFile) {

				/**   退出弹出框  **/
				$uibModalInstance.dismiss('cancel');
				/**   显示加载动画  **/
				$rootScope.showLoading = true;

				Upload.upload({
					url: "/upLoadFile.req",
					data: {"file": file}
				}).then(function (result) {

					if (result.statusText == "OK") {

						$rootScope.showLoading = false;
						$rootScope.showAlertToggle = true;

					} else {

						$rootScope.showLoading = false;
						alert("上传失败！！");
					}

				});


			} else {

				alert("请重新选择后缀名为xlxs的excel文件.....");

			}

		};

		$scope.cancel = function () {
			$uibModalInstance.dismiss('cancel');
		};

	}]);