package com.leeandjosh.restauranttemplate;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class DeliveryFragment extends Fragment {

	private String myDeliveryName="";
	private String myDeliveryNumber="";
	private String myDeliveryAddress="";
	private String myDeliveryInstructions="";
	private String myDeliveryEmail="";
	private Button placeOrder=null;
	private boolean error;


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
				enableButton();
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
				Order.myOrder.setDeliveryInfo("Address", myDeliveryAddress);
				enableButton();			}
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
				Order.myOrder.setDeliveryInfo("Phone", myDeliveryNumber);	
				enableButton();			}
		});
		EditText deliveryEmail=(EditText) v.findViewById(R.id.delivery_email);
		deliveryEmail.addTextChangedListener(new TextWatcher(){

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
				myDeliveryEmail=arg0.toString();
				Order.myOrder.setDeliveryInfo("Email", myDeliveryEmail);	
				enableButton();			}
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
				Order.myOrder.setDeliveryInfo("Instructions", myDeliveryInstructions);	
				enableButton();
			}


		});
		RadioGroup deliveryRadio = (RadioGroup) v.findViewById(R.id.radio_group_delivery);
		deliveryRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if(checkedId==R.id.radio_delivery){
					Order.myOrder.setDeliveryInfo("Delivery", "Delivery");
				}
				else if (checkedId == R.id.radio_carry_out)		
					Order.myOrder.setDeliveryInfo("Delivery", "Carry Out");
			}
			
		});
		
		placeOrder = (Button) v.findViewById(R.id.place_order);
		placeOrder.setText("Total: $"+Order.myOrder.getTotalPrice()+".00"+ "\n" + "Place Order");
		placeOrder.setEnabled(false);
		placeOrder.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				new FetchItemsTask().execute();
				if(!error){
					Intent i = new Intent(getActivity(),OrderPlacedActivity.class);
					startActivity(i);
				}
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
			if(! new OrderPoster().sendItems()){
				error = true;
				Intent i = new Intent(getActivity(),OrderErrorActivity.class);
				startActivity(i);
			}


			return null;
		}
	}
	private void enableButton() {
		if(placeOrder!=null && !myDeliveryName.isEmpty()  && !myDeliveryNumber.isEmpty() && !myDeliveryEmail.isEmpty())
			placeOrder.setEnabled(true);

	}

}
