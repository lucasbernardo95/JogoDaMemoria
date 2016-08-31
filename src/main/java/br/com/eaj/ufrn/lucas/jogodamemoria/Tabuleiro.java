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
    private static List<Integer> ordemTabuleiro; // Armazena a ordem em que as cartas irão ser geradas no tabuleiro
    private  static List<Integer> botoes; //Armazena o id dos botões


    // Define a ordem em que as cartas irão ser geradas no tabuleiro
    public static void inicializarTabuleiro(ArrayList<Carta> cartas){
        Log.i("id" , "inicializarTabuleiro()");
        //ordemTabuleiro = new ArrayList<>();
        /**
         * Preenche o tabuleiro da seguinte forma:
         * a primeira parte da 'matriz' será preenchida com o valor de i, que irá de 1 à 12
         * a segunda metade com o valor de j, que vai de 24 à 13. Dessa forma irá sobrar uma posição
         * que refere-se a posição reservada para a carta coringa.
         * Assim só serão necessárias 12 voltas, no laço, para preencher a ordem da matriz.
         */
        definiListaBotao();
        int i = 0;
        for (Carta c : cartas){

            cartas.get(i).setIdBotao(botoes.get(i));
            i++;

        }// adiciona um valor que refere-se ao conringa
        //ordemTabuleiro.add(0);

        // Embaralha a ordem dos elementos do array, assim, defini-se uma ordem aleatória para o início das cartas
        //Collections.shuffle(ordemTabuleiro);

        //

;
    }

    //Tem que gerar um número aleatório e esse id será a posição que uma determinada carta será adicionada ao tabuleiro

    //Cria uma lista contendo todos os ids dos botões
    private static void definiListaBotao(){

        botoes = new ArrayList<>();
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
        Collections.shuffle(botoes);
        Log.i("id" , "definiListaBotao()");
    }

}
