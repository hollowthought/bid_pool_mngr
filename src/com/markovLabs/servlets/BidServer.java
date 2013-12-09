package com.markovLabs.servlets;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

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
	public static Map<Integer,Bid> bids=new HashMap<Integer,Bid>();

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {
		String query=req.getQueryString();
		String[] params=query.split("=");
		try {
		if(params[1].equals("in")){
			ObjectInputStream oos = new ObjectInputStream(req.getInputStream());
			Bid bid=(Bid) oos.readObject();
			bids.put(bid.getBid_id(), bid);
		}
		else{
			ObjectOutputStream oos=new ObjectOutputStream(resp.getOutputStream());
			oos.writeObject(bids);
		}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
