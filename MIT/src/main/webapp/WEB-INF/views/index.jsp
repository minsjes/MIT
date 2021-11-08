<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="include/header.jsp"%>

<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<div id="img" style="text-align: center;">
				<img class="fit-picture" src="/resources/dist/img/MIT.png" style="height: 500px; width: auto;">
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
											<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${noticeVO.noticeDate}" /></td>
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
			<div class="row">
				<div class="col-6 col-12-small">
					<div class="card mb-4">
						<div class="card-header">
							<a href="/calendar/list" style="text-decoration: none; color: black;">
								<i class="bi bi-calendar-check"></i> 일정 게시판
							</a>
						</div>
						<div class="card-body">
							<link href='${pageContext.request.contextPath}/resources/fullcalendar-5.9.0/lib/main.css' rel='stylesheet' />
							<script src='${pageContext.request.contextPath}/resources/fullcalendar-5.9.0/lib/main.js'></script>
							<script type='text/javascript'>
								document.addEventListener('DOMContentLoaded', function() {
									var calendarEl = document.getElementById('calendar');
									var calendar = new FullCalendar.Calendar(calendarEl, {
										googleCalendarApiKey : 'AIzaSyAlyKH0kQ91QYqW4MBWyxc_r5KHoW0lO6c',
										eventSources : [{
											googleCalendarId : '1fvaf8auo5mhhbbdvbjss702b0@group.calendar.google.com',
											className : '메모',
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
				</div>
				<div class="col-6 col-12-small">
					<div class="card mb-4">
						<div class="card-header">
							<a href="/photo/list" style="text-decoration: none; color: black;">
								<i class="bi bi-image"></i> 포토 갤러리 
							</a>
						</div>
						<div class="card-body" style="padding-bottom: 5px; padding-top: 30px;">
						<c:if test="${empty listSearch}">
							<div class="dataTable-container">
								<table id="datatablesSimple" class="dataTable-table">
									<thead>
										<tr>
											<th style="text-align: center;">등록된 게시물이 없습니다.</th>
										</tr>
									</thead>
								</table>
							</div>
						</c:if>
						<c:if test="${!empty listSearch}">
							<div class="row">
								<c:forEach items="${listSearch}" var="photoVO" varStatus="status" begin="0" end="3">
									<div class="col-xl-6 col-md-6">
										<div class="card mb-4">
											<div class="card-header">
												<i class="bi bi-image"></i>
												<a href='/photo/read?photoNo=${photoVO.photoNo}'>
													${photoVO.photoTitle}
												</a>
											</div>
											<div class="card-body">
												<img class="img-fluid" src="/displayFile?fileName=${photoVO.photoImage}" alt="" width="100%" height="40">
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
						</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>

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