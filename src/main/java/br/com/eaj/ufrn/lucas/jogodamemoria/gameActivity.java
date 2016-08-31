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
    ArrayList<Carta> cartas; // Armazena as cartas do jogo

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

        ordem = new ArrayList<Integer>();
        // chama o método para gerar a sequência de jogadores.
        Jogador.gerarSequenciaJogadores(jogadores.size(), ordem);

        cartas = new ArrayList<>();
        // Inicia a ondem em que as cartas serão geradas no tabuleiro
        Tabuleiro.inicializarTabuleiro(cartas);

        for (Carta c : cartas){
            System.out.println("carta = " + c.getId() + " id do botão = " + c.getIdBotao());
        }

    }

    /**
     * @param v: refere-se ao botão que está sendo clicado no xml
     */

    protected void revelarCarta(View v){
        System.out.println("Android lixo");
    }


}
