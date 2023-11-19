package com.gnjBook.controller.pay;

import com.gnjBook.dto.*;
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

@WebServlet("/PayCartPro.do")
public class PayCartProCtrl extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession(); // 세션 생성
    String id = (String) session.getAttribute("session_id");

    String[] checked = request.getParameterValues("cartCheck");



    CartDAO cartDAO = new CartDAO();
    List<Cart> cartList = new ArrayList<>();
    for(String s: checked){
      cartList.add(cartDAO.getCart(Integer.parseInt(s)));
    }

    ProductDAO productDAO = new ProductDAO();
    List<Product> productList = new ArrayList<>();
    List<Integer> inventoryList = new ArrayList<>();
    for(Cart c: cartList){
      productList.add(productDAO.getProduct(c.getProNo()));
      inventoryList.add(productDAO.getAmount(c.getProNo()));
    }



    // 출고 처리
    String method = request.getParameter("method");
    String pcom = request.getParameter("pcom");
    String paccount = request.getParameter("paccount");

    List<Payment> payList = new ArrayList<>();
    for(int i=0; i<cartList.size(); i++){
      Payment pay = new Payment();
      pay.setMemId(id);
      pay.setProNo(productList.get(i).getProNo());
      pay.setPayPrice(productList.get(i).getPrice());
      pay.setAmount(cartList.get(i).getAmount());
      pay.setMethod(method);
      pay.setPcom(pcom);
      pay.setPaccount(paccount);
      payList.add(pay);
    }

    List<Delivery> delList = new ArrayList<>();
    for(int i=0; i<cartList.size(); i++){
      Delivery del = new Delivery();
      del.setMemId(id);
      del.setAddress(request.getParameter("address1")+" "+request.getParameter("address2")+" "+request.getParameter("postcode"));
      del.setTel(request.getParameter("tel"));
      del.setName(request.getParameter("name"));
      delList.add(del);
    }

    boolean flag = true;
    for(int i=0; i<cartList.size(); i++){
      int inamount = inventoryList.get(i);
      System.out.println(inamount);
      int cartstock = cartList.get(i).getAmount();
      if(inamount<cartstock){
        flag = false;
        break;
      }
    }

    if(!flag){
      response.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();

      out.println("<script>alert('재고 수량이 부족하여 결제되지 않았습니다. 죄송합니다.');history.go(-1);</script>");
    }else{
      MultiPattern mdao = new MultiPattern();
      for(int i=0; i<cartList.size(); i++){
        int pno = mdao.outstock(payList.get(i), delList.get(i), cartList.get(i));
      }

      String path = request.getContextPath();
      response.sendRedirect(path+"/PayList.do");
    }
  }
}