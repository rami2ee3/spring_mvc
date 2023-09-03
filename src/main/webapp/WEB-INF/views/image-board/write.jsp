<%--
  Created by IntelliJ IDEA.
  User: sbr95
  Date: 2023-08-27
  Time: 오후 4:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="../common/header.jsp" %>
<body>
<div class="mb-3">
    <label for="input-writer" class="form-label">작성자</label>
    <input type="text" class="form-control" id="input-writer" placeholder="작성자를 입력해주세요">
</div>
<div class="mb-3">
    <label for="input-title" class="form-label">글 제목</label>
    <input type="text" class="form-control" id="input-title" placeholder="제목을 입력해주세요">
</div>
<div class="mb-3">
    <label for="input-content" class="form-label">글 내용</label>
    <textarea class="form-control" id="input-content" placeholder="내용을 입력해주세요" rows="6"></textarea>
</div>
<div class="mb-3">
    <img id="thumb-img" src="" alt="미리보기">
</div>
<div class="mb-3">
    <label for="input-file" class="form-label">첨부파일</label>
    <input id="input-file" type="file" class="form-control">
</div>

<button id="reg-btn" type="button" class="btn btn-outline-primary">글 작성 완료</button>
<button id="back-btn" type="button" class="btn btn-outline-secondary">목록으로</button>
</body>
<script type="text/javascript">
    $(document).ready(function () {

        // TODO : 이미지 미리보기용
        $('#input-file').on('change', function (){
        })

        $('#reg-btn').on('click', function(){

            const file = $('#input-file')[0].files[0];
            // formData 생성
            const formData = new FormData();
            formData.append("file", file);
            formData.append("title", $('#input-title').val());
            formData.append("content", $('#input-content').val());
            formData.append("writer", $('#input-writer').val());

            $.ajax({
                url:'/image-board/write',
                type: 'POST',
                data: formData,
                processData: false,
                contentType: false,
                success: function (res){
                    console.log(res);
                },
                error: function (err){
                    console.log(err);
                }
            });



        });
    });
</script>
</html>
