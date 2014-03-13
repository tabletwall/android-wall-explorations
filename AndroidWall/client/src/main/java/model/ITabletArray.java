package model;

/**
 * Created by zherr on 3/12/14.
 */
public interface ITabletArray {

    /**
     * Sets the tablet array
     * @param tabletArray - The tablet array
     */
    public void setTabletArray(ITablet[][] tabletArray);

    /**
     * Gets the tablet array
     * @return ITablet[][] - The tablet array
     */
    public ITablet[][] getTabletArray();
}
