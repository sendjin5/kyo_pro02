<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항 목록</title>
    <%@ include file="../../common.jsp"%>
</head>

<body>
<%@ include file="../../header.jsp"%>
<div style="display: flex; min-height: 80vh;">
    <%@include file="adminBoardList.jsp"%>
    <div class="container" style="margin-top: 20px;">
        <h2 class="title">공지사항</h2>
        <div class="container">
            <table class="table table-secondary" id="tb1">
                <thead>
                <tr>
                    <th class="item1">번호</th>
                    <th class="item2">제목</th>
                    <th class="item3">작성일</th>
                    <th class="item4">조회수</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="notice" items="${noticeList}" varStatus="status">
                <tr>
                    <td class="item1">${status.count}</td>
                    <td class="item2">
                        <a class="link-body-emphasis link-offset-2 link-underline-opacity-25 link-underline-opacity-75-hover item3" href="${rootPath }/NoticeGetAdmin.do?no=${notice.no}" style="display:inline-block; width:100%;>${notice.title}</a>
                    </td>
                                <td class=">${notice.title}</a></td>
                    <td>${notice.resdate}</td>
                    <td class="item4">${notice.visited}</td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
            <a class="btn btn-primary" href="${rootPath }/NoticeAdd.do" role="button">글 추가</a>

        </div>
    </div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>

<script>
    $(document).ready(function(){
        if($("tbody tr").length==0){
            $("tbody").append("<tr><td colspan='4' class='text-center'>해당 목록이 존재하지 않습니다.</td></tr>")
        }
    })
</script>