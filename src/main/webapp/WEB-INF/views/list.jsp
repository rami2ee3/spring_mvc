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
    <title>Title</title>
</head>
<body>
<table>
    <th>글번호</th>
    <th>제목</th>
    <th>내용</th>
    <c:forEach var="board" items="${boardList}">
        <tr>
            <td>${board.id}</td>
            <td>${board["title"]}</td>
            <td>${board["content"]}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
