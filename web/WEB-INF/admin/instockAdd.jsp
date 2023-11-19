<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*, java.lang.*" %>
<%@ page import="java.text.*, java.net.InetAddress" %>
<c:set var="path" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>파일 업로드</title>
    <jsp:include page="../../common.jsp" />
</head>
<body>
<%@include file="../../header.jsp"%>
<div style="display: flex; min-height: 80vh;">
    <%@include file="adminBoardList.jsp"%>
    <div class="container" style="margin-top: 20px;">
        <h2 class="title">${product.title } 상품 입고</h2>
        <div class="container">
            <form class="form_row" action="${path }/InstockAddPro.do" method="post">
                <input type="hidden" name="proNo" id="proNo" value="${proNo }">
                <div class="row">
                    <div class="col-2"><label for="amount" class="form-label">입고 수량</label></div>
                    <div class="col-8">
                        <input type="number" min="1" name="amount" id="amount" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col-2"><label for="inPrice" class="form-label">입고 가격</label></div>
                    <div class="col-8">
                        <input type="number" min="1000" name="inPrice" id="inPrice" required>
                    </div>
                </div>
                <input type="submit" class="btn btn-primary mb-3" value="상품 입고">
            </form>
        </div>
    </div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>
