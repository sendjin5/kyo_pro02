package com.gnjBook.controller.qna;


import com.gnjBook.dto.Notice;
import com.gnjBook.dto.Qna;
import com.gnjBook.model.NoticeDAO;
import com.gnjBook.model.QnaDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/QnaGet.do")
public class QnaGetCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("msg", "묻고답하기 상세페이지를 출력합니다.");
        int qno = Integer.parseInt(request.getParameter("qno"));

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("session_id");
        request.setAttribute("sid", sid);

        QnaDAO dao = new QnaDAO();
        int cnt = dao.countUp(qno);
        Qna qna = dao.getQna(qno);
        request.setAttribute("qna", qna);

        RequestDispatcher view = request.getRequestDispatcher("/qna/getQna.jsp");
        view.forward(request, response);
    }
}