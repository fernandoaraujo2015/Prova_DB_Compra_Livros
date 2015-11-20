package br.nandosoft.pi.compra_livros;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import domin.LivrosDB;

public class Book extends AppCompatActivity {
    LivrosDB livrosDB;
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        livrosDB = new LivrosDB(this);
        SQLiteDatabase database;

        findViewById(R.id.btn_adicionar).setOnClickListener(cadastrarlivro());
        findViewById(R.id.btn_excluir).setOnClickListener(excluirlivro());
        findViewById(R.id.btn_Lista).setOnClickListener(listlivro());
        findViewById(R.id.btn_editar_livro).setOnClickListener(edicaolivro());
    }

    private View.OnClickListener cadastrarlivro() {
        return new View.OnClickListener() {
            public void onClick(View v) {
                database = livrosDB.getWritableDatabase();
                EditText txtlivr = (EditText) findViewById(R.id.btn_adicionar);
                EditText txtauto = (EditText) findViewById(R.id.btn_adicionar);

                String livr = txtlivr.getText().toString();
                String auto = txtauto.getText().toString();
                ContentValues values = new ContentValues();

                values.put("livro", livr);
                values.put("autor", auto);
                long id = database.insert("livro", null, values);
                if (id != 0) {
                    Toast.makeText(getApplicationContext(), getString(R.string.sucesso), Toast.LENGTH_LONG).show();
                    txtlivr.setText("");
                    txtauto.setText("");
                    txtlivr.requestFocus(Integer.parseInt(""));
                }else {
                    Toast.makeText(getApplicationContext(),getString(R.string.error), Toast.LENGTH_LONG).show();

                }
            }

        };
    }

    private  View.OnClickListener Listas_Livros() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(Book.this, Listas_Livros.class);
                startActivity(intent);
            }
        };
    }
}

