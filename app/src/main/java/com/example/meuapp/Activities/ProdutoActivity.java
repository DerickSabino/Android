
package com.example.meuapp.Activities;

import  androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.meuapp.MODEL.Produto;
import com.example.meuapp.R;
import com.example.meuapp.controller.ProdutoCtrl;
import com.example.meuapp.dbHelper.ConexaoSQLite;

public class ProdutoActivity extends AppCompatActivity {


    private EditText editProduto;
    private EditText editNomeProduto;
    private EditText editQuantidadeProduto;
    private EditText editPrecoProduto;
    private Button btnSalvarProduto;
    private Produto produto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        editProduto = (EditText) findViewById(R.id.editProduto);
        editNomeProduto = (EditText) findViewById(R.id.editNomeProduto);
        editQuantidadeProduto = (EditText)  findViewById(R.id.editQuantidadeProduto);
        editPrecoProduto = (EditText) findViewById(R.id.editPrecoProduto);

        btnSalvarProduto = (Button) findViewById(R.id.btnSalvarProduto);

        this.clickNoBotaoSalvarListener();

    }



    private void clickNoBotaoSalvarListener(){

        this.btnSalvarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Produto produtoACadastra = getDadosProdutoDoFormulario();
                if (produtoACadastra != null ){
                    ProdutoCtrl produtoCtrl = new ProdutoCtrl(ConexaoSQLite.getInstancia(ProdutoActivity.this));
                    long idProduto = produtoCtrl.salvarProdutoCtrl(produtoACadastra);
                    if (idProduto > 0){
                        Toast.makeText(ProdutoActivity.this, "Produto salvo com sucesso!", Toast.LENGTH_LONG).show();
                        finish();
                    }else{
                        Toast.makeText(ProdutoActivity.this, "Erro ao salvar produto! ", Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(ProdutoActivity.this, "Todos os campos são obrigatorios!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private Produto getDadosProdutoDoFormulario (){

        this.produto = new Produto();

        if (this.editProduto.getText().toString().isEmpty() == false ){
            this.produto.setId(Long.parseLong(this.editProduto.getText().toString()));
        }else {
            return null;
        }
        if (this.editNomeProduto.getText().toString().isEmpty() == false){
          this.produto.setNome(this.editNomeProduto.getText().toString());
        }else{
           return null;
        }
        if (editQuantidadeProduto.getText().toString().isEmpty() == false){
            int quantidadedoProduto = Integer.parseInt(this.editQuantidadeProduto.getText().toString());
            this.produto.setQuantidadeEmEstoque(quantidadedoProduto);
        }else{
            return null;
        }
        if (editPrecoProduto.getText().toString().isEmpty() == false){
            double precoProduto = Double.parseDouble(this.editPrecoProduto.getText().toString());
            this.produto.setPreco(precoProduto);
        }else{
            return null;
        }
        return produto;



   }



    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
    }

    @Override
    public Intent getIntent() {
        return super.getIntent();
    }
}


