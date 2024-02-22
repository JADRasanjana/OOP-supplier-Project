package com.supplier;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateSupplierServlet")
public class UpdateSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("supid");	
		String name = request.getParameter("name");	
		String email = request.getParameter("email");	
		String phone = request.getParameter("phone");	
		String userName = request.getParameter("uname");	
		String password = request.getParameter("pass");	
		
		boolean isTrue;
		
		isTrue = SupplierDBUtil.updatesupplier(id, name, email, phone, userName, password);
		
		if(isTrue == true) {
			
			List<Supplier> supDetails = SupplierDBUtil.getSupplierDetails(id);
			request.setAttribute("supDetails", supDetails);
			
			
			RequestDispatcher dis = request.getRequestDispatcher("Supplieraccount.jsp");
			dis.forward(request, response);
		
		}else {
			RequestDispatcher dis = request.getRequestDispatcher("Supplieraccount.jsp");
			dis.forward(request, response);
		}
	}
	

}
