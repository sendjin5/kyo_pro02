package com.gnjBook.controller.qna;

import com.gnjBook.dto.Qna;
import com.gnjBook.model.QnaDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/QnaUpdatePro.do")
public class QnaUpdateProCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // addNotice.jsp의 form에서 post method로 보내므로, doPost로 받아야 함
        request.setAttribute("msg", "묻고답하기 글을 수정합니다.");
        String path = request.getContextPath();

        int qno = Integer.parseInt(request.getParameter("no"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        Qna new_qna = new Qna();
        new_qna.setQno(qno);
        new_qna.setTitle(title);
        new_qna.setContent(content);

        QnaDAO dao = new QnaDAO();
        int cnt = dao.updateQna(new_qna);

        if(cnt>0){
            System.out.println("성공적으로 수정되었습니다.");
            response.sendRedirect(path+"/QnaList.do");
        } else{
            System.out.println("오류로 인해 제대로 처리되지 않았습니다.");
            PrintWriter out = response.getWriter();
            out.println("<script>history.go(-1);</script>");
        }
    }
}