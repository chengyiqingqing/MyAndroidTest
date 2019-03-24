package com.meitu.sww.testoverdraw.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;

/**
 * @author ShaoWenWen
 * @date 2019/1/3
 */
public class DevicesUtils {

    public static int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;

    public static int getScreenHeight(Activity context) {
        Display display = context.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.y;
    }

    public static int getStatusBarHeight() {
        int resourceId = Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android");
        return resourceId > 0 ? Resources.getSystem().getDimensionPixelSize(resourceId) : 0;
    }

}
