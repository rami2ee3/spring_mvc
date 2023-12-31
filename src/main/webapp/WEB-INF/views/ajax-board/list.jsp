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
<table class="table table-bordered">
    <thead>
    <tr class="table-primary">
        <th scope="col">글 번호</th>
        <th scope="col">제목</th>
        <th scope="col">작성자</th>
        <th scope="col">작성일시</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="ajaxBoard" items="${ajaxBoardList}">
    <tr>
        <th scope="row">${ajaxBoard.id}</th>
        <td>
            <a href="/ajax-board/detail/${ajaxBoard.id}">${ajaxBoard.title}</a>
        </td>
        <td>${ajaxBoard.writer}</td>
        <td>
            <!-- Date 형식을 String format 으로 변경 -->
            <fmt:formatDate value="${ajaxBoard.created_at}" pattern="yyyy.MM.dd HH:mm:ss"/>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<button id="reg-btn" type="button" class="btn btn-outline-primary">글 작성하러 가기</button>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        // id가 reg-btn 친구를 click 했을때 일어나는 이벤트
        $('#reg-btn').on('click', function () {
            location.href = '/ajax-board/write';
        });
    });
</script>
</html>
