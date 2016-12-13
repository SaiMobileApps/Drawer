package com.saimobileapps.androidsamples;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.support.v7.widget.SwitchCompat;
import java.util.ArrayList;

public class DrawerListViewAdapter extends BaseAdapter {

    public class DrawerListViewHolder {
        public ImageView itemImage;
        public TextView itemName;
    }

    public ArrayList<DrawerList> ListOfItems = new ArrayList<DrawerList>();
    Activity _context;
    int selectedItemPosition = -1;
    LinearLayout DrawerListViewTextViewLL;

    public void setItemSelected(int value) {
        this.selectedItemPosition = value;
        this.notifyDataSetChanged();
    }

    public DrawerListViewAdapter(Activity contextListItems, ArrayList<DrawerList> listOfItems) {
        this.ListOfItems = listOfItems;
        _context = contextListItems;
    }

    public ArrayList<DrawerList> GetListOfItems() {
        return this.ListOfItems;
    }

    @Override
    public int getCount() {
        return ListOfItems.size();
    }

    @Override
    public Object getItem(int position) {
        return ListOfItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View drawerLayout = convertView;
        DrawerListViewHolder holder;
        if (convertView == null) {
            drawerLayout = _context.getLayoutInflater().inflate(_context.getResources().getLayout(R.layout.drawer_listview), null);
            DrawerListViewTextViewLL = (LinearLayout) drawerLayout.findViewById(R.id.DrawerListViewTextViewLL);
            LinearLayout drawerListViewParentLL = (LinearLayout) drawerLayout.findViewById(R.id.drawerListViewParentLL);
            drawerListViewParentLL.setBackgroundColor(ContextCompat.getColor(_context,R.color.background));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                DrawerListViewTextViewLL.setBackground(ContextCompat.getDrawable(_context, R.drawable.layoutlistviewstyle));
            } else {
                DrawerListViewTextViewLL.setBackgroundDrawable(ContextCompat.getDrawable(_context, R.drawable.layoutlistviewstyle));
            }
            holder = new DrawerListViewHolder();
            holder.itemName = (TextView)drawerLayout.findViewById(R.id.DrawerListViewTextView);
            holder.itemImage = (ImageView) drawerLayout.findViewById(R.id.DrawerListViewImageView);
            drawerLayout.setTag(holder);
        } else {
            holder = (DrawerListViewHolder) drawerLayout.getTag();
        }

        if (ListOfItems.size() <= 0) {
            holder.itemName.setText("Empty List");
        } else {
            holder.itemImage.setImageDrawable(ContextCompat.getDrawable(_context, ListOfItems.get(position).image));
            holder.itemName.setText(ListOfItems.get(position).name);
            holder.itemName.setTextColor(ContextCompat.getColor(_context,R.color.borderColor));
            if (selectedItemPosition == position) {
                holder.itemName.setTextColor(ContextCompat.getColor(_context, R.color.selectedColor));
            } else {
                holder.itemName.setTextColor(ContextCompat.getColor(_context, R.color.unselectedColor));
            }
        }
        return drawerLayout;
    }

}