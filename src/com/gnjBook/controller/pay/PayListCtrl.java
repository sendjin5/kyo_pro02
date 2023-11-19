package com.gnjBook.controller.pay;

import com.gnjBook.dto.Cart;
import com.gnjBook.dto.Delivery;
import com.gnjBook.dto.Payment;
import com.gnjBook.dto.Product;
import com.gnjBook.model.*;
import com.gnjBook.vo.PayVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/PayList.do")
public class PayListCtrl extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    HttpSession session = request.getSession(); // 세션 생성
    String id = (String) session.getAttribute("session_id");

    PaymentDAO dao = new PaymentDAO();
    List<Payment> payList = dao.getMemberPaymentList(id);

    ProductDAO productDAO = new ProductDAO();
    List<Product> productList = new ArrayList<>();
    for(Payment p: payList){
      productList.add(productDAO.getProduct(p.getProNo()));
    }

    DeliveryDAO deliveryDAO = new DeliveryDAO();
    List<Delivery> delList = new ArrayList<>();
    for(Payment p: payList){
      delList.add(deliveryDAO.getPayDeliveryList(p.getPayNo()));
    }

    List<PayVO> payvoList = new ArrayList<>();
    for(int i=0; i<payList.size(); i++){
      PayVO payvo = new PayVO();
      payvo.setPro(productList.get(i));
      payvo.setDel(delList.get(i));
      payvo.setPay(payList.get(i));
      payvoList.add(payvo);
    }

    request.setAttribute("payvoList", payvoList);

    RequestDispatcher view = request.getRequestDispatcher("/pay/payList.jsp");
    view.forward(request,response);
  }
}