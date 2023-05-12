package com.example.meuapp.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.meuapp.MODEL.Produto;
import com.example.meuapp.dbHelper.ConexaoSQLite;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private final ConexaoSQLite conexaoSQLite;

    public ProdutoDAO (ConexaoSQLite conexaoSQLite) {

        this.conexaoSQLite = conexaoSQLite;

    }

    public long salvarProdutoDAO(Produto pProduto){

        SQLiteDatabase db = conexaoSQLite.getWritableDatabase();

        try{
           ContentValues values = new ContentValues();
           values.put("ID", pProduto.getId());
           values.put("Nome", pProduto.getNome());
           values.put("quantidade_em_estoque" , pProduto.getQuantidadeEmEstoque());
           values.put("preco", pProduto.getPreco());

           long idProdutoInserido = db.insert("produto", null, values);

           return idProdutoInserido;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (db != null){
                db.close();
            }
        }
        return 0;
    }

    public List<Produto> getListaProdutosDAO() {

        List<Produto> listaProdutos = new ArrayList<>();
        SQLiteDatabase db = null;
        Cursor cursor;

        String query = "SELECT * FROM produto";

        try {
            db = this.conexaoSQLite.getReadableDatabase();
            cursor = db.rawQuery(query, null);
            if (cursor.moveToFirst()){

                do{
                    Produto produto = new Produto();
                    produto.setId(cursor.getLong(0));
                    produto.setNome(cursor.getString(1));
                    produto.setQuantidadeEmEstoque(cursor.getInt(2));
                    produto.setPreco(cursor.getDouble(3));

                    listaProdutos.add(produto);

                }while (cursor.moveToNext());
            }

        }catch (Exception e){
            Log.d("ERRO LISTA DE PRODUTOS", "Erro ao salvar produtos");
            return null;
        }finally {
            if (db != null){
                db.close();
            }
        }

        return listaProdutos;

    }

}



