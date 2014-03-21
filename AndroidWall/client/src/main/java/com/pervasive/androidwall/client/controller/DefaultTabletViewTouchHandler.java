package com.pervasive.androidwall.client.controller;

import android.app.ActionBar;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.pervasive.androidwall.client.view.TabletView;

/**
 * Created by zherr on 3/20/14.
 * A touch listener for objects in the tablet view
 */
public class DefaultTabletViewTouchHandler implements View.OnTouchListener{

    private Context appContext;
    private TabletView tabletView;

    public DefaultTabletViewTouchHandler(Context appContext, TabletView tabletView) {
        this.appContext = appContext;
        this.tabletView = tabletView;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        switch(motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;

            case MotionEvent.ACTION_MOVE:

                int x_cord = (int) motionEvent.getRawX();
                int y_cord = (int) motionEvent.getRawY();

                final int tVHeight = tabletView.getViewTabletHeight();
                final int tVWidth = tabletView.getViewTabletWidth();

                // Take care of hitting view boundary
                if (x_cord > tVWidth - view.getWidth()/2) {
                    x_cord = tVWidth- view.getWidth()/2;
                }
                if (x_cord < 0 + view.getWidth()/2) {
                    x_cord = 0 + view.getWidth()/2;
                }
                if (y_cord > tVHeight - view.getHeight()/2 ) {
                    y_cord = tVHeight - view.getHeight()/2;
                }
                if (y_cord < 0 + view.getHeight()) {
                    y_cord = 0 + view.getHeight();
                }

                view.setX(x_cord - view.getWidth()/2);
                view.setY(y_cord - view.getHeight());
                break;
            default:
                break;
        }
        return true;
    }
}
