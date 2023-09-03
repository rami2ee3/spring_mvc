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
<style>
    .user__wrap {
        display: flex;
    }

    .info__wrap {
        display: flex;
        flex-direction: column;
    }

    .logout__wrap {
        display: flex;
        margin-left: auto;
    }

    #logout-btn {
        margin-bottom: 24px;
    }
</style>
<body>
<div class="user__wrap">
    <div class="info__wrap">
        <h5><b>${memberInfo.userName}</b>님 반갑습니다.</h5>
        <P>최근 접속일 : <fmt:formatDate value="${memberInfo.lastLoginAt}" pattern="yyyy.MM.dd HH:mm:ss"/></P>
    </div>
    <div class="logout__wrap">
        <button id="logout-btn" type="button" class="btn btn-outline-dark btn-sm">로그아웃</button>
    </div>
</div>
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
    <tr>
        <th scope="row">1</th>
        <td>
            <a href="/image-board/detail/1">글 제목</a>
        </td>
        <td>작성자</td>
        <td>
            2023.08.01 00:00:00
        </td>
    </tr>
    </tbody>
</table>
<button id="reg-btn" type="button" class="btn btn-outline-primary">글 작성하러 가기</button>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        // id가 reg-btn 친구를 click 했을때 일어나는 이벤트
        $('#reg-btn').on('click', function () {
            location.href = '/image-board/write';
        });

        // 로그아웃 버튼 클릭
        $('#logout-btn').on('click', function () {
            // 로그아웃 API 호출
            const confirmYn = confirm("로그아웃 하시겠습니까?");
            if (confirmYn) {
                $.ajax({
                    url: '/api/member/logout',
                    type: 'GET',
                    dataType: 'json',
                    success: function (res) {
                        console.log(res);
                        if (res.result.code === 200) {
                            // 로그아웃 성공
                            location.href = '/';
                        } else {
                            alert(res.result.info);
                        }
                    }
                })

            }

        });

    });
</script>
</html>
