package com.leeandjosh.restauranttemplate;

import android.support.v4.app.Fragment;

public class CheckoutActivity extends SingleFragmentActivity {
	
	
	private Order myOrder;

	@Override
	protected Fragment createFragment() {
		return CheckoutFragment.newInstance(myOrder);
	}

}
