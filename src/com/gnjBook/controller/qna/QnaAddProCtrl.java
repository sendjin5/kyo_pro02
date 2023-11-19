package com.gnjBook.controller.qna;

import com.gnjBook.dto.Qna;
import com.gnjBook.model.QnaDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/QnaAddPro.do")
public class QnaAddProCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("session_id");
        // addQna.jsp의 form에서 post method로 보내므로, doPost로 받아야 함
        request.setAttribute("msg", "묻고답하기 글을 추가합니다.");
        String path = request.getContextPath();

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String author = sid;
        int lev = Integer.parseInt(request.getParameter("lev"));
        int par = Integer.parseInt(request.getParameter("par"));
        boolean secret = Boolean.parseBoolean(request.getParameter("secret"));


        Qna new_qna = new Qna();
        new_qna.setTitle(title);
        new_qna.setContent(content);
        new_qna.setAuthor(author);
        new_qna.setLev(lev);
        new_qna.setPar(par);
        new_qna.setSecret(secret);

        QnaDAO dao = new QnaDAO();
        int cnt = dao.addQna(new_qna);

        if(cnt==2){
            System.out.println("질문 글이 등록되었습니다.");
            response.sendRedirect(path+"/QnaList.do");
        } else if(cnt==1){
            System.out.println("답변 글이 등록되었습니다.");
            response.sendRedirect(path+"/QnaList.do");
        } else{
            System.out.println("오류로 인해 제대로 처리되지 않았습니다.");
            PrintWriter out = response.getWriter();
            out.println("<script>history.go(-1);</script>");
        }
    }
}