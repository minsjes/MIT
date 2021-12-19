<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="include/header.jsp"%>

<style>
.video-wrap {
	position:relative;
	padding-bottom:56.25%;
	padding-top:30px;
	height:0;
	overflow:hidden;
}

.video-wrap iframe,

.video-wrap object,

.video-wrap embed {
	position:absolute;
	top:0;
	left:0;
	width:100%;
	height:100%;
}
</style>

<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<div id="img" style="text-align: center;">
				<a href="/history/list">
					<img class="fit-picture" src="/resources/dist/img/MIT.png" style="height: 500px; width: auto;">
				</a>
			</div>
			<div class="card mb-4">
				<div class="card-header">
					<a href="/notice/list" style="text-decoration: none; color: black;">
						<i class="bi bi-megaphone"></i> 공지사항
					</a>
				</div>
				<div class="card-body">
					<div class="dataTable-container">
						<c:if test="${empty list}">
							<table id="datatablesSimple" class="dataTable-table">
								<thead>
									<tr>
										<th style="text-align: center;">등록된 공지사항이 없습니다.</th>
									</tr>
								</thead>
							</table>
						</c:if>
						<c:if test="${!empty list}">
							<table id="datatablesSimple" class="dataTable-table">
								<thead>
									<tr>
										<th style="width: 10px">NO</th>
										<th>제목</th>
										<th>작성자</th>
										<th>작성일</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list}" var="noticeVO" varStatus="status">
										<tr>
											<td>${noticeVO.rnum}</td>
											<td><a href='/notice/read?noticeNo=${noticeVO.noticeNo}'>${noticeVO.noticeTitle}</a></td>
											<td>${noticeVO.memberName}</td>
											<td>${noticeVO.noticeDate}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</c:if>
					</div>
				</div>
			</div>
		</div>
		<div class="container-fluid px-4">
			<div class="card-group mb-4">
				<div class="card">
					<div class="card-header">
						<a href="/calendar/list" style="text-decoration: none; color: black;">
							<i class="bi bi-calendar-check"></i> 동아리 일정
						</a>
					</div>
					<div class="card-body">
						<link href='${pageContext.request.contextPath}/resources/fullcalendar-5.9.0/lib/main.css' rel='stylesheet' />
						<script src='${pageContext.request.contextPath}/resources/fullcalendar-5.9.0/lib/main.js'></script>
						<script type='text/javascript'>
							document.addEventListener('DOMContentLoaded', function() {
								var calendarEl = document.getElementById('calendar');
								var calendar = new FullCalendar.Calendar(calendarEl, {
									googleCalendarApiKey : 'AIzaSyBlictKgUZJ-73uYvibOIq-wwXo9_pq7lk',
									eventSources : [{
										googleCalendarId : 'hnumitcircle@gmail.com',
										className : 'MIT',
										color : '#568dbe', //rgb,#ffffff 등의 형식으로 할 수 있어요.
										//textColor: 'black' 
									}, {
										googleCalendarId : 'ko.south_korea#holiday@group.v.calendar.google.com',
										className : '대한민국의 휴일',
										color : '#8080c0',
										//textColor: 'black' 
									} ]
								});
										
								calendar.render();
							});
						</script>
						<style>
							#calendar {
								width: 100%;
								margin: 20px auto;
							}
						</style>
						<div id='calendar'></div>
					</div>
				</div>
				<div class="card">
					<div class="card-header">
						<a href="https://www.youtube.com/embed/Zc9Vyke-t9I" style="text-decoration: none; color: black;">
							<i class="bi bi-vinyl-fill"></i> 추천 플레이리스트
						</a>
					</div>
					<div class="card-body">
						<img class="img-fluid mb-4" src="/resources/dist/img/playlist.PNG">
						<div class="video-wrap">
							<iframe id="video" width="100%" height="315" src="https://www.youtube.com/embed/Zc9Vyke-t9I" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>

<script>
	var $videoIframe = document.getElementById('video');
	var responsiveHeight = $videoIframe.offsetWidth * 0.5625;
	$videoIframe.setAttribute('height', responsiveHeight);
	
	window.addEventListener('resize', function(){
	    responsiveHeight = $videoIframe.offsetWidth * 0.5625;
	    $videoIframe.setAttribute('height', responsiveHeight);
	});
</script>

<script>
	var msg = '${msg}';

	if (msg == 'LOGOUT') {
		alert("로그아웃되었습니다.");
	}
	
	var result = '${result}';

	if (result == 'JOIN') {
		alert("[필독]회원가입이 완료되었습니다. 승인까지는 최소 2~3일 소요됩니다.");
	}
</script>

<%@ include file="include/footer.jsp"%>