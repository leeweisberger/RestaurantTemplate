package com.leeandjosh.restauranttemplate;

import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;

public class MenuActivity extends SingleFragmentActivity {

	@Override
	protected Fragment createFragment() {
		return new MenuFragment();
	}
	

}
