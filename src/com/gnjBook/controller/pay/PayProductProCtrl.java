package com.gnjBook.controller.pay;

import com.gnjBook.dto.Cart;
import com.gnjBook.dto.Delivery;
import com.gnjBook.dto.Payment;
import com.gnjBook.dto.Product;
import com.gnjBook.model.CartDAO;
import com.gnjBook.model.InstockDAO;
import com.gnjBook.model.MultiPattern;
import com.gnjBook.model.ProductDAO;
import com.gnjBook.vo.PayVO;

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

@WebServlet("/PayProductPro.do")
public class PayProductProCtrl extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession(); // 세션 생성
    String id = (String) session.getAttribute("session_id");

    ProductDAO productDAO = new ProductDAO();
    int proNo = Integer.parseInt(request.getParameter("proNo"));
    Product product = productDAO.getProduct(proNo);

    // 출고 처리
    String method = request.getParameter("method");
    String pcom = request.getParameter("pcom");
    String paccount = request.getParameter("paccount");
    int amount = Integer.parseInt(request.getParameter("amount"));

    Payment pay = new Payment();
    pay.setMemId(id);
    pay.setProNo(product.getProNo());
    pay.setPayPrice(product.getPrice());
    pay.setAmount(amount);
    pay.setMethod(method);
    pay.setPcom(pcom);
    pay.setPaccount(paccount);

    Delivery del = new Delivery();
    del.setMemId(id);
    del.setAddress(request.getParameter("address1")+"/"+request.getParameter("address2")+"/"+request.getParameter("postcode"));
    del.setTel(request.getParameter("tel"));
    del.setName(request.getParameter("name"));

    PayVO payvo = new PayVO();
    payvo.setPro(product);
    payvo.setDel(del);
    payvo.setPay(pay);

    int instockamount =  productDAO.getAmount(proNo);

    if(instockamount < amount){
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();

      out.println("<script>alert('재고 수량이 부족하여 결제되지 않았습니다. 죄송합니다.');history.go(-1);</script>");
    }

    MultiPattern mdao = new MultiPattern();
    int pno = mdao.outstockProduct(pay, del);

    request.setAttribute("payvoList", payvo);

    String path = request.getContextPath();
    response.sendRedirect(path+"/PayList.do");
  }
}