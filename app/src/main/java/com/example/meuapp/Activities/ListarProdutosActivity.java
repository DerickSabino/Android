package com.example.meuapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Button;


import com.example.meuapp.MODEL.Produto;
import com.example.meuapp.controller.ProdutoCtrl;
import com.example.meuapp.R;
import com.example.meuapp.adapter.AdapterListaProdutos;
import com.example.meuapp.dbHelper.ConexaoSQLite;

import java.util.List;

public class ListarProdutosActivity extends AppCompatActivity {

    private ListView lsvProduto;
    private List<Produto> produtoList;
    private AdapterListaProdutos adapterListaProduto;
    private Button produtoCtrl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_produtos);

        //buscar produtos no banco
        ProdutoCtrl produtoCtrl = new ProdutoCtrl(ConexaoSQLite.getInstancia(ListarProdutosActivity.this));


        this.lsvProduto = (ListView) findViewById(R.id.lsvProdutos);

        this.adapterListaProduto = new AdapterListaProdutos(ListarProdutosActivity.this, this.produtoList);

        this.lsvProduto.setAdapter(this.adapterListaProduto);
    }
}
