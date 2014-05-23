package com.leeandjosh.restauranttemplate;

import java.util.ArrayList;

import android.app.ExpandableListActivity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

public class MenuFragment extends Fragment {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		setRetainInstance(true);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup parent, 
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_menu, parent, false);

		ExpandableListView expandableList = (ExpandableListView) v.findViewById(R.id.list);

		expandableList.setDividerHeight(2);
		expandableList.setGroupIndicator(null);
		expandableList.setClickable(true);

		MenuInfo menuInfo = new MenuInfo();
		ExpandableAdapter adapter = new ExpandableAdapter(menuInfo.myParentItems, menuInfo.myChildItems);

		adapter.setInflater((LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE), getActivity());
		expandableList.setAdapter(adapter);
		return v;
	}

	

}
