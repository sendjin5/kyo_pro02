package com.gnjBook.controller.admin;

import com.gnjBook.dto.Notice;
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

@WebServlet("/NoticeListAdmin.do")
public class NoticeListAdminCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("msg", "공지사항 목록을 출력합니다.");

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("session_id");

        if(sid != null && sid.equals("admin")) {

            NoticeDAO dao = new NoticeDAO();
            List<Notice> noticeList = dao.getNoticeList();
            request.setAttribute("noticeList", noticeList);

            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/noticeList.jsp");
            view.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }
    }
}
