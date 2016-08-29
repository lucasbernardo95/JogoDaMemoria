package br.com.eaj.ufrn.lucas.jogodamemoria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Collections;

public class gameActivity extends AppCompatActivity {

    ArrayList<Integer> ordem; //Armazena a ordem em que os jogadores irão iniciar as jogadas
    ArrayList<Jogador> jogadores; // Armazena os jogadores

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

        // Recupera o ArrayList contendo os jogadores setatos na tela de seleção
        jogadores = pacote.getParcelableArrayList("jogadores");

        // chama o método para gerar a sequência de jogadores.
        Jogador.gerarSequenciaJogadores(jogadores.size(), new ArrayList<Integer>());//"Teste analogia com linguagem C" passa o endereço de memória do array

        Tabuleiro.inicializarTabuleiro();

        Log.i("id" , "recurso da imagem 1" + R.id.imb1);
        Log.i("id" , "recurso da imagem 1" + R.drawable.ekko);

    }

    protected void atribuirImagensAoTabuleiro(View v){
        ImageButton imb = (ImageButton) findViewById(R.id.imb1);
        int id =(int ) R.id.imb1;
    }


}
