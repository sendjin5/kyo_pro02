package com.gnjBook.controller.admin;

import com.gnjBook.dto.Product;
import com.gnjBook.model.ProductDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CateListAdmin.do")
public class CateListAdminCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("msg", "교재 목록을 출력합니다.");
        String category = "";

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("session_id");

        if(sid != null && sid.equals("admin")) {ProductDAO dao = new ProductDAO();
            List<Product> bookList = new ArrayList<>();
            if(request.getParameter("category")==""){
                bookList = dao.getProductList();
            } else{
                category = request.getParameter("category");
                bookList = dao.getCategoryProduct(category);
            }

            request.setAttribute("bookList", bookList);

            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/bookList.jsp");
            view.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }
    }
}
