<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<%@include file="common/header.jsp" %>
<body>

<div class="mb-3">
    <label for="user-id" class="form-label">아이디 * </label>
    <input id="user-id" type="text" class="form-control" placeholder="아이디를 입력해주세요.">
</div>
<div class="mb-3">
    <label for="user-pw" class="form-label">비밀번호 * </label>
    <input id="user-pw" type="password" class="form-control" placeholder="비밀번호를 입력해주세요.">
</div>
<div class="mb-3">
    <label for="user-pw-check" class="form-label">비밀번호 확인 * </label>
    <input id="user-pw-check" type="password" class="form-control" placeholder="비밀번호를 확인해주세요">
</div>
<div class="mb-3">
    <label for="user-name" class="form-label">이름 * </label>
    <input id="user-name" type="text" class="form-control" placeholder="이름을 입력해주세요.">
</div>
<div class="mb-3">
    <label for="user-address" class="form-label">주소</label>
    <input id="user-address" type="text" class="form-control" placeholder="주소를 입력해주세요.">
</div>
<div class="mb-3">
    <label for="address-detail" class="form-label">상세주소</label>
    <input id="address-detail" type="text" class="form-control" placeholder="상세주소를 입력해주세요.">
</div>
<button type="submit" class="btn btn-secondary" onclick="history.go(-1)">뒤로가기</button>
<button id="join-btn" type="submit" class="btn btn-success">회원가입</button>
</body>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
    $(document).ready(function () {

        function openAddrSearch() {
            new daum.Postcode({
                oncomplete: function (data) {
                    // 지번주소 선택했는지, 도로명 주소 선택했는지 확인 ( 지번 : J, 도로명 : R )
                    const userSelectedType = data.userSelectedType;
                    if (userSelectedType === "J") {
                        $('#user-address').val(data.jibunAddress);
                    } else if (userSelectedType === "R") {
                        $('#user-address').val(data.roadAddress);
                    }
                }
            }).open();
        }

        $('#user-address').on('click', function () {
            openAddrSearch();
            $('#address-detail').focus();
        });


        $('#join-btn').on('click', function () {
            // userId, userPw, userName, userAddress
            const userId = $('#user-id').val();
            const userPw = $('#user-pw').val();
            const userPwCheck = $('#user-pw-check').val();
            const userName = $('#user-name').val();
            const mainAddress = $('#user-address').val();
            const detailAddress = $('#address-detail').val();

            if (userId === '') {
                alert('아이디를 입력해주세요.');
            } else if (userPw === '') {
                alert('비밀번호를 입력해주세요.');
            } else if (userPwCheck === '') {
                alert('비밀번호 확인을 입력해주세요.');
            } else if (userPw !== userPwCheck) {
                alert('비밀번호가 일치하지 않습니다.')
            } else if (userName === '') {
                alert('이름을 입력해주세요');
            } else {
                const data = {userId, userPw, userName, userAddress: mainAddress + detailAddress}

                $.ajax({
                    url: '/api/member/join',
                    type: 'POST',
                    data,
                    dataType: 'json',
                    success: function (res) {
                        if (res.result.code === 200) {
                            alert(res.result.info);
                            location.href = '/';
                        } else {
                            alert(res.result.info);
                        }
                    }
                });

            }


        });


    });
</script>
</html>
