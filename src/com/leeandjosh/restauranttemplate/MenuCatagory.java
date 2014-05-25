package com.leeandjosh.restauranttemplate;

import java.util.ArrayList;
import java.util.List;

public class MenuCatagory {
	private String myName;
	private List<MenuSelection> myMenuItems;
	
	public MenuCatagory(String name){
		myName=name;
		myMenuItems= new ArrayList<MenuSelection>();
	}

	public List<MenuSelection> getMenuItems() {
		return myMenuItems;
	}

	public void addMenuItem(MenuSelection item){
		myMenuItems.add(item);
	}

	public String getName() {
		return myName;
	}
}
