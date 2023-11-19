package com.gnjBook.controller.pay;

import com.gnjBook.dto.Cart;
import com.gnjBook.dto.Member;
import com.gnjBook.dto.Product;
import com.gnjBook.model.CartDAO;
import com.gnjBook.model.InstockDAO;
import com.gnjBook.model.MemberDAO;
import com.gnjBook.model.ProductDAO;
import com.gnjBook.vo.CartVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/PayProduct.do")
public class PayProductCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(); // 세션 생성
        String sid = (String) session.getAttribute("session_id");
        if(sid != null){
            int amount = Integer.parseInt(request.getParameter("amount"));
            int proNo = Integer.parseInt(request.getParameter("proNo"));

            ProductDAO dao = new ProductDAO();
            Product product = dao.getProduct(proNo);

            int instockamount =  dao.getAmount(proNo);

            System.out.println(instockamount+" "+amount);
            if(instockamount<amount){
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html; charset=UTF-8");
                PrintWriter out = response.getWriter();

                out.println("<script>alert('재고 수량이 부족하여 결제할 수 없습니다. 죄송합니다.');history.go(-1);</script>");
            } else{
                request.setAttribute("amount", amount);
                request.setAttribute("product", product);

                MemberDAO memberDAO = new MemberDAO();
                Member member = memberDAO.getMember((String) session.getAttribute("session_id"));

                request.setAttribute("mem", member);

                RequestDispatcher view = request.getRequestDispatcher("/pay/productPay.jsp");
                view.forward(request,response);
            }
        }
    }
}