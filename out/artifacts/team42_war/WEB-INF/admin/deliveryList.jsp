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
        <h2 class="title">배송 관리</h2>
        <div class="container">
            <table class="table table-secondary" id="tb1">
                <thead>
                    <tr>
                        <th>결제번호</th>
                        <th>배송회사</th>
                        <th>배송회사 번호</th>
                        <th>배송시작일</th>
                        <th>배송도착일</th>
                        <th>운송번호</th>
                        <th>배송 상태</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="delivery" items="${delList}">
                <tr>
                    <td>${delivery.payNo}</td>
                    <td>${delivery.dcom}</td>
                    <td>${delivery.dtel}</td>
                    <td>${delivery.etd}</td>
                    <td>${delivery.eta}</td>
                    <td>${delivery.dcode}</td>
                    <td class="state">${delivery.state}</td>
                    <td><a class="btn btn-primary" href="${rootPath}/DeliveryGetAdmin.do?dno=${delivery.dno}">수정</a></td>
                </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>

<script>
    $(document).ready(function(){
        $(".state").each(function(){
            var now = $(this).text();
            if(now==="0"){
                $(this).text("배송 전");
            } else if(now==="1"){
                $(this).text("배송 중");
            } else if(now==="2"){
                $(this).text("배송도착");
            } else if(now==="3"){
                $(this).text("구매확정");
            }
        })
    })
</script>

<script>
    $(document).ready(function(){
        if($("tbody tr").length==0){
            $("tbody").append("<tr><td colspan='8' class='text-center'>해당 목록이 존재하지 않습니다.</td></tr>")
        }
    })
</script>