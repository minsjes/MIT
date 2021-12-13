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
			<h2 class="mt-4" style='text-align: center; margin-bottom: 30px;'>자유
				게시판 게시물 수정하기</h2>

			<form role="form" action="modify" method="post" name="frm">
				<input type='hidden' id="freeNo" name='freeNo'
					value="${freeVO.freeNo}"> <input type='hidden'
					id="memberNo" name='memberNo' value="${freeVO.memberNo}">
					<input type="hidden" name="hiddenStatus" id="hiddenStatus">

				<div class="row">
					<div class="col" style="padding-right: 0;">
						<div class="input-group">
							<span class="input-group-text" id="inputGroup-sizing-default">작성자</span>
							<label class="form-control">${login.memberName}</label>
							<div class="form-control" align="right">
								<input type="checkbox" name="ckhiddenStatus" id="ckhiddenStatus"
									value="1" /> <label for="ckhiddenStatus"
									style="font-size: 17px;">익명</label>
							</div>
						</div>
						<div class="col" style="padding-left: 0;">
							<div class="input-group">
								<div class="input-group-text">작성일</div>
								<input type="text" class="form-control"
									value="<fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${freeVO.freeDate}"/>"
									readonly="readonly">
							</div>
						</div>
					</div>
					<div class="input-group">
						<div class="input-group-text" style="padding: 0 20px 0 20px;">제목</div>
						<input type="text" class="form-control" name='freeTitle'
							value="${freeVO.freeTitle}">
					</div>
					<div class="form-group">
						<div class="input-group-text">내용</div>
						<textarea class="form-control" id="freeContent" name="freeContent">${freeVO.freeContent}</textarea>
					</div>

					<script>
						$(document).ready(function() {
							CKEDITOR.replace("freeContent", {
								/* filebrowserUploadUrl : "/common/ckUpload", */
								height : 400
							});
						});
					</script>


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
						<ul class="dropzone-previews clearfix uploadedList preview-list">
							<c:forEach items="${freeFileVO}" var="fVo" varStatus="status">
								<c:set var="fileName" value="${fVo.fileName}" />
								<c:set var="fileNo" value="${fn:toLowerCase(fileName)}" />

								<li class="dropzone-previews mt-3">
									<div
										class="card mt-1 mb-0 shadow-none border dz-processing dz-image-preview dz-success dz-complete">
										<div class="p-2">
											<div class="row align-items-center px-3">
												<c:forTokens var="token" items="${fileNo}" delims="."
													varStatus="status">
													<c:if test="${status.last}">
														<c:choose>
															<c:when test="${token eq 'hwp'}">
																<img data-dz-thumbnail=""
																	class="avatar-sm rounded bg-light preview-icon"
																	src="/resources/dist/img/hwp.png" alt="${fileName}" />
															</c:when>
															<c:when test="${token eq 'xls' || token eq 'xlsx' }">
																<img data-dz-thumbnail=""
																	class="avatar-sm rounded bg-light preview-icon"
																	src="/resources/dist/img/excelIcon.png" />
															</c:when>
															<c:when
																test="${token eq 'jpg' || token eq 'gif' || token eq 'png' || token eq 'bmp' }">
																<img data-dz-thumbnail=""
																	class="avatar-sm rounded bg-light preview-size"
																	src="/displayFile?fileName=${fVo.fileLocation}">
															</c:when>
															<c:when test="${token eq 'pdf'}">
																<img data-dz-thumbnail=""
																	class="avatar-sm rounded bg-light preview-icon"
																	src="/resources/dist/img/pdf.png" alt="${fileName}" />
															</c:when>
															<c:when test="${token eq 'ppt' }">
																<img data-dz-thumbnail=""
																	class="avatar-sm rounded bg-light preview-icon"
																	src="/resources/dist/img/ppt.png" alt="${fileName}" />
															</c:when>
															<c:otherwise>
																<img data-dz-thumbnail=""
																	class="avatar-sm rounded bg-light preview-icon"
																	src="/resources/dist/img/file.svg" alt="${fileName}" />
															</c:otherwise>
														</c:choose>
													</c:if>
												</c:forTokens>
												<div class="col pl-0">
													<a href="/displayFile?fileName=${fVo.fileLocation}"
														text-muted font-weight-bold data-dz-name="">
														${fVo.fileName} </a>
												</div>
												<div class="col-auto">
													<a href="${fVo.fileLocation}"
														class="btn btn-default btn-xs pull-right delbtn"> <i
														class="far fa-trash-alt"></i>
													</a>
												</div>
											</div>
										</div>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>

					<div style="text-align: right; margin: 17px 0 17px 0;">
						<button type="submit" class="btn btn-outline-primary">수정</button>
						<button type="button" class="btn btn-outline-dark"
							onclick="location.href='/free/list'">목록</button>
					</div>
			</form>
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
				
			}else{
				alert('false')
				$("#hiddenStatus").val("0");
				alert($("#hiddenStatus").val());
				return true;
				
			}

			return true;
		}

		<script>
		function checkImageType(fileName) {
			var pattern = /jpg|gif|png|jpeg/i;
			return fileName.match(pattern);
		}
	</script>

	<script>
		$(document).ready(
				function() {
					var formObj = $("form[role='form']");
					formObj.submit(function(event) {
						event.preventDefault();
						
						//유효성 검사
						var val = validate();
				       if(val){}
						var that = $(this);
						var str = "";

						$(".uploadedList .delbtn").each(
								function(index) {
									str += "<input type='hidden' name='files'"
											+ " value='" + $(this).attr("href")
											+ "'> ";
								});

						that.append(str);
						that.get(0).submit();
					}
					});
				});

		$('#mydropzone').click(function(event) {
			document.frm.fileUpload.click();
		});

		var template = Handlebars.compile($("#template").html());

		$(".fileDrop").on("dragenter dragover", function(event) {
			event.preventDefault();
		});

		$(".fileDrop").on("drop", function(event) {
			event.preventDefault();

			var uploaded = $("#uploadCount").val();
			var files = event.originalEvent.dataTransfer.files;
			var file = files[0];
			var formData = new FormData();

			formData.append("file", file);

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

		//파일 삭제 버튼 클릭 시 
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

		function getOriginalName(fileName) {
			if (checkImageType(fileName)) {
				return;
			}

			var idx = fileName.indexOf("_") + 1;

			return fileName.substr(idx);
		}

		function getImageLink(fileName) {
			if (!checkImageType(fileName)) {
				return;
			}

			var front = fileName.substr(0, 12);
			var end = fileName.substr(14);

			return front + end;
		}
	</script>

	<%@include file="../include/footer.jsp"%>