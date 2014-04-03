package com.pervasive.androidwall.client.model;

import java.util.List;

/**
 * Created by zherr on 3/12/14.
 */
public interface ITabletArray {

    /**
     * Sets the tablet array
     * @param tabletArray - The tablet array
     */
    public void setTabletArray(List<ITablet> tabletArray);

    /**
     * Gets the tablet array
     * @return ArrayList<ITablet> - The tablet array
     */
    public List<ITablet> getTabletArray();

    /**
     * Gets a tablet by its Id from the tablet array
     * @param tabletId - The tablet Id
     * @return ITablet - null, or the ITablet found
     */
    public ITablet getTabletById(String tabletId);

    /**
     * Adds a tablet to the tablet array
     * @param tablet - The tablet to add
     */
    public void addTablet(ITablet tablet);

    /**
     * Removes a tablet from the array
     * @param tablet - The tablet to remove
     */
    public void removeTablet(ITablet tablet);
}
