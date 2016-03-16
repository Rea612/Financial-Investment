package com.suddenlyjune.financialinvestment.dao;

public class Stock {
	private int userid;
	private String name;
	private double price;
	private int quantity;
	private double totalPrice;
	
	
	public Stock(){
		
	}
	public Stock(int userid, String name, double price, int quantity, double totalPrice) {
		this.userid = userid;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "Stock [userid=" + userid + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ ", totalPrice=" + totalPrice + "]";
	}
	
	

}

