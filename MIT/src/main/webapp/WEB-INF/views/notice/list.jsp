<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<div id="layoutSidenav_content">
   <main>
	   <div class="container-fluid px-4">
	      <h1 class="mt-4" style='text-align: center; margin-bottom: 30px;'>공지사항</h1>
	
	      <div class="card mb-4">
	         <div class="card-header">
	            <i class="bi bi-megaphone"></i> 공지사항 목록
	            <c:if test="${login.memberNo == 12345678}">
	            	<button class="btn btn-outline-dark btn-sm" id="newBtn" style="float: right; padding: 0 auto 0 auto;">새 게시글 작성</button>
	            </c:if>
	         </div>
	         <div class="card-body">
	            <table id="datatablesSimple">
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
</script>

<%@include file="../include/footer.jsp"%>