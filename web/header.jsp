<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
    header + * {margin-top: 66px;}
    /*헤더를 top에 고정시키므로 header 뒤에 오는 컨텐츠(뭐가 될진 몰라서 모든 것 * 선택)에는 헤더의 높이 만큼 margin을 적용시켜줘야 한다. */

    .navbar .nav-item > a {color:antiquewhite;}
    /*부트스트랩 navbar 위에 있는 아이템만 흰 글씨로. 안 그러면 토글해서 나오는 것도 흰 글씨가 되어 안 보인다.*/

    .navbar .nav-item {margin: auto 10px;}
    /*부트스트랩 navbar 색깔을 어두운색으로 변경했으므로 색깔을 달리해줘야 한다.*/

    .col-lg-6 {width:100%;}

</style>

<section class="top-header">
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-xs-12 col-sm-4">
                <div class="contact-number">
                </div>
            </div>
            <div class="col-md-4 col-xs-12 col-sm-4">
                <!-- Site Logo -->
                <div class="logo text-center">
                    <a href="${rootPath }/">
                        <img src="${rootPath }/images/common/icon_48.png" alt="My Roo Book">
                        My Roo Book
                    </a>
                </div>
            </div>
            <div class="col-md-4 col-xs-12 col-sm-4">
                <!-- Cart -->
                <ul class="top-menu text-right list-inline">
                    <c:choose>
                        <c:when test="${empty session_id}">
                            <li><a href="${rootPath }/member/login.jsp">로그인</a></li>
                            <li><a href="${rootPath }/member/term.jsp">회원가입</a></li>
                        </c:when>
                        <c:when test="${session_id eq 'admin'}">
                            <li><a href="${rootPath }/Logout.do">로그아웃</a></li>
                            <li><a href="${rootPath }/MemberListAdmin.do">관리자</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="${rootPath }/Logout.do">로그아웃</a></li>
                            <li><a href="${rootPath }/CartList.do">장바구니</a></li>
                            <li><a href="${rootPath }/PayList.do">결제 내역</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </div>
</section>
<section class="menu">
    <nav class="navbar navigation">
        <div class="container">
            <div id="navbar" class="navbar-collapse collapse text-center">
                <ul class="nav navbar-nav">
                    <li class="dropdown dropdown-slide">
                        <a href="#!" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="350" role="button" aria-haspopup="true" aria-expanded="false">My Roo Book 소개 <i class="fas fa-sort-down" style="vertical-align: 0.125em!important;"></i></a>
                        <div class="dropdown-menu">
                            <div class="row">
                                <div class="col-lg-6 col-md-6 mb-sm-3">
                                    <ul>
                                        <li><a href="${rootPath}/product/introduce.jsp">회사소개</a></li>
                                        <li><a href="${rootPath}/product/map.jsp">오시는길</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="dropdown dropdown-slide">
                        <a href="#!" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="350" role="button" aria-haspopup="true" aria-expanded="false">도서 <i class="fas fa-sort-down" style="vertical-align: 0.125em!important;"></i></a>
                        <div class="dropdown-menu">
                            <div class="row">
                                <div class="col-lg-6 col-md-6 mb-sm-3">
                                    <ul>
                                        <li><a href="${rootPath }/BookList.do?category=*">전체</a></li>
                                        <li><a href="${rootPath }/BookList.do?category=A">초등</a></li>
                                        <li><a href="${rootPath }/BookList.do?category=B">중등</a></li>
                                        <li><a href="${rootPath }/BookList.do?category=C">고등</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li class="dropdown dropdown-slide">
                        <a href="#!" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-delay="350" role="button" aria-haspopup="true" aria-expanded="false">커뮤니티 <i class="fas fa-sort-down" style="vertical-align: 0.125em!important;"></i></a>
                        <div class="dropdown-menu">
                            <div class="row">
                                <div class="col-lg-6 col-md-6 mb-sm-3">
                                    <ul>
                                        <li><a href="${rootPath}/NoticeList.do">공지사항</a></li>
                                        <li><a href="${rootPath}/QnaList.do">묻고답하기</a></li>
                                        <li><a href="${rootPath }/FileboardList.do">학습자료실</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</section>
