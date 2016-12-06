package com.maxbassoul.app.myjumper.com.maxbassoul.app.myjumper.engine;

import com.maxbassoul.app.myjumper.com.maxbassoul.app.myjumper.elementos.Canos;
import com.maxbassoul.app.myjumper.com.maxbassoul.app.myjumper.elementos.Passaro;

/**
 * Created by Diego on 10/12/2015.
 */
public class VerificadorDeColisao {
    private final Passaro passaro;
    private final Canos canos;

    public VerificadorDeColisao(Passaro passaro, Canos canos){
        this.passaro = passaro;
        this.canos = canos;
    }

    public boolean temColisao(){
        return canos.temColisaoCom(passaro);
    }
}
