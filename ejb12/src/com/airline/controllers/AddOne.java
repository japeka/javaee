package com.airline.controllers;
import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.service.CounterBean;
import com.airline.service.CounterStatefulBean;

@WebServlet("/AddOne")
public class AddOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	CounterBean cb;
	@EJB
	CounterStatefulBean cbStateful;
	
    public AddOne() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		out.println("The current ( SINGLETON ) count: " + cb.getCount());
		out.println("The current ( STATEFUL ) count: " + cbStateful.getCount());
		
		cb.addOneToCount();
		cbStateful.addOneToCount();
		
		out.println("The current count ( SINGLETON ) : " + cb.getCount());
		out.println("The current count ( STATEFUL ): " + cbStateful.getCount());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
