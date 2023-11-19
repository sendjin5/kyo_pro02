<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>교재 관리 페이지</title>
    <%@ include file="../../common.jsp"%>
</head>

<body>
<%@include file="../../header.jsp"%>
<div style="display: flex; min-height: 80vh;">
    <%@include file="adminBoardList.jsp"%>
    <div class="container" style="margin-top: 20px;">
        <div class="row">
            <div class="col-4" style="width: 500px">
                <img class="card-img-top" src="${product.img }" alt="${product.title }" width="100"/>
            </div>
            <div class="col-8" style="width: 640px">
                <table class="table" >
                    <thead>
                    <tr>
                        <td colspan="2"><h2>${product.title }</h2></td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">카테고리</th>
                        <td>${category.categoryName} </td>
                    </tr>
                    <tr>
                        <th scope="row">저자</th>
                        <td>${product.author} </td>
                    </tr>
                    <tr>
                        <th scope="row">저자</th>
                        <td>${product.author} </td>
                    </tr>
                    <tr>
                        <th scope="row">수량</th>
                        <td>
                            <c:if test="${amount <= 0}">절판</c:if>
                            <c:if test="${amount > 0}">${amount}</c:if>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">가격</th>
                        <td>${product.price}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="content" style="margin-top: 24px; padding: 24px; border: 1px solid black; ">
            <c:if test="${!empty product.video }">
                <video height="600" width="400" controls >
                    <source src="${rootPath}/storage/${product.video }" type="video/mp4">
                </video>
            </c:if>
            <br>
            ${product.content}
        </div>
        <a class="btn btn-primary" href="${rootPath }/BookListAdmin.do" role="button">글 목록</a>
        <a class="btn btn-primary" href="${rootPath }/Instock.do?no=${product.proNo}" role="button">상품 입고</a>
        <a class="btn btn-primary" href="${rootPath }/BookUpdate.do?no=${product.proNo}" role="button">글 수정</a>
        <a class="btn btn-primary" href="${rootPath }/BookDelete.do?no=${product.proNo}" role="button">글 삭제</a>
    </div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>
