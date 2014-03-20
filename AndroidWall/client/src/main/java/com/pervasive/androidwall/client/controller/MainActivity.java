package com.pervasive.androidwall.client.controller;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.pervasive.androidwall.client.R;
import com.pervasive.androidwall.client.model.CTablet;
import com.pervasive.androidwall.client.view.TabletView;


public class MainActivity extends ActionBarActivity {

    private TabletView tabletView;
    private CTablet tablet;
    private Rect defaultTabletRect;

    View ima;
    private static final String IMAGEVIEW_TAG = "Android Logo";
    String msg;
    private android.widget.RelativeLayout.LayoutParams layoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup model
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        defaultTabletRect = new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        tablet = new CTablet(0, defaultTabletRect);
        // Plugin model to view
        tabletView = (TabletView) findViewById(R.id.tabletview);
        tabletView.setTablet(tablet);

        // Note: to be changed later with other objects
        ima = (ImageView) findViewById(R.id.iv_logo);
        // Sets the tag
        ima.setTag(IMAGEVIEW_TAG);

        // Hook up the listeners
        setListeners();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setListeners() {
        // Old implementation commented
//        ima.setOnDragListener(new DefaultImageViewDraggable(this));
//        ima.setOnDragListener(new DefaultTabletViewDraggable(this));
//        tabletView.setOnDragListener(new DefaultTabletViewDraggable(this));
        ima.setOnTouchListener(new DefaultImageViewTouchHandler(this, tabletView));
    }
}
