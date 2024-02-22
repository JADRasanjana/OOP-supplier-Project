package com.supplier;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteSupplierServlet")
public class DeleteSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("supid");	
		
	boolean isTrue;
		
		isTrue = SupplierDBUtil.deletesupplier(id);
		
		if(isTrue == true) {
			
		
			RequestDispatcher disp = request.getRequestDispatcher("supplierinsert.jsp");
			disp.forward(request, response);
		
		}else {
			List<Supplier> supDetails = SupplierDBUtil.getSupplierDetails(id);
			request.setAttribute("supDetails", supDetails);
			
			RequestDispatcher disp = request.getRequestDispatcher("Supplieraccount.jsp");
			disp.forward(request, response);
		}
		
	}

}
