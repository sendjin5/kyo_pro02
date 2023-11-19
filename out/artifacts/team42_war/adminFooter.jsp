<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<c:set var="rootPath" value="<%=request.getContextPath() %>" />

<style>
    footer {padding: 10px; background-color: #CEDEBD;}
    .nav-link {color: #435334;}
    a {color: #435334; text-decoration: none;}
    a:hover {text-decoration: 1px underline #435334;}
    /* 푸터와 컨텐츠 사이의 일정 거리 확보 */
</style>

<footer class="footer text-center">
    <nav class="nav">
        <a class="nav-link" href="#">회원약관</a>
        <a class="nav-link" href="#">개인정보처리방침</a>
        <a class="nav-link" href="#">이메일수집거부</a>
        <a class="nav-link" href="#">고객센터</a>
    </nav>
    <nav class="nav justify-content-center container-fluid">
        <a class="col nav-link" href="#">Copyrights & Company Info</a>
        <a class="col nav-link" href="#">Other Contents</a>
        <a class="col nav-link" href="#">TradeMark & WA Mark</a>
    </nav>
</footer>
