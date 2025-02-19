package com.servlet.buyer_login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.util.index.IndexUI;
import com.util.index.IndexUtil;
import com.vo.BuyerAccount;


@WebServlet("/buyerloginServlet")
public class buyerloginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String account = request.getParameter("buyeracnumber");
		String pwd = request.getParameter("buyerpwd");
		IndexUtil iu = new IndexUI();
		BuyerAccount ba = new BuyerAccount(account,pwd);  
		HttpSession session = request.getSession();
		String flag2 = "True";
			if(iu.checkLogin(account, pwd, "buyer")) {
				flag2 = "True";
				session.setAttribute("flag2", flag2);
				session.setAttribute("buyeruser", ba);
				response.sendRedirect("buyer_login/buyer_login_success.jsp");
			}else {
				flag2 = "False";
				session.setAttribute("flag2", flag2);
				response.sendRedirect("buyer_login/buyer_login.jsp");
			}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
