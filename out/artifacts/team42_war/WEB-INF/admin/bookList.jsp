<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>교재 목록</title>
    <%@ include file="../../common.jsp"%>
    <style>
        .dropdown-toggle::after { transition: transform 0.15s linear;}
        .show.dropdown .dropdown-toggle::after {transform: translateY(3px);}
        .dropdown-menu {margin-top: 0;}
    </style>
</head>

<body>
<%@ include file="../../header.jsp"%>
<div style="display: flex; min-height: 80vh;">
    <%@include file="adminBoardList.jsp"%>
    <div class="container" style="margin-top: 20px;">
        <h2 class="title">교재 목록</h2>
        <ui class="category" style="float: right;">
            <a class="nav-link dropdown-toggle" href="${rootPath }/BookListAdmin.do" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                카테고리</a>
            <ul class="dropdown-menu">
                <li><a class="dropdown-item" href="${rootPath }/CateList.do?category=A">초등 교과서</a></li>
                <li><a class="dropdown-item" href="${rootPath }/CateList.do?category=B">중등 교과서</a></li>
                <li><a class="dropdown-item" href="${rootPath }/CateList.do?category=C">고등 교과서</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="${rootPath }/BookList.do?category=*">전체</a></li>
            </ul>
        </ui>
        <div class="container">
            <form action="${rootPath}/BookDelete.do" method="post" onsubmit="return deleteTrue()">
            <table class="table table-secondary" id="tb1">
                <thead>
                <tr>
                    <th></th>
                    <th>카테고리</th>
                    <th>제목</th>
                    <th>가격</th>
                    <th>등록일</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <c:forEach var="book" items="${bookList}" varStatus="status">
                        <td class="check"><input type="checkbox" class="isDelete" name="isDelete" value="${book.proNo}"></td>

                        <td >${book.categoryId}</td>
                        <td>
                            <a class="link-body-emphasis link-offset-2 link-underline-opacity-25 link-underline-opacity-75-hover" href="${rootPath }/BookGetAdmin.do?id=${book.proNo}" style="display:inline-block; width:100%;">${book.title}</a>
                        </td>
                        <td><p class="text"> ${book.price} 원</p></td>

                        <td>${book.regdate}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a class="btn btn-primary" href="${rootPath }/BookAdd.do" role="button">교재 추가</a>
            <input class="btn btn-danger" type="submit" value="교재 삭제">

            </form>
        </div>
    </div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>

<script>
    function deleteTrue(){
        var isdelete = confirm("정말 삭제하시겠습니까?");
        console.log($(".isDelete[checked='true']"));
        if(isdelete==true){
            var len = $(".isDelete[checked='true']").length;
            if(len>0){
                return true;
            } else{
                alert("삭제할 상품이 없습니다.");
                return false;
            }
        } else {
            return false;
        }
    }
</script>