package com.gnjBook.controller.cart;

import com.gnjBook.dto.Cart;
import com.gnjBook.model.CartDAO;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CartList.do")
public class CartListCtrl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("msg", "장바구니 목록을 출력합니다.");
        HttpSession session = request.getSession(); // 세션 생성
        String id = (String) session.getAttribute("session_id");

        List<CartVO> cartVOList = new ArrayList<>();

        CartDAO cartDAO = new CartDAO();
        List<Cart> cartList = cartDAO.getMemberCartList(id);

        ProductDAO productDAO = new ProductDAO();
        for(Cart c: cartList){
            CartVO cvo = new CartVO();
            cvo.setCart(c);
            cvo.setProduct(productDAO.getProduct(c.getProNo()));
            cartVOList.add(cvo);
        }

        request.setAttribute("cartVOList", cartVOList);

        RequestDispatcher view = request.getRequestDispatcher("/cart/cartList.jsp");
        view.forward(request, response);
    }
}
