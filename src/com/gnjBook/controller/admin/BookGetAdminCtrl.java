package com.gnjBook.controller.admin;

import com.gnjBook.dto.Category;
import com.gnjBook.dto.Product;
import com.gnjBook.model.CategoryDAO;
import com.gnjBook.model.ProductDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@WebServlet("/BookGetAdmin.do")
public class BookGetAdminCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = request.getServletContext();
        request.setAttribute("msg", "교재 상세페이지를 출력합니다.");
        int id = Integer.parseInt(request.getParameter("id"));

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("session_id");

        if(sid != null && sid.equals("admin")) {
            ProductDAO dao = new ProductDAO();
            Product product = dao.getProduct(id);

            File isfile = new File( application.getRealPath("/storage/") + product.getImg());
            if(!isfile.exists()) {
                product.setImg(request.getContextPath() + "/images/noimage.jpg");
            } else {
                product.setImg(request.getContextPath() + "/storage/" + product.getImg());
            }

            File isVideo = new File( application.getRealPath("/storage/") + product.getVideo());
            if(!isVideo.exists()) {
                product.setVideo("");
            } else {
                product.setVideo(request.getContextPath() + "/storage/" + product.getVideo());
            }

            int amount = dao.getAmount(id);

            CategoryDAO cdao = new CategoryDAO();
            Category category = cdao.getCategory(product.getCategoryId());

            request.setAttribute("product", product);
            request.setAttribute("category", category);
            request.setAttribute("amount", amount);

            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/admin/bookGet.jsp");
            view.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }
    }
}