<%--
  Created by IntelliJ IDEA.
  User: sbr95
  Date: 2023-08-28
  Time: 오후 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<%@include file="../common/header.jsp" %>
<body>
<style>
    .btn__wrap {
        margin-top: 20px;
        margin-bottom: 20px;
    }

    .list-group {
        margin-top: 20px;
        margin-bottom: 20px;
    }

    .reply-content {
        width: 70% !important;
    }

    .reply-writer {
        width: 20% !important;
    }

    .reply-btn {
        width: 10% !important;
    }
</style>

<div class="card">
    <div class="card-header">
        ${detail.title}
    </div>
    <div class="card-body">
        <pre class="card-text">${detail.content}</pre>
    </div>
    <div class="card-footer text-body-secondary">
        <b>${detail.writer}</b>
        <fmt:formatDate value="${detail.created_at}" pattern="yyyy.MM.dd HH:mm:ss"/>
    </div>
</div>
<div class="btn__wrap">
    <button id="mod-btn" type="button" class="btn btn-outline-info">수정하기</button>
    <button id="del-btn" type="button" class="btn btn-outline-danger">삭제하기</button>
    <button id="list-btn" type="button" class="btn btn-outline-secondary">목록으로</button>
</div>

<b>댓글목록</b>
<ul id="reply-list" class="list-group">
    <c:forEach var="reply" items="${replyList}">
        <li class="list-group-item d-flex justify-content-between align-items-center">
                ${reply.content}
            <span class="badge bg-secondary rounded-pill">
            ${reply.writer} ${reply.created_at}}
        </span>
        </li>
    </c:forEach>
</ul>

<div class="input-group mb-3">
    <input type="text" id="reply-content" class="reply-content form-control" placeholder="댓글입력해주세요"
           aria-describedby="reply-btn">
    <input type="text" id="reply-writer" class="reply-writer form-control" placeholder="작성자명을 입력해주세요">
    <button type="button" id="reply-btn" class="reply-btn btn btn-outline-secondary">댓글작성</button>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $('#reply-btn').on('click', function () {
            const content = $('#reply-content').val();
            console.log('content : ' + content)

            const writer = $('#reply-writer').val();
            console.log('writer : ' + writer)

            if (content === '') {
                alert('내용을 입력해주세요');
            } else if (writer === '') {
                alert('작성자를 입력해주세요');
            } else {
                const board_id = ${detail.id};
                const data = {content, writer, ajax_board2_id: board_id}

                $.ajax({
                    type: "POST",
                    url: "/ajax-board2/reply",
                    data: data,
                    dataType: "json",
                    success: function (response) {
                        if (response.id) {
                            alert('댓글작성 완료')

                            const replyHTML = '<li class="list-group-item d-flex justify-content-between align-items-center">' +
                                response.content +
                                '<span class="badge bg-secondary rounded-pill">' +
                                response.writer + ' ' + response.created_at +
                                '</span>' +
                                '</li>';

                            $('#reply-list').append(replyHTML);
                            $('#reply-content').val('');
                            $('#reply-writer').val('');
                        } else {
                            alert('댓글작성 실패')
                        }
                    },
                    error: function () {
                        console.log('오류 발생');
                    }
                });
            }
        });

        $('#list-btn').on('click', function () {
            location.href = '/ajax-board2/list';
        });

        $('#mod-btn').on('click', function () {
            const id = ${detail.id}
                location.href = '/ajax-board2/update/' + id;
        });

        $('#del-btn').on('click', function () {
            const confirmDelete = confirm('글 삭제하시겠습니까?');
            if (confirmDelete) {
                const boardId = ${detail.id};
                $.ajax({
                    type: "DELETE",
                    url: "/ajax-board2/delete/" + boardId,
                    dataType: "text",
                    success: function (res) {
                        console.log(res);
                        if (res === '1') {
                            alert('글 삭제 성공');
                            location.href = '/ajax-board2/list';
                        } else {
                            alert('글 삭제 실패');
                        }
                    },
                    error: function () {
                        console.log('오류 발생');
                    }
                });
            }
        });

    })
</script>

</html>







