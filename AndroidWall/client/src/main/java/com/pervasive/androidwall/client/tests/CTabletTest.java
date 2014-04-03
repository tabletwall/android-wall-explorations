package com.pervasive.androidwall.client.tests;

import android.graphics.Rect;
import android.test.AndroidTestCase;

import com.pervasive.androidwall.client.model.CTablet;

/**
 * Created by zherr on 3/13/14.
 */
public class CTabletTest extends AndroidTestCase{

    CTablet tablet;

    @Override
    public void setUp() throws Exception {
        tablet = new CTablet("0", new Rect(0, 0, 0, 0));
    }

    public void testSetTabletId() throws Exception {
        tablet.setTabletId("1");
        assertEquals(1, tablet.getTabletId());
    }

    public void testGetTabletId() throws Exception {
        assertEquals(0, tablet.getTabletId());
    }

    public void testSetScreenRectangle() throws Exception {
        tablet.setScreenRectangle(new Rect(1, 1, 1, 1));
        assertNotNull(tablet.getScreenRectangle());
    }

    public void testGetScreenRectangle() throws Exception {
        assertNotNull(tablet.getScreenRectangle());
    }
}
