package com.gnjBook.controller.review;

import com.gnjBook.dto.Product;
import com.gnjBook.model.ProductDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/ReviewAdd.do")
public class ReviewAddCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("session_id");
        int proNo = Integer.parseInt(request.getParameter("proNo"));

        if(sid != null) {

            ProductDAO dao = new ProductDAO();
            Product product = dao.getProduct(proNo);

            request.setAttribute("sid", sid);
            request.setAttribute("proNo", proNo);
            request.setAttribute("product", product);

            RequestDispatcher view = request.getRequestDispatcher("/review/reviewAdd.jsp");
            view.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }

    }
}
