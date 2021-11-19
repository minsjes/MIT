<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<div class="box-header">
				<h2 class="mt-4" style='text-align: center; margin-bottom: 30px;'>회원 정보 수정</h2>
			</div>
			<form role="form" action="modify" method="post">
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-user fa-fw"></i> 회원 관리
					</div>	
					<div class="card-body">
						<div class="form-group">
							<div class="form-group" style="padding-right:350px; padding-left: 350px;">
								<label class="exampleInputEmail1">학번(아이디)</label>
								<div class="input-group mb-3">
									<span class="input-group-text" id="basic-addon1"><i class="far fa-user"></i></span>
									<input type="text" name='memberNo' class="form-control" value="${memberVO.memberNo}" readonly="readonly">
								</div>
							</div>
							<div class="form-group" style="padding-right:350px; padding-left: 350px;">
								<label for="exampleInputEmail1">비밀번호</label> 
								<div class="input-group mb-3">
		 							<span class="input-group-text" id="basic-addon1"><i class="fas fa-unlock-alt"></i></span>
		  							<input type="password" name='memberPw' class="form-control" value="${memberVO.memberPw}" readonly="readonly">
								</div>
							</div>
										
							<div class="form-group" style="padding-right:350px; padding-left: 350px;">
								<label for="exampleInputEmail1">회원명</label> 
								<div class="input-group mb-3">
		  							<span class="input-group-text" id="basic-addon1"><i class="far fa-smile"></i></span>
		  							<input type="text" name='memberName' class="form-control" value="${memberVO.memberName}" readonly="readonly">
								</div>
							</div>
					
							<div class="form-group" style="padding-right:350px; padding-left: 350px;">
								<label for="exampleInputEmail1">전화번호</label> 
								<div class="input-group mb-3">
		  							<span class="input-group-text" id="basic-addon1"><i class="fas fa-mobile-alt"></i></span>
		  							<input type="text" name="memberPhone" class="form-control" value="${memberVO.memberPhone}" readonly="readonly">
								</div>
							</div>
							<div class="form-group" style="padding-right:350px; padding-left: 350px;">
								<label for="exampleInputEmail1">회원등급</label> 
								<select name='memberClass' class="form-select">
									<option value="현재등급">${memberVO.memberClass}</option>
									<option value="회장"> -- 수정할 등급을 선택해 주세요-- </option>
									<option value="회장"> 회장</option>
									<option value="부회장"> 부회장</option>
									<option value="조장"> 조장</option>
									<option value="회원"> 회원</option>
								</select> 
							</div><br>	
						</div>	
					</div>				
						
					<div class="box-footer" style="float: right; margin: 50px auto 50px;">
						<button type="button" class="btn btn-outline-primary">저장</button>
						<button type="button" class="btn btn-outline-dark">취소</button>
					</div>
			</form>
		</div>
	</main>
</div>




<%@include file="../include/footer.jsp"%>
