package com.pervasive.androidwall.client.tests;

import android.graphics.Rect;
import android.test.AndroidTestCase;

import java.util.ArrayList;

import com.pervasive.androidwall.client.model.CTablet;
import com.pervasive.androidwall.client.model.CTabletArray;
import com.pervasive.androidwall.client.model.ITablet;

/**
 * Created by zherr on 3/13/14.
 */
public class CTabletArrayTest extends AndroidTestCase {

    CTabletArray tabletArray;
    CTablet aTablet;

    @Override
    public void setUp() throws Exception {
        tabletArray = new CTabletArray(new ArrayList<ITablet>());
        aTablet = new CTablet(0, new Rect(0, 0, 0, 0));
        tabletArray.addTablet(aTablet);
    }

    public void testSetTabletArray() throws Exception {
        tabletArray.setTabletArray(new ArrayList<ITablet>());
        assertNotNull(tabletArray.getTabletArray());
    }

    public void testGetTabletArray() throws Exception {
        assertNotNull(tabletArray.getTabletArray());
    }

    public void testGetTabletById() throws Exception {
        CTablet temp = null;
        temp = (CTablet) tabletArray.getTabletById(0);
        assertNotNull(temp);
    }

    public void testAddTablet() throws Exception {
        tabletArray.addTablet(new CTablet(1, new Rect(1, 1, 1, 1)));
        assertNotNull(tabletArray.getTabletById(1));
    }

    public void testRemoveTablet() throws Exception {
        tabletArray.removeTablet(aTablet);
        assertNull(tabletArray.getTabletById(0));
    }
}
