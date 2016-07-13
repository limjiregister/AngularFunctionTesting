/**
 * Created by Administrator on 2016/7/12.
 */

app.directive('imageloaded', [

	function () {

		'use strict';

		return {
			restrict: 'A',

			link: function (scope, element, attrs) {
				var cssClass = attrs.loadedclass;

				element.bind('load', function (e) {
					angular.element(element).addClass(cssClass);
				});
			}
		}
	}
]);