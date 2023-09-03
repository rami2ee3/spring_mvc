<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<%@include file="common/header.jsp" %>
<body>

<div class="mb-3">
    <label for="user-id" class="form-label">아이디</label>
    <input id="user-id" type="email" class="form-control">
</div>
<div class="mb-3">
    <label for="user-pw" class="form-label">비밀번호</label>
    <input id="user-pw" type="password" class="form-control">
</div>
<button id="login-btn" type="submit" class="btn btn-primary">로그인</button>
<button type="submit" class="btn btn-success" onclick="location.href='/join'">회원가입</button>
</body>

<script type="text/javascript">
    $(document).ready(function () {

        function loginAction() {
            const data = {userId: $('#user-id').val(), userPw: $('#user-pw').val()}

            $.ajax({
                url: '/api/member/login',
                type: 'post',
                data,
                dataType: 'json',
                success: function (res) {
                    if (res.result.code === 200) {
                        // 로그인 성공
                        location.href = '/image-board/list';
                    } else {
                        alert(res.result.info);
                    }
                },
            });
        }

        $('#user-id, #user-pw').on('keyup', function (e) {
            // 입력된 키가 엔터일 경우 로그인 액션 호출
            if (e.keyCode === 13) {
                loginAction();
            }
        });

        // 로그인 버튼 눌렀을때 액션
        $('#login-btn').on('click', function () {
            loginAction();
        });

    });
</script>
</html>
