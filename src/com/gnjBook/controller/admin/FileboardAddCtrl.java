package com.gnjBook.controller.admin;

import com.gnjBook.dto.Fileboard;
import com.gnjBook.model.FileboardDAO;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/FileboardAdd.do")
public class FileboardAddCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = "학습자료를 업로드 합니다.";
        FileboardDAO dao = new FileboardDAO();
        List<Fileboard> fileboardList = dao.getFileboardList();

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("session_id");

        if(sid != null && sid.equals("admin")) {
            request.setAttribute("fileboardList", fileboardList);
            request.setAttribute("msg", msg);
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/fileboardAdd.jsp");
            view.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }
    }
}
