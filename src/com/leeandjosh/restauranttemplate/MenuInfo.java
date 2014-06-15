package com.leeandjosh.restauranttemplate;

import java.util.ArrayList;
import java.util.List;

public class MenuInfo {
	public static final String myAddress = "160+Ticonderoga+Terrace+Wayne+NJ";
	public static String myPhoneNumber = "973-981-1170";
	public static String myAboutText = "Sample About Us Text: you can talk about your restaurant, your mission, your employees, or why customers should give you their business";

	public static ArrayList<MenuCatagory> makeMenu() {
		ArrayList<MenuCatagory> myParentItems = new ArrayList<MenuCatagory>();
		
		MenuCatagory appetizers = new MenuCatagory("Appetizers");
		appetizers.addMenuItem(new MenuSelection("Bruschetta", 8));
		appetizers.addMenuItem(new MenuSelection("Bruschetta", 8));
		appetizers.addMenuItem(new MenuSelection("Bruschetta", 8));
		appetizers.addMenuItem(new MenuSelection("Bruschetta", 8));
		myParentItems.add(appetizers);
		
		MenuCatagory pizza = new MenuCatagory("Pizza");
		pizza.addMenuItem(new MenuSelection("Pepperoni", 15));
		pizza.addMenuItem(new MenuSelection("Pepperoni", 15));
		pizza.addMenuItem(new MenuSelection("Pepperoni", 15));
		pizza.addMenuItem(new MenuSelection("Pepperoni", 15));
		pizza.addMenuItem(new MenuSelection("Pepperoni", 15));
		pizza.addMenuItem(new MenuSelection("Pepperoni", 15));
		myParentItems.add(pizza);
		
		MenuCatagory pasta = new MenuCatagory("Pasta");
		pasta.addMenuItem(new MenuSelection("Lasagna", 22));
		pasta.addMenuItem(new MenuSelection("Lasagna", 22));
		pasta.addMenuItem(new MenuSelection("Lasagna", 22));
		myParentItems.add(pasta);
		return myParentItems;
	}
}
