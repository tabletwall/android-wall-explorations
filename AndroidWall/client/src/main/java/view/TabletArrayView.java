package view;

import java.util.List;

/**
 * Created by zherr on 3/12/14.
 */
public class TabletArrayView {

    private List<TabletView> tabletViewList = null;

    public TabletArrayView(List<TabletView> tabletViewList) {
        this.tabletViewList = tabletViewList;
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
     * @param tabletViewList - The tablet view list
     */
    public void setTabletViewList(List<TabletView> tabletViewList) {
        this.tabletViewList = tabletViewList;
    }
}
