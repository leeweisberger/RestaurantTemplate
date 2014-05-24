package com.leeandjosh.restauranttemplate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public class DirectionsFragment extends Fragment {

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
		
		Intent i = new Intent(Intent.ACTION_VIEW);
		Uri.parse("google.navigation:q=" + MenuInfo.myAddress);
		startActivity(i);
	}
}
