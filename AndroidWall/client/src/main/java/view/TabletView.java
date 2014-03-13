package view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import model.ITablet;

/**
 * Created by zherr on 3/12/14.
 */
public class TabletView extends View {

    private ITablet tablet = null;

    public TabletView(Context context) {
        super(context);
    }

    public TabletView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TabletView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * Sets this view's tablet
     * @param tablet - The tablet for the view
     */
    public void setTablet(ITablet tablet) {
        this.tablet = tablet;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // TODO
        canvas.drawRect(tablet.getScreenRectangle(), new Paint());
    }
}
