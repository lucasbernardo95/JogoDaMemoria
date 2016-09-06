package br.com.eaj.ufrn.lucas.jogodamemoria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class SelecaoJogadoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecao_jogadores);

        SeekBar sb = (SeekBar) findViewById(R.id.seekBar);
        final TextView ts = (TextView) findViewById(R.id.textSeekbar);
        EditText ativaJogador; // Responsável por controlar a visibilidade dos EditiText's

        sb.setMax(2);
        // Seta o progresso do seekbar inicialmente como 2 e exibe seu valaor no textvie
        sb.setProgress(sb.getMax() + 2);
        ts.setText(sb.getProgress() + 2+ "");

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            EditText ativaJogador;
            // Esse método irá setar o valor em tempo real do seekbar ao textview
            @Override
            public void onProgressChanged(SeekBar seekBar, int progresso, boolean b) {
                progresso += 2;
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

    /**
     * Evento do botão iniciar, que irá pegar os nomes dos jogadores digitados nos campos e adicionar
     * a um objeto jogador que por sua ver, será adicionado a um array que será enviado para a game
     * activity que irá tratar do processamento do jogo
     */
    public void iniciar(View view){

        String nome1 = ((EditText) findViewById(R.id.editTjogador1)).getText().toString();
        String nome2 = ((EditText) findViewById(R.id.editTjogador2)).getText().toString();
        String nome3 = ((EditText) findViewById(R.id.editTjogador3)).getText().toString();
        String nome4 = ((EditText) findViewById(R.id.editTjogador4)).getText().toString();

        //Testa se pelo menos dois dos jogadores tem um nome
        if ( !nome1.equals("") && !nome2.equals("") ){

            ArrayList<Jogador> jogadores = new ArrayList<>();

            // Após pegar os nomes dos jogadores e instanciá-los, eles serão adicionados a um bundle e passados em uma intent para a próxima activity
            Intent intent = new Intent(SelecaoJogadoresActivity.this, gameActivity.class);

            //Testa se os nome dos jogadores são diferentes de nulo, se for, instancia um novo jogador, passando o nome como parâmetro e adiciona ao array
            if(!nome1.equals(""))
                jogadores.add( new Jogador(nome1));

            if(!nome2.equals(""))
                jogadores.add( new Jogador(nome2));

            if(!nome3.equals(""))
                jogadores.add( new Jogador(nome3));

            if(!nome4.equals(""))
                jogadores.add( new Jogador(nome4));

            //Adiciona a intent o array contendo os nomes dos jogadores
            intent.putParcelableArrayListExtra("jogadores", jogadores);

            //Inicia a próxima activity passando a intent com o pacote contendo os nomes dos jogadores
            startActivity(intent);

        } else {// Caso não tenha no mínimo dois jogadores com nomes exibe uma mensagem com Toast
            // a mensagem que irá ser exibida no toast está associada a uma string no stringxml, para que seja possível a tradução também dessa mensagem em caso de mudar a linguagem
            Toast.makeText(SelecaoJogadoresActivity.this, getResources().getString(R.string.minimoJogadores), Toast.LENGTH_LONG).show();
        }

    }

    protected void fechar(View view){

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