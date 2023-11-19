package com.gnjBook.controller.member;

import com.gnjBook.dto.Member;
import com.gnjBook.model.MemberDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/JoinPro.do")
public class JoinProCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Member new_member = new Member();

        new_member.setName(request.getParameter("name"));
        new_member.setId(request.getParameter("id"));
        new_member.setPw(request.getParameter("pw"));
        new_member.setEmail(request.getParameter("email"));
        new_member.setTel(request.getParameter("tel"));
        new_member.setBirth(request.getParameter("birth"));
        new_member.setPostcode(request.getParameter("postcode"));
        new_member.setAddress(request.getParameter("address1")+"/"+request.getParameter("address2"));

        MemberDAO dao = new MemberDAO();
        int cnt = dao.addMember(new_member);

        if(cnt>0){
            String path = request.getContextPath();
            System.out.println("정상적으로 회원가입 되었습니다.");
            response.sendRedirect(path+"/member/login.jsp");
        } else{
            System.out.println("오류로 인해 처리되지 못했습니다.");
            PrintWriter out = response.getWriter();
            out.println("<script>history.go(-1);</script>");
        }
    }
}