package com.markovLabs.bid;

public class Bid {

	private int id;
	private double bidValue;
	
	public static String ID_FIELD_NAME="id";
	public static String BID_FIELD_NAME="bid";
	
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
	
}
