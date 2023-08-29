<%--
  Created by IntelliJ IDEA.
  User: sbr95
  Date: 2023-08-28
  Time: 오후 9:11
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
        <c:forEach var="ajax2" items="${ajax2List}">
        <tr>
            <th scope="row">${ajax2.id}</th>
            <td><a href="/ajax-board2/detail/${ajax2.id}">${ajax2.title}</a></td>
            <td>${ajax2.writer}</td>
            <td>
                <fmt:formatDate value="${ajax2.created_at}" pattern="yyyy.mm.dd HH:mm:ss"/>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
<button id="reg-btn" type="button" class="btn btn-outline-primary">글 작성하러 가기</button>
</body>
<script type="text/javascript">
    $(document).ready(function(){
        $('#reg-btn').on('click', function (){
            location.href = '/ajax-board2/write';
        });
    });
</script>
</html>
