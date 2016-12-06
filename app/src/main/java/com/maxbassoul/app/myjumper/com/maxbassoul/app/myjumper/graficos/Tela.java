package com.maxbassoul.app.myjumper.com.maxbassoul.app.myjumper.graficos;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by Diego on 07/12/2015.
 */
public class Tela {
    private DisplayMetrics metrics;

    public Tela(Context context){
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        metrics = new DisplayMetrics();
        display.getMetrics(metrics);
    }


    public int getAltura() {
        return metrics.heightPixels;
    }

    public int getLargura() {
        return metrics.widthPixels;
    }
}
