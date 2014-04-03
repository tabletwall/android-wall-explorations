package com.pervasive.androidwall.client.controller;

import android.graphics.Rect;
import android.net.nsd.NsdServiceInfo;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.pervasive.androidwall.client.R;
import com.pervasive.androidwall.client.model.CTablet;
import com.pervasive.androidwall.client.service.CoordinateConnection;
import com.pervasive.androidwall.client.service.NsdHelper;
import com.pervasive.androidwall.client.view.TabletView;


public class MainActivity extends ActionBarActivity {

    private TabletView tabletView;
    private CTablet tablet;
    private Rect defaultTabletRect;
    private int actionBarOffset;

    private View defaultImageView;
    private static final String IMAGEVIEW_TAG = "Android Logo";
    private static final String TAG = "MainActivity";

    private Handler coordHandler;
    private CoordinateConnection coordinateConnection;
    private NsdHelper nsdHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup model
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        Log.d("DISPLAY METRICS: ", displayMetrics.toString());

        // Get drawable space
        defaultTabletRect = new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        String deviceMacAddress = NsdHelper.getMACAddress("wlan0");
        Log.d(TAG, "Got MAC Address: " + deviceMacAddress);
        tablet = new CTablet(deviceMacAddress, defaultTabletRect);

        // Plugin model to view
        tabletView = (TabletView) findViewById(R.id.tabletview);
        tabletView.setTablet(tablet);

        // Calculate ActionBar height
        TypedValue tv = new TypedValue();
        if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true))
        {
            actionBarOffset = TypedValue.complexToDimensionPixelSize(tv.data,getResources().getDisplayMetrics());
        }

        // Note: to be changed later with other objects
        defaultImageView = (ImageView) findViewById(R.id.iv_logo);
        // Sets the tag
        defaultImageView.setTag(IMAGEVIEW_TAG);


        // TODO need a way to distinguish own messages vs. peer messages
        coordHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                String msgString = msg.getData().getString("msg");

                String[] coordinates = msgString.split(",");
                final boolean isMyMessage = coordinates[0].equals(tablet.getTabletId());
                if(!isMyMessage && coordinates.length == 3) {
                    int x_sent = Integer.parseInt(coordinates[1]);
                    int y_sent = Integer.parseInt(coordinates[2]);

                    defaultImageView.setX(x_sent);
                    defaultImageView.setY(y_sent - actionBarOffset);
                }
            }
        };

        coordinateConnection = new CoordinateConnection(coordHandler);
        nsdHelper = new NsdHelper(this);
        nsdHelper.initializeNsd();

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
//        defaultImageView.setOnDragListener(new DefaultImageViewDraggable(this));
//        defaultImageView.setOnDragListener(new DefaultTabletViewDraggable(this));
//        tabletView.setOnDragListener(new DefaultTabletViewDraggable(this));
        defaultImageView.setOnTouchListener(new DefaultTabletViewTouchHandler(this, tabletView, tablet.getTabletId()));
    }

    public void clickAdvertise(View v) {
        // Register service
        if(coordinateConnection.getLocalPort() > -1) {
            nsdHelper.registerService(coordinateConnection.getLocalPort());
        } else {
            Log.d("MainActivity", "ServerSocket isn't bound.");
        }
    }

    public void clickConnect(View v) {
        NsdServiceInfo service = nsdHelper.getChosenServiceInfo();
        if (service != null) {
            Log.d("MainActivity", "Connecting.");
            coordinateConnection.connectToServer(service.getHost(),
                    service.getPort());
        } else {
            Log.d("MainActivity", "No service to connect to!");
        }
    }

    public CoordinateConnection getCoordinateConnection() {
        return this.coordinateConnection;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        coordinateConnection.tearDown();
        nsdHelper.tearDown();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (nsdHelper != null) {
            nsdHelper.stopDiscovery();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (nsdHelper != null) {
            nsdHelper.discoverServices();
        }
    }
}
