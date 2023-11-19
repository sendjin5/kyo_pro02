package com.gnjBook.controller.admin;

import com.gnjBook.dto.Product;
import com.gnjBook.model.ProductDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/Instock.do")
public class InstockAddCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("session_id");

        int proNo = Integer.parseInt(request.getParameter("no"));

        ProductDAO dao = new ProductDAO();
        Product product = dao.getProduct(proNo);

        if(sid != null && sid.equals("admin")) {
            request.setAttribute("proNo", proNo);
            request.setAttribute("product", product);

            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/instockAdd.jsp");
            view.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }

    }
}
