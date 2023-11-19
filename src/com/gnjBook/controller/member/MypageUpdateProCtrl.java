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

@WebServlet("/MypageUpdatePro.do")
public class MypageUpdateProCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MemberDAO dao = new MemberDAO();
        Member member = new Member();
        member.setName(request.getParameter("name"));
        member.setId(request.getParameter("id"));
        member.setPw(request.getParameter("pw"));
        String newpw = request.getParameter("newpw");
        if(newpw.length()>0){
            member.setPw(newpw);
        }
        member.setEmail(request.getParameter("email"));
        member.setTel(request.getParameter("tel"));
        member.setAddress(request.getParameter("address1")+"/"+request.getParameter("address2"));
        member.setBirth(request.getParameter("birth"));
        member.setPostcode(request.getParameter("postcode"));

        int cnt = dao.memberUpdate(member);
        if(cnt>0){
            System.out.println("회원정보가 정상적으로 수정되었습니다.");
        }

        String path = request.getContextPath();
        RequestDispatcher view = request.getRequestDispatcher(path+"/Mypage.do");
        view.forward(request, response);
    }
}