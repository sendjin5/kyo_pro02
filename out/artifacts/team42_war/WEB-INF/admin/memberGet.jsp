<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <%@ include file="../../common.jsp" %>
    <style>

    </style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div style="display: flex; min-height: 80vh;">
    <%@include file="adminBoardList.jsp"%>
    <div class="container contents text-center">

        <h2 class="page_title text-center">내 정보</h2>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb justify-content-end">
                <li class="breadcrumb-item"><a href="${rootPath }">Home</a></li>
                <li class="breadcrumb-item active" aria-current="page">Mypage</li>
            </ol>
        </nav>
        <c:set var="me" value="${member}"/>
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
                <td>${me.address1} ${me.address2}</td>
            </tr>
            <tr>
                <th>생년월일</th>
                <td>${me.birth}</td>
            </tr>
            </tbody>
        </table>
        <div class="container">
            <a class="btn btn-primary" href="${rootPath }/MemberListAdmin.do" role="button">회원 목록</a>
            <a class="btn btn-primary" href="${rootPath }/MemberUpdateAdmin.do?id=${me.id}" role="button">정보 수정</a>
        </div>
    </div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>