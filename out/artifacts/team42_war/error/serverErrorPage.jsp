<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>error page</title>
    <%@ include file="../common.jsp"%>
</head>
<body id="body">
<section class="page-404">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <a href="${path }/">My Roo Book소개</a>
                <h1>500</h1>
                <h2>Page Server Error</h2>
                <a href="${path }/" class="btn btn-main"><i class="fas fa-arrow-left"></i> 홈페이지로 이동</a>
                <p class="copyright-text">© 2023 My RooBOOK All Rights Reserved</p>
            </div>
        </div>
    </div>
</section>
<%@ include file="../commonsub.jsp" %>
</body>
</html>
