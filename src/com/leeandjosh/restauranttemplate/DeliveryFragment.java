package com.leeandjosh.restauranttemplate;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeliveryFragment extends Fragment {

	private String myDeliveryName;
	private String myDeliveryNumber;
	private String myDeliveryAddress;
	private String myDeliveryInstructions;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		setRetainInstance(true);
	}
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, 
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_delivery, parent, false);
		EditText deliveryName=(EditText) v.findViewById(R.id.delivery_name);
		deliveryName.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable arg0) {				
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {				
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				myDeliveryName=arg0.toString();
				Order.myOrder.setDeliveryInfo("Name", myDeliveryName);
			}	
		});
		EditText deliveryAddress=(EditText) v.findViewById(R.id.deliver_address);
		deliveryAddress.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable arg0) {				
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {				
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				myDeliveryAddress=arg0.toString();
				Order.myOrder.setDeliveryInfo("Address", myDeliveryAddress);			}
		});
		EditText deliveryPhone=(EditText) v.findViewById(R.id.delivery_phone);
		deliveryPhone.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable arg0) {				
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {				
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				myDeliveryNumber=arg0.toString();
				Order.myOrder.setDeliveryInfo("Phone", myDeliveryNumber);			}
		});
		EditText deliveryInstructions=(EditText) v.findViewById(R.id.delivery_instructions);
		deliveryInstructions.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable arg0) {				
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {				
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				myDeliveryInstructions=arg0.toString();
				Order.myOrder.setDeliveryInfo("Instructions", myDeliveryInstructions);			}
		});

		
		

		Button placeOrder = (Button) v.findViewById(R.id.place_order);
		placeOrder.setText("Total: $"+Order.myOrder.getTotalPrice()+".00"+ "\n" + "Place Order");
		placeOrder.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				new FetchItemsTask().execute();
				Order.myOrder.resetOrder();
				Intent i = new Intent(getActivity(),OrderPlacedActivity.class);
				startActivity(i);
				
				

			}
		});

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
		}
		return v;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId()==android.R.id.home){
			if (NavUtils.getParentActivityName(getActivity()) != null) 
				NavUtils.navigateUpFromSameTask(getActivity());
			return true;
		}
		else{
			return super.onOptionsItemSelected(item);
		}
	}
	private class FetchItemsTask extends AsyncTask<Void,Void,Void> {
		@Override
		protected Void doInBackground(Void... params) {
			new OrderPoster().fetchItems();
			return null;
		}
	}

}
