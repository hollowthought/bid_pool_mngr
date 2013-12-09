package com.markovLabs.bid;

public class Bid {

	private int id;
	private double bidValue=0;
	private int bid_id;
	
	public static String ID_FIELD_NAME="id";
	public static String BID_FIELD_NAME="bid";
	
	public Bid(int id,int bid_id) {
		this.id=id;
		this.setBid_id(bid_id);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBidValue() {
		return bidValue;
	}
	public void setBidValue(double bidValue) {
		this.bidValue = bidValue;
	}
	public int getBid_id() {
		return bid_id;
	}
	public void setBid_id(int bid_id) {
		this.bid_id = bid_id;
	}
	
}
