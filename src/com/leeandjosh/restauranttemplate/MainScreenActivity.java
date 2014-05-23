package com.leeandjosh.restauranttemplate;

import android.support.v4.app.Fragment;

public class MainScreenActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new MainScreenFragment();
	}

	

}
