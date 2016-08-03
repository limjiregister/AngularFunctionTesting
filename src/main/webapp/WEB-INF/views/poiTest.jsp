<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>poiTest</title>
</head>
<body>

<!--  顶端弹出alert提示信息 -->
<div uib-alert ng-if="showAlertToggle" template-url="alert.html" class="alertTipBg aaa">UpLoad Success!!
	<button ng-click="closeAlert()" class="alertTipBtn">X</button>
</div>


<div unselectable="on" class="loading_bg" ng-if="showLoading">

	<div class="loading">
		<img src="/images/loading2.gif"/><span ng-bind="loading_text"></span>
	</div>

</div>

<div class="btn-group btn-group-sm">
	<label class="btn btn-lg btn-info" ng-model="checkModel.left"
		   ng-click="tableParams.reload()"><i class=" glyphicon glyphicon-refresh"></i> 刷新
	</label> <label class="btn btn-info btn-lg" ng-model="checkModel.search"
					uib-btn-checkbox> <i class=" glyphicon glyphicon-search"></i> 搜索 <i
		class="glyphicon"
		ng-class="{'glyphicon-menu-down':checkModel.search,'glyphicon-menu-up':!checkModel.search}"></i>
</label>
</div>

<!-- uib-dropdown 生命这个节点是下弹菜单 -->
<div class="btn-group" style="float: right;margin-right: 10px" uib-dropdown dropdown-append-to-body>

	<!--  uib-dropdown-toggle点击弹出的开关 -->
	<button id="btn-append-to-body" type="button" class="btn btn-primary" uib-dropdown-toggle>
		<i class=" glyphicon glyphicon-import"></i> 导入导出数据库 <span class="caret"></span>
	</button>

	<!-- uib-dropdown-menu 子菜单  -->
	<ul class="dropdown-menu" uib-dropdown-menu role="menu" aria-labelledby="btn-append-to-body">
		<li role="menuitem"><a href=" javascript:void(0)" ng-click="importData()">从excel导入数据库</a></li>
		<li class="divider"></li>
		<li role="menuitem"><a href=" javascript:void(0)" ng-click="exportData()">导出数据集到excel</a></li>
	</ul>
</div>

<!--  搜索条件的 -->
<div uib-collapse="!checkModel.search">
	
	<profit-search></profit-search>
	
</div>

<!--  table data -->
<div style="min-height: 600px;overflow-y: auto;background: rgba(228, 228, 228, 0.15);border: solid 1px #9fa2a4;word-break: keep-all">
	<table class="table table-hover table-bordered" si-table>
		<thead>
		<tr>
			<th><input type="checkbox" ng-model="selectAll" ng-change="selAllOrNot()"></th>
			<th ng-click="predicate='businessNo'; reverse=!reverse">业务编号</th>
			<th ng-click="predicate='salesman'; reverse=!reverse">业务员</th>
			<th ng-click="predicate='salePrice'; reverse=!reverse">销售价</th>
			<th ng-click="predicate='profits'; reverse=!reverse">利润</th>
			<th ng-click="predicate='costPrice'; reverse=!reverse">成本价</th>
			<th ng-click="predicate='shipper'; reverse=!reverse">托运方</th>
			<th ng-click="predicate='recipient'; reverse=!reverse">收货方</th>
			<th ng-click="predicate='cuctomerService'; reverse=!reverse">客服</th>
			<th ng-click="predicate='finishTime'; reverse=!reverse">实际完成时间</th>
			<th ng-click="predicate='shipmentTime'; reverse=!reverse">实际装货时间</th>
			<th ng-click="predicate='deliverTime'; reverse=!reverse">实际送货时间</th>
			<th ng-click="predicate='businessTime'; reverse=!reverse">实际业务时间</th>
			<th ng-click="predicate='recordingPerson'; reverse=!reverse">录单人</th>
			<th ng-click="predicate='contType'; reverse=!reverse">柜型</th>
			<th ng-click="predicate='contNum'; reverse=!reverse">柜量</th>
			<th ng-click="predicate='destination'; reverse=!reverse">目的地</th>
			<th ng-click="predicate='feeType'; reverse=!reverse">费用类型</th>
			<th ng-click="predicate='payType'; reverse=!reverse">付款方式</th>
			<th ng-click="predicate='businessType'; reverse=!reverse">业务类型</th>
			<th ng-click="predicate='department'; reverse=!reverse">业务部门</th>
		</tr>
		</thead>
		<tbody>
		<tr ng-repeat="i in datas | filter:filter|orderBy:predicate:reverse">
			<td><input type="checkbox" ng-checked="selectAll" ng-model="checkbox[i.id]"></td>
			<td>{{ i.businessNo }}</td>
			<td>{{ i.salesman }}</td>
			<td>{{ i.salePrice }}</td>
			<td>{{ i.profits }}</td>
			<td>{{ i.costPrice }}</td>
			<td>{{ i.shipper }}</td>
			<td>{{ i.recipient }}</td>
			<td>{{ i.cuctomerService }}</td>
			<td>{{ i.finishTime }}</td>
			<td>{{ i.shipmentTime }}</td>
			<td>{{ i.deliverTime }}</td>
			<td>{{ i.businessTime }}</td>
			<td>{{ i.recordingPerson }}</td>
			<td>{{ i.contType }}</td>
			<td>{{ i.contNum }}</td>
			<td>{{ i.destination }}</td>
			<td>{{ i.feeType }}</td>
			<td>{{ i.payType }}</td>
			<td>{{ i.businessType }}</td>
			<td>{{ i.department }}</td>

		</tr>
		</tbody>
	</table>

</div>
<!-- 分页部件  -->
<div>
	<div style="float: left;" ng-show="datas!=null||datas!=''">

		<pager page-count="pageCount" current-page="currentPage" on-page-change="onPageChange()" first-text="首页"
			   next-text="下一页" prev-text="上一页" last-text="尾页" show-goto="true" goto-text="跳转到"></pager>

	</div>
	<div style="float: right;margin-right: 10px;margin-left: 20px">
		<span>数据库一共有{{totalItems}}条记录</span><span style="margin-left: 30px">  一共有：{{pageCount}}页</span>
		<span style="margin-left: 20px">当前为第：{{currentPage}}页</span>
	</div>
	<br>
</div>


</body>


<script type="text/ng-template" id="myModalContent.html">
	<div class="modal-header">
		<h3 class="modal-title">please select the file you want to import into database</h3>
	</div>
	<div class="modal-body">

		<input type="file" ngf-select ng-model="file" ng-change="seefile(file)">

	</div>
	<div class="modal-footer">
		<button class="btn btn-primary" type="button" ng-click="ok()">Import</button>
		<button class="btn btn-warning" type="button" ng-click="cancel()">Cancel</button>
	</div>
</script>

<script type="text/ng-template" id="alert.html">
	<div ng-transclude></div>
</script>

</html>
