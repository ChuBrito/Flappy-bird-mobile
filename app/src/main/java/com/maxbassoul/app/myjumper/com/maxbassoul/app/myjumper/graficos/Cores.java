package com.maxbassoul.app.myjumper.com.maxbassoul.app.myjumper.graficos;

import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * Created by Diego on 07/12/2015.
 */
public class Cores{
    public static Paint getCorDoPassaro(){
        Paint vermelho = new Paint();
        vermelho.setColor(0xFFFF0000);
        return vermelho;
    }
    public static Paint getCorDoCano(){
        Paint verde = new Paint();
        verde.setColor(0xFF00FF00);
        return verde;
    }
    public static Paint getCorDaPontuacao(){
        Paint branco = new Paint();
        branco.setTextSize(80);
        branco.setColor(0xFFFFFFFF);
        branco.setTypeface(Typeface.DEFAULT_BOLD);
        branco.setShadowLayer(3, 5, 5, 0xFF000000);
        return branco;
    }
    public static Paint getCorDoGameOver(){
        Paint vermelho = new Paint();
        vermelho.setColor(0xFFFF0000);
        vermelho.setTextSize(50);
        vermelho.setTypeface(Typeface.DEFAULT_BOLD);
        vermelho.setShadowLayer(2, 3, 3, 0xFF000000);
        return vermelho;
    }
}
