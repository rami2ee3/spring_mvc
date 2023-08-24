<%--
  Created by IntelliJ IDEA.
  User: sbr95
  Date: 2023-08-22
  Time: 오후 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>글 목록</title>
</head>
<style>
    th, td{
        border: 1px solid black;
    }
    .title{
        min-width: 200px;
    }
</style>
<body>
<a href="/form-board/write">글 작성하러 가기</a>
<table style="border: solid 1px black">
    <th>글번호</th>
    <th class="title">제목</th>
    <th>작성자</th>
    <c:forEach var="formBoard" items="${formBoardList}">
    <tr>
        <td>${formBoard["id"]}</td>
        <td><a href="/form-board/detail?id=${formBoard["id"]}">${formBoard["title"]}</a></td>
        <td>${formBoard["writer"]}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
