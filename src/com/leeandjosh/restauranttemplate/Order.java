package com.leeandjosh.restauranttemplate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order{

	private Map<MenuSelection,Integer> myMenuItems = new HashMap<MenuSelection,Integer>();
	public static Order myOrder = new Order();
	public void addItem(MenuSelection item){
		if(findInOrder(item)==null){
			myMenuItems.put(item, 0);
		}
		myMenuItems.put(findInOrder(item), myMenuItems.get(findInOrder(item))+1);
	}

	public int getTotalPrice(){
		int price=0;
		for(MenuSelection item: myMenuItems.keySet()){
			price+=item.getPrice()*myMenuItems.get(item);
		}
		return price;
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
	public String toString(){
		String order="";
		for(MenuSelection item :myMenuItems.keySet()){
			order+=item.getName() + " : " + myMenuItems.get(item);
		}
		return order;
	}
	
	private MenuSelection findInOrder(MenuSelection item){
		for(MenuSelection selection:myMenuItems.keySet()){
			if(selection.getName().equals(item.getName()))
				return selection;
		}
		return null;
	}




}
