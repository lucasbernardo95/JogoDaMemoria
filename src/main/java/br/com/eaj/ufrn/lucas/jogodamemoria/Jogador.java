package br.com.eaj.ufrn.lucas.jogodamemoria;

/**
 * Created by Lucas on 24/08/2016.
 */
public class Jogador {

    private String nomeJogador; // nome do jogador
    private Integer pontos;     // pontuação do jogador
    private Integer jogadas;    // representará a pontuação do jogador a cada partida
    private Boolean venceu;     // Indica se o jogador venceu ou não, para o caro de uma nova partida, o vencedor ser o primeiro a jogar

    public Jogador(String nomeJogador){
        this.nomeJogador = nomeJogador;
    }

    public Jogador(){}

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
}
