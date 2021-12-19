<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="../include/header.jsp"%>

<div id="layoutSidenav_content">
	<main>
		<div class="container-fluid px-4">
			<h1 class="mt-4 mb-5" style='text-align: center;'>동아리 소개</h1>
			
			<div class="clearfix">
				<img src="/resources/dist/img/MIT.png" class="col-md-4 float-md-start mb-2 ms-md-2">
				
				<p>안녕하세요. 글로벌IT경영 학우 여러분,<br>
				저는 이번 IT동아리 MIT(MIS IT Team)의 동아리장 이태헌입니다.<br>
				이번에 새롭게 학과전용 IT동아리를 개설하게 되었습니다.<br>
				많은 학우분들이 저희 학과에 입학하여 진로 선택에 많은 고민을 갖고, 저 또한 그랬듯이  IT분야를 어려워한다는 것을 알고 있습니다.<br>
				그런 학우분들과 IT로 진로를 선택한 모두를 위해 동아리를 개설하게 되었습니다.<br>
				동아리에서는 기본적으로 데이터베이스 실습, 웹프로그래밍 등 IT트랙 전공 과목을 함께 공부할 계획입니다.<br>
				수업이 어렵거나 이해가 부족한 부분들 , 혹은 과제에 대해서 서로 물어보고 공부할 수 있는 좋은 기회가 될 것입니다.<br>
				또한, 무조건 활동을 해야 하는 건 아닙니다.<br>
				가벼운 마음으로 들어와 IT라는 분야가 자신의 적성과 맞는지 알아보고 학우분들의 진로 선택에 도움이 됐다면 충분할 것입니다.</p>
				
				<p>
					◎ 활동 내용<br>
					 - IT트랙 전공 과목 스터디 운영<br>
					 - IT 관련 자격증 스터디 운영
				</p>
				
				<p>
					◎ 활동 방법<br>
					 - 거리두기 2단계 이하 : 단톡방 및 소규모 모임 (실습실 활용가능)<br>
					 - 거리두기 2.5단계 이상 : 단톡방, ZOOM 등 SNS를 활용한 비대면 모임
				</p>
				
				<p>
					◎ 가입 자격 요건<br>
					글로벌IT경영학과 학생이면 누구나 가능!! (졸업생도 환영합니다!!)
				</p>
				
				<p>
					◎ 문의사항<br>
					혹시 궁금하신 내용이 있다면 메일 주시길 바랍니다.
				</p>
			</div>
		</div>
		<hr>
		<div class="container-fluid px-4 mb-5">
			<h1 class="mt-5" style='text-align: center; margin-bottom: 30px;'>동아리 연혁</h1>
			
			<c:if test="${login.memberNo == 12345678}">
				<button class="btn btn-outline-dark btn-sm" onclick="openRegister()" style="float: right; padding: 0 auto 0 auto;">
					동아리 연혁 작성
				</button>
				<br><br>
			</c:if>
			
			<c:if test="${empty list}">
				<h6 class="mt-4 mb-4" style='text-align: center;'>등록된 글이 없습니다.</h6>
			</c:if>
			<c:if test="${!empty list}">
				<div class="accordion mb-4" id="accordionFlushExample">
					<c:forEach items="${list}" var="historyVO" varStatus="status">
						<div class="accordion-item">
							<h2 class="accordion-header" id="flush-heading${historyVO.rnum}">
								<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#flush-collapse${historyVO.rnum}" aria-expanded="false" aria-controls="flush-collapse${historyVO.rnum}">
									${historyVO.historyDate}
								</button>
							</h2>
							<div id="flush-collapse${historyVO.rnum}" class="accordion-collapse collapse" aria-labelledby="flush-heading${historyVO.rnum}" data-bs-parent="#accordionFlushExample">
								<div class="accordion-body">
									<p>${historyVO.historyContent}</p>
									<c:if test="${login.memberNo == 12345678}">
										<p><a href="javascript:void(window.open('/history/modify?historyNo=' + ${historyVO.historyNo} + '', '', 'width=800, height=630, left=' + xPos + ', top=' + yPos + ''));">
											<button type="button" class="btn btn-outline-primary" style="float: right;">수정</button>
										</a></p>
										<p><br></p>
									</c:if>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</c:if>
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
		var formObj = $("form[role='form']");

		console.log(formObj);

		$(".btn-modify").on("click", function() {
			formObj.attr("action", "/history/modify");
			formObj.attr("method", "get");
			formObj.submit();
		});

		$(".btn-outline-danger").on("click", function() {
			formObj.attr("action", "/history/remove");
			formObj.attr("method", "post");
			formObj.submit();
		});
</script>

<script>
	function openRegister() {
		window.open("/history/register", "", "width=800, height=630, left=" + xPos + ", top=" + yPos + "");
	}
	
	var xPos = (document.body.offsetWidth/2) - (800/2);
	var yPos = (document.body.offsetHeight/2) - (630/2);
</script>

<%@include file="../include/footer.jsp"%>