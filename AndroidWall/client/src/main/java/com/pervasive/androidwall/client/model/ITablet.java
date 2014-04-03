package com.pervasive.androidwall.client.model;

import android.graphics.Rect;

/**
 * Created by zherr on 3/12/14.
 */
public interface ITablet {

    /**
     * Sets the tablet's id
     * @param tabletId - The tablet id
     */
    public void setTabletId(String tabletId);

    /**
     * Gets the tablet's id
     * @return int - The tablet's id
     */
    public String getTabletId();

    /**
     * Sets the tablet's screen rectangle
     * @param rectangle - The rectangle to set the tablet's screen to
     */
    public void setScreenRectangle(Rect rectangle);

    /**
     * Gets the tablet's screen rectangle
     * @return Rect - The tablet's screen rectangle
     */
    public Rect getScreenRectangle();
}
