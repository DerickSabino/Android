package com.example.meuapp.controller;

import com.example.meuapp.Activities.ListarProdutosActivity;
import com.example.meuapp.DAO.ProdutoDAO;
import com.example.meuapp.MODEL.Produto;
import com.example.meuapp.dbHelper.ConexaoSQLite;

import java.util.List;

public class ProdutoCtrl extends ListarProdutosActivity {

    private final ProdutoDAO produtoDAO;

    public ProdutoCtrl(ConexaoSQLite pConexaoSQLite){
        produtoDAO = new ProdutoDAO(pConexaoSQLite);

}
    public long salvarProdutoCtrl (Produto pProduto){
    return this.produtoDAO.salvarProdutoDAO(pProduto);
}
    public List<Produto> getListaProdutoCtrl(){
        return this.produtoDAO.getListaProdutosDAO();
    }

 }
