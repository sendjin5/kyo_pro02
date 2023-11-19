<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 목록</title>
    <%@ include file="../../common.jsp"%>
</head>

<body>
<%@ include file="../../header.jsp"%>
<div style="display: flex; min-height: 80vh;">
    <%@include file="adminBoardList.jsp"%>
    <div class="container" style="margin-top: 20px;">
        <h2 class="title">회원</h2>
        <div class="container">
            <form action="${rootPath}/MemberDelete.do" method="post" onsubmit="return deleteTrue()">
                <table class="table table-secondary" id="tb1">
                    <thead>
                    <tr>
                        <th></th>
                        <th>번호</th>
                        <th>아이디</th>
                        <th>이름</th>
                        <th>등록일</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="member" items="${memberList}" varStatus="status">
                    <tr id="${status.count}">
                        <td class="check"><input type="checkbox" class="isDelete" name="isDelete" value="${member.id}"></td>
                        <td>${status.count}</td>
                        <td>
                            <a class="link-body-emphasis link-offset-2 link-underline-opacity-25 link-underline-opacity-75-hover" href="${rootPath }/MemberGetAdmin.do?id=${member.id}" style="display:inline-block; width:100%;">${member.id}</a>
                        </td>
                        <td>${member.name}</td>
                        <td>${member.regdate}</td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <input class="btn btn-danger" type="submit" value="회원 삭제">

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
        if(isdelete===true){
            var len = $(".isDelete[checked='true']").length;
            if(len>0){
                return true;
            } else{
                alert("삭제할 회원이 없습니다.");
                return false;
            }
        } else {
            return false;
        }
    }
</script>

<script>
    $(document).ready(function(){
        if($("tbody tr").length==0){
            $("tbody").append("<tr><td colspan='5' class='text-center'>해당 목록이 존재하지 않습니다.</td></tr>")
        }
    })
</script>