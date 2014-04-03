package com.pervasive.androidwall.client.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zherr on 3/13/14.
 */
public class CTabletArray implements ITabletArray {

    private List<ITablet> tabletArray;

    public CTabletArray() {
    }

    public CTabletArray(ArrayList<ITablet> tabletArray) {
        this.tabletArray = tabletArray;
    }

    @Override
    public void setTabletArray(List<ITablet> tabletArray) {
        this.tabletArray = tabletArray;
    }

    @Override
    public List<ITablet> getTabletArray() {
        return tabletArray;
    }

    @Override
    public ITablet getTabletById(String tabletId) {
        ITablet tabletFound = null;
        for(ITablet t : tabletArray) {
            if(t.getTabletId().equals(tabletId)) {
                tabletFound = t;
                break;
            }
        }
        return tabletFound;
    }

    @Override
    public void addTablet(ITablet tablet) {
        tabletArray.add(tablet);
    }

    @Override
    public void removeTablet(ITablet tablet) {
        tabletArray.remove(tablet);
    }
}
