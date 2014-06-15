package com.leeandjosh.restauranttemplate;

import java.util.ArrayList;
import java.util.List;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class CheckoutFragment extends ListFragment {
	private int updateSpinner;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		updateAdapter();
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
		}
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	protected void updateAdapter() {
		updateSpinner--;
		List<MenuSelection> menuList = new ArrayList<MenuSelection>();
		menuList.addAll(Order.myOrder.getMenuItems().keySet());
		CheckoutAdapter adapter = new CheckoutAdapter(menuList);
		setListAdapter(adapter);
		setHasOptionsMenu(true);
	}




	private class CheckoutAdapter extends ArrayAdapter<MenuSelection> {
		public CheckoutAdapter(List<MenuSelection> item) {
			super(getActivity(), 0, item);
		} 
		@TargetApi(Build.VERSION_CODES.HONEYCOMB)
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// If we weren't given a view, inflate one
			if (convertView == null) {
				convertView = getActivity().getLayoutInflater()
						.inflate(R.layout.fragment_checkout, null);
			}
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
				getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
			}

			MenuSelection item = getItem(position);

			TextView titleTextView = 
					(TextView)convertView.findViewById(R.id.order_item_name);
			titleTextView.setText(item.getName());
			TextView priceTextView = 
					(TextView)convertView.findViewById(R.id.order_item_price);
			priceTextView.setText("$"+Order.myOrder.getMenuItems().get(item) * item.getPrice() + ".00");

			Button removeButton = (Button) convertView.findViewById(R.id.remove_from_order);
			removeButton.setOnClickListener(new RemoveOnClickListener(item));


			Spinner spinner = (Spinner) convertView.findViewById(R.id.quantity_choice);
			// Create an ArrayAdapter using the string array and a default spinner layout
			ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
					R.array.quantity_choice, R.layout.spinner_layout);
			// Specify the layout to use when the list of choices appears
			adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			// Apply the adapter to the spinner

			spinner.setAdapter(adapter);
			spinner.setSelection(adapter.getPosition(Order.myOrder.getMenuItems().get(item).toString()));
			updateSpinner--;
			spinner.setOnItemSelectedListener(new SpinnerActivity(item));


			return convertView;
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId()==android.R.id.home){
			if (NavUtils.getParentActivityName(getActivity()) != null) 
				NavUtils.navigateUpFromSameTask(getActivity());
			return true;
		}
		else if(item.getItemId()==R.id.menu_place_order){
			Intent i = new Intent(getActivity(),DeliveryActivity.class);
			startActivity(i);
			return true;
		}

		else{

			return super.onOptionsItemSelected(item);
		}
	}
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.fragment_checkout, menu);
	}


	public class SpinnerActivity extends Activity implements OnItemSelectedListener {
		private MenuSelection myItem;
		public SpinnerActivity(MenuSelection item){
			myItem=item;
		}
		public void onItemSelected(AdapterView<?> parent, View view, 
				int pos, long id) {
			// An item was selected. You can retrieve the selected item using
			// parent.getItemAtPosition(pos)
			
			updateSpinner++;
			Log.d("hangK", updateSpinner+"");
			if(updateSpinner>=0){
				String quantity = (String) parent.getItemAtPosition(pos);
				Order.myOrder.updateQuantity(myItem, Integer.valueOf(quantity));
				updateAdapter();
			}


		}

		public void onNothingSelected(AdapterView<?> parent) {
			// Another interface callback
		}
	}
	public class RemoveOnClickListener implements OnClickListener{

		MenuSelection myItem;
		public RemoveOnClickListener(MenuSelection item) {
			myItem = item;
		}

		@Override
		public void onClick(View v){
			Order.myOrder.removeItem(myItem);
			updateSpinner++;
			updateAdapter();
		}

	};




}