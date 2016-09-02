package br.com.eaj.ufrn.lucas.jogodamemoria;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Lucas on 24/08/2016.
 */
public class Tabuleiro {

    private static final int LINHAS = 5; // quantidade de linhas que o tabuleiro irá ter
    private static final int COLUNAS = 5; // quantidade de colunas

    // Define a ordem em que as cartas irão ser geradas no tabuleiro
    public static void inicializarTabuleiro(ArrayList<Carta> cartas, ArrayList<Integer> botoes){
;
        //Associa o id de um botão aleatório a uma imagem que será exibida ao ser clicada
        int i = 0;
        for (Carta c : cartas) {
            c.setIdBotao(botoes.get(i));
            ++i;
        }

    }

    //Cria uma lista contendo todos os ids dos botões e depois irá embaralhar a ordem que esses foram
    //inseridos na lista
    public static void definiListaBotao(ArrayList<Integer> botoes){

        botoes.add(R.id.imb1);
        botoes.add(R.id.imb2);
        botoes.add(R.id.imb3);
        botoes.add(R.id.imb4);
        botoes.add(R.id.imb5);
        botoes.add(R.id.imb6);
        botoes.add(R.id.imb7);
        botoes.add(R.id.imb8);
        botoes.add(R.id.imb9);
        botoes.add(R.id.imb10);
        botoes.add(R.id.imb11);
        botoes.add(R.id.imb12);
        botoes.add(R.id.imb13);
        botoes.add(R.id.imb14);
        botoes.add(R.id.imb15);
        botoes.add(R.id.imb16);
        botoes.add(R.id.imb17);
        botoes.add(R.id.imb18);
        botoes.add(R.id.imb19);
        botoes.add(R.id.imb20);
        botoes.add(R.id.imb21);
        botoes.add(R.id.imb22);
        botoes.add(R.id.imb23);
        botoes.add(R.id.imb24);
        botoes.add(R.id.imb25);
        Collections.shuffle(botoes); // Embaralha os ids da lista

    }

}
