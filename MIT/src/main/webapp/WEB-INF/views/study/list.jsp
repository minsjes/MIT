<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4" style='text-align: center; margin-bottom: 30px;'>스터디 게시판</h1>
			
			<c:if test="${null ne login.memberNo}">
				<div class="card mb-4">
					<div class="card-header">
						<span style="vertical-align: middle;">
							<i class="bi bi-house"></i> 게더타운 스터디룸
						</span>
						<c:if test="${12345678 eq login.memberNo}">
							<button class="btn btn-outline-dark btn-sm" onclick="openRegister()" style="float: right; padding: 0 auto 0 auto;">게더타운 링크 등록</button>
						</c:if>
					</div>
					<div class="card-body">
						<c:if test="${empty gathertown}">
							<div style="text-align: center;">등록된 스터디가 없습니다.</div>
						</c:if>
						<c:if test="${!empty gathertown}">
							<div id="carouselExampleIndicators" class="carousel carousel-dark slide" data-bs-interval="false">
							  <div class="carousel-indicators">
							  	<c:forEach items="${gathertown}" var="gathertownVO" varStatus="status">
							  		<c:if test="${1 eq status.count}">
							  			<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="${gathertownVO.rnum}" class="active"></button>
							  		</c:if>
							  		<c:if test="${1 ne status.count}">
							  			<button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="${gathertownVO.rnum}"></button>
							  		</c:if>
							  	</c:forEach>
							  </div>
							  <div class="carousel-inner">
							  	<c:forEach items="${gathertown}" var="gathertownVO" varStatus="status">
							  		<c:if test="${1 eq status.count}">
							  			<div class="carousel-item active">
									    	<div class="card">
									    		<div class="row g-0" style="width: 80%; margin: 0 auto;">
									    			<div class="col-md-4">
									    				<a href="${gathertownVO.gathertownLink}">
									    					<c:if test="${empty gathertownVO.thumbnail}">
									    						<img class="img-fluid" src="/resources/dist/img/MIT.png">
									    					</c:if>
									    					<c:if test="${!empty gathertownVO.thumbnail}">
									    						<img class="img-fluid" src="${gathertownVO.thumbnail}">
									    					</c:if>
									    				</a>
									    			</div>
									    			<div class="col-md-8">
										    			<div class="card-body">
										    				<h5 class="card-title">${gathertownVO.groupName}</h5>
										    				<p class="card-text">${gathertownVO.groupContent}</p>
										    				<p class="card-text"><small class="text-muted">참여인원: ${gathertownVO.groupNo}</small></p>
										    				<a href="javascript:void(window.open('${gathertownVO.gathertownLink}'));"  class="btn btn-primary">접속하기</a>
										    				<c:if test="${login.memberNo eq gathertownVO.memberNo}">
																<a href="javascript:void(window.open('/gathertown/modify?gathertownNo=' + ${gathertownVO.gathertownNo} + '', '', 'width=800, height=630, left=' + xPos + ', top=' + yPos + ''));"  class="btn btn-outline-primary">수정</a>
															</c:if>
										    			</div>
									    			</div>
									    		</div>
									    		<div class="mb-5"></div>
									    	</div>
									    </div>
							  		</c:if>
							  		<c:if test="${1 ne status.count}">
							  			<div class="carousel-item">
									    	<div class="card">
									    		<div class="row g-0" style="width: 80%; margin: 0 auto;">
									    			<div class="col-md-4">
									    				<a href="${gathertownVO.gathertownLink}">
									    					<c:if test="${empty gathertownVO.thumbnail}">
									    						<img class="img-fluid" src="/resources/dist/img/MIT.png">
									    					</c:if>
									    					<c:if test="${!empty gathertownVO.thumbnail}">
									    						<img class="img-fluid" src="${gathertownVO.thumbnail}">
									    					</c:if>
									    				</a>
									    			</div>
									    			<div class="col-md-8">
										    			<div class="card-body">
										    				<h5 class="card-title">${gathertownVO.groupName}</h5>
										    				<p class="card-text">${gathertownVO.groupContent}</p>
										    				<p class="card-text"><small class="text-muted">참여인원: ${gathertownVO.groupNo}</small></p>
										    				<a href="javascript:void(window.open('${gathertownVO.gathertownLink}'));"  class="btn btn-primary">접속하기</a>
										    				<c:if test="${login.memberNo eq gathertownVO.memberNo}">
																<a href="javascript:void(window.open('/gathertown/modify?gathertownNo=' + ${gathertownVO.gathertownNo} + '', '', 'width=800, height=630, left=' + xPos + ', top=' + yPos + ''));"  class="btn btn-outline-primary">수정</a>
															</c:if>
										    			</div>
									    			</div>
									    		</div>
									    		<div class="mb-5"></div>
									    	</div>
									    </div>
							  		</c:if>
							  	</c:forEach>
							  </div>
							  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
							    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
							    <span class="visually-hidden">Previous</span>
							  </button>
							  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
							    <span class="carousel-control-next-icon" aria-hidden="true"></span>
							    <span class="visually-hidden">Next</span>
							  </button>
							</div>
						</c:if>
					</div>
				</div>
			</c:if>
			
			<div class="card mb-4">
				<div class="card-header">
					<span style="vertical-align: middle;">
						<i class="bi bi-pencil"></i> 스터디 게시판 목록
					</span>
					<c:if test="${null ne login.memberNo}">
						<button class="btn btn-outline-dark btn-sm" id="newBtn" style="float: right; padding: 0 auto 0 auto;">새 게시글 작성</button>
					</c:if>
				</div>
				<div class="card-body">
					<c:if test="${empty list}">
						<table id="datatablesSimple" class="dataTable-table">
							<thead>
								<tr>
									<th style="text-align: center;">등록된 게시글이 없습니다.</th>
								</tr>
							</thead>
						</table>
					</c:if>
					<c:if test="${!empty list}">
						<table id="datatablesSimple">
							<thead>
								<tr>
									<th style="width: 10px">NO</th>
									<th>유형</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성일</th>
									<th>조회수</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="studyVO" varStatus="status">
									<tr>
										<td>${studyVO.rnum}</td>
										<td>
											<c:if test="${1 eq studyVO.studyClass}">
	      										웹디자인
											</c:if>
											<c:if test="${2 eq studyVO.studyClass}">
												파이썬 기초
											</c:if>
										</td>
										<td>
											<a href='/study/read?studyNo=${studyVO.studyNo}'>
												${studyVO.studyTitle}
											</a>
										</td>
										<td>${studyVO.memberName}</td>
										<td>${studyVO.studyDate}</td>
										<td>${studyVO.studyView}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:if>
				</div>
			</div>
		</div>
	</main>

<script>
	var result = '${msg}';

	if (result == 'REGISTER') {
		alert("등록되었습니다.");
	}

	if (result == 'MODIFY') {
		alert("수정되었습니다.");
	}
	
	if (result == 'REMOVE') {
		alert("삭제되었습니다.");
	}

	if (result == 'CANNOT') {
		alert("로그인 정보가 일치하지 않아 수정 불가능합니다.");
	}
	
	if (result == 'CANTDELETE') {
		alert("로그인 정보가 일치하지 않아 삭제 불가능합니다.");
	}
</script>

<script>
	$(document).ready(function() {
		$('#newBtn').on("click", function(evt) {
			self.location = "register";
		});
	});
	
	var xPos = (document.body.offsetWidth/2) - (800/2);
	var yPos = (document.body.offsetHeight/2) - (630/2);
	
	function openRegister() {
		window.open("/gathertown/register", "", "width=800, height=630, left=" + xPos + ", top=" + yPos + "");
	}
</script>

<%@include file="../include/footer.jsp"%>