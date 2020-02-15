package it.matteocorradin.tsupportlibrary.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class ScreenUtils {

    Context ctx;
    DisplayMetrics metrics;

    public ScreenUtils(Context ctx) {
        this.ctx = ctx;
        WindowManager wm = (WindowManager) ctx
                .getSystemService(Context.WINDOW_SERVICE);

        Display display = null;
        if (wm != null) {
            display = wm.getDefaultDisplay();
        }
        metrics = new DisplayMetrics();
        if (display != null) {
            display.getMetrics(metrics);
        }
    }

    public int getHeight() {
        return metrics.heightPixels;
    }

    public int getWidth() {
        return metrics.widthPixels;
    }

    public int getRealHeight() {
        return metrics.heightPixels / metrics.densityDpi;
    }

    public int getRealWidth() {
        return metrics.widthPixels / metrics.densityDpi;
    }

    public int getDensity() {
        return metrics.densityDpi;
    }

    public int getScale(int picWidth) {
        WindowManager manager = ((WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE));
        if (manager != null){
            Display display = manager.getDefaultDisplay();
            int width = display.getWidth();
            double val = (double) width / (double) picWidth;
            val = val * 100d;
            return (int) val;
        }
        return 1;
    }
}