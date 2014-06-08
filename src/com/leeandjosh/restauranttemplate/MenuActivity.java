package com.leeandjosh.restauranttemplate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuInflater;

public class MenuActivity extends SingleFragmentActivity {
	@Override
	protected Fragment createFragment() {
		return new MenuFragment();
	}


}
