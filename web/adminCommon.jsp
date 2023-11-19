<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="rootPath" value="<%=request.getContextPath() %>" />

<!-- 메타포, 오픈그래프, 파비콘, 폰트 등 각 종 자원 로딩 -->

<script src="${rootPath}/js/jquery-1.10.0.js"></script>
<script src="${rootPath}/js/nav.js"></script>


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

<style>
    @font-face {
        font-family: 'Pretendard-Regular';
        src: url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff') format('woff');
        font-weight: 600;
        font-style: normal;
    }
</style>

<style>
    html{scrollbar-width:none;}
    html * {font-family: 'Pretendard-Regular', "monospace", "sans-serif";}
    body::-webkit-scrollbar, html::-webkit-scrollbar { display:none; }
    /*스크롤 숨기기*/

    .contents {min-height: 90vh;}
    /* 한 페이지의 주요 내용을 차지하는 바닥은 적어도 80은 차지해야 header와 footer 사이의 간격을 확보할 수 있다.  */

    .page_title {margin-top: 20px; display: inline-block;}
    /* 일반 페이지는 타이틀로 시작. 따라서 타이틀을 헤더에서 조금 떨어트림 */

    a {color: #435334; text-decoration: none;}
    a:hover {text-decoration: 1px underline #435334;}
    /* 브래드크럼 스타일 지정 */

    nav[aria-label="breadcrumb"] {border-bottom:2px solid #435334;}
    /* 타이틀, 브래드크럼 영역과 콘텐츠 영역 분리 선 */

    a:hover {font-weight: bold;}
    /* 이동가능한 링크는 두껍게 표시 */

    .form_row .row {margin: 20px auto;}

    .card img{max-height: 300px;}


    #tb1 { width:960px; margin:40px auto; }
    #tb1 th { background-color: #111; color:#fff; }
    .item1 { width:10%; }
    .item2 { width:60%; }
    .item3 { width:20%; }
    .item4 { width:10%; }
    #page-nation1 { width: 960px; margin:20px auto; }
    .list li { margin-top: 24px; }

    .dropdown-toggle::after { transition: transform 0.15s linear;}
    .show.dropdown .dropdown-toggle::after {transform: translateY(3px);}
    .dropdown-menu {margin-top: 0;}

    .frm { clear:both; width:1200px; margin:0 auto; padding-top: 80px; }

    .tb1 { width:500px; margin:50px auto; }
    .tb1 th { width:180px; line-height:32px; padding-top:8px; padding-bottom:8px;
        border-top:1px solid #333; border-bottom:1px solid #333;
        background-color:deepskyblue; color:#fff; }
    .tb1 td { width:310px; line-height:32px; padding-top:8px; padding-bottom:8px;
        border-bottom:1px solid #333;
        padding-left: 14px; border-top:1px solid #333; }

    .indata { display:inline-block; width: 500px; height: 48px; line-height: 48px;
        text-indent:14px; font-size:18px; }
    .inbtn { display:block;  border-radius:100px;
        min-width:140px; padding-left: 24px; padding-right: 24px; text-align: center;
        line-height: 48px; background-color: #333; color:#fff; font-size: 18px; }
    .inbtn:first-child { float:left; }
    .inbtn:last-child { float:right; }

    .agree_fr { width: 900px; margin: 20px auto; border:1px solid #eee;
        padding: 20px; overflow-y: auto;
        height: 250px; white-space: pre-wrap; }
    .btn_fr{text-align:center;}

</style>

<style>
    .term input[type="checkbox"]{border: 0; clip: rect(0 0 0 0); height: 1px; margin: -1px; overflow: hidden; padding: 0; position: absolute; width: 1px;}
    .term input[type="checkbox"] + label{display:inline-block; position:relative; vertical-align:middle; padding-left:40px; line-height:28px; font-size:18px;}
    .term input[type="checkbox"] + label:after{content:""; display:block; position:absolute; top:0; left:0; width:31px; height:31px; background:url(../image/join/chk_ico.png) 0 0 no-repeat;}
    .term input[type="checkbox"]:checked + label:after{background-position:0 -31px;}

    .term {width:800px;margin:0 auto}
    .term ul li{display:flex; align-items:center; justify-content:space-between; padding:14px 0;}
    .term ul li p .essential{color:#ed3535;}
    .term ul li a{position:relative; font-size:14px; color:#97999b;}
    .term ul li a:before{content:""; display:inline-block; position:absolute; bottom:-1px; left:0; width:100%; border-bottom:1px solid #97999b;}

    .inBtn.center{display:block;margin:10px auto 0;width:80%;background-color:var(--third-color);}
</style>
