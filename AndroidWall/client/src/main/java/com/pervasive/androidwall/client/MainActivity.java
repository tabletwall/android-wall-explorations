package com.pervasive.androidwall.client;

import android.graphics.Rect;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.pervasive.androidwall.client.model.CTablet;
import com.pervasive.androidwall.client.view.TabletView;


public class MainActivity extends ActionBarActivity {

    private TabletView tabletView;
    private CTablet tablet;
    private final Rect defaultRect = new Rect(0, 0, 50, 50);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tablet = new CTablet(0, defaultRect);
        tabletView = (TabletView) findViewById(R.id.tabletview);
        tabletView.setTablet(tablet);
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

}
