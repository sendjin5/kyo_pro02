<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>배송 관리</title>
    <%@ include file="../../common.jsp"%>
</head>

<body>
<%@ include file="../../header.jsp"%>
<div style="display: flex; min-height: 80vh;">
    <%@include file="adminBoardList.jsp"%>
    <div class="container" style="margin-top: 20px;">
        <h2 class="title">배송 관리</h2>
        <div class="container">
            <form action="${rootPath}/DeliveryUpdateAdmin.do" method="post" class="form_row">
                <div class="row">
                    <input type="hidden" name="dno" value="${delivery.dno}">
                    <div class="col-4">배송번호: ${delivery.dno}</div>
                    <div class="col-4">결제번호: ${delivery.payNo}</div>
                    <div class="col-4">회원아이디: ${delivery.memId}</div>
                </div>
                <div class="row">
                    <div class="col-2"><label class="form-label" for="dcom">배달회사</label></div>
                    <div class="col-4"><input class="form-control" type="text" name="dcom" id="dcom" value="${delivery.dcom}"></div>
                    <div class="col-2"><label class="form-label" for="dtel">배달회사 전화</label></div>
                    <div class="col-4"><input class="form-control" type="tel" name="dtel" id="dtel"  value="${delivery.dtel}"></div>
                </div>
                <div class="row">
                    <div class="col-2"><label class="form-label" for="etd">배송출발일</label></div>
                    <div class="col-4"><input class="form-control" type="date" name="etd" id="etd"  value="${delivery.etd}"></div>
                    <div class="col-2"><label class="form-label" for="eta">배송도착일</label></div>
                    <div class="col-4"><input class="form-control" type="date" name="eta" id="eta" value="${delivery.eta}"></div>
                </div>
                <div class="row">
                    <div class="col-2"><label class="form-label" for="dcode">운송번호</label></div>
                    <div class="col-4"><input class="form-control" type="text" name="dcode" id="dcode"  value="${delivery.dcode}"></div>
                    <div class="col-2">배송 상태</div>
                    <input class="form-control" type="hidden" id="nowstate" value="${delivery.state}">
                    <div class="col-1"><input class="form-check-input" type="radio" name="state" id="state0" value="0"><label class="form-label" for="state0">배송전</label></div>
                    <div class="col-1"><input class="form-check-input" type="radio" name="state" id="state1" value="1"><label class="form-label" for="state1">배송중</label></div>
                    <div class="col-1"><input class="form-check-input" type="radio" name="state" id="state2" value="2"><label class="form-label" for="state2">배송 도착</label></div>
                    <div class="col-1"><input class="form-check-input" type="radio" name="state" id="state3" value="3"><label class="form-label" for="state3">구매 확정</label></div>
                </div>
                <input type="submit" class="btn btn-primary mb-3" value="수정하기">
            </form>
        </div>
    </div>
</div>
<%@ include file="../../footer.jsp" %>
</body>
</html>

<script>
    function deleteTrue(){
        let isdelete = confirm("정말 삭제하시겠습니까?");
        if(isdelete){
            return true;
        } else{
            return false;
        }
    }

    function delUpdate(dno){
        $("form").attr("action", "${rootPath}/DeliveryUpdateAdmin.do?dno="+dno);
    }
</script>

<script>
    $(document).ready(function(){
        var state = $("#nowstate").val();
        if(state==="0"){
            $("#state0").attr("checked", "true");
        } else if(state==="1"){
            $("#state1").attr("checked", "true");
        } else if(state==="2"){
            $("#state2").attr("checked", "true");
        } else if(state==="3"){
            $("#state3").attr("checked", "true");
        }
    })
</script>