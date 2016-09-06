package br.com.eaj.ufrn.lucas.jogodamemoria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class fimDeJogoActivity extends AppCompatActivity {

    private ArrayList<Jogador> jogadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fim_de_jogo);

        Bundle pacote = getIntent().getExtras();
        jogadores = pacote.getParcelableArrayList("jogadores");
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView t = (TextView) findViewById(R.id.nome1);
        TextView pts = (TextView) findViewById(R.id.pts1);
        t.setText(jogadores.get(0).getNomeJogador());
        pts.setText(""+jogadores.get(0).getPontos());

        TextView t2 = (TextView) findViewById(R.id.nome2);
        TextView pts2 = (TextView) findViewById(R.id.pts2);
        t2.setText(jogadores.get(1).getNomeJogador());
        pts2.setText(""+jogadores.get(1).getPontos());

        TextView t3 = (TextView) findViewById(R.id.nome3);
        TextView pts3 = (TextView) findViewById(R.id.pts3);


        TextView t4 = (TextView) findViewById(R.id.nome4);
        TextView pts4 = (TextView) findViewById(R.id.pts4);

        int i = 0;
        TextView vendedor = (TextView) findViewById(R.id.textViewNomeVencedor);
        for (Jogador j : jogadores){
            if (j.getVenceu())
                i++;
        }
        switch (jogadores.size()){
            case 2:
                t3.setVisibility(View.INVISIBLE);
                pts3.setVisibility(View.INVISIBLE);
                t4.setVisibility(View.INVISIBLE);
                pts4.setVisibility(View.INVISIBLE);
                break;

            case 3:
                t3.setText(jogadores.get(2).getNomeJogador());
                pts3.setText(""+jogadores.get(2).getPontos());
                t4.setVisibility(View.INVISIBLE);
                pts4.setVisibility(View.INVISIBLE);
                break;
            case 4:
                t3.setText(jogadores.get(2).getNomeJogador());
                pts3.setText(""+jogadores.get(2).getPontos());
                t4.setText(jogadores.get(3).getNomeJogador());
                pts4.setText(""+jogadores.get(3).getPontos());
                break;
        }

        vendedor.setText( "venceu = "+jogadores.get(i).getNomeJogador() + "posição " + i + "pontos" + jogadores.get(i).getPontos());
    }
}
