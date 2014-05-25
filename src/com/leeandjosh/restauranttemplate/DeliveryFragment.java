package com.leeandjosh.restauranttemplate;

import android.annotation.TargetApi;
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
import android.widget.EditText;

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
			}
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
			}
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
}
