<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-0">
		<link href='${pageContext.request.contextPath}/resources/fullcalendar-5.9.0/lib/main.css' rel='stylesheet' />
		<script src='${pageContext.request.contextPath}/resources/fullcalendar-5.9.0/lib/main.js'></script>
		<script type='text/javascript'>
			document.addEventListener('DOMContentLoaded', function() {
				var calendarEl = document.getElementById('calendar');
				var calendar = new FullCalendar.Calendar(calendarEl, {
					googleCalendarApiKey: 'AIzaSyAlyKH0kQ91QYqW4MBWyxc_r5KHoW0lO6c',
					eventSources: [{
						googleCalendarId: '1fvaf8auo5mhhbbdvbjss702b0@group.calendar.google.com',
						className: '메모',
						color: '#568dbe', //rgb,#ffffff 등의 형식으로 할 수 있어요.
						//textColor: 'black' 
					},{
						googleCalendarId : 'ko.south_korea#holiday@group.v.calendar.google.com',
						className : '대한민국의 휴일',
						color : '#8080c0',
						//textColor: 'black' 
					}]
  				});
  				
				calendar.render();
			});
		</script>
		
		<style>
			#calendar{
			   width:60%;
			   margin:20px auto;
			}
		</style>
    	<div id='calendar'></div>

<%@include file="../include/footer.jsp"%>