package com.leeandjosh.restauranttemplate;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class OrderErrorFragment extends Fragment {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_order_error, container,false);
		Button returnToMenu = (Button) v.findViewById(R.id.return_to_menu_button);
		returnToMenu.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {			
				Intent i = new Intent(getActivity(),MainScreenActivity.class);
				startActivity(i);
			}

		});
		return v;
	}
}


