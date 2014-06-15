package com.leeandjosh.restauranttemplate;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ExpandableAdapter extends BaseExpandableListAdapter {

	private Activity activity;
	private LayoutInflater inflater;
	private ArrayList<MenuCatagory> parentItems;

	public ExpandableAdapter(ArrayList<MenuCatagory> parents) {
		this.parentItems = parents;
	}

	public void setInflater(LayoutInflater inflater, Activity activity) {
		this.inflater = inflater;
		this.activity = activity;
	}

	@Override
	public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {


		List<MenuSelection> menuItems = parentItems.get(groupPosition).getMenuItems();


		TextView textView = null;

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.menu_parent_elements, null);
		}

		textView = (TextView) convertView.findViewById(R.id.menu_item_name);
		textView.setText(menuItems.get(childPosition).getName());
		textView=(TextView) convertView.findViewById(R.id.menu_item_price);
		textView.setText("$"+menuItems.get(childPosition).getPrice()+".00");
		Button addToCartButton = (Button) convertView.findViewById(R.id.add_to_cart_button);
		addToCartButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				AlertDialog.Builder builder = new AlertDialog.Builder(activity);
				builder.setMessage("Do you want to add to cart?");
				builder.setCancelable(false);
				builder.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						MenuSelection addedItem = parentItems.get(groupPosition).getMenuItems().get(childPosition);
						MenuCatagory catagory = parentItems.get(groupPosition);
						;                        Order.myOrder.addItem(addedItem);
						notifyDataSetChanged();
						Context context = activity;
						CharSequence text = "Added To Cart";
						int duration = Toast.LENGTH_SHORT;

						Toast toast = Toast.makeText(context, text, duration);
						toast.show();
					}
				});
				builder.setNegativeButton("No",
						new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});
				AlertDialog alertDialog = builder.create();
				alertDialog.show();


			}

		});
		return convertView;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.menu_child_elements, null);
		}

		((TextView) convertView).setText(parentItems.get(groupPosition).getName());

		//		((TextView) convertView).setChecked(isExpanded);
		return convertView;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return parentItems.get(groupPosition).getMenuItems().get(childPosition);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return parentItems.get(groupPosition).getMenuItems().size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return parentItems.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		return parentItems.size();
	}

	@Override
	public void onGroupCollapsed(int groupPosition) {
		super.onGroupCollapsed(groupPosition);
	}

	@Override
	public void onGroupExpanded(int groupPosition) {
		super.onGroupExpanded(groupPosition);
	}

	@Override
	public long getGroupId(int groupPosition) {
		return 0;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

}