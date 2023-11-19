package com.gnjBook.controller.fileboard;

import com.gnjBook.dto.Fileboard;
import com.gnjBook.dto.Notice;
import com.gnjBook.model.FileboardDAO;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/Fileboard.do")
public class FileboardCtrl extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("msg", "자료실 상세페이지를 출력합니다.");
    int no = Integer.parseInt(request.getParameter("no"));

    FileboardDAO dao = new FileboardDAO();
    int cnt = dao.countUp(no);
    Fileboard fileboard = dao.getFileboard(no);
    request.setAttribute("fileboard", fileboard);

    RequestDispatcher view = request.getRequestDispatcher("/file/getFileboard.jsp");
    view.forward(request, response);
  }
}