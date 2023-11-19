<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>로그인</title>
    <%@ include file="../common.jsp" %>
</head>
<body id="body">

<section class="signin-page account">
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div class="block text-center">
                    <a class="logo" href="${rootPath }/">My Roo Book소개</a>
                    <h2 class="text-center">로그인</h2>
                    <form class="text-left clearfix form_row" action="${rootPath}/LoginPro.do" id="login_form" method="post">
                        <div class="form-group">
                            <input class="form-control" type="text" name="id" id="id" placeholder="아이디 입력" autofocus required>
                        </div>
                        <div class="form-group">
                            <input class="form-control" type="password" name="pw" id="pw"  placeholder="패스워드 입력" required>
                        </div>
                        <div class="text-center">
                            <button type="submit" class="btn btn-main text-center" >로그인</button>
                        </div>
                    </form>
                    <p class="mt-20">회원가입을 하시겠습니까?<a href="${rootPath }/member/term.jsp"> 회원가입</a></p>
                </div>
            </div>
        </div>
    </div>
</section>
<%--
<div class="container contents text-center">
    <h2 class="page_title text-center">로그인</h2>
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb justify-content-end">
            <li class="breadcrumb-item"><a href="${rootPath }">Home</a></li>
            <li class="breadcrumb-item active" aria-current="page">Login</li>
        </ol>
    </nav>

    &lt;%&ndash; 로그인 Form   &ndash;%&gt;
    <form action="${rootPath}/LoginPro.do" id="" class="form_row" method="post">
        <div class="container justify-content-center" style="max-width: 400px;">
            <div class="row">
                <input class="form-control" type="text" name="id" id="id" placeholder="아이디 입력" autofocus required>
            </div>
            <div class="row">
                <input class="form-control" type="password" name="pw" id="pw"  placeholder="패스워드 입력" required>
            </div>
            <a href="" style="display: block; text-align: end; font-size: 8px; color: gray; margin-bottom: 20px;">아이디/비밀번호 찾기</a>
            <input type="submit" value="로그인" class="btn btn-primary mb-3">
            <a href="${rootPath }/member/term.jsp" class="btn btn-primary mb-3">회원가입</a>
        </div>
    </form>
</div>--%>
<%@ include file="/commonsub.jsp"%>
</body>
</html>