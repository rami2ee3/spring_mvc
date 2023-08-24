<%--
  Created by IntelliJ IDEA.
  User: sbr95
  Date: 2023-08-22
  Time: 오후 2:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>글 상세</title>
</head>
<style>
    .content{
        border: solid 1px black;
        min-height: 500px;
    }
</style>
<body>
<div>
    <div>글 번호 : ${detail.id}</div>
    <div><b>제목 : </b> ${detail.title}</div>
    <div class="content">
        ${detail.content}
    </div>
    <span>
        <b>작성자 : </b> ${detail.writer}
    </span>
</div>
<a href="/form-board/modify?id=${detail.id}">글 수정하러 가기</a>
<a href="/form-board/delete?id=${detail.id}">글 삭제하기</a>
</body>
</html>
