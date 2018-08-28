package fiap.com.br.novoprojeto;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class DashBoardActivity extends AppCompatActivity {

    RadioGroup rdgCores;
    SharedPreferences sp;
    View screen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        rdgCores = findViewById(R.id.rdgCores);

        sp = getSharedPreferences("salvar", MODE_PRIVATE);

        //Variavel para receber valor que representara a cor
        int cor = sp.getInt("cor", 0);

        //Condição que atribui um int para variavel cor para determinar e mudar a cor de fundo
        if(cor == 1){
            screen.setBackgroundColor(Color.BLUE);
        } else if (cor == 2){
            screen.setBackgroundColor(Color.GREEN);
        } else if (cor == 3){
            screen.setBackgroundColor(Color.RED);
        }
    }

    public void salvar(View view){

        SharedPreferences.Editor e = sp.edit();
        int valor = rdgCores.getCheckedRadioButtonId();

        switch(valor){
            case R.id.rdgAzul:
                    screen.setBackgroundColor(Color.BLUE);
                    e.putInt("cor", 1);
                    break;

             case R.id.rdgVerde;
                    screen.setBackgroundColor(Color.GREEN);
                    e.putInt("cor", 2);
                    break;
             case R.id.rdgVermelho;
                    screen.setBackgroundColor(Color.RED);
                    break;
        }
        e.commit();

        Toast.makeText(this, "Cor Alterada", Toast.LENGTH_SHORT).show();


    }
}
