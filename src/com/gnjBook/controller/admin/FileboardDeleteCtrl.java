package com.gnjBook.controller.admin;

import com.gnjBook.model.FileboardDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FileboardDelete.do")
public class FileboardDeleteCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("session_id");

        if(sid != null && sid.equals("admin")) {
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }
        request.setAttribute("msg", "학습자료를 삭제합니다.");
        int no = Integer.parseInt(request.getParameter("no"));

        FileboardDAO dao = new FileboardDAO();
        int cnt = dao.deleteFileboard(no);
        if(cnt>0){
            System.out.println("성공적으로 제거되었습니다.");
            String path = request.getContextPath();
            response.sendRedirect(path+"/FileboardListAdmin.do");
        } else{
            System.out.println("오류로 인해 제대로 처리되지 않았습니다.");
            PrintWriter out = response.getWriter();
            out.println("<script>history.go(-1);</script>");
        }
    }
}