package com.gnjBook.controller.admin;

import com.gnjBook.dto.Product;
import com.gnjBook.model.ProductDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/BookUpdatePro.do")
public class BookUpdateProCtrl extends HttpServlet {
      @Override
      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

          String msg = "";
          ServletContext application = request.getServletContext();
          String home = application.getContextPath();

          HttpSession session = request.getSession();
          String sid = (String) session.getAttribute("session_id");

          if(sid != null && sid.equals("admin")) {
              try {
                  String saveDirectory = application.getRealPath("/storage");
                  int maxSize = 1024*1024*10;
                  String encoding = "UTF-8";

                  MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxSize, encoding, new DefaultFileRenamePolicy());
                  Product uppro = new Product();
                  uppro.setCategoryId(mr.getParameter("category"));
                  uppro.setPrice(Integer.parseInt(mr.getParameter("price")));
                  uppro.setTitle(mr.getParameter("title"));
                  uppro.setAuthor(mr.getParameter("author"));
                  uppro.setContent(mr.getParameter("content"));
                  uppro.setProNo(Integer.parseInt(mr.getParameter("proNo")));


                    ProductDAO dao = new ProductDAO();
                    int cnt = dao.updateProduct(uppro);

                  PrintWriter out = response.getWriter();

                  response.sendRedirect(home+"/BookListAdmin.do");

              } catch(Exception e){
                  System.out.println(e.getMessage());
              }
          } else {
              response.sendRedirect(request.getContextPath()+"/");
          }
      }
}