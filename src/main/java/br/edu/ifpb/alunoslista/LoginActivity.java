package br.edu.ifpb.alunoslista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText nome;
    EditText sobrenome;
    EditText senha;
    EditText reSenha;
    TextView hint;
    Button botaoCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Questão Três

        nome = (EditText) findViewById(R.id.edittextnome);
        sobrenome = (EditText) findViewById(R.id.edittextsobrenome);
        senha = (EditText) findViewById(R.id.edittextsenha);
        reSenha = (EditText) findViewById(R.id.edittextresenha);
        botaoCadastrar = (Button) findViewById(R.id.botaocadastrar);
        hint = (TextView) findViewById(R.id.textviewhint);

        senha.addTextChangedListener(watcherSenha);


    }

    TextWatcher watcherSenha = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            int cont = 0;
            hint.setText(s);

            for (int i = 0; i < s.length(); i++){
                if (Character.isDigit(s.charAt(i))) {
                    cont++;

                }
            }



            if (s.length() <= 5 ) {
                Toast.makeText(getApplicationContext(),"A senha deve conter mais de 5 caracteres", Toast.LENGTH_SHORT).show();
            }

            if (cont < 2){
                Toast.makeText(getApplicationContext(),"A senha deve conter pelo menos dois numeros",Toast.LENGTH_SHORT).show();
            }

            if (s.equals(nome.getText().toString())){
                Toast.makeText(getApplicationContext(),"A senha não pode ser igual ao nome de usuário",Toast.LENGTH_SHORT).show();
            }

            if (s.equals(reSenha.getText().toString())){
                hint.setVisibility(View.GONE);

            }

            else{
                hint.setText("Você digitou : " + senha.getText());

            }

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };




    private void mostrarListViewActivity(){

        Intent intent = new Intent(LoginActivity.this, ListViewActivity.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        Toast.makeText(LoginActivity.this, "Nome: " + nome + sobrenome + "Senha : " + senha,Toast.LENGTH_SHORT).show();

        mostrarListViewActivity();
    }
}
