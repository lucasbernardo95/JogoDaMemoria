package br.com.eaj.ufrn.lucas.jogodamemoria;

import android.util.Log;
import android.view.View;
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

    // Define a ordem em que as cartas irão ser geradas no tabuleiro
    public static void inicializarTabuleiro(){

        ordemTabuleiro = new ArrayList<>();
        /**
         * Preenche o tabuleiro da seguinte forma:
         * a primeira parte da 'matriz' será preenchida com o valor de i, que irá de 1 à 12
         * a segunda metade com o valor de j, que vai de 24 à 13. Dessa forma irá sobrar uma posição
         * que refere-se a posição reservada para a carta coringa.
         * Assim só serão necessárias 12 voltas, no laço, para preencher a ordem da matriz.
         */

        for (int i = 1, j = (LINHAS * COLUNAS) - 1; i <= (LINHAS * COLUNAS) / 2; i++, j--){

            ordemTabuleiro.add(i);
            ordemTabuleiro.add(j);

        }// adiciona um valor que refere-se ao conringa
        ordemTabuleiro.add(0);

        // Embaralha a ordem dos elementos do array, assim, defini-se uma ordem aleatória para o início das cartas
        Collections.shuffle(ordemTabuleiro);

;
    }


}
