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
					googleCalendarApiKey : 'AIzaSyBlictKgUZJ-73uYvibOIq-wwXo9_pq7lk',
					eventSources : [{
						googleCalendarId : 'hnumitcircle@gmail.com',
						className : 'MIT',
						color : '#568dbe', //rgb,#ffffff 등의 형식으로 할 수 있어요.
						//textColor: 'black' 
					}, {
						googleCalendarId : 'ko.south_korea#holiday@group.v.calendar.google.com',
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