<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="border: solid 1px #b4b4b4;border-radius: 5px;padding: 20px;">
	<div class="row">
		<div class="input-group" style="width: 30% !important;float: left;margin-left: 15px;">
			<span class="input-group-addon">业务编号</span>
			<input type="text" class="form-control" placeholder="业务编号" ng-model="searchObject.businessNo">
		</div>

		<div class="input-group" style="width: 30% !important;float: left;margin-left: 15px;">
			<span class="input-group-addon">业务员</span>
			<input type="text" class="form-control" placeholder="业务员" ng-model="searchObject.saleMan">
		</div>

		<div class="input-group" style="width: 30% !important;float: left;margin-left: 15px;">
			<span class="input-group-addon">收货方</span>
			<input type="text" class="form-control" placeholder="收货方" ng-model="searchObject.reciverMan">
		</div>

	</div>

	<br>

	<div class="row">
		<div class="input-group" style="width: 30% !important;float: left;margin-left: 15px;">
			<span class="input-group-addon">录单人</span>
			<input type="text" class="form-control" placeholder="录单人" ng-model="searchObject.creator">
		</div>

		<div class="input-group" style="width: 30% !important;float: left;margin-left: 15px;">
			<span class="input-group-addon">业务部门</span>
			<input type="text" class="form-control" placeholder="业务部门" ng-model="searchObject.department">
		</div>

		<div class="input-group" style="width: 30% !important;float: left;margin-left: 15px;">
			<span class="input-group-addon">付款方式</span>
			<input type="text" class="form-control" placeholder="付款方式" ng-model="searchObject.payType">
		</div>

	</div>

	<br>

	<div class="row">
		<div class="input-group" style="width: 30% !important;float: left;margin-left: 15px;">
			<span class="input-group-addon">实际完成时间</span>
			<input type="text" class="form-control" uib-datepicker-popup="{{format}}"
				   is-open="popup.opened1" datepicker-options="dateOptions" ng-required="true"
				   close-text="Close" alt-input-formats="altInputFormats" ng-click="open1()" placeholder="实际完成时间"
				   ng-model="finishTime"/>
		</div>

		<div class="input-group" style="width: 30% !important;float: left;margin-left: 15px;">
			<span class="input-group-addon">实际装货时间</span>
			<input type="text" class="form-control" uib-datepicker-popup="{{format}}"
				   is-open="popup.opened2" datepicker-options="dateOptions" ng-required="true"
				   close-text="Close" alt-input-formats="altInputFormats" ng-click="open2()" placeholder="实际装货时间"
				   ng-model="makeTime"/>
		</div>

		<div class="input-group" style="width: 30% !important;float: left;margin-left: 15px;">

			<span class="input-group-addon">实际送货时间</span>
			<input type="text" class="form-control" uib-datepicker-popup="{{format}}"
				   is-open="popup.opened3" datepicker-options="dateOptions" ng-required="true"
				   close-text="Close" alt-input-formats="altInputFormats" ng-click="open3()" placeholder="实际送货时间"
				   ng-model="sendTime"/>

		</div>


	</div>
	<br>

	<div class="row">

		<button class="btn btn-primary" style="float: right;margin-right: 100px" ng-click="doSearch()">Search</button>
		<button class="btn btn-primary" style="float: right;margin-right: 40px" ng-click="doReset()">Reset</button>

	</div>

</div>

