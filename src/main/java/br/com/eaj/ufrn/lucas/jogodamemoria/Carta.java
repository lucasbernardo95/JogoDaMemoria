package br.com.eaj.ufrn.lucas.jogodamemoria;

/**
 * Created by Lucas on 27/08/2016.
 */

public class Carta {

    private int imagem; //Representa o id da imagem
    private int par; //Representa o par da imagem
    public boolean isFlip = false;
    public boolean isMatch = false;
    private int posicao;

    public Carta(int imagem, int par) {
        super();
        this.imagem = imagem;
        this.par = par;
    }

    public int getImagem() {
        return imagem;
    }

    public int getPar() {
        return par;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public int getPosicao() {
        return posicao;
    }

}