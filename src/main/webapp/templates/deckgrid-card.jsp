
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="photo" ng-model="card.id">
<a href ng-click="info(card.id)">
	<div class="photo-wrapper">
		<img src="" data-ng-src="{{card.src}}"
			 class="animation-fade" imageloaded data-loadedclass="animation-faded" style="width: 250px;">
	</div>


	<div class="photo-description">
		<h3 class="ng-binding">{{card.name}}</h3>
		<p>Nice photo, eh.</p>
	</div>
</a>
	<p>你好吗？</p>{{card.id}}
</div>