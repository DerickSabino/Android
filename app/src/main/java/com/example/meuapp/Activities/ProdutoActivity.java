package com.example.meuapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.meuapp.MODEL.Produto;
import com.example.meuapp.R;

public class ProdutoActivity extends AppCompatActivity {


    private EditText editNomeProduto;
    private EditText editQuantidadeProduto;
    private EditText editPrecoProduto;
    private Button btnSalvarProduto;

    private Produto produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        editNomeProduto = (EditText) findViewById(R.id.editNomeProduto);
        editQuantidadeProduto = (EditText) findViewById(R.id.editQuantidadeProduto);
        editPrecoProduto = (EditText) findViewById(R.id.editPrecoProduto);
        btnSalvarProduto = (Button) findViewById(R.id.btnSalvarProduto);

    }
    private Produto getDadosProdutoDoFormulario() {

        this.produto = new Produto();
        if (this.editNomeProduto.getText().toString().isEmpty() == false) {
            this.produto.setNome(this.editNomeProduto.getText().toString());
        } else {
            return null;
        }
        if (editQuantidadeProduto.getText().toString().isEmpty() == false) {
            int quantidadeProduto = Integer.parseInt(this.editQuantidadeProduto.getText().toString());
            this.produto.setQuantidadeEmEstoque(quantidadeProduto);
        } else {
            return null;}
        if (editPrecoProduto.getText().toString().isEmpty() == false) {
            double precoProduto = Double.parseDouble(this.editPrecoProduto.getText().toString());
            this.produto.setPreco(precoProduto);

        } else {
            return null;
        }
        return produto;
    }



}