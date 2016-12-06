package com.maxbassoul.app.myjumper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.maxbassoul.app.myjumper.com.maxbassoul.app.myjumper.engine.Game;


public class MainActivity extends AppCompatActivity {

    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        FrameLayout container = (FrameLayout) findViewById(R.id.container);
        this.game = new Game(this);
        container.addView(game);
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.game.cancela();
    }

    @Override
    protected void onResume(){
        super.onResume();
        this.game.inicia();
        new Thread(game).start();
    }
}
