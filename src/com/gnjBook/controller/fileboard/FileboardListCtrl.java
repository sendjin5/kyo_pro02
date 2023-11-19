package com.gnjBook.controller.fileboard;

import com.gnjBook.dto.Fileboard;
import com.gnjBook.model.FileboardDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/FileboardList.do")
public class FileboardListCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("msg", "학습자료실 목록을 출력합니다.");

        FileboardDAO dao = new FileboardDAO();
        List<Fileboard> fileboardList = dao.getFileboardList();
        request.setAttribute("fileboardList", fileboardList);

        RequestDispatcher view = request.getRequestDispatcher("/file/fileboardList.jsp");
        view.forward(request, response);
    }
}
