package com.leeandjosh.restauranttemplate;

import android.support.v4.app.Fragment;

public class AboutActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new AboutFragment();
	}

}
