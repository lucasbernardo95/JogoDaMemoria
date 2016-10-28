package br.com.ufrn.eaj.tads.lucasbernardo.jogodamemoria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class fimDeJogoActivity extends AppCompatActivity {

    private ArrayList<Jogador> jogadores;
    private Intent i;
    private int v = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fim_de_jogo);

        Bundle pacote = getIntent().getExtras();
        jogadores = new ArrayList<>();
        jogadores = (ArrayList<Jogador>) pacote.get("jogadores");

    }

    @Override
    protected void onResume() {
        super.onResume();
        /**
         * Nesse método serão setados os nomes e as pontuações de cada jogador
         * de acordo com a quantidade.
         */
        //Seta o nome e a pontuação do jogador 1
        TextView t = (TextView) findViewById(R.id.nome1);
        TextView pts = (TextView) findViewById(R.id.pts1);
        t.setText(jogadores.get(0).getNomeJogador());
        pts.setText("" + jogadores.get(0).getPontos());

        //Seta o nome e a pontuação do jogador 2
        TextView t2 = (TextView) findViewById(R.id.nome2);
        TextView pts2 = (TextView) findViewById(R.id.pts2);
        t2.setText(jogadores.get(1).getNomeJogador());
        pts2.setText("" + jogadores.get(1).getPontos());

        //Referencia um text vi ao nome e outro para a pontuação do jogador 3, caso ele não exista, pode ser desabilitado da tela
        TextView t3 = (TextView) findViewById(R.id.nome3);
        TextView pts3 = (TextView) findViewById(R.id.pts3);


        TextView t4 = (TextView) findViewById(R.id.nome4);
        TextView pts4 = (TextView) findViewById(R.id.pts4);

        //TextView responsável por exibir o nome do vencedor, se houver um.
        TextView vendedor = (TextView) findViewById(R.id.textViewNomeVencedor);

        /**
         * nesse laço é verificado se houve um vencedor, se houver, pega a posição do arry desse
         * elemento para que seja possível exibir seu nome no textview. O indice é atribuído a variável V
         * para o caso de empate, a variável v recebe -1, indicando o empate.
         */

        for (int i = 0; i < jogadores.size(); ++i) {
            if (jogadores.get(i).getVenceu()) {
                v = i;
                break;
            } else if (jogadores.get(i).getEmpatou()) {
                v = -1;
                break;
            }
        }

        /**
         * Os nomes dos jogadores irão ser exibidos de acordo com a quantidade de jogadores existentes.
         * Se houver apenas dois jogadores, os demais não serão exibidos na tela. o mesmo ocorre caso
         * hajam apenas 3, o jogador 4 não será exibido.
         */

        switch (jogadores.size()) {
            //caso hajam apenas 2 jogadores, os jogadores 3 e 4 serão setados como invisíveis
            case 2:
                t3.setVisibility(View.INVISIBLE);
                pts3.setVisibility(View.INVISIBLE);
                t4.setVisibility(View.INVISIBLE);
                pts4.setVisibility(View.INVISIBLE);
                break;

            case 3:
                //Se houverem 3 jogadores, apenas o 4 não aparecerá
                t3.setText(jogadores.get(2).getNomeJogador());
                pts3.setText("" + jogadores.get(2).getPontos());
                t4.setVisibility(View.INVISIBLE);
                pts4.setVisibility(View.INVISIBLE);
                break;
            case 4:
                t3.setText(jogadores.get(2).getNomeJogador());
                pts3.setText("" + jogadores.get(2).getPontos());
                t4.setText(jogadores.get(3).getNomeJogador());
                pts4.setText("" + jogadores.get(3).getPontos());
                break;
        }

        if (v != -1){
            vendedor.setText(jogadores.get(v).getNomeJogador() + ", "+getResources().getString(R.string.vendeu));
        } else {
            vendedor.setText(R.string.empate);
        }
    }

    /**
     * Método chamado quando o usuário decidir jogar novamente.
     * Esse irá zerar a pontuação de cada jogador e chamar a tela do jogo novamente.
     * Além disso, se houve um vencedor na partida anterior, esse, será setado como o primeiro
     * jogador da nova partida.
     */
    public void jogarNovamente(View view){
        for (Jogador j: jogadores) {
            j.setEmpatou(false);
            j.setVenceu(false);
            j.setPontos(0);
        }
        //indica que quero partir dessa tela para a tela do jogo 'gameActivity'
        i = new Intent(fimDeJogoActivity.this, gameActivity.class);

        //Seta o jogador vencedor, se houve um, como o primeir da lista para a oróxima jogada
        if (v != -1) {
            Jogador j;
            j = jogadores.get(v);
            jogadores.remove(v);
            jogadores.add(v, jogadores.get(0));
            jogadores.remove(0);
            jogadores.add(0, j);
        } else
            Collections.shuffle(jogadores);//caso não haja um ganhador, inicia com uma ordem aleatória
        //Adiciona os jogadores à intent
        i.putExtra("jogadores", jogadores);
        startActivity(i);
        finish();
    }

    /**
     * Método para criar um novo jogo com novos jogadores.
     * Quando o usuário clicar no botão Novo Jodo a tela de seleção de jogadores serão chamada e
     * todos os dados que a tela de exibição de resultados serão perdidos na chamada do método finish()
     */
    public void novoJogo(View view){
        i = new Intent(fimDeJogoActivity.this, SelecaoJogadoresActivity.class);
        startActivity(i);
        //Destroy essa tela quando a próxima for chamada
        finish();
    }
    //finaliza a activity
    public void sair(View view){
        finish();
    }

}
