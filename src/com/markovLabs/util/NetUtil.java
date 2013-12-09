package com.markovLabs.util;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.markovLabs.bid.Bid;

public class NetUtil {
	
	private static final String POOL_URL="http://localhost:8080/bid_pool_mngr/handler";
	
	//in and out are respected to the pool server
	private static final String POOL_BID_URL_IN="http://localhost:8080/bid_pool_mngr/bid?mode=in";
	private static final String POOL_BID_URL_OUT="http://localhost:8080/bid_pool_mngr/bid?mode=out";
	
	public static void sendRequestToPool(Integer id,int code){
		try {
			URL req=new URL(POOL_URL);
			HttpURLConnection con=(HttpURLConnection) req.openConnection();
			OutputStream out=con.getOutputStream();
			out.write(code);
			out.write(',');
			out.write(id);
			out.flush();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Bid getBidFromPool(Integer id){
		try {
			URL req=new URL(POOL_BID_URL_OUT);
			HttpURLConnection con=(HttpURLConnection) req.openConnection();
			InputStream in=con.getInputStream();
			ObjectInputStream oos = new ObjectInputStream(in);
			Bid bid=(Bid) oos.readObject();
			in.close();
			return bid;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Bid sendBidToPool(Bid bid){
		try {
			URL req=new URL(POOL_BID_URL_IN);
			HttpURLConnection con=(HttpURLConnection) req.openConnection();
			OutputStream out=con.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(out);
			oos.writeObject(bid);
			oos.flush();
			out.close();
			return bid;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
