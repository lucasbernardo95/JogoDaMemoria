package br.com.ufrn.eaj.tads.lucasbernardo.jogodamemoria;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Lucas on 24/08/2016.
 */
public class Jogador implements Serializable {

    private String nomeJogador; // nome do jogador
    private int pontos = 0;     // pontuação do jogador
    private Boolean empatou = false; //Indicará se houve empate ou não
    private boolean jogou = false; // Variável controladora para verificar se o jogador já teve sua vez naquela rodada
    private Boolean venceu = false;     // Indica se o jogador venceu ou não, para o caro de uma nova partida, o vencedor ser o primeiro a jogar

    public Jogador(String nomeJogador){
        this.nomeJogador = nomeJogador;
    }

    public Jogador(){}

    // Controla a pontuação do jogador incrementando-a sempre que for chamado
    public void incrementaPontos(){
        this.pontos = pontos + 1;
    }

    public int getPontos() {
        return pontos;
    }

    public Boolean getVenceu() {
        return venceu;
    }

    public void setVenceu(Boolean venceu) {
        this.venceu = venceu;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public Boolean getEmpatou() {
        return empatou;
    }

    public void setEmpatou(Boolean empatou) {
        this.empatou = empatou;
    }
}
