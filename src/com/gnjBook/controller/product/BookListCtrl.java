package com.gnjBook.controller.product;

import com.gnjBook.dto.Product;
import com.gnjBook.model.ProductDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/BookList.do")
public class BookListCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = request.getServletContext();
        request.setAttribute("msg", "교재 목록을 출력합니다.");
        String category = request.getParameter("category");

        ProductDAO dao = new ProductDAO();
        List<Product> bookList = new ArrayList<>();

        if(category.equals("*")){
            bookList = dao.getProductList();
        } else{
            bookList = dao.getCategoryProduct(category);
        }

        for(Product book : bookList) {
            File isfile = new File( application.getRealPath("/storage/") + book.getImg());
            if(!isfile.exists()) {
                book.setImg(request.getContextPath() + "/images/noimage.jpg");
            } else {
                book.setImg(request.getContextPath() + "/storage/" + book.getImg());
            }
        }

        request.setAttribute("bookList", bookList);
        request.setAttribute("category", category);

        RequestDispatcher view = request.getRequestDispatcher("/product/bookList.jsp");
        view.forward(request, response);
    }
}
