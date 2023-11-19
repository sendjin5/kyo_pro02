package com.gnjBook.controller.admin;

import com.gnjBook.dto.Fileboard;
import com.gnjBook.dto.Notice;
import com.gnjBook.model.FileboardDAO;
import com.gnjBook.model.NoticeDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/FileboardListAdmin.do")
public class FileboardListAdminCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("session_id");

        if(sid != null && sid.equals("admin")) {
            FileboardDAO dao = new FileboardDAO();
            List<Fileboard> fileboardList = dao.getFileboardList();
            request.setAttribute("fileboardList", fileboardList);

            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/fileboardList.jsp");
            view.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }
        request.setAttribute("msg", "학습자료실 목록을 출력합니다.");
    }
}
