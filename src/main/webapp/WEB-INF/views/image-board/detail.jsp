<%--
  Created by IntelliJ IDEA.
  User: sbr95
  Date: 2023-08-27
  Time: 오후 4:07
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
        글제목
    </div>
    <div class="card-body">
        <img src="http://image.gamechosun.co.kr/wlwl_upload/dataroom/df/2023/03/25/951488_1679720282.jpg" class="img-thumbnail" alt="이미지 샘플">
        <pre class="card-text">글 내용</pre>
    </div>
    <div class="card-footer text-body-secondary">
        <b>작성자</b>
        2023.08.01 00:00:00
    </div>
</div>
<div class="btn__wrap">
    <button id="mod-btn" type="button" class="btn btn-outline-info">수정하기</button>
    <button id="del-btn" type="button" class="btn btn-outline-danger">삭제하기</button>
    <button id="list-btn" type="button" class="btn btn-outline-secondary">목록으로</button>
</div>

<b>댓글 목록</b>
<ul id="reply-list" class="list-group">
    <li class="list-group-item d-flex justify-content-between align-items-center">
            댓글내용
        <span class="badge bg-secondary rounded-pill">댓글작성자 2023.08.01 00:00:00</span>
    </li>
</ul>

<!-- 댓글 입력 영역 -->
<div class="input-group mb-3">
    <input type="text" id="reply-content" class="reply-content form-control" placeholder="댓글을 입력해주세요"
           aria-describedby="reply-btn">
    <input type="text" id="reply-writer" class="reply-writer form-control" placeholder="작성자명을 입력해주세요">
    <button type="button" id="reply-btn" class="reply-btn btn btn-outline-secondary">댓글 작성</button>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {

    })
</script>

</html>
