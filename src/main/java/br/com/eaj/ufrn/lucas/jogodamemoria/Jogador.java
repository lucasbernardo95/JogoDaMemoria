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
    private Integer pontos;     // pontuação do jogador
    private Integer jogadas;    // representará a pontuação do jogador a cada partida
    private Boolean venceu;     // Indica se o jogador venceu ou não, para o caro de uma nova partida, o vencedor ser o primeiro a jogar

    public Jogador(String nomeJogador){
        this.nomeJogador = nomeJogador;
    }

    public Jogador(){}

    //Método para gerar a ordem em que os jogadores irão jogar. Define quem irá iniciar a jogada, quem será o segundo e assim por diante
    protected static void gerarSequenciaJogadores(int quantidade, ArrayList<Integer> ordem) {

        // Vai adicionar a lista de ordem dos jogadores um número entre 1 e a quantiidade máxima de jogadores
        for (int i = 0; i < quantidade; i++)
            ordem.add(1 + i);
        // Vai embaralhar a ordem em que os elementos foram inseridos na lista 'ordem'
        Collections.shuffle(ordem);

    }

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

    // controla a quantidade de jogadas dos jogadores
    public void incrementaJogada(){
        this.jogadas++;
    }

    // Controla a pontuação do jogador
    public void incrementaPontos(){
        this.pontos++;
    }

    public Integer getPontos() {
        return pontos;
    }

    public Integer getJogadas() {
        return jogadas;
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

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
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
