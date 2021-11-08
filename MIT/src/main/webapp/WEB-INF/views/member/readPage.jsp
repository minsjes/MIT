<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>

<div id="layoutSidenav_content">
	<main>

				<div class="container-fluid px-4">
					<div class="box-header">
						<h2 class="mt-4" style='text-align: center; margin-bottom: 30px;'>회원 관리</h2>
					</div>


			<form role="form" action="modify" method="post">
				
				<div class="card mb-4">
				<div class="card-header">
					<i class="fas fa-user fa-fw"></i> 회원 관리
				</div>

				<div class="card-body" style="padding-right:350px; padding-left: 350px;">
					<div class="form-group">
					
						<label for="exampleInputEmail1">학번(아이디)</label> 
						<div class="input-group mb-3">
 							 <span class="input-group-text" id="basic-addon1"><i class="far fa-user"></i></span>
  								<input type="text" name='memberNo' class="form-control" value="${memberVO.memberNo}" readonly="readonly">
						</div>

					</div>
					
					<div class="form-group">
					
						<label for="exampleInputEmail1">회원명</label> 
						<div class="input-group mb-3">
  							<span class="input-group-text" id="basic-addon1"><i class="far fa-smile"></i></span>
  							<input type="text" class="form-control" value="${memberVO.memberName}" readonly="readonly">
						</div>
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">전화번호</label> 
						<div class="input-group mb-3">
  							<span class="input-group-text" id="basic-addon1"><i class="fas fa-mobile-alt"></i></span>
  							<input type="text" class="form-control" value="${memberVO.memberPhone}" readonly="readonly">
						</div>
					</div>
					
					
					<div class="form-group">
						<label for="exampleInputEmail1">회원등급</label> 
						<div class="input-group mb-3">
  							<span class="input-group-text" id="basic-addon1"><i class="far fa-star"></i></span>
  							<input type="text" class="form-control" value="${memberVO.memberClass}" readonly="readonly">
						</div>
					</div>
				</div>


				<div class="box-footer" style="float: right; margin: 50px auto 50px;">
					<button type="button" class="btn btn-outline-primary">수정</button>
					<button type="button" class="btn btn-outline-danger">삭제</button>
					<button type="button" class="btn btn-outline-dark">목록</button>
				</div>
	</form>
				<script>
					var result = '${msg}';

					if (result != '') {
						alert(result);
					}
				</script>

				<script>
					$(document).ready(function() {

						var formObj = $("form[role='form']");

						console.log(formObj);

						$(".btn-outline-primary").on("click", function() {
							formObj.attr("action", "/member/modifyPage");
							formObj.attr("method", "get");
							formObj.submit();
						});

						$(".btn-outline-danger").on("click", function() {
							formObj.attr("action", "/member/removePage");
							formObj.submit();
						});

						$(".btn-outline-dark").on("click", function() {
							formObj.attr("method", "get");
							formObj.attr("action", "/member/list");
							formObj.submit();
						});

					});
				</script>
			</div>

		</div>


	</div>

</div>
</main>





<%@include file="../include/footer.jsp"%>
