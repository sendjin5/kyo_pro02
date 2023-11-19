<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>회원약관</title>
    <%@ include file="../common.jsp" %>
    <style>
        .text-area {height:300px;overflow-y:auto;}
    </style>
</head>
<body id="body">
<section class="signin-page account">
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <div class="block text-center">
                    <a class="logo" href="${rootPath}/">My Roo Book소개</a>
                    <h2 class="text-center">회원약관</h2>
                    <div>
                        <div class="form-group text-area mt-20">
                            <%@include file="term_util.jsp"%>
                        </div>
                        <div class="form-group">
                            <input type="checkbox" id="ck_item1" name="ck_item"> <label for="ck_item1">이용약관 동의</label><br>
                        </div>
                        <div class="form-group text-area mt-20">
                            <%@include file="term_person.jsp"%>
                        </div>
                        <div class="form-group">
                            <input type="checkbox" id="ck_item2" name="ck_item"> <label for="ck_item2">개인정보 수집 및 이용약관 동의</label>
                        </div>
                        <div class="text-center">
                            <button type="button" id="in_btn1" class="btn btn-main text-center">다음 단계</button>
                        </div>
                    </div>
                    <p class="mt-20">계정이 있으신가요?<a href="${rootPath }/member/login.jsp"> 로그인</a></p>
                </div>
                <script>
                    var in_btn1 = document.getElementById("in_btn1");
                    var ck_item1 = document.getElementById("ck_item1");
                    var ck_item2 = document.getElementById("ck_item2");
                    in_btn1.addEventListener("click", function(){
                        if(ck_item1.checked && ck_item2.checked) {
                            location.href = "${rootPath}/Join.do";
                        } else {
                            alert("약관에 동의하지 않으셨습니다.");
                        }
                    });
                </script>
            </div>
        </div>
    </div>
</section>

<%@ include file="/commonsub.jsp"%>
</body>
</html>