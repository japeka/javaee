package com.airline.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.models.Pilot;
import com.airline.models.PilotRank;
import com.airline.service.PilotService;

@WebServlet("/CreatePilotAndAddToFlight")
public class CreatePilotAndAddToFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	@EJB
	PilotService ps;
    public CreatePilotAndAddToFlight() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fName = request.getParameter("first_name");
		String lName = request.getParameter("last_name");
		Integer license = Integer.parseInt(request.getParameter("license"));
		String rank = request.getParameter("pilot_rank");
		String fid = request.getParameter("fid");
		
		Pilot p = new Pilot();
		p.setFirstName(fName);
		p.setLastName(lName);
		p.setPilotLicense(license);
		p.setPilotRank(PilotRank.valueOf(rank));
		
		ps.addNewPilotToFlight(p, fid);
		response.sendRedirect("Flights");
		
	}

}