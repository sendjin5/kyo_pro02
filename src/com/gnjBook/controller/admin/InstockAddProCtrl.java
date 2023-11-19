package com.gnjBook.controller.admin;

import com.gnjBook.dto.Instock;
import com.gnjBook.dto.Notice;
import com.gnjBook.model.InstockDAO;
import com.gnjBook.model.NoticeDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/InstockAddPro.do")
public class InstockAddProCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("msg", "상품 입고를 추가합니다.");
        String path = request.getContextPath();

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("session_id");

        int proNo = Integer.parseInt(request.getParameter("proNo"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        int inPrice = Integer.parseInt(request.getParameter("inPrice"));

        if(sid != null && sid.equals("admin")) {
            Instock new_instock = new Instock();
            new_instock.setProNo(proNo);
            new_instock.setAmount(amount);
            new_instock.setInPrice(inPrice);

            InstockDAO dao = new InstockDAO();
            int cnt = dao.addInstock(new_instock);

            if(cnt>0){
                System.out.println("성공적으로 추가되었습니다.");
                response.sendRedirect(path+"/BookGetAdmin.do?id="+proNo);
            } else{
                System.out.println("오류로 인해 제대로 처리되지 않았습니다.");
                PrintWriter out = response.getWriter();
                out.println("<script>history.go(-1);</script>");
            }
        } else {
                response.sendRedirect(request.getContextPath()+"/");
            }


        }
}
