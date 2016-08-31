package br.com.eaj.ufrn.lucas.jogodamemoria;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Lucas on 27/08/2016.
 */

public class Carta {

    private Integer id; //Representa o id da imagem
    private Integer par; //Representa o par da imagem
    private Integer idBotao; //Refere-se a qual botao irá exibir essa imagem, ou seja, a qual botão estará associado a essa imagem
    public boolean flip = false;

    public Carta(Integer id, Integer par) {
        super();
        this.id = id;
        this.par = par;
    }

    public Integer getId() {
        return id;
    }

    public Integer getPar() {
        return par;
    }

    public boolean isFlip() {
        return flip;
    }

    public void setFlip(boolean flip) {
        this.flip = flip;
    }

    public Integer getIdBotao() {
        return idBotao;
    }

    public void setIdBotao(Integer idBotao) {
        this.idBotao = idBotao;
    }

    /**
     * @param cartas recebe um ArrayList onde serão armazenadas as cartas juntamente com seus pares
     * Método para criar uma lista com as cartas juntamente com suas cartas pares.
     * Essa lista conterá as cartas que serão exibidas na dela do jogo ao clicar nas imagens de interrocação
     */

    protected static void intanciarCartas(ArrayList<Carta> cartas){

        cartas.add( new Carta(R.drawable.azir, R.drawable.azir2));
        cartas.add( new Carta(R.drawable.kindred , R.drawable.kindred2 ));
        cartas.add( new Carta(R.drawable.ekko , R.drawable.ekko2 ));
        cartas.add( new Carta(R.drawable.illaoi , R.drawable.illaoi2 ));
        cartas.add( new Carta(R.drawable.jax , R.drawable.jax2 ));
        cartas.add( new Carta(R.drawable.velkoz , R.drawable.velkoz2 ));
        cartas.add( new Carta(R.drawable.lucian , R.drawable.lucian2 ));
        cartas.add( new Carta(R.drawable.maokai , R.drawable.maokai2 ));
        cartas.add( new Carta(R.drawable.ryze , R.drawable.ryze2 ));
        cartas.add( new Carta(R.drawable.swain , R.drawable.swain2 ));
        cartas.add( new Carta(R.drawable.taliyah , R.drawable.taliyah2 ));
        cartas.add( new Carta(R.drawable.tryndamere , R.drawable.tryndamere2 ));

        cartas.add( new Carta(R.drawable.azir2, R.drawable.azir));
        cartas.add( new Carta(R.drawable.kindred2 , R.drawable.kindred));
        cartas.add( new Carta(R.drawable.ekko2 , R.drawable.ekko));
        cartas.add( new Carta(R.drawable.illaoi2 , R.drawable.illaoi));
        cartas.add( new Carta(R.drawable.jax2 , R.drawable.jax ));
        cartas.add( new Carta(R.drawable.velkoz2 , R.drawable.velkoz ));
        cartas.add( new Carta(R.drawable.lucian2 , R.drawable.lucian ));
        cartas.add( new Carta(R.drawable.maokai2 , R.drawable.maokai));
        cartas.add( new Carta(R.drawable.ryze2 , R.drawable.ryze));
        cartas.add( new Carta(R.drawable.swain2 , R.drawable.swain ));
        cartas.add( new Carta(R.drawable.taliyah2 , R.drawable.taliyah ));
        cartas.add( new Carta(R.drawable.tryndamere2 , R.drawable.tryndamere ));

        //seta o par do coringa como null, pois não tem par
        cartas.add( new Carta(R.drawable.coringa , null ));
        //Embaralha a lista das cartas
        Collections.shuffle(cartas);

    }

}