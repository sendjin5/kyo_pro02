<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="rootPath" value="<%=request.getContextPath() %>" />
<style>
    header + * {margin-top: 66px;}
    /*헤더를 top에 고정시키므로 header 뒤에 오는 컨텐츠(뭐가 될진 몰라서 모든 것 * 선택)에는 헤더의 높이 만큼 margin을 적용시켜줘야 한다. */

    .navbar .nav-item > a {color:antiquewhite;}
    /*부트스트랩 navbar 위에 있는 아이템만 흰 글씨로. 안 그러면 토글해서 나오는 것도 흰 글씨가 되어 안 보인다.*/

    .navbar .nav-item {margin: auto 10px;}
    /*부트스트랩 navbar 색깔을 어두운색으로 변경했으므로 색깔을 달리해줘야 한다.*/

</style>

<header class="header container-fluid fixed-top" id="hd" style="background-color: #435334">
    <div class="container">
        <nav class="navbar navbar-expand-lg">
            <div class="container-fluid">
                <a class="navbar-brand" href="${rootPath }">
                    <img src="${rootPath}/images/favicon-color.png" alt="SamSam" height="40">
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" href="${rootPath}/introduce.jsp">My Roo Book</a>
                        </li>
                    </ul>
                    <ul class="nav justify-content-end">
                    <c:choose>
                        <c:when test="${empty session_id}">
                            <li class="nav-item"><a href="${rootPath }/member/login.jsp" class="nav-link">로그인</a></li>
                            <li class="nav-item"><a href="${rootPath }/member/term.jsp" class="nav-link">회원가입</a></li>
                        </c:when>
                        <c:when test="${session_id eq 'admin'}">
                            <li class="nav-item"><a href="${rootPath }/Logout.do" class="nav-link">로그아웃</a></li>
                            <li class="nav-item"><a href="${rootPath }/MemberListAdmin.do" class="nav-link">관리자</a></li>
                        </c:when>
                        <c:otherwise>
                            <li class="nav-item"><a href="${rootPath }/Logout.do" class="nav-link">로그아웃</a></li>
                            <li class="nav-item"><a href="${rootPath }/Mypage.do" class="nav-link">내 정보</a></li>
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="${rootPath }/CartList.do" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                    장바구니
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="${rootPath }/CartList.do">장바구니</a></li>
                                    <li><a class="dropdown-item" href="${rootPath }/PayList.do">결제 내역</a></li>
                                </ul>
                            </li>
                        </c:otherwise>
                    </c:choose>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</header>

<%----%>