package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.RadioGroup;

import com.example.meuapp.Activities.ProdutoActivity;
import com.example.meuapp.MODEL.Produto;
import com.example.meuapp.controller.ProdutoCtrl;
import com.example.meuapp.dbHelper.ConexaoSQLite;

public class MainActivity extends AppCompatActivity {

    private Button btnCadastroProduto;
    private Button btnListarProdutos;
    private Button meuBotao;
    private RadioGroup radioGroup;


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



        //produto feito na mao
        Produto produto1 = new Produto();
        produto1.setId(123455);
        produto1.setNome("Computador");
        produto1.setQuantidadeEmEstoque(50);
        produto1.setPreco(1500);

        ProdutoCtrl produtoCtrl = new ProdutoCtrl(conexaoSQLite);
        long resultado = produtoCtrl.salvarProdutoCtrl(produto1);

        System.out.println("resultado = " + resultado);

        this.btnCadastroProduto = (Button) findViewById(R.id.btnCadastroProduto);

        this.btnCadastroProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProdutoActivity.class);
                startActivity(intent);
            }
        });

        radioGroup = findViewById(R.id.radio_group);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_button_1:
                        break;
                    case R.id.radio_button_2:
                        break;
                    case R.id.radio_button_3:
                        break;
                }
            }
        });
    }
}
