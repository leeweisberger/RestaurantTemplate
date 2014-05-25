package com.leeandjosh.restauranttemplate;

public class MenuSelection {
	private int myPrice;
	private String myName;
	
	public MenuSelection(String name, int price){
		myPrice=price;
		myName=name;
	}

	public int getPrice() {
		return myPrice;
	}

	public String getName() {
		return myName;
	}
}
