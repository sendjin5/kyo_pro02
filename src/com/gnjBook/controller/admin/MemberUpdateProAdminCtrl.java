package com.gnjBook.controller.admin;

import com.gnjBook.dto.Member;
import com.gnjBook.model.MemberDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MemberUpdateProAdmin.do")
public class MemberUpdateProAdminCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("session_id");

        if(sid != null && sid.equals("admin")) {
            Member new_member = new Member();
            new_member.setName(request.getParameter("name"));
            new_member.setId(request.getParameter("id"));
            if(request.getParameter("pw").equals("")){
                new_member.setPw(request.getParameter("old_pw"));
                System.out.println(request.getParameter("old_pw"));
            } else{
                new_member.setPw(request.getParameter("pw"));
            }
            new_member.setEmail(request.getParameter("email"));
            new_member.setTel(request.getParameter("tel"));
            new_member.setBirth(request.getParameter("birth"));
            new_member.setPostcode(request.getParameter("postcode"));
            new_member.setAddress(request.getParameter("address1")+" "+request.getParameter("address2"));

            MemberDAO dao = new MemberDAO();
            int cnt = dao.memberUpdate(new_member);

            if(cnt>0){
                String path = request.getContextPath();
                System.out.println("정상적으로 회원정보가 수정되었습니다.");
                response.sendRedirect(path+"/MemberListAdmin.do");
            } else{
                System.out.println("오류로 인해 처리되지 못했습니다.");
                PrintWriter out = response.getWriter();
                out.println("<script>history.go(-1);</script>");
            }
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }
    }
}