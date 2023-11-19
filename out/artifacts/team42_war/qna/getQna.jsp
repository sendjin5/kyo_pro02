<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>묻고답하기 상세보기</title>
    <%@ include file="../common.jsp"%>
</head>

<body id="body">
    <%@ include file="../header.jsp"%>
    <section class="page-header" style="margin-top:0!important;">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="content">
                        <h1 class="page-name">Q & A 상세보기</h1>
                        <ol class="breadcrumb">
                            <li><a href="${rootPath }/">Home</a></li>
                            <li class="active">QnA</li>
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
            <c:set var="qna" value="${qna}"/>
            <tr>
                <td class="item2">${qna.title}</td>
                <td class="item3">${qna.regdate}</td>
                <td class="item4">${qna.visited}</td>
            </tr>
            <tr>
                <td colspan="3">
                    ${qna.content}
                </td>
            </tr>
        </tbody>
        </table>
        <div class="btn-group text-right" style="margin:20px 0;">
            <a class="btn btn-main btn-medium" href="${rootPath }/QnaList.do" role="button">글 목록</a>
            <c:if test="${qna.author eq sid }">
                <a class="btn btn-main btn-medium" href="${rootPath }/QnaUpdate.do?no=${qna.qno}" role="button">글 수정</a>
                <a class="btn btn-main btn-medium" href="${rootPath }/QnaDelete.do?no=${qna.qno}" role="button">글 삭제</a>
            </c:if>
            <c:if test="${sid eq 'admin' }">
                <a class="btn btn-main btn-medium" href="${rootPath }/QnaAddAdmin.do?lev=1&par=${qna.qno}" role="button">답변하기</a>
            </c:if>
        </div>
    </div>
    <%@ include file="../footer.jsp" %>
    <%@ include file="/commonsub.jsp"%>
</body>
</html>
