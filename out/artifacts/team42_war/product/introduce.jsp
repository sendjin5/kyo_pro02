<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <title>소개</title>
    <%@ include file="/common.jsp"%>
    <style>
        .intro p {text-indent: 2em; line-height: 2em; display:inline-block; word-break: keep-all;}
        .intro_tit {margin-top: 20px; display:inline-block;}
        .intro li {line-height: 2em;}
    </style>
</head>

<body id="body">
<%@ include file="/header.jsp"%>
<section class="page-header" style="margin-top:0!important;">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="content">
                    <h1 class="page-name">My Roo Book 소개</h1>
                    <ol class="breadcrumb">
                        <li><a href="${rootPath }/">Home</a></li>
                        <li class="active">소개</li>
                    </ol>
                </div>
            </div>
        </div>
    </div>
</section>
<div class="container contents text-center">
    <div class="intro text-start" style="margin-top: 20px;">
        <h3 class="intro_tit">함께, 똑같이 나아가는 교육, My Roo Book</h3>
        <div class="row" style="align-items: center;margin-bottom:20px;">
            <div class="col-7"><p>My Roo Book은 교육의 혁신과 미래를 모색하는 교육 브랜드로서, 학습자들이 풍부한 지식과 창의력을 발전시키며 더 나은 미래를 준비할 수 있도록 돕고 있습니다. 우리는 교육 분야에서 지속적인 혁신과 도전을 통해 학습 경험을 혁신하고, 학생 한 명 한 명의 잠재력을 최대한으로 끌어내는 데 최선을 다하고 있습니다.</p></div>
        </div>
        <h4 class="intro_tit">My Roo Book의 가치</h4>
        <ol>
            <li>우리는 교육이 개인과 사회의 변화를 이끌고, 더 나은 미래를 창출하는 역할을 잘 이해하고 있습니다. 따라서 우리의 비전은 지식을 선도하는 길을 열며, 교육의 미래를 함께 만들어나가는 것입니다.</li>
            <li>품질과 혁신: 우리는 교육의 품질을 향상시키기 위해 지속적인 혁신에 주력합니다. 최신 연구 결과와 교육 방법론을 바탕으로 학습자들이 보다 효과적으로 지식을 습득하고 응용할 수 있도록 혁신적인 교과서를 개발합니다.</li>
            <li>개인 맞춤 교육: 각 학습자의 독특한 능력과 요구에 맞추어 교육 리소스를 제공하는 것을 중요한 가치로 여깁니다. 다양한 학습 경로와 자원을 통해 학생들이 자신만의 학습 방식을 찾고 개발할 수 있도록 돕습니다.</li>
            <li>사회적 책임: 우리는 교육이 사회 전반에 긍정적인 영향을 미칠 수 있다는 사실을 알고 있습니다. 따라서 우리의 교육 자원은 사회적 공정성과 평등을 존중하며, 다양성을 존중하고 인권을 증진하는 데 기여하고자 합니다.</li>
        </ol>
    </div>
    <%--  인트로 END  --%>

</div>

<%@ include file="/footer.jsp" %>
</body>
</html>
