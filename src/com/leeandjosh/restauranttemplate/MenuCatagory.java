package com.leeandjosh.restauranttemplate;

import java.util.ArrayList;
import java.util.List;

public class MenuCatagory {
	private String myName;
	private List<MenuItem> myMenuItems;
	
	public MenuCatagory(String name){
		myName=name;
		myMenuItems= new ArrayList<MenuItem>();
	}

	public List<MenuItem> getMenuItems() {
		return myMenuItems;
	}

	public void addMenuItem(MenuItem item){
		myMenuItems.add(item);
	}

	public String getName() {
		return myName;
	}
}
