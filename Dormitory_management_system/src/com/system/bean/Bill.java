package com.system.bean;

public class Bill {
	private String bid;
	private String did;
	private Double money;
	private String situation;
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	public String getSituation() {
		return situation;
	}
	public void setSituation(String situation) {
		this.situation = situation;
	}
	@Override
	public String toString() {
		return "Bill [bid=" + bid + ", did=" + did + ", money=" + money + ", situation=" + situation + "]";
	}
	
	
	
}
