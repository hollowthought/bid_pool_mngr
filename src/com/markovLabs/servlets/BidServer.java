package com.markovLabs.servlets;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.markovLabs.bid.Bid;

@WebServlet("/bid")
public class BidServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//temporary cache
	public static List<Bid> bids=new ArrayList<Bid>();

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {
		
		
		
	}
}
