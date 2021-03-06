package com.pervasive.androidwall.client.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.pervasive.androidwall.client.controller.MainActivity;
import com.pervasive.androidwall.client.model.CTablet;

/**
 * Created by zherr on 3/12/14.
 */
public class TabletView extends View {

    private CTablet tablet = null;
    private Paint tabletScreenRectPaint = null;
    private final MainActivity mainActivity;

    public TabletView(Context context) {
        super(context);
        mainActivity = (MainActivity) context;
        setFocusable(true);
        setFocusableInTouchMode(true);
        tabletScreenRectPaint = new Paint();
        tabletScreenRectPaint.setColor(Color.TRANSPARENT);
    }

    public TabletView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mainActivity = (MainActivity) context;
        setFocusable(true);
        setFocusableInTouchMode(true);
        tabletScreenRectPaint = new Paint();
        tabletScreenRectPaint.setColor(Color.TRANSPARENT);
    }

    public TabletView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mainActivity = (MainActivity) context;
        setFocusable(true);
        setFocusableInTouchMode(true);
        tabletScreenRectPaint = new Paint();
        tabletScreenRectPaint.setColor(Color.TRANSPARENT);
    }

    /**
     * Sets this com.pervasive.androidwall.client.view's tablet
     * @param tablet - The tablet for the com.pervasive.androidwall.client.view
     */
    public void setTablet(CTablet tablet) {
        this.tablet = tablet;
    }

    public int getViewTabletWidth() {
        return this.tablet.getScreenRectangle().width();
    }

    public int getViewTabletHeight() {
        return this.tablet.getScreenRectangle().height();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // TODO
        canvas.drawRect(tablet.getScreenRectangle(), tabletScreenRectPaint);
    }
}
