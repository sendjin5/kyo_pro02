package com.gnjBook.controller.admin;

import com.gnjBook.dto.Category;
import com.gnjBook.dto.Product;
import com.gnjBook.model.CategoryDAO;
import com.gnjBook.model.ProductDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/BookUpdate.do")
public class BookUpdateCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = "관리자의 상품을 수정합니다.";

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("session_id");

        int pno = Integer.parseInt(request.getParameter("no"));

        if(sid != null && sid.equals("admin")) {
            ProductDAO dao = new ProductDAO();
            Product pro = dao.getProduct(pno);

            CategoryDAO cao = new CategoryDAO();
            List<Category> categoryList = cao.getCategoryList();

            request.setAttribute("categoryList", categoryList);
            request.setAttribute("msg", msg);
            request.setAttribute("pro", pro);

            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/bookUpdate.jsp");
            view.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }
    }
}