<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>학습자료실 페이지</title>
    <%@ include file="../common.jsp"%>
</head>
<body id="body">
    <%@ include file="../header.jsp"%>
    <section class="page-header" style="margin-top:0!important;">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="content">
                        <h1 class="page-name">학습자료실</h1>
                        <ol class="breadcrumb">
                            <li><a href="${rootPath }/">Home</a></li>
                            <li class="active">학습자료실</li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <div class="container contents">
        <table class="table">
            <thead>
            <tr>
                <th class="item2">제목</th>
                <th class="item3">작성일</th>
                <th class="item4">조회수</th>
            </tr>
            </thead>
            <tbody>
            <c:set var="fileboard" value="${fileboard}"/>
            <tr>
                <td class="item2">${fileboard.title}</td>
                <td class="item3">${fileboard.regdate}</td>
                <td class="item4">${fileboard.visited}</td>
            </tr>
            <tr>
                <td colspan="3">
                    ${fileboard.content}
                </td>
            </tr>
            <tr>
                <th class="item2" colspan="3">학습자료(클릭하여 다운로드)</th>
            </tr>
            <tr>
                <td colspan="3">
                    <c:if test="${!empty fileboard.filename1 }">
                        <a href="${rootPath }/storage/${fileboard.filename1 }" download ><i class="fas fa-file" style="color: #54c066;"></i> ${fileboard.filename1 }</a>
                    </c:if>
                    <c:if test="${!empty fileboard.filename2 }">
                        <a href="${rootPath }/storage/${fileboard.filename2 }" download ><i class="fas fa-file" style="color: #54c066;"></i> ${fileboard.filename2 }</a>
                    </c:if>
                    <c:if test="${!empty fileboard.filename3 }">
                        <a href="${rootPath }/storage/${fileboard.filename3 }" download ><i class="fas fa-file" style="color: #54c066;"></i> ${fileboard.filename3 }</a>
                    </c:if>
                </td>
            </tr>
            </tbody>
        </table>
    </div>

    <%@ include file="../footer.jsp" %>
    <%@ include file="../commonsub.jsp" %>
</body>
</html>
