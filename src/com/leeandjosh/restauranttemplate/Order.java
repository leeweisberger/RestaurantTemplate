package com.leeandjosh.restauranttemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1875753140347376308L;
	private List<MenuItem> myMenuItems = new ArrayList<MenuItem>();
	private int myTotalPrice=0;
	
	public void addItem(MenuItem item){
		myMenuItems.add(item);
		myTotalPrice+=item.getPrice();
	}
	
	public void removeItem(MenuItem item){
		myMenuItems.remove(item);
		myTotalPrice-=item.getPrice();
	}
	
	public int getTotalPrice(){
		return myTotalPrice;
	}
	public List<MenuItem> getMenuItems(){
		return myMenuItems;
	}
	
	
}
