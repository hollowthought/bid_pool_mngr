package com.markovLabs.servlets;

import java.io.InputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.markovLabs.bid.Bid;

@WebServlet("/handler")
public class PoolOperationsHandler extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final int BUFFER_SIZE=60;
	public static final int CREATE_OP = 0;
	public static final int DELETE_OP = 1;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {
		InputStream in= req.getInputStream();
		byte[] buf=new byte[BUFFER_SIZE];
		in.read(buf);
		String mesg=String.valueOf(buf);
		String values[]=mesg.split(",");
		int command=Integer.parseInt(values[0]);
		int id=Integer.parseInt(values[1]);
		switch(command){
			case PoolOperationsHandler.CREATE_OP:BidServer.bids.put(id,new Bid(id));break;
			case PoolOperationsHandler.DELETE_OP:BidServer.bids.remove(id);break;
		}
	}
}
