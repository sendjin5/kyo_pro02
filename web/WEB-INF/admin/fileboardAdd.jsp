<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>학습 자료실 업로드</title>
    <jsp:include page="../../common.jsp" />
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
                            <h2 class="card-title text-center">학습자료 업로드</h2>
                            <form action="${path}/FileboardAddPro.do" method="post" enctype="multipart/form-data">
                                <table class="table">
                                    <tbody>
                                    <tr>
                                        <th><label for="title">제목</label></th>
                                        <td><input type="text" name="title" id="title" class="form-control"></td>
                                    </tr>
                                    <tr>
                                        <th><label for="content">내용</label></th>
                                        <td><textarea name="content" id="content" class="form-control"></textarea></td>
                                    </tr>
                                    <tr>
                                        <th><label for="filename1">첨부 파일1</label></th>
                                        <td><input type="file" name="filename1" id="filename1" class="form-control"></td>
                                    </tr>
                                    <tr>
                                        <th><label for="filename2">첨부 파일2</label></th>
                                        <td><input type="file" name="filename2" id="filename2" class="form-control"></td>
                                    </tr>
                                    <tr>
                                        <th><label for="filename3">첨부 파일3</label></th>
                                        <td><input type="file" name="filename3" id="filename3" class="form-control"></td>
                                    </tr>
                                    <tr>
                                        <td colspan="2"><input type="submit" value="등록" class="btn btn-primary"></td>
                                    </tr>
                                    </tbody>
                                </table>
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
