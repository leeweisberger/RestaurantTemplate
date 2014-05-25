package com.leeandjosh.restauranttemplate;
import java.util.ArrayList;
import java.util.List;

public class Order{

	private List<MenuSelection> myMenuItems = new ArrayList<MenuSelection>();
	private int myTotalPrice=0;
	public static Order myOrder = new Order();
	public void addItem(MenuSelection item){
		myMenuItems.add(item);
		myTotalPrice+=item.getPrice();
	}
	
	public void removeItem(MenuSelection item){
		myMenuItems.remove(item);
		myTotalPrice-=item.getPrice();
	}
	
	public int getTotalPrice(){
		return myTotalPrice;
	}
	public List<MenuSelection> getMenuItems(){
		return myMenuItems;
	}

	
	
	
}
