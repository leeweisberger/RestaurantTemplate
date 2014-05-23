package com.leeandjosh.restauranttemplate;

import java.util.ArrayList;
import java.util.List;

public class MenuInfo {
	public static ArrayList<String> myParentItems = new ArrayList<String>();
	public static ArrayList<Object> myChildItems = new ArrayList<Object>();

	public MenuInfo(){
		myParentItems.add("Appetizers");
		myParentItems.add("Pizza");
		myParentItems.add("Pasta");
		myParentItems.add("Sandwiches");
		myParentItems.add("Entrees");
		myParentItems.add("Desserts");
		myParentItems.add("Drinks");

		//Appetizers
		List<String> child = new ArrayList<String>();
		child.add("Salad");
		child.add("Bruscheta");
		child.add("Garlic Bread");
		myChildItems.add(child);
		//Pizza
		child = new ArrayList<String>();
		child.add("Plain Pie");
		child.add("Pepperoni Pie");
		child.add("Mushroom Pie");
		myChildItems.add(child);
		//Pasta
		child = new ArrayList<String>();
		child.add("Penne alla Vodka");
		child.add("Spaghetti and Meatballs");
		child.add("Ravioli");
		child.add("Lasagna");
		child.add("Manicotti");
		myChildItems.add(child);
		//Sandwiches
		child = new ArrayList<String>();
		child.add("Meatball Parmigiana Sub");
		child.add("Chicken Parmigiana Sub");
		child.add("Hamburger");
		child.add("Grilled Cheese");
		child.add("Italian Sub");
		myChildItems.add(child);
		//Entres
		child = new ArrayList<String>();
		child.add("Chicken Marsala");
		child.add("Chicken Piccata");
		child.add("Veal Piccata");
		child.add("Salmon Filet");
		child.add("Lasagna Bake");
		myChildItems.add(child);
		//Desserts
		child = new ArrayList<String>();
		child.add("Ice Cream");
		child.add("Cannoli");
		myChildItems.add(child);
		//Drinks
		child = new ArrayList<String>();
		child.add("Fountain Drinks");
		child.add("Bottled Soda");
		child.add("Espresso");
		myChildItems.add(child);
	}
}
