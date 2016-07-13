<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="myapp">
<head>
	<title>功能测试</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ng-pagination.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/loading-bar.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my.css">
</head>
<body>

<div id="header">
	<span style="margin-left:20px;"><a href="#">PRACTICES MAKE PREFECT: Demo of testing shiro functions and angular ui-router </a></span>
	<button class="btn btn-primary btn-sm header-login-btn">注册</button>
	<button class="btn btn-primary btn-sm header-login-btn">登陆</button>
</div>
<div id="side">
	<ul>
		<li><a ui-sref="one">loadingBar</a></li>
		<li><a ui-sref="two">图片瀑布流</a></li>
	</ul>
</div>
<div id="content">
	<!-- stage is the key where the aimation work-->
	<div ui-view class="stage"></div>
</div>

</body>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/angular1.5.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/angular-animate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/angular-ui-router.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/loading-bar.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/angular-deckgrid.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/app.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/si-table.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/ng-pagination.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/directives.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/controllers.js"></script>

</html>
