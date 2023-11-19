package com.gnjBook.controller.member;

import com.gnjBook.model.MemberDAO;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/IdCheck.do")
public class IdCheckCtrl extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String id = request.getParameter("id");
    MemberDAO dao = new MemberDAO();
    JSONObject json = new JSONObject();
    json.put("result", dao.checkId(id));
    response.setContentType("application/x-json; charset=utf-8");
    response.getWriter().print(json); // 전송이 되는 부분
  }
}