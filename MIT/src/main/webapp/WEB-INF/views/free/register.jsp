<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../include/header.jsp"%>

<style>
.preview-list {
	list-style: none;
	padding: 0 10px 0 10px;
}
</style>

<div id="layoutSidenav_content">
	<main>
	<div class="container-fluid px-4">
		<h2 class="mt-4" style="text-align: center; margin-bottom: 30px;">자유
			게시판 게시물 등록하기</h2>

		<form role="form" method="post" name="frm">
			<input type="hidden" value="${login.memberNo}"
				id="inlineFormInputGroupUsername" name="memberNo"> <input
				type="hidden" name="hiddenStatus" id="hiddenStatus">

			<div class="input-group">
				<span class="input-group-text" id="inputGroup-sizing-default">작성자</span>
				<label class="form-control">${login.memberName}</label>
				<div class="form-control" align="right">
					<input type="checkbox" name="ckhiddenStatus" id="ckhiddenStatus"
						value="1" /> <label for="ckhiddenStatus" style="font-size: 17px;">익명</label>
				</div>
			</div>
			<div class="input-group">
				<span class="input-group-text" id="inputGroup-sizing-default"
					style="padding: 0 20px 0 20px;">제목</span> <input type="text"
					class="form-control" id="freeTitle" name="freeTitle"
					placeholder="Enter Title...">
			</div>
			<div class="form-group">
				<div class="input-group-text">내용</div>
				<textarea class="form-control" id="freeContent" name="freeContent"
					rows="15" placeholder="Enter content..."></textarea>
				<script>
					$(document).ready(function() {
						CKEDITOR.replace("freeContent", {
							height : 400
						});
					});
				</script>
			</div>


			<div class="input-group">
				<input type="file" class="form-control" id="fileUpload"
					name="fileUpload" aria-describedby="inputGroupFileAddon04"
					aria-label="Upload">
				<button class="btn btn-outline-secondary" type="button"
					id="inputGroupFileAddon04" onclick="fileUpload.click()">
					<i class="bi bi-plus-lg"></i>
				</button>
			</div>
			<div class="card">
				<ul class="dropzone-previews clearfix uploadedList preview-list"></ul>
			</div>

			<div style="text-align: right; margin: 17px 0 17px 0;">
				<button type="button" class="btn btn-outline-primary"
					id="btn_submit">등록</button>
				<button type="button" class="btn btn-outline-dark" id="btn_list">취소</button>
			</div>
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

	<script>
		// 등록 유효성 검사 
		function validate() {
			var freeTitle = $("#freeTitle").val();
			var freeContent = CKEDITOR.instances.freeContent.getData();
			var hiddenStatus = $("#ckhiddenStatus").is(":checked");

			alert(hiddenStatus)

			if (freeTitle == "") {
				alert("제목을 입력해주세요 .");
				document.getElementById("freeTitle").focus();
				return false;
			}

			if (freeContent == "") {
				alert("내용을 입력해주세요 .");
				return false;
			}

			if (hiddenStatus) {
				$("#hiddenStatus").val("1");
				alert($("#hiddenStatus").val());
				return true;

			} else {
				alert{'false'}
				$("#hiddenStatus").val("0");
				alert($("#hiddenStatus").val());
				return true;

			}

			return true;
		}
	</script>

	<script>
		$("input:text[numberOnly]").on("focus", function() {
			var x = $(this).val();
			x = removeCommas(x);
			$(this).val(x);
		}).on("focusout", function() {
			var x = $(this).val();
			if (x && x.length > 0) {
				if (!$.isNumeric(x)) {
					x = x.replace(/[^0-9]/g, "");
				}
				x = addCommas(x);
				$(this).val(x);
			}
		}).on("keyup", function() {
			$(this).val($(this).val().replace(/[^0-9]/g, ""));
		});
	</script>

	<script>
		$(document)
				.ready(
						function() {
							var formObj = $("form[role='form']");
							formObj
									.submit(function(event) {
										event.preventDefault();

										//유효성 검사
										var val = validate();

										if (val) {
											var that = $(this);
											var str = "";

											$(".uploadedList .delbtn")
													.each(
															function(index) {
																str += "<input type='hidden' name='files'"
																		+ " value='"
																		+ $(
																				this)
																				.attr(
																						"href")
																		+ "'> ";
															});

											that.append(str);
											console.log(str);
											that.get(0).submit();
										}//if문 종료
									});
						});

		var template = Handlebars.compile($("#template").html());

		//dragenter dragover, drop 기본 동작 막기(기본적인 이벤트 처리 제한 preventDefault) 끌어다 놓으면 새로운 창이 열리는 동작
		$(".fileDrop").on("dragenter dragover", function(event) {
			event.preventDefault();
		});

		$(".fileDrop").on("drop", function(event) {
			event.preventDefault();

			var uploaded = $("#uploadCount").val();

			//event.dataTransfer=이벤트와 같이 전달된 데이터   
			//dataTransfer.files= 그안 에 포함된 전달된 파일 데이터를 찾아 가져오는 부분
			//jQuery를 이용하는 경우 envent가 순수한 DOM 이벤트가 아니기때문에 
			var files = event.originalEvent.dataTransfer.files;

			var file = files[0];

			//formData를 이용한 서버 호출 (기존 <form>태그로 만든 데이터 전송방식과 동일)
			var formData = new FormData();

			//file 이름으로 파일 객체 추가
			formData.append("file", file);

			//$.post()를 사용하지 않고 $.ajax() 사용하는 대신 processData,contentType: false로 지정
			$.ajax({
				url : '/uploadAjax',
				data : formData,
				dataType : 'text',
				processData : false, //데이터를 자동 변환 할 것인지(true:일반적인 query string / false:자동 변환 없이)
				contentType : false, //기본값(true) application/urlcod 타입으로 전송 / 파일의 경우(false) multipart/form_data 방식으로 전송
				type : 'POST',
				success : function(data) {
					var fileInfo = getFileInfo(data);
					var html = template(fileInfo);
					var str = "";

					$(".uploadedList").append(html);

					uploaded++;

					$("#uploadCount").attr("value", uploaded);

					$(".uploadedList").append(str);
				}
			});
		});

		//클릭으로 파일 업로드할 때 호출되는 함수
		$("#fileUpload").on("change", function(event) {
			event.preventDefault();

			var uploaded = $("#uploadCount").val();

			if (uploaded >= 3) {
				alert('첨부파일은 3개 까지 업로드할 수 있습니다.');
				return;
			}

			// 파일업로드 인풋에서 파일을 받음
			var file = document.getElementById("fileUpload").files[0];

			// 새로운 폼데이터를 생성
			var formData = new FormData();

			// 폼데이터에 파일을 붙임
			formData.append("file", file);

			// AJAX로 uploadAjax 메소드를 호출해서 파일을 업로드함
			$.ajax({
				url : '/uploadAjax',
				data : formData,
				dataType : 'text',
				processData : false,
				contentType : false,
				type : 'POST',
				success : function(data) {
					var fileInfo = getFileInfo(data);
					var html = template(fileInfo);
					var str = "";

					$(".uploadedList").append(html);

					uploaded++;

					$("#uploadCount").attr("value", uploaded);

					$(".uploadedList").append(str);
				}
			});
		});

		//첨부파일 삭제 처리
		$(".uploadedList").on("click", ".delbtn", function(event) {
			event.preventDefault();

			var that = $(this);
			var uploaded = $("#uploadCount").val();

			$.ajax({
				url : "/deleteFile",
				type : "post",
				data : {
					fileName : $(this).attr("href")
				},
				dataType : "text",
				success : function(result) {
					if (result == 'deleted') {
						that.closest("li").remove();
						uploaded--;
						$("#uploadCount").attr("value", uploaded);
					}
				}
			});
		});

		//파일링크 처리(길이를 줄여줌)
		function getOriginalName(fileName) {
			if (checkImageType(fileName)) {
				return;
			}

			var idx = fileName.indexOf("_") + 1;
			return fileName.substr(idx);
		}

		//이미지파일 원본 파일 찾기
		function getImageLink(fileName) {
			if (!checkImageType(fileName)) {
				return;
			}

			//noticeFileName.substring(0,12)/년/월/일 경로 추출  
			//noticeFileName.substring(14) 파일 이름앞의 's_'제거
			var front = fileName.substr(0, 12);
			var end = fileName.substr(14);

			return front + end;
		}
	</script>

	<script>
		$(document).ready(function() {
			var formObj = $("form[role='form']");
			console.log(formObj);

			$("#btn_submit").on("click", function() {
				formObj.submit();
			});

			$('#btn_list').on("click", function(evt) {
				self.location = "list";
			});
		});
	</script>

	<%@include file="../include/footer.jsp"%>