package com.maxbassoul.app.myjumper.com.maxbassoul.app.myjumper.elementos;

import android.graphics.Canvas;

import com.maxbassoul.app.myjumper.com.maxbassoul.app.myjumper.graficos.Tela;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Diego on 07/12/2015.
 */
public class Canos {
    private List<Cano> canos = new ArrayList<Cano>();
    private static final int QUANTIDADE_DE_CANOS = 5;
    private static final int DISTANCIA_ENTRE_CANOS = 250;
    private Tela tela;
    private Pontuacao pontuacao;

    public void desenhaNo(Canvas canvas){
        for (Cano cano : canos){
            cano.desenhaNo(canvas);
        }
    }
    public Canos(Tela tela, Pontuacao pontuacao){
        this.tela = tela;
        this.pontuacao = pontuacao;
        int posicaoInicial = 200;

        for(int i=0; i < QUANTIDADE_DE_CANOS; i++){
            posicaoInicial += DISTANCIA_ENTRE_CANOS;
            canos.add(new Cano(tela, posicaoInicial));
        }
    }
    public void move(){
        ListIterator<Cano> iterator = canos.listIterator();
        while(iterator.hasNext()){
            Cano cano = (Cano) iterator.next();
            cano.move();
            if(cano.saiuDaTela()){
                pontuacao.aumenta();
                iterator.remove();
                Cano outroCano = new Cano(tela, getMaximo() + DISTANCIA_ENTRE_CANOS);
                iterator.add(outroCano);
            }
        }
    }
    private int getMaximo(){
        int maximo = 0;
        for(Cano cano : canos){
            maximo = Math.max(cano.getPosicao(), maximo);
        }
        return maximo;
    }
    public boolean temColisaoCom(Passaro passaro){
        for(Cano cano : canos){
            if(cano.temColisaoHorizontalCom(passaro) && cano.temColisaoVerticalCom(passaro)){
                return true;
            }
        }
        return false;
    }

}
