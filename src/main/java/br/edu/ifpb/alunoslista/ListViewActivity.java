package br.edu.ifpb.alunoslista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ListViewActivity extends AppCompatActivity implements OnItemClickListener, View.OnClickListener {

     List <String> alunos = new ArrayList<>();
     ListView listview;
     ArrayAdapter<String> adapter;
     Button botaoAdicionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);

        //Questão um

        alunos.add("João");
        alunos.add("Maria");
        alunos.add("Jose");
        alunos.add("Manoel");
        alunos.add("Joaquim");

        //Criando ListView e o adapter

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,alunos);

        listview = (ListView) findViewById(R.id.listaAlunos);
        listview.setAdapter(adapter);

        botaoAdicionar = findViewById(R.id.botaoAdicionar);
        botaoAdicionar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //Método para adicionar um aluno ao clique do botao adicionar

        //Questao dois

        Log.i("List View","voce clicou no botão");
        EditText alunosEditText = findViewById(R.id.caixaTextoAlunos);
        String aluno = alunosEditText.getText().toString();
        alunos.add(aluno);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Metodo de resposta ao clicar em um item da ListView

        Log.i("ListView", "Item da List View clicado");
        String aluno = alunos.get(position);

        Toast toast = Toast.makeText(this,
                "Item clicado: " + position + " Valor: " + aluno,
                Toast.LENGTH_LONG);
        toast.show();
    }
}
