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
    <title>Title</title>
</head>
<body>
    <div>
        <form action="/write" method="post">
            <div> 제목 : <input type="text" name="title" value=""/></div>
            <br>
            <div> 내용 : <textarea name="content"></textarea></div>
            <br>
            <button type="submit">전송</button>
        </form>
    </div>
    <a href="/list">글 목록으로 가기</a>
</body>
</html>
