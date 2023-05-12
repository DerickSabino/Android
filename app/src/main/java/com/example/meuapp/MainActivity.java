
package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.meuapp.Activities.ProdutoActivity;
import com.example.meuapp.MODEL.Produto;
import com.example.meuapp.controller.ProdutoCtrl;
import com.example.meuapp.dbHelper.ConexaoSQLite;

public class MainActivity extends AppCompatActivity {

    private Button btnCadastroProduto;
    private Button btnListarProdutos;
    private Button meuBotao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexaoSQLite conexaoSQLite = ConexaoSQLite.getInstancia(this);


        Button meuBotao = findViewById(R.id.meuBotao);
        meuBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListaDoProduto.class);
                startActivity(intent);
            }
        });

        this.btnCadastroProduto = (Button) findViewById(R.id.btnCadastroProduto);

        this.btnCadastroProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProdutoActivity.class);
                startActivity(intent);
            }
        });
    }



}




