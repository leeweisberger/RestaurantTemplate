package com.leeandjosh.restauranttemplate;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

public class MenuFragment extends Fragment {
	public static final String EXTRA_ORDER_MENUFRAGMENT = "extra_order_menufragment";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		setRetainInstance(true);
	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_menu, parent, false);

		ExpandableListView expandableList = (ExpandableListView) v
				.findViewById(R.id.list);

		expandableList.setDividerHeight(2);
		expandableList.setGroupIndicator(null);
		expandableList.setClickable(true);

		ExpandableAdapter adapter = new ExpandableAdapter(MenuInfo.makeMenu());

		adapter.setInflater(inflater, getActivity());
		expandableList.setAdapter(adapter);
		expandableList
				.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

					@Override
					public boolean onChildClick(ExpandableListView arg0,
							View arg1, int arg2, int arg3, long arg4) {
						Toast.makeText(getActivity(),
								R.string.added_to_order_toast,
								Toast.LENGTH_SHORT).show();
						Order.myOrder.addItem(MenuInfo.makeMenu().get(arg2)
								.getMenuItems().get(arg3));
						return true;
					}
				});
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
		}
		return v;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			if (NavUtils.getParentActivityName(getActivity()) != null)
				NavUtils.navigateUpFromSameTask(getActivity());
			return true;
		} else if (item.getItemId() == R.id.menu_checkout) {
			Intent i = new Intent(getActivity(), CheckoutActivity.class);
			startActivity(i);
			return true;
		}

		else {

			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.fragment_menu, menu);
	}

}