package com.example.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.meuapp.Activities.ProdutoActivity;

public class MainActivity extends AppCompatActivity {

    Button btnCadastroProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnCadastroProduto = (Button) findViewById(R.id.btnCadastroProduto);

        this.btnCadastroProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // exciutado ao clicar no botao tudo que tem aqui dentro
                Intent intent = new Intent(MainActivity.this, ProdutoActivity.class);
                startActivity(intent);
            }
        });

    }
}