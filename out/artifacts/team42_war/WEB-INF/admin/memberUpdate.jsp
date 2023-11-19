<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <%@ include file="../../common.jsp" %>
    <style>

    </style>
</head>
<body>
<%@ include file="../../header.jsp" %>
<div style="display: flex; min-height: 80vh;">
    <%@include file="adminBoardList.jsp"%>
    <div class="container contents text-center">

        <h2 class="page_title text-center">내 정보</h2>
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb justify-content-end">
                <li class="breadcrumb-item"><a href="${rootPath }">Home</a></li>
                <li class="breadcrumb-item active" aria-current="page">Mypage</li>
            </ol>
        </nav>
        <c:set var="member" value="${member}"/>

        <form class="form_row" action="${rootPath}/MemberUpdateProAdmin.do" method="post" onsubmit="return inform(this)">
            <div class="row">
                <div class="col-2"><label for="name" class="form-label">이름</label></div>
                <div class="col-8"><input type="text" class="form-control col-10" id="name" name="name" value="${member.name}"></div>
            </div>
            <div class="row">
                <div class="col-2"><label for="id" class="form-label">아이디</label></div>
                <div class="col-8 text-start">${member.id}<input type="hidden" id="id" name="id" value="${member.id}"></div>
            </div>
            <div class="row">
                <div class="col-2"><label for="old_pw" class="form-label">기존 비밀번호</label></div>
                <div class="col-8 text-start">${member.pw}<input type="hidden" id="old_pw" name="old_pw" value="${member.pw}"></div>
            </div>
            <div class="row">
                <div class="col-2"><label for="pw" class="form-label">새 비밀번호</label></div>
                <div class="col-3"><input type="password" class="form-control" id="pw" name="pw" placeholder="비밀번호"></div>
                <div class="col-3"><input type="password" class="form-control" id="pwchk" name="pwchk" placeholder="비밀번호 확인"></div>
                <div class="col-4"><div id="pwStatus" class="form-text text-start">비밀번호와 비밀번호 확인이 일치하지 않습니다.</div></div>
                <input type="hidden" id="pwck" value="no">
            </div>
            <div class="row">
                <div class="col-2"><label for="email" class="form-label">이메일</label></div>
                <div class="col-8"><input type="email" class="form-control" id="email" name="email" value="${member.email}"></div>
            </div>
            <div class="row">
                <div class="col-2"><label for="tel" class="form-label">전화번호</label></div>
                <div class="col-8"><input type="tel" class="form-control" id="tel" name="tel" value="${member.tel}"></div>
            </div>
            <div class="row">
                <div class="col-2"><label for="birth">생년월일</label></div>
                <div class="col-4"><input type="date" class="form-control" id="birth" name="birth" value="1999-01-01" value="${member.birth}"></div>
            </div>
            <div class="row">
                <div class="col-2"><label for="address1" class="form-label">주소</label></div>
                <div class="col-4"><input type="text" class="form-control" id="address1" name="address" value="${member.address}"></div>
                <div class="col-4"><input type="text" class="form-control" id="postcode" name="postcode" placeholder="우편번호" value="${member.postcode}"></div>
                <div class="col-2"><button type="button" class="btn btn-primary mb-3" onclick="findAddr()">우편번호 검색</button></div>
            </div>
            <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
            <input type="submit" class="btn btn-primary mb-3" value="수정하기">
            </form>
    </div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>


<script>
    $(document).ready(function(){
        $("#pwchk").keyup(function(){
            if($("#pw").val()===""||$("#pwchk").val()===""){
                console.log($("#pwchk").val())
                $("#pwStatus").html("<strong style='color: red'>비밀번호를 입력하세요.</strong>");
                $("#pwck").val("no");
            }
            else if($("#pw").val()==$("#pwchk").val()){
                $("#pwStatus").html("<strong style='color: green'>비밀번호가 일치합니다.</strong>");
                $("#pwck").val("yes");
            } else{
                $("#pwStatus").text("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
                $("#pwck").val("no");
            }
        })
    })

    function inform(frm){
        if($("#pw").val()!=="" && $("#pwck").val()!="yes"){
            alert("비밀번호를 다시 확인해주십시오.");
            $("#pw").focus();
            return false;
        }
    }

    function findAddr(){
        new daum.Postcode({
            oncomplete:function(data){
                console.log(data);
                var roadAddr = data.roadAddress;
                var jibunAddr = data.jibunAddress;
                document.getElementById("postcode").value = data.zonecode;
                if(roadAddr !== ''){
                    document.getElementById("address1").value = roadAddr;
                } else if(jibunAddr !== ''){
                    document.getElementById("address1").value = jibunAddr;
                }
                document.getElementById("address2").focus();
            }
        }).open();
    }
</script>