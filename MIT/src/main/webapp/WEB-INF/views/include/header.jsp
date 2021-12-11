<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="MIT Website" />
	<meta name="author" content="MIT" />
	
	<title>MIT</title>
	
	<!-- MAIN JS -->
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	<!-- startbootstrap-sb-admin-gh-pages -->
	<link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
	<link href="/resources/bootstrap/css/styles.css" rel="stylesheet" />
	<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
	
	<!-- Bootstrap Icons -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
	
	<!-- CKEditor4 -->
	<script src="//cdn.ckeditor.com/4.16.2/standard/ckeditor.js"></script>
</head> 
<body class="sb-nav-fixed">
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<!-- Navbar Brand-->
		<a class="navbar-brand ps-3" href="/">MIT</a>
		<!-- Sidebar Toggle-->
		<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle">
			<i class="fas fa-bars"></i>
		</button>
		<!-- Navbar UserName -->
		<form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
			<div class="input-group">
				<span style="color: #f8f9fa;">${login.memberName}</span>
			</div>
		</form>
		
		<!-- Navbar-->
		<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
					<i class="fas fa-user fa-fw"></i>
				</a>
				<ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
					<c:if test="${null eq login.memberNo}">
						<li><a class="dropdown-item" href="/join/memberRegister">회원가입</a></li>
						<li><a class="dropdown-item" href="/member/login">로그인</a></li>
					</c:if>
					<c:if test="${null ne login.memberNo}">
						<li><a class="dropdown-item" href="/member/readMyPage?memberNo=${login.memberNo}">내 정보</a></li>
						<li><a class="dropdown-item" href="#">쪽지함</a></li>
						<li><a class="dropdown-item" href="/member/logout">로그아웃</a></li>
					</c:if>
				</ul>
			</li>
		</ul>
	</nav>
	
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
				<div class="sb-sidenav-menu">
					<div class="nav">
						<c:if test="${login.memberNo == 12345678}">
							<div class="sb-sidenav-menu-heading">관리자 전용 MENU</div>
							<a class="nav-link" href="/member/list">
								<div class="sb-nav-link-icon">
									<i class="bi bi-person-lines-fill"></i>
								</div> 회원 관리
							</a>
							<a class="nav-link" href="/join/list">
								<div class="sb-nav-link-icon">
									<i class="bi bi-person-plus-fill"></i>
								</div> 가입 관리
							</a>
						</c:if>
						
						<div class="sb-sidenav-menu-heading">MENU</div>
						<a class="nav-link" href="/history/list">
							<div class="sb-nav-link-icon">
								<i class="bi bi-emoji-sunglasses"></i>
							</div> 동아리 소개
						</a>
						<a class="nav-link" href="/notice/list">
							<div class="sb-nav-link-icon">
								<i class="bi bi-megaphone"></i>
							</div> 공지사항
						</a>
						<a class="nav-link" href="/calendar/list">
							<div class="sb-nav-link-icon">
								<i class="bi bi-calendar-check"></i>
							</div> 동아리 일정
						</a>
						<a class="nav-link" href="/info/list">
							<div class="sb-nav-link-icon">
								<i class="bi bi-share-fill"></i>
							</div> 진로 정보 공유 게시판
						</a>
						<a class="nav-link" href="/qna/list">
							<div class="sb-nav-link-icon">
								<i class="bi bi-question-diamond"></i>
							</div> 질문 게시판
						</a>
						<a class="nav-link" href="/study/list">
							<div class="sb-nav-link-icon">
								<i class="bi bi-pencil"></i>
							</div> 스터디 게시판
						</a>
						<a class="nav-link" href="/free/list">
							<div class="sb-nav-link-icon">
								<i class="bi bi-chat-square-text"></i>
							</div> 자유 게시판
						</a>
						<a class="nav-link" href="#">
							<div class="sb-nav-link-icon">
								<i class="bi bi-pencil-square"></i>
							</div> 건의사항
						</a>
					</div>
				</div>
			</nav>
		</div>