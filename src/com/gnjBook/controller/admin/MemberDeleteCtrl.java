package com.gnjBook.controller.admin;

import com.gnjBook.model.MemberDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MemberDelete.do")
public class MemberDeleteCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("msg", "회원을 삭제합니다.");

        String[] isdelete = request.getParameterValues("isDelete");

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("session_id");

        if(sid != null && sid.equals("admin")) {
            MemberDAO dao = new MemberDAO();

            for(String s: isdelete){
                System.out.println(s);
                int cnt = dao.deleteMember(s);
                if(cnt>0){
                    System.out.println("회원 "+s+"가 제거되었습니다.");
                } else{
                    System.out.println("회원 "+s+"가 제거되지 않았습니다.");
                    PrintWriter out = response.getWriter();
                    out.println("<script>history.go(-1);</script>");
                }
            }

            System.out.println("성공적으로 제거되었습니다.");
            response.sendRedirect("MemberListAdmin.do");
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }
    }
}