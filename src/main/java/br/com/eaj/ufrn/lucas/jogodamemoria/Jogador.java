package br.com.eaj.ufrn.lucas.jogodamemoria;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Lucas on 24/08/2016.
 */
public class Jogador implements Parcelable {

    private String nomeJogador; // nome do jogador
    private int pontos = 0;     // pontuação do jogador
    private boolean jogou = false; // Variável controladora para verificar se o jogador já teve sua vez naquela rodada
    private Boolean venceu = false;     // Indica se o jogador venceu ou não, para o caro de uma nova partida, o vencedor ser o primeiro a jogar
    private Boolean empatou = false; //Variável que indica de houve ou não empate

    public Jogador(String nomeJogador){
        this.nomeJogador = nomeJogador;
    }

    public Jogador(){}

    protected Jogador(Parcel in) {
        nomeJogador = in.readString();
    }

    public static final Creator<Jogador> CREATOR = new Creator<Jogador>() {
        @Override
        public Jogador createFromParcel(Parcel in) {
            return new Jogador(in);
        }

        @Override
        public Jogador[] newArray(int size) {
            return new Jogador[size];
        }
    };

    // Controla a pontuação do jogador
    public void incrementaPontos(){
        this.pontos++;
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

    public Boolean getEmpatou() {
        return empatou;
    }

    public void setEmpatou(Boolean empatou) {
        this.empatou = empatou;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public boolean isJogou() {
        return jogou;
    }

    public void setJogou(boolean jogou) {
        this.jogou = jogou;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nomeJogador);
    }
}
