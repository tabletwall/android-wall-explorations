package com.pervasive.androidwall.client.controller;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.pervasive.androidwall.client.view.TabletView;

/**
 * Created by zherr on 3/20/14.
 */
public class DefaultTabletViewDraggable implements View.OnDragListener {

    private Context appContext;
    private android.widget.RelativeLayout.LayoutParams layoutParams;

    public DefaultTabletViewDraggable(Context appContext) {
        this.appContext = appContext;
    }
    @Override
    public boolean onDrag(View view, DragEvent dragEvent) {

        final int action = dragEvent.getAction();
        String msg = "default";

        switch(action)
        {
            case DragEvent.ACTION_DRAG_STARTED:
                Log.d(msg, "Action is DragEvent.ACTION_DRAG_STARTED");
                if(dragEvent.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                    layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    view.invalidate();
                    return true;
                } else {
                    return false;
                }
            case DragEvent.ACTION_DRAG_ENTERED:
                Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENTERED");
                return true;
            case DragEvent.ACTION_DRAG_LOCATION  :
                Log.d(msg, "Action is DragEvent.ACTION_DRAG_LOCATION");
                int x_cord = (int) dragEvent.getX();
                int y_cord = (int) dragEvent.getY();
                view.setX(x_cord);
                view.setY(y_cord);
                view.invalidate();
                return true;
            case DragEvent.ACTION_DRAG_EXITED :
                Log.d(msg, "Action is DragEvent.ACTION_DRAG_EXITED");
                x_cord = (int) dragEvent.getX();
                y_cord = (int) dragEvent.getY();
                layoutParams.leftMargin = x_cord;
                layoutParams.topMargin = y_cord;
                view.invalidate();
                return true;
            case DragEvent.ACTION_DROP:
                Log.d(msg, "ACTION_DROP event");
                ClipData.Item item = dragEvent.getClipData().getItemAt(0);
                CharSequence dragData = item.getText();
                Toast.makeText(appContext, "Dragged data is " + dragData, Toast.LENGTH_LONG).show();
                x_cord = (int) dragEvent.getX();
                y_cord = (int) dragEvent.getY();
                view.setX(x_cord);
                view.setY(y_cord);
                layoutParams.leftMargin = x_cord;
                layoutParams.topMargin = y_cord;
                view.invalidate();
//                View v = (View) dragEvent.getLocalState();
//                ViewGroup owner = (ViewGroup) view.getParent();
//                owner.removeView(v);
//                TabletView container = (TabletView) view;
//                container.addView(v);
//                view.setVisibility(v.VISIBLE)
                return true;
            case DragEvent.ACTION_DRAG_ENDED   :
                Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENDED");
                if(dragEvent.getResult()) {
                    Toast.makeText(appContext, "The drop was handled", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(appContext, "The drop was NOT handled", Toast.LENGTH_LONG).show();
                }
                return true;
            default:
                Log.e("DragDrop Example","Unknown action type received by OnDragListener.");
                break;
        }
        return true;
    }
}
