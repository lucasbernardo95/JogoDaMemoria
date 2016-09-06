package br.com.eaj.ufrn.lucas.jogodamemoria;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Lucas on 27/08/2016.
 */

public class Carta {

    private int id; //Representa o id da imagem
    private int idBotao; //Refere-se a qual botao irá exibir essa imagem, ou seja, a qual botão estará associado a essa imagem
    public boolean flip = false;

    public Carta(Integer id) {
        super();
        this.id = id;

    }
    public Carta(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFlip() {
        return flip;
    }

    public void setFlip(boolean flip) {
        this.flip = flip;
    }

    public int getIdBotao() {
        return idBotao;
    }

    public void setIdBotao(int idBotao) {
        this.idBotao = idBotao;
    }

    /**
     * @param cartas recebe um ArrayList onde serão armazenadas as cartas juntamente com seus pares
     * Método para criar uma lista com as cartas juntamente com suas cartas pares.
     * Essa lista conterá as cartas que serão exibidas na dela do jogo ao clicar nas imagens de interrocação
     */

    public static void instanciarCartas(ArrayList<Carta> cartas){

        cartas.add( new Carta(R.drawable.azir));
        cartas.add( new Carta(R.drawable.kindred));
        cartas.add( new Carta(R.drawable.ekko));
        cartas.add( new Carta(R.drawable.illaoi));
        cartas.add( new Carta(R.drawable.jax ));
        cartas.add( new Carta(R.drawable.velkoz));
        cartas.add( new Carta(R.drawable.lucian));
        cartas.add( new Carta(R.drawable.maokai));
        cartas.add( new Carta(R.drawable.ryze));
        cartas.add( new Carta(R.drawable.swain));
        cartas.add( new Carta(R.drawable.taliyah));
        cartas.add( new Carta(R.drawable.tryndamere));

        cartas.add( new Carta(R.drawable.azir));
        cartas.add( new Carta(R.drawable.kindred));
        cartas.add( new Carta(R.drawable.ekko));
        cartas.add( new Carta(R.drawable.illaoi));
        cartas.add( new Carta(R.drawable.jax ));
        cartas.add( new Carta(R.drawable.velkoz));
        cartas.add( new Carta(R.drawable.lucian));
        cartas.add( new Carta(R.drawable.maokai));
        cartas.add( new Carta(R.drawable.ryze));
        cartas.add( new Carta(R.drawable.swain));
        cartas.add( new Carta(R.drawable.taliyah));
        cartas.add( new Carta(R.drawable.tryndamere));

        cartas.add( new Carta(R.drawable.coringa));
        //Embaralha a lista das cartas
        Collections.shuffle(cartas);

    }

}