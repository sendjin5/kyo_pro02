package com.gnjBook.controller.member;

import com.gnjBook.dto.Member;
import com.gnjBook.model.MemberDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/Mypage.do")
public class MypageCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("msg", "나의 정보로 이동합니다.");

        HttpSession session = request.getSession(); // 세션 생성
        MemberDAO dao = new MemberDAO();
        Member member = dao.getMember((String) session.getAttribute("session_id"));

        request.setAttribute("me", member);

        String[] address = member.getAddress().split("/");
        String address1 = address[0];
        String address2 = "";
        if(address.length>1){
            address2 = address[1];
        }

        request.setAttribute("address1", address1);
        request.setAttribute("address2", address2);

        RequestDispatcher view = request.getRequestDispatcher("/member/mypage.jsp");
        view.forward(request, response);
    }
}