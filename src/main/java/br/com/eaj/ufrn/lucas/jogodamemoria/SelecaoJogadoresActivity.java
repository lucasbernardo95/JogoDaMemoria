package br.com.eaj.ufrn.lucas.jogodamemoria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SelecaoJogadoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecao_jogadores);

        SeekBar sb = (SeekBar) findViewById(R.id.seekBar);
        final TextView ts = (TextView) findViewById(R.id.textSeekbar);
        EditText ativaJogador; // Responsável por controlar a visibilidade dos EditiText's

        // Seta o progresso do seekbar inicialmente como 2 e exibe seu valaor no textvie
        sb.setProgress(2);
        ts.setText(sb.getProgress()+ "");

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            EditText ativaJogador;
            // Esse método irá setar o valor em tempo real do seekbar ao textview
            @Override
            public void onProgressChanged(SeekBar seekBar, int progresso, boolean b) {
                progresso =+ 2;
                ts.setText(progresso + "");
                if (progresso <= 2) {
                    ativaJogador = (EditText) findViewById(R.id.editTjogador3);
                    ativaJogador.setVisibility(View.INVISIBLE);
                    ((EditText) findViewById(R.id.editTjogador3)).setText("");
                } else {
                    ativaJogador = (EditText) findViewById(R.id.editTjogador3);
                    ativaJogador.setVisibility(View.VISIBLE);
                    ((EditText) findViewById(R.id.editTjogador3)).setText(R.string.jogador3);
                }
                if (progresso <= 3) {
                    ativaJogador = (EditText) findViewById(R.id.editTjogador4);
                    ativaJogador.setVisibility(View.INVISIBLE);
                    ((EditText) findViewById(R.id.editTjogador4)).setText("");
                } else {
                    ativaJogador = (EditText) findViewById(R.id.editTjogador4);
                    ativaJogador.setVisibility(View.VISIBLE);
                    ((EditText) findViewById(R.id.editTjogador4)).setText(R.string.jogador4);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

    }

    protected void iniciar(View view){

        String nome1 = ((EditText) findViewById(R.id.editTjogador1)).getText().toString();
        String nome2 = ((EditText) findViewById(R.id.editTjogador2)).getText().toString();
        String nome3 = ((EditText) findViewById(R.id.editTjogador3)).getText().toString();
        String nome4 = ((EditText) findViewById(R.id.editTjogador4)).getText().toString();

        List<Jogador> jogador = new ArrayList();
        Jogador play;

        //Testa se pelo menos dois dos jogadores tem um nome
        if ( !nome1.equals("") && !nome2.equals("") ){

            int quantidadeJogadores;
            //Testa se os nome dos jogadores são diferentes de nulos e recebe os nomes
            if(!nome1.equals("")) {
                play = new Jogador();
                play.setNomeJogador(nome1);
                jogador.add(play);
            } if(!nome2.equals("")) {
                play = new Jogador();
                play.setNomeJogador(nome2);
                jogador.add(play);
            } if(!nome3.equals("")) {
                play = new Jogador();
                play.setNomeJogador(nome3);
                jogador.add(play);
            } if(!nome4.equals("")) {
                play = new Jogador();
                play.setNomeJogador(nome4);
                jogador.add(play);
            }
            Log.i("i", nome1 + nome2 + nome3 + nome4);

            // Após pegar os nomes dos jogadores e instanciá-los, eles serão adicionados a um bundle e passados em uma intent para a próxima activity
            Intent intent = new Intent(SelecaoJogadoresActivity.this, gameActivity.class);//informo o contexto da tela atual e informo qual tela eu quero abrir
            Bundle bundle = new Bundle();

            //adiciona os nomes ao bundle
            bundle.putString("nome1", nome1);
            bundle.putString("nome2", nome2);
            bundle.putString("nome3", nome3);
            bundle.putString("nome4", nome4);

            //Adiciona o bundle à intent
            intent.putExtras(bundle);

            //Inicia a próxima activity passando a intent com o pacote contendo os nomes dos jogadores
            startActivity(intent);

        } else {// Caso não tenha no mínimo dois jogadores com nomes exibe uma mensagem com Toast
            // a mensagem que irá ser exibida no toast está associada a uma string no stringxml, para que seja possível a tradução também dessa mensagem em caso de mudar a linguagem
            Toast.makeText(SelecaoJogadoresActivity.this, getResources().getString(R.string.minimoJogadores), Toast.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Aula 3", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Aula 3", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Aula 3", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Aula 3", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Aula 3", "onDestroy()");
    }
}
