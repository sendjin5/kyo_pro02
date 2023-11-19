<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>카테고리 등록</title>
    <c:set var="path" value="<%=request.getContextPath() %>" />
    <%@ include file="../../common.jsp"%>
</head>
<body>
<%@ include file="../../header.jsp"%>
<div style="display: flex; min-height: 80vh;">
    <%@include file="adminBoardList.jsp"%>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                        <h2 class="card-title text-center">카테고리 추가하기</h2>
                        <form action="${rootPath}/CategoryAddPro.do" method="post">
                            <div class="form-group">
                                <label for="categoryId">카테고리 기호:</label>
                                <input type="text" id="categoryId" name="categoryId" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label for="categoryName">카테고리 이름:</label>
                                <input type="text" id="categoryName" name="categoryName" class="form-control" required>
                            </div>
                            <button type="submit" class="btn btn-primary">추가하기</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>
<!-- 부트스트랩 JS 및 jQuery 추가 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


