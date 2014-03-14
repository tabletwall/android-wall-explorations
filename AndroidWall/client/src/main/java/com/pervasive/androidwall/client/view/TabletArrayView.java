package com.pervasive.androidwall.client.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import java.util.List;

/**
 * Created by zherr on 3/12/14.
 */
public class TabletArrayView extends View{

    private List<TabletView> tabletViewList = null;

    public TabletArrayView(Context context) {
        super(context);
    }

    /**
     * Gets the tablet views
     * @return List<TabletView> the tablet views
     */
    public List<TabletView> getTabletViewList() {
        return tabletViewList;
    }

    /**
     * Sets the tablet views
     * @param tabletViewList - The tablet com.pervasive.androidwall.client.view list
     */
    public void setTabletViewList(List<TabletView> tabletViewList) {
        this.tabletViewList = tabletViewList;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(TabletView tv : tabletViewList) {
            tv.invalidate();
        }
    }
}
