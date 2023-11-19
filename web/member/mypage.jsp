<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <%@ include file="../common.jsp" %>
    <style>

    </style>
</head>
<body id="body">
    <%@ include file="../header.jsp"%>
    <section class="page-header" style="margin-top:0!important;">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="content">
                        <h1 class="page-name">내 정보</h1>
                        <ol class="breadcrumb">
                            <li><a href="${rootPath }/">Home</a></li>
                            <li class="active">마이페이지</li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <div class="container contents text-center">
        <c:set var="me" value="${me}"/>
        <table class="table">
            <tbody>
            <tr>
                <th>이름</th>
                <td>${me.name}</td>
            </tr>
            <tr>
                <th>아이디</th>
                <td>${me.id}</td>
            </tr>
            <tr>
                <th>비밀번호</th>
                <td>${me.pw}</td>
            </tr>
            <tr>
                <th>전화번호</th>
                <td>${me.tel}</td>
            </tr>
            <tr>
                <th>이메일</th>
                <td>${me.email}</td>
            </tr>
            <tr>
                <th>주소</th>
                <td>${address1 } ${address2 }</td>
            </tr>
            <tr>
                <th>생년월일</th>
                <td>${me.birth}</td>
            </tr>
            </tbody>
        </table>
        <a href="${rootPath }/MypageUpdate.do" class="btn btn-primary mb-3">회원정보 수정하기</a>
        <a href="${rootPath }/MypageDelete.do" class="btn btn-primary mb-3">회원 탈퇴하기</a>
    </div>

    <%@ include file="../footer.jsp" %>
    <%@ include file="../commonsub.jsp" %>
</body>
</html>