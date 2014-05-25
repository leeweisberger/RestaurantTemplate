package com.leeandjosh.restauranttemplate;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CheckoutFragment extends ListFragment {

	private static final String EXTRA_ORDER = "order_items_extra";
	private Order myOrder;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		myOrder = (Order) getArguments().getSerializable(EXTRA_ORDER);
		setHasOptionsMenu(true);
		setRetainInstance(true);
		CheckoutAdapter adapter = new CheckoutAdapter(myOrder.getMenuItems());
		setListAdapter(adapter);

	}

	public static CheckoutFragment newInstance(Order order) {
		Bundle args = new Bundle();
		args.putSerializable(EXTRA_ORDER, order);
		CheckoutFragment fragment = new CheckoutFragment();
		fragment.setArguments(args);
		return fragment;
	}

	private class CheckoutAdapter extends ArrayAdapter<MenuItem> {
		public CheckoutAdapter(List<MenuItem> item) {
			super(getActivity(), 0, item);
		} 
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// If we weren't given a view, inflate one
			if (convertView == null) {
				convertView = getActivity().getLayoutInflater()
						.inflate(R.layout.fragment_checkout, null);
			}
			// Configure the view for this Crime
			MenuItem item = getItem(position);
			TextView titleTextView = 
					(TextView)convertView.findViewById(R.id.order_item_name);
			titleTextView.setText(item.getName());
			TextView priceTextView = 
					(TextView)convertView.findViewById(R.id.order_item_price);
			priceTextView.setText(item.getPrice()+"");
			return convertView;
		}
	}


}
