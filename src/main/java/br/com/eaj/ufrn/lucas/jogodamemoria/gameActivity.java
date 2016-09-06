package br.com.eaj.ufrn.lucas.jogodamemoria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.xml.sax.helpers.LocatorImpl;

import java.util.ArrayList;
import java.util.Collections;

public class gameActivity extends AppCompatActivity {

    private ArrayList<Jogador> jogadores; // Armazena os jogadores
    private static ArrayList<Carta> cartas; // Armazena as cartas do jogo
    private static ArrayList<Integer> botoes; //Armazena o id dos botões
    private int jogadas = 1; // variável para controle de jogadas
    private Carta carta;
    private Carta par;
    private ImageButton ib;
    private ImageButton imb;
    private int ordem = 0; //Controla a ordem dos jogadores, quem irá jogar e quando.
    TextView nome;//Variável para exibir o nome dos jogadores
    private int total = 0; //variável que indica o final no jogo. quando atingir o valor de 12 pontos, o jogo será encerrado



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game);
    }
    @Override
    protected void onResume() {
        super.onResume();

        //Recupera o pacote que foi enviado na seleção de jogadores que contém os nomes e quantidades dos jogadores
        Bundle pacote = getIntent().getExtras();

        // Recupera o ArrayList contendo os jogadores setatos na tela de seleção
        jogadores = pacote.getParcelableArrayList("jogadores");
        //Embaralha a ordem dos jogadores para definir uma sequêscia aleatória em que esses irão jogar
        Collections.shuffle(jogadores);

        //Seta o nome do primeiro jogador ao textView
        nome = (TextView) findViewById(R.id.textnome);
        nome.setText(jogadores.get(ordem).getNomeJogador());

        cartas = new ArrayList<>();
        //Cria uma lista contendo todas as cartas
        Carta.instanciarCartas(cartas);

        botoes = new ArrayList<>();
        //Define uma lista com os ids dos botões para serem associados à lista de imagens
        Tabuleiro.definiListaBotao(botoes);
        // Inicia a ondem em que as cartas serão geradas no tabuleiro
        Tabuleiro.inicializarTabuleiro(cartas, botoes);
        //Instancia os objetos cartas para que seja possível atribuir valores a esses
        carta = new Carta();
        par = new Carta();

    }

    private void fimDoGame(){
        //maior = j.getPontos() > maior ? maior: 0;
        int i = 0, maior = 0;
        for (Jogador j : jogadores){
            if (j.getPontos() > maior){
                maior = j.getPontos();
                i++;
            }
        }
        //seta o possível vendedor
        jogadores.get(i).setVenceu(true);
        Log.i("venceu", "venceu = "+jogadores.get(i).getNomeJogador() + "posição " + jogadores.get(i).getPontos() + " maior" + maior);
        //verifica se tem alguém com a mesma pontuação
        for (Jogador j : jogadores){
            if (j.getPontos() == jogadores.get(i).getPontos() && j.getVenceu() == false){
                j.setEmpatou(true);
                jogadores.get(i).setEmpatou(true);
                jogadores.get(i).setVenceu(false);
                Log.i("empate","houve empate");
            }
        }
        Intent intent = new Intent(gameActivity.this, fimDeJogoActivity.class);
        intent.putParcelableArrayListExtra("jogadores", jogadores);
        startActivityForResult(intent, 1);
    }

    /**
     * @param id: id do botão clicado
     * Esse método irá pegar, de acordo com o botão clicado, a carta que está por trás desse botão,
     * ou seja, cada botão tem uma carta, definida aleatariamente, associado a si. Então esse irá
     * pegar essa carta e exibir no botão clicado no primeiro click.
     * No segundo click o processo é repeitdo, porém irá comparar se as duas cartas clicadas são iguais
     * se forem, seta os dois, botões referentes a essas cartas, como não clicáveis, e permaneceram
     * com suas imagens a amostra, além de somar um ponto para o jogador que escobriu o par de cartas.
     * Caso não sejam iguais as cartas voltam a ser escondidas e é passada a vez para o próximo jogador.
     */

    public void pegaCarta(int id ){
        int time = 1300;//variável de controle do tempo de delay
        for (Carta c: cartas) {
            //Testa se o id do botão clicado é igual ao iddo botão contido dentro do objeto carta
            //Cada carta possui um id que refere-se ao botão que ela será vinculada
            if (c.getIdBotao() == id) {

                //Se for a primeira jogada executa os procedimentos listados a baixo
                if (jogadas == 1){
                    //se cair o coringa o jogador perde a vez
                    if ((int)c.getId() == (int)R.drawable.coringa){
                        clicavel(false);
                        /**mostra o coringa no botão clicado, dá um delay e desabilita os demais botões
                         * para evitar que o usuário saia clicando. após alguns segundos o jogo volta
                         * ao seu fluxo normalmente
                         */
                        ib = (ImageButton) findViewById(c.getIdBotao());
                        ib.setImageResource(c.getId());
                        ib.postDelayed(delay, time);
                        jogadas = 1;
                        controleRodada();
                        carta = null;
                        par = null;
                        break;
                    }

                    // Recebe a carta referente ao id do botão clicado
                    carta = c;
                    //Associa o objeto ImageButton ao botão clicado para poder manipulá-lo
                    ib = (ImageButton) findViewById(id);
                    //Seta a imagem que está "por trás" do botão clicado
                    ib.setImageResource(carta.getId());
                    //Seta a imagem como não clicável para evitar que o usuário clice na mesma imagem novamente e conte como um ponto
                    //permanece nesse estado até a próixma jogada, caso não seja o par dela
                    ib.setClickable(false);
                    //seta o número de jogadas como dois para indicar que o próximo click será a segunda jogada
                    jogadas = 2;
                    break;

                    // Se for a segunda jogada
                } else if(jogadas == 2){
                    clicavel(false);
                    par = c;//recebe a carta par
                    ib = (ImageButton) findViewById(id);//vincula o id do botão clicado ao imagebutton
                    ib.setImageResource(par.getId());//seta a imagem ao botão

                    //se cair o coringa na segunda jogada, a primeira carta volta ao estado inicial e o jogador perde a vez
                    if ((int)c.getIdBotao() == (int)R.drawable.coringa){
                        ib = (ImageButton) findViewById(par.getIdBotao());
                        imb = (ImageButton) findViewById(carta.getIdBotao());
                        ib.postDelayed(delay, time);
                        par = null;
                        carta = null;
                        clicavel(true);
                        //altera a vez do jogador
                        controleRodada();
                        break;
                    }

                    //Testa se as duas cartas clicadas são iguais
                    if(carta.getId() ==  par.getId() ){
                        //Seta as cartas como viradas para controlar estados das cartas posteriormente
                        int i = cartas.indexOf(carta);
                        cartas.get(i).setFlip(true);
                        i = cartas.indexOf(par);
                        cartas.get(i).setFlip(true);

                        //Se as cartas forem iguais, seta os objetos imagbutton como não clicáveis, pois são pares e não serão mais ocultados
                        ib = (ImageButton) findViewById(par.getIdBotao());
                        ib.setImageResource(par.getId());
                        ib.setClickable(false);

                        ib = (ImageButton) findViewById(carta.getIdBotao());
                        ib.setImageResource(carta.getId());
                        ib.setClickable(false);
                        //Limpa os valores dos objetos carta para evigar bugs
                        carta = null;
                        par = null;
                        jogadas = 1;
                        jogadores.get(ordem).incrementaPontos();
                        Log.i("jogador" , "acertou uma = "+jogadores.get(ordem).getNomeJogador());
                        total++;
                        clicavel(true);
                        if (total == 3)
                            fimDoGame();
                        break;//finaliza
                        //Se não for um par, as imagens clicadas no primeiro e segundo click da jogada
                        // tornarão ao estado inicial, ou seja, exibe uma interrogação como imagem
                    } else if ( carta.getId() !=  par.getId()) {
                        //caso não seja um par, retorna os botões clicados para exibir uma interrogação como imagem
                        ib = (ImageButton) findViewById(par.getIdBotao());
                        imb = (ImageButton) findViewById(carta.getIdBotao());
                        //Método usado para dar um delay no fluxo do jogo, aguarda 2 segundos e as imagens voltarão a ser uma interrogação
                        ib.postDelayed(delay, time);
                        //limpa os valores da do objeto carta e do par para evitar que peguem lixo de memória
                        carta = null;
                        par = null;
                        controleRodada();
                        clicavel(false);
                        break;
                    }
                }

            }
        }
    }

    private void controleRodada(){
        //altera a vez do jogador, pois ele clicou no coringa, passa a vez para o próximo
        if (ordem < jogadores.size() - 1){
            ordem ++;
            jogadores.get(ordem).setJogou(true);
            nome.setText(jogadores.get(ordem).getNomeJogador());
        }else {

            for (Jogador j :jogadores){
                j.setJogou(false);
            }
            ordem = 0;
            nome.setText(jogadores.get(ordem).getNomeJogador());
        }
    }

    /**
     * @param click indicará se os botões serão clicáveis ou não
     * Esse método consiste em evitar bugs no jogo, no momento de delay, entre a verificação das cartas
     * todas as cartas serão setadas como não clicáveis para evitar que o usuário clique em outras cartas
     * e essas sejam exibidas. Após o delay de dois segundos serão setadas como clicáveis novamente
     */

    private void clicavel(Boolean click){
        ImageButton i;
        for (Carta c: cartas) {
            if (!c.isFlip()) {
                i = (ImageButton) findViewById(c.getIdBotao());
                i.setClickable(click);
            }
        }
    }

    /**Método para dar um delay no fluxo do jogo. Ao ser chamado após a verificação de duas cartas e
     * essas não forem iguais o fluxo do jogo é interrompido por 2 segundos e enseguida as cartas
     * terão suas imagens substituídas por uma interrogação novamente.
     */
    private Runnable delay = new Runnable() {
        @Override
        public void run() {
            //Altera o estado de todos os ImageButtons para não clicáveis
            clicavel(false);
            ib.setImageResource(R.drawable.interrogacao);
            if (jogadas == 2) {
                imb.setImageResource(R.drawable.interrogacao);
                jogadas = 1;//seta o número de jogadas como um para que ao finalizar o contador volte a ser 1, indicando a primeira jogada
            }
            //retorna o estado dos ImageButtons como clicáveis novamente
            clicavel(true);
        }
    };


    /**
     * @param v: refere-se ao botão que está sendo clicado no xml
     */
    public void revelarCarta(View v) {

        switch (v.getId()){
            case R.id.imb1:
                pegaCarta(R.id.imb1);
                return;

            case R.id.imb2:
                pegaCarta(R.id.imb2);
                break;

            case R.id.imb3:
                pegaCarta(R.id.imb3);
                break;

            case R.id.imb4:
                pegaCarta(R.id.imb4);
                break;

            case R.id.imb5:
                pegaCarta(R.id.imb5);
                break;

            case R.id.imb6:
                pegaCarta(R.id.imb6);
                break;

            case R.id.imb7:
                pegaCarta(R.id.imb7);
                break;

            case R.id.imb8:
                pegaCarta(R.id.imb8);
                break;

            case R.id.imb9:
                pegaCarta(R.id.imb9);
                break;
            case R.id.imb10:
                pegaCarta(R.id.imb10);
                break;

            case R.id.imb11:
                pegaCarta(R.id.imb11);
                break;

            case R.id.imb12:
                pegaCarta(R.id.imb12);
                break;

            case R.id.imb13:
                pegaCarta(R.id.imb13);
                break;

            case R.id.imb14:
                pegaCarta(R.id.imb14);
                break;

            case R.id.imb15:
                pegaCarta(R.id.imb15);
                break;

            case R.id.imb16:
                pegaCarta(R.id.imb16);
                break;

            case R.id.imb17:
                pegaCarta(R.id.imb17);
                break;

            case R.id.imb18:
                pegaCarta(R.id.imb18);
                break;

            case R.id.imb19:
                pegaCarta(R.id.imb19);
                break;

            case R.id.imb20:
                pegaCarta(R.id.imb20);
                break;

            case R.id.imb21:
                pegaCarta(R.id.imb21);
                break;

            case R.id.imb22:
                pegaCarta(R.id.imb22);
                break;

            case R.id.imb23:
                pegaCarta(R.id.imb23);
                break;

            case R.id.imb24:
                pegaCarta(R.id.imb24);
                break;

            case R.id.imb25:
                pegaCarta(R.id.imb25);
                break;

        }
    }


}
