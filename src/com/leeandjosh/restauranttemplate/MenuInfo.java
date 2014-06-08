package com.leeandjosh.restauranttemplate;

import java.util.ArrayList;
import java.util.List;

public class MenuInfo {
	public static final String myAddress = "160+Ticonderoga+Terrace+Wayne+NJ";
	public static String myPhoneNumber = "973-981-1170";
	public static String myAboutText = "got some shit to do today and tomorrow but will be checking emails as i can and getting the mailing ready for those who have paid after seeing and approving there proofs in middle of movig my base this weekend so please do not fret im not ingoring anyone just super busy so might be a tad slower on replies with all the driving back and forth and whatnot between states";

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
