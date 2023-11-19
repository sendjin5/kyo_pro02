<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <title>메인 페이지</title>
    <%@ include file="/common.jsp"%>

    <style>
        .service_container .item {float: left ; width: 25%; text-align: center;}
    </style>
</head>

<body id="body">
<%@ include file="/header.jsp"%>
<div class="hero-slider">
    <div class="slider-item th-fullpage hero-area" style="background-image: url('${rootPath }/images/001.jpg');">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 text-center">
                    <p data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".1">Book</p>
                    <h1 data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".5"> 이곳은 지식의 대나무숲, <br>
                        끝없는 배움이 펼쳐지는 곳입니다.</h1>
                    <p>
                        새로운 아이디어와 통찰력을 얻으며 성장하는 이 공간에서, 우리는 역사를 읽고 미래를 상상하며 끊임없이 발전합니다. 지식의 보고에서 만나는 미래의 리더, 그 첫 걸음을 함께 시작해보세요.
                    </p>
                    <a data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".8" class="btn" href="${rootPath }/BookList.do?category=*">바로가기</a>
                </div>
            </div>
        </div>
    </div>
    <div class="slider-item th-fullpage hero-area" style="background-image: url('${rootPath }/images/003.jpg');">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 text-right">
                    <p data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".1">학습자료실</p>
                    <h1 data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".5">다양한 자료를 <br>확인해보세요.</h1>
                    <a data-duration-in=".3" data-animation-in="fadeInUp" data-delay-in=".8" class="btn" href="${rootPath }/FileboardList.do">바로가기</a>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- service section -->

<section class="service_section layout_padding" id="service">>
    <div class="container">
        <div class="heading_container heading_center ">
            <h2 class="">
                Roo 서비스
            </h2>

        </div>
        <div class="service_container">
            <div class="carousel-wrap ">
                <div class="service_owl-carousel owl-carousel" >
                    <div class="item">
                        <div class="box ">
                            <div class="img-box">
                                <img src="images/s3.png" alt="교과서와 학습 자료" />
                            </div>
                            <div class="detail-box">
                                <h5>
                                    <span>교과서와 학습 자료</span>
                                </h5>
                                <p>
                                    다양한 학년과 과목을 위한 교과서와 학습 자료를 제공합니다. <br><br>
                                    학습자의 성장 단계와 요구에 맞추어 적절한 내용과 난이도로 구성된 자료를 개발하여 학습 효과를 극대화합니다.

                                </p>
                            </div>

                        </div>
                    </div>
                    <div class="item">
                        <div class="box ">
                            <div class="img-box">
                                <img src="images/s2.png" alt="교사 지원 프로그램" />
                            </div>
                            <div class="detail-box">
                                <h5>
                                    <span>교사 지원 프로그램</span>
                                </h5>
                                <p>
                                    교사들을 위한 교육 리소스를 제공하는 프로그램을 운영합니다. <br><br>
                                    지도하는 교사들이 학생들의 학습을 더욱 더 효과적으로 지원할 수 있도록 돕는 것이 우리 My Roo의 목표입니다.
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="box ">
                            <div class="img-box">
                                <img src="images/s1.png" alt="학교 컨설팅" />
                            </div>
                            <div class="detail-box">
                                <h5>
                                    <span>학교 컨설팅</span>
                                </h5>
                                <p>
                                    학교의 교육과정 개선을 위한 컨설팅 서비스를 제공합니다. <br><br>
                                    학교와 교사들의 요구와 목표를 파악하고 맞춤형 교육 솔루션을 개발하여 학교 커뮤니티 전반에 긍정적인 변화를 가져옵니다.
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="box ">
                            <div class="img-box">
                                <img src="images/s4.png" alt="디지털 학습 플랫폼" />
                            </div>
                            <div class="detail-box">
                                <h5>
                                    <span>디지털 학습 플랫폼</span>
                                </h5>
                                <p>
                                    현대 학습 환경에 부합하도록 디지털 학습 플랫폼을 제공합니다. <br><br>
                                    온라인 퀴즈, 대화형 모듈, 멀티미디어 콘텐츠 등을 활용하여 학생들이 더욱 적극적으로 학습에 참여하도록 돕습니다.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- service section ends -->
<section class="product-category section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="title text-center">
                    <h2>Product Category</h2>
                </div>
            </div>
            <div class="col-md-6">
                <div class="category-box">
                    <a href="${rootPath }/BookList.do?category=A">
                        <img src="${rootPath }/images/main/elebook.jpg" alt="" />
                        <div class="content">
                            <h3>초등 서적</h3>
                            <p>초등학생을 위한 최적의 서적</p>
                        </div>
                    </a>
                </div>
           </div>
            <div class="col-md-6">
                    <div class="category-box">
                        <a href="${rootPath }/BookList.do?category=B">
                            <img src="${rootPath }/images/main/midbook.jpg" alt="" />
                            <div class="content">
                                <h3>중등 서적</h3>
                                <p>중학생을 위한 최적의 서적</p>
                            </div>
                        </a>
                    </div>
          </div>
            <div class="col-md-6">
                <div class="category-box">
                    <a href="${rootPath }/BookList.do?category=C">
                        <img src="${rootPath }/images/main/highbook.jpg" alt="" />
                        <div class="content">
                            <h3>고등 서적</h3>
                            <p>고등학생을 위한 최적의 서적</p>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>


<section class="products section bg-gray">
    <div class="container">
        <div class="row">
            <div class="title text-center">
                <h2>Trendy Products</h2>
            </div>
        </div>
        <div class="row">
            <c:forEach var="pro" items="${proList }" varStatus="status">
                <a href="${rootPath }/BookGet.do?proNo=${pro.proNo }" class="list_search">
                    <div class="col-md-3">
                        <div class="product-item">
                            <div class="product-thumb">
                                <img class="img-responsive" src="${pro.img }" alt="${pro.title }" />
                            </div>
                            <div class="product-content">
                                <h4>${pro.title }</h4>
                                <p class="price">${pro.price } 원</p>
                            </div>
                        </div>
                    </div>
                </a>
            </c:forEach>
            <c:if test="${empty proList }">
                <p class="text-center">등록된 상품이 없습니다.</p>
            </c:if>
        </div>
    </div>
</section>

<%@ include file="/footer.jsp" %>
<%@ include file="/commonsub.jsp"%>
</body>
</html>