package com.gnjBook.controller.admin;

import com.gnjBook.dto.Product;
import com.gnjBook.model.ProductDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/BookAddPro.do")
public class BookAddProCtrl extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = "";
        ServletContext application = request.getServletContext();

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("session_id");

        if(sid != null && sid.equals("admin")) {
            try {
                String saveDirectory = application.getRealPath("/storage"); //실제 저장 경로
                int maxSize = 1024*1024*10;     //10MB
                String encoding = "UTF-8";

                MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxSize, encoding, new DefaultFileRenamePolicy());
                Product product= new Product();
                product.setCategoryId(mr.getParameter("category"));
                product.setTitle(mr.getParameter("title"));
                product.setAuthor(mr.getParameter("author"));
                product.setPrice(Integer.parseInt(mr.getParameter("price")));
                product.setContent(mr.getParameter("content"));


                File upfile = null;
                Enumeration files = mr.getFileNames();

                int idx = 1;
                String item;
                String oriFile = "";
                String fileName = "";
                while(files.hasMoreElements()) {
                    item = (String) files.nextElement();
                    oriFile = mr.getOriginalFileName(item); //실제 첨부된 파일경로와 이름
                    fileName = mr.getFilesystemName(item);  //파일이름만 추출


                    if(fileName!=null) {
                        upfile = mr.getFile(item); //실제 업로드
                        if (upfile.exists()) {
                            long filesize = upfile.length();
                            if (idx == 1) {
                                product.setImg(upfile.getName());
                            } else if (idx == 2) {
                                product.setVideo(upfile.getName());
                            }
                            msg = "파일 업로드 성공";
                            System.out.println("파일 업로드 성공");
                        } else {
                            msg = "파일 업로드 실패";
                            System.out.println("파일 업로드 실패");
                        }
                    }
                    idx++;
                }


                ProductDAO dao = new ProductDAO();
                int cnt = dao.addProduct(product);
                List<Product> productList = new ArrayList<>();

                if(cnt>0){
                    productList = dao.getCategoryProduct(mr.getParameter("category"));
                    request.setAttribute("bookList",productList);
                    response.sendRedirect(request.getContextPath()+"/BookListAdmin.do");
                    //RequestDispatcher view = request.getRequestDispatcher("/BookListAdmin.do");
                    //              view.forward(request, response);
                } else {
                    response.sendRedirect(request.getContextPath()+"/BookAdd.do");
                }
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }
    }
}
