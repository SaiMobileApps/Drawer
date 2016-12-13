package com.saimobileapps.androidsamples;

import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class DrawerSampleActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawer_layout;
    ActionBarDrawerToggle mDrawerToggle;
    TextView titletool, userNameTextView;
    ListView left_drawer_listview;
    DrawerListViewAdapter listViewAdapter;
    ArrayList<DrawerList> _drawerList;
    LinearLayout HomesActivityDrawerListViewLL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_sample_activity);
        initUI();
        loadDrawerMenu();
    }
    //Drawer Animation Attach
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    void loadDrawerMenu() {
        final String[] listOfItemsForListView = getResources().getStringArray(R.array.drawerListViewArrayHavingAds);
        _drawerList = new ArrayList<DrawerList>();
        for (int i = 0; i < listOfItemsForListView.length; i++) {
            _drawerList.add(new DrawerList(GetDrawerImages(i), listOfItemsForListView[i], false));
        }
        listViewAdapter = new DrawerListViewAdapter(DrawerSampleActivity.this, _drawerList);
        left_drawer_listview.setAdapter(listViewAdapter);
        drawer_layout.setDrawerListener(mDrawerToggle);
        left_drawer_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listViewAdapter.setItemSelected(position);//Highlight Selected Row
                //Load your fragment or start activity
            }
        });

    }
    //region Drawer
    public int GetDrawerImages(int id) {
        int _ResourceId = 0;
        switch (id) {
            case 0:
                _ResourceId = R.drawable.newicon;//"Find Nearest Temple",
                break;
            case 1:
                _ResourceId = R.drawable.newicon;  //"All Temples"
                break;
            case 2:
                _ResourceId = R.drawable.newicon;//"Rate Us"
                break;
            case 3:
                _ResourceId = R.drawable.newicon;//"Tell Your Friends"
                break;
            case 4:
                _ResourceId = R.drawable.newicon;//"Feedback""
                break;
            case 5:
                _ResourceId = R.drawable.newicon;//"About Us"
                break;
            case 6:
                _ResourceId = R.drawable.newicon;//"Language"
                break;
        }
        return _ResourceId;
    }


    //Initialize elements and register events
    void initUI() {
        toolbar = (Toolbar) findViewById(R.id.homeToolBar);
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        left_drawer_listview = (ListView) findViewById(R.id.left_drawer_listview);
        titletool = (TextView) findViewById(R.id.titletool);
        HomesActivityDrawerListViewLL = (LinearLayout) findViewById(R.id.HomesActivityDrawerListViewLL);
//        userNameTextView = (TextView) findViewById(R.id.userNameTextView);
//        userNameTextView.setTextColor(ContextCompat.getColor(this,android.R.color.white));
        mDrawerToggle = new ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
    }
}


