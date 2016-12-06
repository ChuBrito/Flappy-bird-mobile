package com.maxbassoul.app.myjumper.com.maxbassoul.app.myjumper.elementos;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.maxbassoul.app.myjumper.com.maxbassoul.app.myjumper.graficos.Cores;
import com.maxbassoul.app.myjumper.com.maxbassoul.app.myjumper.graficos.Tela;

/**
 * Created by Diego on 07/12/2015.
 */
public class Cano {
    private static final int TAMANHO_DO_CANO = 250;
    private static final int LARGURA_DO_CANO = 100;

    private final Tela tela;

    private int alturaDoCanoInferior;
    private int alturaDoCanoSuperior;
    private int posicao;

    private static final Paint VERDE = Cores.getCorDoCano();

    public Cano(Tela tela, int posicao) {
        this.tela = tela;
        this.posicao = posicao;
        this.alturaDoCanoInferior = tela.getAltura() - TAMANHO_DO_CANO - valorAleatorio();
        this.alturaDoCanoSuperior = 0 + TAMANHO_DO_CANO + valorAleatorio();
    }

    private int valorAleatorio() {
        return (int) (Math.random() * 150);
    }

    public void desenhaNo(Canvas canvas){
        desenhaCanoSuperiorNo(canvas);
        desenhaCanoInferiorNo(canvas);
    }

    private void desenhaCanoSuperiorNo(Canvas canvas) {
        canvas.drawRect(posicao, 0, posicao + LARGURA_DO_CANO, alturaDoCanoSuperior, VERDE);
    }

    private void desenhaCanoInferiorNo(Canvas canvas) {
        canvas.drawRect(posicao, alturaDoCanoInferior, posicao + LARGURA_DO_CANO, tela.getAltura(), VERDE);
    }
    public void move(){
        posicao -= 5;
    }

    public boolean saiuDaTela() {
        return posicao + LARGURA_DO_CANO < 0;
    }

    public int getPosicao() {
        return posicao;
    }

    public boolean temColisaoVerticalCom(Passaro passaro){
        return passaro.getAltura() - Passaro.RAIO <
                this.alturaDoCanoSuperior
                || passaro.getAltura() + Passaro.RAIO >
                this.alturaDoCanoInferior;
    }
    public boolean temColisaoHorizontalCom(Passaro passaro){
        return this.posicao - Passaro.X < Passaro.RAIO;
    }
}
