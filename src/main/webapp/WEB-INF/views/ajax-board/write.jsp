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
<button id="reg-btn" type="button" class="btn btn-outline-primary">글 작성 완료</button>
<button id="back-btn" type="button" class="btn btn-outline-secondary">목록으로</button>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        // id가 reg-btn 친구를 click 했을때 일어나는 이벤트
        $('#reg-btn').on('click', function () {
            const writer = $('#input-writer').val();
            console.log('writer : ' + writer)

            const title = $('#input-title').val();
            console.log('title : ' + title)

            const content = $('#input-content').val();
            console.log('content : ' + content)

            if (writer === '') {
                alert('작성자를 입력해주세요');
            } else if (title === '') {
                alert('글 제목을 입력해주세요');
            } else if (content === '') {
                alert('내용을 입력해주세요');
            } else {
                // ajax로 글 작성하고나서 성공하면 list 페이지로 이동

                const data = {title, content, writer}


                $.ajax({
                    type: "POST",
                    url: "/ajax-board/write",
                    data: data,
                    dataType: "text",
                    success: function (res) {
                        if (res === '1') {
                            alert('글 작성이 완료되었습니다.')
                            location.href = '/ajax-board/list';
                        } else {
                            alert('글 작성에 실패하였습니다.')
                        }
                    },
                    error: function () {
                        console.log('오류가 발생했습니다.');
                    }
                });


            }
        });

        $('#back-btn').on('click', function () {
            location.href = "/ajax-board/list";
        });


    });
</script>
</html>
