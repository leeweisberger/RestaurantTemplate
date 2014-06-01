package com.leeandjosh.restauranttemplate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order{

	private Map<MenuSelection,Integer> myMenuItems = new HashMap<MenuSelection,Integer>();
	private int myTotalPrice=0;
	public static Order myOrder = new Order();
	public void addItem(MenuSelection item){
		if(!myMenuItems.keySet().contains(item)){
			myMenuItems.put(item, 0);
		}
		myTotalPrice+=item.getPrice();
		myMenuItems.put(item, myMenuItems.get(item)+1);
	}

	public int getTotalPrice(){
		return myTotalPrice;
	}
	public Map<MenuSelection,Integer> getMenuItems(){
		return myMenuItems;
	}
	public void updateQuantity (MenuSelection item, int quantity){
		myMenuItems.put(item, quantity);
	}
	public void removeItem(MenuSelection item){
		myMenuItems.remove(item);
	}




}
