<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="common/header.jsp" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=${naverID}"></script>
</head>
<body>
	<h1>Main 페이지</h1>
	<hr> 
	<div style="margin-left:5%; margin-right: 5%;">
		<div id="mapList" style="width: 100%; height: 600px; border: 1px solid black;"></div>
		<div id="list" style="width: 100%; height: 400px;">
			<div class="row">
				<h4>오늘의 이슈 <button class="fas fa-undo" onclick="todayNews(1)"></button></h4>
			</div>
			<div class="row" style="border: 1px solid black;">
				<div id="issues-wrap" class="col-xs-12 col-sm-6 col-md-5">
					<ul id="todayNews"></ul>
				</div>
				<div class="col-xs-12 text-right mt-1"></div>
			</div>
			<div class="grey-text">
				<i class="fal fa-clock"></i> 날짜: <span id="issue-analysis-time" ></span>
			</div>
		</div>
	</div>
	
<script src="<c:url value='/resources/js/main_news2.js' />"></script>
<script src="<c:url value='/resources/js/modal_news.js' />"></script>
<%@ include file="common/footer.jsp" %>