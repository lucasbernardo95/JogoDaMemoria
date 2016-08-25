package br.com.eaj.ufrn.lucas.jogodamemoria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class gameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Recupera o pacote que foi enviado na seleção de jogadores que contém os nomes e quantidades dos jogadores
        Bundle pacote = getIntent().getExtras();

    }

    //Método para gerar a ordem em que os jogadores irão jogar
    protected void gerarSequenciaJogadores(){

    }
}
