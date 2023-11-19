package com.gnjBook.controller;

import com.gnjBook.dto.Product;
import com.gnjBook.model.ProductDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = request.getServletContext();
        application.setAttribute("rootPath", request.getContextPath());

        ProductDAO dao = new ProductDAO();
        List<Product> proList = dao.getProductListmain();

        for(Product pro : proList) {
            File isfile = new File( application.getRealPath("/storage/") + pro.getImg());
            if(!isfile.exists()) {
                pro.setImg(request.getContextPath() + "/images/noimage.jpg");
            } else {
                pro.setImg(request.getContextPath() + "/storage/" + pro.getImg());
            }
        }

        request.setAttribute("proList", proList);

        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
        view.forward(request, response);
    }
}
