package com.example.matheus.apiroomcrud;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.matheus.apiroomcrud.confdatabase.AppDatabase;
import com.example.matheus.apiroomcrud.model.Contato;
import com.example.matheus.apiroomcrud.model.Usuario;
import com.example.matheus.apiroomcrud.util.DatabaseInitializer;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private ListView listaContatos;
    private Button btnConcluir, btnExcluir;
    private EditText editNome, editTelefone, editInfo;
    private ArrayAdapter<Contato> contatoArrayAdapter;
    private ArrayList<Contato> contatoArrayList;
    private Contato contato = new Contato();
    private Usuario usuario = new Usuario();

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listaContatos = (ListView) findViewById(R.id.listContato);
        btnConcluir = (Button) findViewById(R.id.btnConcluir);
        btnExcluir = (Button) findViewById(R.id.btnExcluir);
        editNome = (EditText) findViewById(R.id.editNome);
        editInfo = (EditText) findViewById(R.id.editInfo);
        editTelefone = (EditText) findViewById(R.id.editTelefone);


        btnConcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (contato.getUid() == null) {

                    if (validar(editNome.getText().toString(), editTelefone.getText().toString())) {
                        contato.setNome(editNome.getText().toString());
                        contato.setTelefone(editTelefone.getText().toString());
                        contato.setInfo(editInfo.getText().toString());


                        AppDatabase.getAppDatabase(MainActivity.this).contatoDao().insertAll(contato);
                        carregarContato();
                        LimparCampo();

                    } else {

                        Toast.makeText(MainActivity.this, "Campo Nome ou Telefone nao pode ser vazio", Toast.LENGTH_SHORT).show();
                    }

                }

                if (contato.getUid() != null) {


                    contato.setDataAlteração(new Date());
                    contato.setNome(editNome.getText().toString());
                    contato.setTelefone(editTelefone.getText().toString());
                    contato.setInfo(editInfo.getText().toString());


                    AppDatabase.getAppDatabase(MainActivity.this).contatoDao().update(contato);
                    btnExcluir.setVisibility(View.GONE);
                    carregarContato();
                    LimparCampo();


                }


            }
        });

        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AppDatabase.getAppDatabase(MainActivity.this).contatoDao().delete(contato);
                LimparCampo();
                carregarContato();
                contato.setUid(null);
                btnExcluir.setVisibility(View.GONE);

            }
        });


        listaContatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long l) {

                btnExcluir.setVisibility(View.VISIBLE);
                contato = (Contato) contatoArrayAdapter.getItem(posicao);
                editNome.setText(contato.getNome());
                editInfo.setText(contato.getInfo());
                editTelefone.setText(contato.getTelefone());


            }
        });

    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarContato();
    }

    public void carregarContato() {
        //usuarioDAO = new UsuarioDAO(this);
        // contatoArrayList.clear();

        contatoArrayList = (ArrayList<Contato>) AppDatabase.getAppDatabase(this).contatoDao().getAll();

        if (contatoArrayList != null) {
            contatoArrayAdapter = new ArrayAdapter<Contato>(MainActivity.this, android.R.layout.simple_list_item_1, contatoArrayList);
            listaContatos.setAdapter(contatoArrayAdapter);
        }


    }

    public void LimparCampo() {
        editInfo.setText("");
        editNome.setText("");
        editTelefone.setText("");
    }

    public boolean validar(String nome, String telefone) {


        if (nome.isEmpty() || telefone.isEmpty()) {
            return false;
        } else {
            return true;
        }


    }
}
