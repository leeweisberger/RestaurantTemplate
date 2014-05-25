package com.leeandjosh.restauranttemplate;

import java.util.List;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class CheckoutFragment extends ListFragment {


	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setRetainInstance(true);
		CheckoutAdapter adapter = new CheckoutAdapter(Order.myOrder.getMenuItems());
		setListAdapter(adapter);
		setHasOptionsMenu(true);

	}
	



	private class CheckoutAdapter extends ArrayAdapter<MenuSelection> {
		public CheckoutAdapter(List<MenuSelection> item) {
			super(getActivity(), 0, item);
		} 
		@TargetApi(Build.VERSION_CODES.HONEYCOMB)
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// If we weren't given a view, inflate one
			if (convertView == null) {
				convertView = getActivity().getLayoutInflater()
						.inflate(R.layout.fragment_checkout, null);
			}
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
				getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
			}
		
			MenuSelection item = getItem(position);
			TextView titleTextView = 
					(TextView)convertView.findViewById(R.id.order_item_name);
			titleTextView.setText(item.getName());
			TextView priceTextView = 
					(TextView)convertView.findViewById(R.id.order_item_price);
			priceTextView.setText(item.getPrice()+"");
			Spinner spinner = (Spinner) convertView.findViewById(R.id.spinner1);
			return convertView;
		}
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId()==android.R.id.home){
			if (NavUtils.getParentActivityName(getActivity()) != null) 
				NavUtils.navigateUpFromSameTask(getActivity());
			return true;
		}
		else if(item.getItemId()==R.id.menu_place_order){
			Intent i = new Intent(getActivity(),DeliveryActivity.class);
			startActivity(i);
			return true;
		}
		
		else{
			
			return super.onOptionsItemSelected(item);
		}
	}
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.fragment_checkout, menu);
	}
	
	


}
