package com.leeandjosh.restauranttemplate;

import android.content.Intent;
import android.net.Uri;
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
		wireContactButton(v);
		wireAboutButton(v);
		wireDirectionsButton(v);
		return v; 
	}
	private void wireDirectionsButton(View v) {
		Button directionsButton = (Button) v.findViewById(R.id.directions_button);
		directionsButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String url = "http://maps.google.com/maps?daddr="+MenuInfo.myAddress;
				Intent intent = new Intent(android.content.Intent.ACTION_VIEW,  Uri.parse(url));
				startActivity(intent);
			}
		});
	}
	private void wireAboutButton(View v) {
		Button aboutButton = (Button) v.findViewById(R.id.about_us_button);
		aboutButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(getActivity(),AboutActivity.class);
				startActivity(i);
				
			}
		});
	}
	private void wireContactButton(View v) {
		Button contactButton = (Button) v.findViewById(R.id.contact_button);
		contactButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Intent.ACTION_DIAL);
				intent.setData(Uri.parse("tel:"+MenuInfo.myPhoneNumber));
				startActivity(intent);
			}
		});
	}
	private void wireMenuButton(View v) {
		Button menuButton = (Button) v.findViewById(R.id.order_button);
		menuButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(getActivity(),MenuActivity.class);
				startActivity(i);
			}
		});
	}
}
