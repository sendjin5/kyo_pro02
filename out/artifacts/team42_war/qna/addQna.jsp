<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>qna 글쓰기</title>
    <c:set var="path" value="<%=request.getContextPath() %>" />
    <%@ include file="../common.jsp"%>

</head>
<body id="body">
    <%@ include file="../header.jsp"%>
    <section class="page-header" style="margin-top:0!important;">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="content">
                        <h1 class="page-name">질문하기</h1>
                        <ol class="breadcrumb">
                            <li><a href="${rootPath }/">Home</a></li>
                            <li class="active">QnA</li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <div style="display: flex; min-height: 80vh;">
        <div class="container" style="margin-top: 20px;">
            <form action="${rootPath }/QnaAddPro.do" method="post">
                <input type="hidden" name="lev" value="0" >
                <input type="hidden" name="par" value="0" >

                <div class="mb-3">
                    <label class="form-label" for="title">제목</label>
                    <input class="form-control" type="text" name="title" id="title">
                </div>
                <div class="mb-3">
                    <label for="content" class="form-label">내용 입력</label>
                    <textarea class="form-control" name="content" id="content" rows="5"></textarea>
                </div>
                <div class="col-auto text-right">
                    <button type="submit" class="btn btn-main btn-medium">글 등록</button>
                </div>
            </form>
            <div class="btn-group text-right" style="margin:20px 0;">
                <a class="btn btn-main btn-medium" href="${rootPath }/QnaList.do" role="button">글 목록</a>
            </div>
        </div>
    </div>
    <%@ include file="../footer.jsp" %>
    <%@ include file="/commonsub.jsp"%>
</body>
</html>
