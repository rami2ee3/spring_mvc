<%--
  Created by IntelliJ IDEA.
  User: sbr95
  Date: 2023-08-28
  Time: 오후 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="../common/header.jsp" %>
<body>
<div class="md-3">
    <label for="input-writer" class="form-label">작성자</label>
    <input type="text" class="form-control" id="input-writer" placeholder="작성자를 입력해주세요" value="${detail.writer}">
</div>
<div class="md-3">
    <label for="input-title" class="form-label">글 제목</label>
    <input type="text" class="form-control" id="input-title" placeholder="제목을 입력해주세요" value="${detail.title}">
</div>
<div class="md-3">
    <label for="input-content" class="form-label">글 내용</label>
    <textarea class="form-control" id="input-content" rows="6" placeholder="내용을 입력해주세요">${detail.content}</textarea>
</div>
<button id="mod-btn" type="button" class="btn btn-outline-primary">수정 완료</button>
<button id="back-btn" type="button" class="btn btn-outline-secondary">목록으로</button>
</body>
<script type="text/javascript">
    $(document).ready(function () {

        $('#mod-btn').on('click', function () {
            const writer = $('#input-writer').val();
            console.log('writer : ' + writer)

            const title = $('#input-title').val();
            console.log('title : ' + title)

            const content = $('#input-content').val();
            console.log('content : ' + content)

            if (writer === '') {
                alert('작성자를 입력해주세요');
            } else if (title === '') {
                alert('제목을 입력해주세요');
            } else if (content === '') {
                alert('내용을 입력해주세요');
            } else {
                const id = ${detail.id};
                const data = {id, writer, title, content}
                $.ajax({
                    type: "POST",
                    url: "/ajax-board2/update",
                    data: data,
                    dataType: "text",
                    success: function (res) {
                        if (res === '1') {
                            alert('글 수정 완료')
                            location.href = '/ajax-board2/detail/' + id;
                        } else {
                            alert('글 수정 실패')
                        }
                    },
                    error: function () {
                        console.log('오류발생');
                    }

                });
            }
        });

        $('#back-btn').on('click', function () {
            location.href = '/ajax-board2/list';
        });

    });
</script>
</html>
