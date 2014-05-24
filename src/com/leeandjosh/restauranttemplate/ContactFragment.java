package com.leeandjosh.restauranttemplate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public class ContactFragment extends Fragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		setRetainInstance(true);

		Intent intent = new Intent(Intent.ACTION_DIAL);
		intent.setData(Uri.parse("tel:"+MenuInfo.myPhoneNumber));
		startActivity(intent);
	}


}
