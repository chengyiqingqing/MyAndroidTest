package com.meitu.sww.testcustomviewcollection.util;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;

/**
 * @author ShaoWenWen
 * @date 2019/3/24
 */
public class DeviceUtil {

    public static int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;

    public static int getScreenWidth() {
        return screenWidth;
    }

    public static int getScreenHeight(Activity context) {
        Display display = context.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.y;
    }

    public static int dpToPx(int dpValue){
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
