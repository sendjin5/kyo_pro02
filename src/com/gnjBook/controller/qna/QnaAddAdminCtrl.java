package com.gnjBook.controller.qna;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/QnaAddAdmin.do")
public class QnaAddAdminCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("msg", "답변글을 추가합니다.");

        //게시글 읽기에서 답변글쓰기를 클릭하면 넘겨주는 데이터들을 받아줌
        //int num = Integer.parseInt(request.getParameter("num"));
        int lev = Integer.parseInt(request.getParameter("lev"));
        int par = Integer.parseInt(request.getParameter("par"));

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("session_id");

        if(sid != null && sid.equals("admin")) {

            request.setAttribute("lev", lev);
            request.setAttribute("par", par);

            RequestDispatcher view = request.getRequestDispatcher("/qna/addAdminQna.jsp");
            view.forward(request, response);

        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }
    }
}