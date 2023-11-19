<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항 페이지</title>
    <%@ include file="../../common.jsp"%>
</head>

<body>
<%@ include file="../../header.jsp"%>
<div style="display: flex; min-height: 80vh;">
    <%@include file="adminBoardList.jsp"%>
    <div class="container" style="margin-top: 20px;">
        <h2 class="title">공지사항</h2>
        <c:set var="notice" value="${notice}"/>
        <form action="${rootPath }/NoticeUpdatePro.do" method="post">
            <input type="hidden" name="no" value="${notice.no}">
            <div class="mb-3">
                <label class="form-label" for="title">제목</label>
                <input class="form-control" type="text" name="title" id="title" value="${notice.title}">
            </div>
            <div class="mb-3">
                <label for="content" class="form-label">내용 입력</label>
                <textarea class="form-control" name="content" id="content" rows="3">${notice.content}</textarea>
            </div>
            <div class="col-auto">
                <button type="submit" class="btn btn-primary mb-3">글 수정</button>
            </div>
        </form>
        <a class="btn btn-primary" href="${rootPath }/NoticeListAdmin.do" role="button">글 목록</a>
    </div>

</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>
