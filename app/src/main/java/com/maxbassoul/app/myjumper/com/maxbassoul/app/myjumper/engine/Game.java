package com.maxbassoul.app.myjumper.com.maxbassoul.app.myjumper.engine;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.maxbassoul.app.myjumper.MainActivity;
import com.maxbassoul.app.myjumper.R;
import com.maxbassoul.app.myjumper.com.maxbassoul.app.myjumper.elementos.Cano;
import com.maxbassoul.app.myjumper.com.maxbassoul.app.myjumper.elementos.Canos;
import com.maxbassoul.app.myjumper.com.maxbassoul.app.myjumper.elementos.GameOver;
import com.maxbassoul.app.myjumper.com.maxbassoul.app.myjumper.elementos.Passaro;
import com.maxbassoul.app.myjumper.com.maxbassoul.app.myjumper.elementos.Pontuacao;
import com.maxbassoul.app.myjumper.com.maxbassoul.app.myjumper.graficos.Tela;

/**
 * Created by Diego on 07/12/2015.
 */
public class Game extends SurfaceView implements Runnable, View.OnTouchListener {
    private Cano cano;
    private boolean isRunning = true;
    private Passaro passaro;
    private Bitmap background;
    private Tela tela;
    private Canos canos;
    private Pontuacao pontuacao;
    private Context context;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        passaro.pula();
        return false;
    }

    private final SurfaceHolder holder = getHolder();

    public Game(Context context) {
        super(context);
        this.context = context;
        this.tela = new Tela(context);
        inicializaElementos();
        setOnTouchListener((OnTouchListener) this);
    }

    private void inicializaElementos() {
        this.passaro = new Passaro(tela, context);
        this.pontuacao = new Pontuacao();
        this.canos = new Canos(tela, pontuacao);

        Bitmap back = BitmapFactory.decodeResource(
                getResources(),
                R.drawable.background
        );
        this.background = Bitmap.createScaledBitmap(
                back, back.getWidth(), tela.getAltura(), false);

    }

    @Override
    public void run() {
        while(isRunning){
            if(!holder.getSurface().isValid())continue;
            Canvas canvas = holder.lockCanvas();

            canvas.drawBitmap(background, 0, 0, null);

            passaro.desenhaNo(canvas);
            passaro.cai();
            canos.desenhaNo(canvas);
            canos.move();
            pontuacao.desenhaNo(canvas);

            if(new VerificadorDeColisao(passaro, canos).temColisao()){
                new GameOver(tela).desenhaNo(canvas);
                isRunning = false;
            }
            //Restart
            if(isRunning == false){
                try{
                    Thread.sleep(1000);


                }catch (Exception e){

                }
                Intent i = new Intent(context, MainActivity.class);
                context.startActivity(i);

            }

            holder.unlockCanvasAndPost(canvas);
        }
    }


    public void cancela(){
        this.isRunning = false;
    }

    public void inicia(){
        this.isRunning = true;
    }

}
