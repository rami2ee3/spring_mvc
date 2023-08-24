<%--
  Created by IntelliJ IDEA.
  User: sbr95
  Date: 2023-08-22
  Time: 오후 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>공지사항 목록</title>
</head>
<body>
<a href="/notice/write">공지사항 쓰러 가기</a>
<table>
    <th>글번호</th>
    <th>제목</th>
    <th>내용</th>
    <th>작성자</th>
    <c:forEach var="list" items="${noticeList}">
    <tr>
        <td>${list["id"]}</td>
        <td>${list["title"]}</td>
        <td>${list["content"]}</td>
        <td><b>${list["writer"]}</b></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
