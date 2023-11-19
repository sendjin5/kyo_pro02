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
    <c:set var="path" value="<%=request.getContextPath() %>" />
    <style>
        .dropdown-toggle::after { transition: transform 0.15s linear;}
        .show.dropdown .dropdown-toggle::after {transform: translateY(3px);}
        .dropdown-menu {margin-top: 0;}

        #tb1 { width:960px; margin:40px auto; }
        #tb1 th { background-color: #111; color:#fff; }
        .item1 { width:10%; }
        .item2 { width:30%; }
        .item3 { width:60%; }
        #page-nation1 { width: 960px; margin:20px auto; }
    </style>
</head>
<body>
<%@ include file="../../header.jsp"%>
<div style="display: flex; min-height: 80vh;">
    <%@include file="adminBoardList.jsp"%>
    <div class="container" style="margin-top: 20px;">
        <h2 class="title">카테고리 목록</h2>
        <div class="container">
            <div class="box_wrap">
                <form action="${rootPath}/Deletecate.do" method="post" onsubmit="return deleteTrue()">
                    <table class="table table-secondary" id="tb1">
                        <thead>
                        <tr>
                            <th class="item1">번호</th>
                            <th class="item2">기호</th>
                            <th class="item3">카테고리명</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="cate" items="${cateList }" varStatus="status">
                            <tr>
                                <td class="item1">
                                    <input type="checkbox" class="isDelete" name="categoryId" value="${cate.categoryId }">
                                </td>
                                <td class="item2">
                                    <span title="${cate.categoryId}">${cate.categoryId}</span>
                                </td>
                                <td class="item3">
                                    <span title="${cate.categoryName}">${cate.categoryName }</span>
                                </td>
                            </tr>
                        </c:forEach>
                        <c:if test="${empty cateList}">
                            <tr>
                                <td colspan="3">카테고리가 존재하지 않습니다.</td>
                            </tr>
                        </c:if>
                        </tbody>
                    </table>
                    <a href="${rootPath}/CategoryAdd.do" class="btn btn-primary">카테고리 추가</a>
                    <c:if test="${!empty cateList}">
                        <input type="submit" value="선택삭제" class="btn btn-danger">
                    </c:if>
                </form>
            </div>
        </div>
    </div>
 </div>
    <%@ include file="../../footer.jsp" %>
</body>
</html>

<script>
    $(document).ready(function(){
        if($("tbody tr").length==0){
            $("tbody").append("<tr><td colspan='3' class='text-center'>해당 목록이 존재하지 않습니다.</td></tr>")
        }
    })
</script>

<script>
    function deleteTrue(){
        var isdelete = confirm("정말 삭제하시겠습니까?");
        console.log($(".isDelete[checked='true']").length);

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