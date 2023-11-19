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

@WebServlet("/FileboardGetAdmin.do")
public class FileboardGetAdminCtrl extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("msg", "학습자료실 상세페이지를 출력합니다.");
    int no = Integer.parseInt(request.getParameter("no"));

    HttpSession session = request.getSession();
    String sid = (String) session.getAttribute("session_id");

    if(sid != null && sid.equals("admin")) {
      FileboardDAO dao = new FileboardDAO();
      Fileboard fileboard = dao.getFileboard(no);
      request.setAttribute("fileboard", fileboard);

      RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/fileboardGet.jsp");
      view.forward(request, response);
    } else {
      response.sendRedirect(request.getContextPath()+"/");
    }
  }
}