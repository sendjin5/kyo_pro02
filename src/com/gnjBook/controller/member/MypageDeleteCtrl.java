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

@WebServlet("/MypageDelete.do")
public class MypageDeleteCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("msg", "나의 정보로 이동합니다.");

        HttpSession session = request.getSession(); // 세션 생성
        String id = (String) session.getAttribute("session_id");
        MemberDAO dao = new MemberDAO();
        int cnt = dao.resignMember(id);
        if(cnt>0){
            System.out.println("정상적으로 탈퇴되었습니다.");
        }

        session.removeAttribute("session_id");
        String path = request.getContextPath();
        response.sendRedirect(path+"/index.jsp");
    }
}