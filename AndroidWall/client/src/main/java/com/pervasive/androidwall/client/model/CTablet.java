package com.pervasive.androidwall.client.model;

import android.graphics.Rect;

/**
 * Created by zherr on 3/13/14.
 */
public class CTablet implements ITablet {

    private int tabletId;
    private Rect screenRectangle;

    public CTablet() {
    }

    public CTablet(int tabletId, Rect screenRectangle) {
        this.tabletId = tabletId;
        this.screenRectangle = screenRectangle;
    }

    @Override
    public void setTabletId(int tabletId) {
        this.tabletId = tabletId;
    }

    @Override
    public int getTabletId() {
        return tabletId;
    }

    @Override
    public void setScreenRectangle(Rect rectangle) {
        this.screenRectangle = rectangle;
    }

    @Override
    public Rect getScreenRectangle() {
        return screenRectangle;
    }
}
