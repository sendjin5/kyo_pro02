package com.gnjBook.controller.admin;


import com.gnjBook.dto.Delivery;
import com.gnjBook.model.DeliveryDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/DeliveryUpdateAdmin.do")
public class DeliveryUpdateAdminCtrl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sid = (String) session.getAttribute("session_id");

        if(sid != null && sid.equals("admin")) {
            DeliveryDAO dao = new DeliveryDAO();
            int dno = Integer.parseInt(request.getParameter("dno"));
            String dcom = request.getParameter("dcom");
            String dtel = request.getParameter("dtel");
            String etd = request.getParameter("etd");
            String eta = request.getParameter("eta");
            String dcode = request.getParameter("dcode");
            int state = Integer.parseInt(request.getParameter("state"));

            Delivery delivery = new Delivery();

            delivery.setDno(dno);
            delivery.setDcom(dcom);
            delivery.setDtel(dtel);
            delivery.setEtd(etd);
            delivery.setEta(eta);
            delivery.setDcode(dcode);
            delivery.setState(state);

            int cnt = dao.updateDelivery(delivery);
            if(cnt>0){
                System.out.println("정상적으로 배송 정보가 수정되었습니다.");
                String path = request.getContextPath();
                response.sendRedirect(path+"/DeliveryListAdmin.do");
            } else{
                PrintWriter out = response.getWriter();

                out.println("<script>history.go(-1);</script>");
            }
        } else {
            response.sendRedirect(request.getContextPath()+"/");
        }
    }
}
