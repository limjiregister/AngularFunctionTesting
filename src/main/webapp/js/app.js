/** Created on 2016/7/3 */
var app = angular.module("myapp",
	["ui.router", 'akoenig.deckgrid', 'ui.bootstrap', 'ngAnimate', "ng-pagination", "siTable", 'angular-loading-bar', 'ngFileUpload']).config(
	['cfpLoadingBarProvider', function (cfpLoadingBarProvider) {
		cfpLoadingBarProvider.includeSpinner = false;
	}]);

//ui-router
app.config(function ($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.otherwise("default")

	$stateProvider.state("one", {
		url: "/one",
		templateUrl: "one.req",
		controller: "StudentsCtl"

	}).state("two", {
		url: "/two",
		templateUrl: "two.req",
		controller: "twoCtrl"

	}).state("poiTest", {
		url: "/poiTest",
		templateUrl: "poiTest.req",
		controller: "poiCtrl"
	}).state("default", {
		url: "/default",
		templateUrl: "home.req",
		controller: "mainCtrl"

	})
});


app.config(function ($httpProvider) {
	$httpProvider.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
	$httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
	// Override $http service's default transformRequest
	$httpProvider.defaults.transformRequest = [function (data) {
		/**
		 * The workhorse; converts an object to x-www-form-urlencoded serialization.
		 * @param {Object} obj
		 * @return {String}
		 */
		var param = function (obj) {
			var query = '';
			var name, value, fullSubName, subName, subValue, innerObj, i;
			for (name in obj) {
				value = obj[name];
				if (value instanceof Array) {
					for (i = 0; i < value.length; ++i) {
						subValue = value[i];
						fullSubName = name + '[]';
						innerObj = {};
						innerObj[fullSubName] = subValue;
						query += param(innerObj) + '&';
					}
				} else if (value instanceof Object) {
					for (subName in value) {
						subValue = value[subName];
						fullSubName = subName;
						innerObj = {};
						innerObj[fullSubName] = subValue;
						query += param(innerObj) + '&';
					}
				} else if (value !== undefined && value !== null) {
					query += encodeURIComponent(name) + '='
						+ encodeURIComponent(value) + '&';
				}
			}
			return query.length ? query.substr(0, query.length - 1) : query;
		};
		return angular.isObject(data) && String(data) !== '[object File]'
			? param(data)
			: data;
	}];
});


/**
 *   angularjs的factory方法
 *
 **/
app.factory("baseMethod", ["$http", 'cfpLoadingBar', function ($http, cfpLoadingBar) {

	return {
		toGetStudentList: function (pageNo) {

			//启动loading
			cfpLoadingBar.start();

			var args = {"pageNo": pageNo};
			var url = "toGetAllStudent.req";

			return $http({
				method: 'POST',
				data: args,
				url: url
			}).success(function (response) {

				return response;

				//结束loading
				cfpLoadingBar.complete();

			}).error(function (response, status) {

				alert(status + response);

			});

		},
		toGetProfitDatas: function (pageNo) {
			//启动loading
			cfpLoadingBar.start();

			var args = {"pageNO": pageNo};
			var url = "profitDatas.req";

			return $http({
				method: 'POST',
				data: args,
				url: url
			}).success(function (response) {

				return response;

			}).error(function (response, status) {

				alert("数据库无返回数据.......错误代码：" + status);

			});
		}
	};

}]);
