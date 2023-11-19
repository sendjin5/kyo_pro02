<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>묻고 답하기</title>
    <%@ include file="../common.jsp"%>
</head>

<body id="body">
    <%@ include file="../header.jsp"%>
    <section class="page-header" style="margin-top:0!important;">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="content">
                        <h1 class="page-name">Q & A</h1>
                        <ol class="breadcrumb">
                            <li><a href="${rootPath }/">Home</a></li>
                            <li class="active">QnA</li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <div class="container">
        <div class="box_wrap">
        <table class="table table-secondary" id="tb1">
            <thead>
            <tr>
                <th class="item1">번호</th>
                <th class="item2">제목</th>
                <th class="item3">작성자</th>
                <th class="item3">작성일</th>
                <th class="item4">조회수</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="qna" items="${qnaList}" varStatus="status">
                <tr>
                    <td class="item1">${status.count}</td>
                    <td class="item2">
                        <c:if test="${qna.lev eq 0 }">
                            <a class="link-body-emphasis link-offset-2 link-underline-opacity-25 link-underline-opacity-75-hover" href="${rootPath }/QnaGet.do?qno=${qna.qno}" style="display:inline-block; width:100%;">${qna.title}</a>
                        </c:if>
                        <c:if test="${qna.lev ne 0 }">
                            <a class="link-body-emphasis link-offset-2 link-underline-opacity-25 link-underline-opacity-75-hover" href="${rootPath }/QnaGet.do?qno=${qna.qno}" style="display:inline-block; width:100%; padding-left:28px;">[답변] ${qna.title}</a>
                        </c:if>
                    </td>
                    <td class="item3">${qna.author}</td>
                    <td class="item3">${qna.regdate}</td>
                    <td class="item4">${qna.visited}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
            <c:if test="${!empty sid}">
                <a class="btn btn-main btn-medium" href="${rootPath }/QnaAdd.do" role="button">글쓰기</a>
            </c:if>


        </div>
    </div>
    <%@ include file="../footer.jsp" %>
    <%@ include file="/commonsub.jsp"%>
</body>
</html>

<script>
    $(document).ready(function(){
        if($("tbody tr").length==0){
            $("tbody").append("<tr><td colspan='5' class='text-center'>해당 목록이 존재하지 않습니다.</td></tr>")
        }
    })
</script>