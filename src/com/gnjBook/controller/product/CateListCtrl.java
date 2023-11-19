package com.gnjBook.controller.product;

import com.gnjBook.dto.Product;
import com.gnjBook.model.ProductDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CateList.do")
public class CateListCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("msg", "교재 목록을 출력합니다.");
        String category = "";

        ProductDAO dao = new ProductDAO();
        List<Product> bookList = new ArrayList<>();
        if(request.getParameter("category")==""){
            bookList = dao.getProductList();
        } else{
            category = request.getParameter("category");
            bookList = dao.getCategoryProduct(category);
        }


        request.setAttribute("bookList", bookList);

        RequestDispatcher view = request.getRequestDispatcher("/product/bookList.jsp");
        view.forward(request, response);
    }
}
