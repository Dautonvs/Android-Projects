package fiap.com.br.aplicacaoteste;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DashBoardActivity extends AppCompatActivity {


    //Cria o objeto SharedPreferences para manipular a persistencia dos dados
    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        //Recupera o objeto de preferencia especificando um nome e o modo de exibição
        sp = getSharedPreferences("login", MODE_PRIVATE);
    }

    //Criação do Método que executará a ação do botão Sair
    public void Sair(View v){

        SharedPreferences.Editor e = sp.edit();
        e.remove("usuário"); //remove o valor string usuário
        e.remove("senha"); //remove o valor string senha
        e.remove("conetado"); //remove o valor string conectado
        e.commit(); //Efetua o commit das ações acima
        finish(); //finish() -> encerra a activity

    }
}
