package com.gnjBook.controller.pay;

import com.gnjBook.model.DeliveryDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/PayConfirm.do")
public class PayConfirmCtrl extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int payNo = Integer.parseInt(request.getParameter("payNo"));

    DeliveryDAO dao = new DeliveryDAO();
    int cnt = dao.payConfirm(payNo);
    if(cnt>0){
      System.out.println("정상적으로 구매 확정되었습니다.");
    }

    String path = request.getContextPath();
    response.sendRedirect(path+"/PayList.do");
  }
}