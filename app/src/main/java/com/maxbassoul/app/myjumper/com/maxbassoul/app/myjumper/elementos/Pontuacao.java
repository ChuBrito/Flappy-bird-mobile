package com.maxbassoul.app.myjumper.com.maxbassoul.app.myjumper.elementos;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.maxbassoul.app.myjumper.com.maxbassoul.app.myjumper.graficos.Cores;

/**
 * Created by Diego on 10/12/2015.
 */
public class Pontuacao {
    private static final Paint BRANCO = Cores.getCorDaPontuacao();
    private int pontos = 0;

    public void desenhaNo(Canvas canvas){
        canvas.drawText(String.valueOf(pontos), 100, 100,BRANCO);
    }

    public void aumenta(){
        this.pontos++;
    }
}
