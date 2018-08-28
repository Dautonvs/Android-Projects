package fiap.com.br.novoprojeto;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtUser;
    EditText edtSenha;
    CheckBox chkConectado;

    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUser = findViewById(R.id.edtUser);
        edtSenha = findViewById(R.id.edtSenha);
        chkConectado = findViewById(R.id.ckhConectado);

        sp = getSharedPreferences("login", MODE_PRIVATE);

        boolean conectado = sp.getBoolean("conectado", false);
        if (conectado){
            abrirDashBoard(); //Chama o método que abre o Dashboard
        }

    }

    private void abrirDashBoard() {
        //Criação do objeto de intent para abrir Activity
        Intent it = new Intent(this, DashBoardActivity.class);
        startActivity(it); //Método que inicia a activity

    }

    public void  Entrar (View v){

        //Cria objeto que guardam os valores que serão passados como parâmetro
        String user = edtUser.getText().toString();  //getText()-> obtem o valor digitado
        String senha = edtSenha.getText().toString(); //toString()-> transforma o valor em uma String

        //Condição que valida os valores digitados
        if(user.equals("Teste01") && senha.equals("Teste01")){

            //Condição que verifica se a opção Conectado é verdadeira para chamar a interface Editor...
            //...e armazenar os valores dentro de sua instancia
            if(chkConectado.isChecked()){
                SharedPreferences.Editor e = sp.edit(); //edit()-> método que permite a edição do objeto SharedPreference
                e.putString("usuário", user); //adiciona na variavel do Editor a string guardada em user
                e.putString("senha", senha); //adiciona na variavel do Editor a string guardada em senha
                e.putBoolean("conectado", true); //adicionar na variavel do editor o valor true
                e.commit(); //realiza o commit das opeações para serem armazenadas
            }

            abrirDashBoard(); // chama o método que abre a activity

        }else { //condição de saída

            //Toast para mostrar ao usuario mensagem de erro
            Toast.makeText(this, R.string.logininvalido, Toast.LENGTH_SHORT).show();

        }



}
