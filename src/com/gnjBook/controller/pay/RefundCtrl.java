package com.gnjBook.controller.pay;

import com.gnjBook.dto.Payment;
import com.gnjBook.model.*;

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

@WebServlet("/Refund.do")
public class RefundCtrl extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int payNo = Integer.parseInt(request.getParameter("payNo"));
    System.out.println(payNo);

    PaymentDAO pdao = new PaymentDAO();
    Payment p = pdao.getpayment(payNo);
    int proNo = p.getProNo();

    MultiPattern dao = new MultiPattern();
    dao.refund(payNo, proNo);

    String path = request.getContextPath();
    response.sendRedirect(path+"/PayList.do");
  }
}