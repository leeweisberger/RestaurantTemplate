package com.leeandjosh.restauranttemplate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainScreenFragment extends Fragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		setRetainInstance(true);
	}
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, 
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_main_screen, parent, false);
		wireMenuButton(v);
		Button contactButton = (Button) v.findViewById(R.id.order_button);
		contactButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(getActivity(),ContactActivity.class);
				startActivity(i);
			}
		});
		return v; 
	}
	private void wireMenuButton(View v) {
		Button menuButton = (Button) v.findViewById(R.id.menu_button);
		menuButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(getActivity(),MenuActivity.class);
				startActivity(i);
			}
		});
	}
	
}
