package com.leeandjosh.restauranttemplate;

public class MenuItem {
	private int myPrice;
	private String myName;
	
	public MenuItem(String name, int price){
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
