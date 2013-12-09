package com.markovLabs.bid;

public class Bid {
	private int user_id;
	private double bidValue=0;
	private int bid_id;
	
	public static final String ID_FIELD_NAME="id";
	public static final String BID_FIELD_NAME="bid";
	public static final String BID_FIELD_NAME_VALUE = "bid_value";
	
	public Bid(Integer id,Integer bid_id) {
		this(id,bid_id,0.0);
	}
	
	public Bid(Integer user_id, Integer bid_id, Double bid_value) {
		this.user_id=user_id;
		this.bid_id=bid_id;
		this.bidValue=bid_value;
	}
	
	public int getUserId() {
		return user_id;
	}
	public void setUserId(int id) {
		this.user_id = id;
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
