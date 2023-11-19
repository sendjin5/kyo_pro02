package com.gnjBook.controller.qna;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/QnaAdd.do")
public class QnaAddCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("msg", "질문글을 추가합니다.");
        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("session_id");
        request.setAttribute("sid", sid);

        if(sid != null) {
            RequestDispatcher view = request.getRequestDispatcher("/qna/addQna.jsp");
            view.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }

    }


}