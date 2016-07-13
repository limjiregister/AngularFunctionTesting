<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>one page</title>
	<style>


	</style>
</head>
<body>


<div align="center">学生成绩浏览表</div>

<div id="shop_top">
	<div class="form-group" id="shop_filter">
		过滤：<input type="text" class="form-control" ng-model="filter.$" placeholder="filter">
	</div>
</div>
	<table class="table table-hover table-bordered" si-table>
		<thead>
		<tr>
			<th ng-click="predicate='id'; reverse=!reverse">序号</th>
			<th ng-click="predicate='examNo'; reverse=!reverse">准考证号</th>
			<th ng-click="predicate='name'; reverse=!reverse">姓名</th>
			<th ng-click="predicate='schoolName'; reverse=!reverse">学校</th>
			<th ng-click="predicate='chinese'; reverse=!reverse">语文</th>
			<th ng-click="predicate='math'; reverse=!reverse">数学</th>
			<th ng-click="predicate='physics'; reverse=!reverse">物理</th>
			<th ng-click="predicate='chemistry'; reverse=!reverse">化学</th>
			<th ng-click="predicate='biology'; reverse=!reverse">生物</th>
			<th ng-click="predicate='politis'; reverse=!reverse">政治</th>
			<th ng-click="predicate='history'; reverse=!reverse">历史</th>
			<th ng-click="predicate='geography'; reverse=!reverse">地理</th>
			<th ng-click="predicate='englishHear'; reverse=!reverse">听力</th>
			<th ng-click="predicate='english'; reverse=!reverse">英语</th>
			<th ng-click="predicate='totalScore'; reverse=!reverse">总分</th>
		</tr>
		</thead>
		<tbody>
		<tr ng-repeat="i in stus | filter:filter|orderBy:predicate:reverse">
			<td>{{$index+1}}</td>
			<td>{{ i.examNo }}</td>
			<td>{{ i.name }}</td>
			<td>{{ i.schoolName }}</td>
			<td>{{ i.chinese }}</td>
			<td>{{ i.math }}</td>
			<td>{{ i.physics }}</td>
			<td>{{ i.chemistry }}</td>
			<td>{{ i.biology }}</td>
			<td>{{ i.politis }}</td>
			<td>{{ i.history }}</td>
			<td>{{ i.geography }}</td>
			<td>{{ i.englishHear }}</td>
			<td>{{ i.english }}</td>
			<td>{{ i.totalScore }}</td>


		</tr>
		</tbody>
	</table>

<!-- 分页部件  -->
<div class="pager">
	<span>数据库一共有{{totalItems}}条记录</span><span style="margin-left: 30px">  一共有：{{pageCount}}页</span>
	<span style="margin-left: 20px">当前为第：{{currentPage}}页</span>
	<br>
	<pager page-count="pageCount" current-page="currentPage" on-page-change="onPageChange()" first-text="首页"
		   next-text="下一页" prev-text="上一页" last-text="尾页" show-goto="true" goto-text="跳转到"></pager>
</div>

</body>

</html>