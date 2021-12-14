<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@include file="../include/header.jsp"%>

<style>
.preview-list {
	list-style: none;
	padding: 0 10px 0 10px;
}

.preview-size {
	width: auto;
	height: auto;
	max-width: 200px;
	max-height: 200px;
}

.preview-icon {
	width: auto;
	height: auto;
	max-width: 50px;
	max-height: 50px;
}
</style>

<div id="layoutSidenav_content">
	<main>
	<div class="container-fluid px-4">
		<h2 class="mt-4" style='text-align: center; margin-bottom: 30px;'>동아리
			소개 수정하기</h2>
			
		<form role="form" action="modify" method="post" name="frm">
			<input type='hidden' id="historyNo" name='historyNo'
				value="${historyVO.historyNo}"> <input type='hidden'
				id="memberNo" name='memberNo' value="${historyVO.memberNo}">
	</div>
	<div class="col" style="padding-left: 0;">
		<div class="input-group">
			<div class="input-group-text">작성일</div>
			<input type="text" class="form-control" name="historyDate"
				value="${historyVO.historyDate}" />
		</div>
	</div>

	<div class="form-group">
		<div class="input-group-text" style="padding-left: 20px;">내용</div>
		<textarea class="form-control" name="historyContent" rows="15">${historyVO.historyContent}</textarea>
	</div>
	<div style="text-align: right; margin: 17px 0 17px 0;">
		<button type="submit" class="btn btn-outline-primary">수정</button>
		<button type="button" class="btn btn-outline-dark"
			onclick="location.href='/history/list'">목록</button>
	</div>
	</main>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript" src="/resources/upload.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
	<script id="template" type="text/x-handlebars-template">
<li class="dropzone-previews mt-3">
<div class="card mt-1 mb-0 shadow-none border dz-processing dz-image-preview dz-success dz-complete">
<div class="p-2">
<div class="row align-items-center">
<div class="col-auto">
<img data-dz-thumbnail="" class="avatar-sm rounded bg-light" src="{{imgsrc}}">
</div>
<div class="col pl-0">
<a href="/displayFile?fileName={{fullName}}" text-muted font-weight-bold" data-dz-name="">{{fileName}}</a>
</div>
<div class="col-auto">
<a href="{{fullName}}" class="btn btn-default btn-xs pull-right delbtn"><i class="far fa-trash-alt"></i></a>
</div>
</div>
</div>
</div>
</li>
</script>

	<%@include file="../include/footer.jsp"%>