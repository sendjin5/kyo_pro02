<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>리뷰 페이지</title>
    <%@ include file="../common.jsp"%>
</head>

<body id="body">
    <%@ include file="../header.jsp"%>
    <section class="page-header" style="margin-top:0!important;">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="content">
                        <h1 class="page-name">리뷰</h1>
                        <ol class="breadcrumb">
                            <li><a href="${rootPath }/">Home</a></li>
                            <li><a href="${rootPath }/BookGet.do?proNo=${proNo }">${product.title }</a></li>
                            <li class="active">리뷰</li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <div class="container contents text-center">
        <form action="${rootPath }/ReviewAddPro.do" method="post">
            <input type="hidden" value="${proNo}" id="proNo" name="proNo" >
            <table class="table">
                <thead>
                <tr>
                    <td colspan="2"><h2>${product.title } 관련 리뷰</h2></td>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row"><label for="star" class="form-label">별점</label></th>
                    <td><input type="number" class="form-control" id="star" name="star" max="5"></td>
                </tr>
                <tr>
                    <th scope="row"><label for="content" class="form-label">리뷰내용</label></th>
                    <td><textarea class="form-control" id="content" name="content" rows="5"></textarea></td>
                </tr>
                </tbody>
            </table>
            <button type="submit">리뷰등록</button>
        </form>
        <a class="btn btn-primary" href="${rootPath }/BookGet.do?proNo=${proNo }" role="button">글 목록</a>
    </div>

    <%@ include file="../footer.jsp" %>
    <%@ include file="../commonsub.jsp" %>
</body>
</html>
