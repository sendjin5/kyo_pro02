package com.gnjBook.controller.qna;

import com.gnjBook.model.QnaDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/QnaDelete.do")
public class QnaDeleteCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("msg", "공지사항을 삭제합니다.");
        int qno = Integer.parseInt(request.getParameter("no"));

        QnaDAO dao = new QnaDAO();
        int cnt = dao.deleteQna(qno);
        if(cnt>0){
            System.out.println("성공적으로 제거되었습니다.");
            String path = request.getContextPath();
            response.sendRedirect("QnaList.do");
        } else{
            System.out.println("오류로 인해 제대로 처리되지 않았습니다.");
            PrintWriter out = response.getWriter();
            out.println("<script>history.go(-1);</script>");
        }
    }
}