package com.gnjBook.controller.member;

import com.gnjBook.model.MemberDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginPro.do")
public class LoginCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        MemberDAO dao = new MemberDAO();
        boolean bool = dao.loginMember(id, pw);

        if(bool){
            System.out.println("정상적으로 로그인되었습니다.");
            HttpSession session = request.getSession(); // 세션 생성
            session.setAttribute("session_id", id);
            String path = request.getContextPath();

            response.sendRedirect(path+"/");
        } else{
            System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");

            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out = response.getWriter();

            out.println("<script>alert('아이디 또는 비밀번호가 일치하지 않습니다.');history.go(-1);</script>");
        }
    }
}
