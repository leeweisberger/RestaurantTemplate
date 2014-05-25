package com.leeandjosh.restauranttemplate;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class CheckoutFragment extends Fragment {

	private static final String EXTRA_ORDER_ITEMS = "order_items_extra";
	private static final String EXTRA_ORDER_PRICE = "order_price_extra";

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Order myOrder = (Order) getArguments().getSerializable(EXTRA_Order);
		setHasOptionsMenu(true);

	}

	public static CheckoutFragment newInstance(Order order) {
		Bundle args = new Bundle();
		args.putInt(EXTRA_ORDER_PRICE, order.getTotalPrice());
		
		//args.putSerializable(EXTRA_ORDER_ITEMS, order.getMenuItems());
		CheckoutFragment fragment = new CheckoutFragment();
		fragment.setArguments(args);
		return fragment;
	}

}
