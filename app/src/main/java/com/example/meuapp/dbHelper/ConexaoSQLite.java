package com.example.meuapp.dbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class  ConexaoSQLite extends SQLiteOpenHelper  {

    private static ConexaoSQLite INSTANCIA_CONEXAO;

    private static final String NOME_BANCO_DADOS = "meu_banco_de_dados.db";
    private static final int VERSAO_BANCO_DADOS = 1;

    public static ConexaoSQLite getInstancia (Context context) {
        if (INSTANCIA_CONEXAO == null){
            INSTANCIA_CONEXAO = new ConexaoSQLite(context);
        }
        return INSTANCIA_CONEXAO;
    }

    private ConexaoSQLite(Context context) {
        super(context, NOME_BANCO_DADOS, null, VERSAO_BANCO_DADOS);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDataBase) {

        String sqlTabelaProduto =
                "CREATE TABLE IF NOT EXISTS produto " +
                        "(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "nome TEXT, " +
                        "quantidade_em_estoque INTEGER" +
                        ")";
        sqLiteDataBase.execSQL(sqlTabelaProduto);

        String sqlAlterTableProduto = "ALTER TABLE produto ADD COLUMN preco REAL";
        sqLiteDataBase.execSQL(sqlAlterTableProduto);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDataBase, int i, int i1) {

    }
}

